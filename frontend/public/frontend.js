let currentYear = 2022;
let currentMonth = 1;
let currentDay = 8;
let firstDayId;
let filters = {};

const backendPort = 5002;

const FIRSTCELL = 1;
const LASTCELL = 42;

async function incrementMonth() {
  if (currentMonth == 12) {
    currentYear++;
    currentMonth = 1;
  }
  else currentMonth++;
  changeText();
  await updateCalendar();
}

async function decrementMonth(){
  if (currentMonth == 1) {
    currentYear--;
    currentMonth = 12;
  }
  else currentMonth--
  changeText();
  updateCalendar();
}

function changeText() {
  document.querySelector('.month').innerHTML  = currentMonth;
  document.querySelector('.year').innerHTML = currentYear;
}

async function updateCalendar() {
  setFirstDayId();
  clearStyle();
  clearMatches();
  styleCalendar();
  await getMatches();
}

function setFirstDayId() {
  firstDayId = new Date(currentYear, currentMonth - 1, 1).getDay() || 7;
}

function getCurrentfirstActiveDays() {
  return (new Date(currentYear, currentMonth - 1, 1).getDay() || 7);
}

function styleCalendar() {
  let day = 1;
  for (let i = getCurrentfirstActiveDays(); i < (new Date(currentYear, currentMonth, 0).getDate())+getCurrentfirstActiveDays(); i++) {
    let element = document.getElementById(`${i}`);
    element.classList.add("active-day");
    element.firstChild.innerHTML = day++;
  }
}

function clearStyle() {
  for (let i = FIRSTCELL; i <= LASTCELL; i++){
    let element = document.getElementById(`${i}`);
    element.classList.remove("active-day");
    element.firstChild.innerHTML = '';
  }
}

function clearMatches() {
  document.querySelectorAll('.matchday').forEach(element => element.remove());
}

async function getMatches() {
  let matchesInCurrentMonth = await getMatchesInCurrentMonth();
  let div;
  matchesInCurrentMonth.forEach(element => {
    div = document.createElement("div");
    div.classList.add("matchday");
    date = new Date(element.DATE);
    div.innerHTML = (`${date.getHours()}:${(date.getMinutes()<10?'0':'')+date.getMinutes()} : ${element.SPORT} match: ${element.HOME_TEAM} - ${element.AWAY_TEAM} at ${element.STADIUM}, ${element.CITY}`);
    document.getElementById(firstDayId + date.getDate()).appendChild(div);
  });
}

async function getMatchesInCurrentMonth() {
  const json = {
    "year": currentYear,
    "month": currentMonth,
  };
  if (Object.keys(filters).length !== 0) {
    json.filters = filters;
  }
  const options = {
    method: 'POST',
    body: JSON.stringify(json),
    headers: {
      'Content-Type':'application/json'
    }
  }
  let matchesInCurrentMonth = await fetch(`http://localhost:${backendPort}/getMatchForMonth`, options)
    .then((res) => { return res.json(); })
    .catch(err => console.error(err));
  return matchesInCurrentMonth;
}

async function setFilters() {
  filters = {};
  if (document.getElementById("cityFilterInput").value) filters.city = document.getElementById("cityFilterInput").value;
  if (document.getElementById("sportFilterInput").value) filters.sport = document.getElementById("sportFilterInput").value;
  if (document.getElementById("teamFilterInput").value) filters.team = document.getElementById("teamFilterInput").value;
  await updateCalendar();
}
