let currentYear = 2022;
let currentMonth = 1;
let currentDay = 8;

let matchesInCurrentMonth = [];

const FIRSTCELL = 1;
const LASTCELL = 42;

function incrementMonth() {
  if (currentMonth == 12) {
    currentYear++;
    currentMonth = 1;
  }
  else currentMonth++;
  changeText();
  updateCalendar();
}

function decrementMonth(){
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

function updateCalendar() {
  clearStyle();
  styleCalendar();
  updateMatches();
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

async function getFilter() {
  let matchesInCurrentMonth = [];
  const json = {
    "year": currentYear,
    "month": currentMonth,
  };
  const options = {
    method: 'POST',
    body: JSON.stringify(json),
    headers: {
      'Content-Type':'application/json'
    }
  }
  fetch('http://localhost:3000/getMatchForMonth', options)
    .then(res => res.json())
    .then(res => console.log(res))
    .catch(err => console.error(err));

  /*let div;
  for (let i = getCurrentfirstActiveDays(); i < (new Date(currentYear, currentMonth, 0).getDate()) + getCurrentfirstActiveDays(); i++) {
    let element = document.getElementById(`${i}`);
    div = document.createElement('div');
    div.id = 'match-day';
    div.innerHTML = 'MATCH';
    element.appendChild(div);
  }*/
}

function updateMatches() {
  getFilter();
}

