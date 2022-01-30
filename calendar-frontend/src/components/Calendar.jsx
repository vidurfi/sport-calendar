import React, { useEffect } from 'react';
import PropTypes from 'prop-types';
import axios from 'axios';
import { useState } from 'react/cjs/react.development';
import Controls from './Controls';
import DayTitle from './DayTitle';
import DaySlot from './DaySlot';

function Calendar({ localDate }) {
  const [dayTitles, setDayTitles] = useState([]);
  const [daySlots, setDaySlots] = useState([]);
  const [params, setParams] = useState({
    team: null,
    city: null,
    sport: null,
  });

  const WEEKDAYS = 7;
  const ROWS = 6;

  function getFirstDay(year, month) {
    return new Date(year, month, 0).getDay() - 1;
  }

  const firstDay = getFirstDay(localDate.year, localDate.month);

  async function getMatchesForMonth(date) {
    const matches = {};
    return axios.get('http://localhost:8080/matches/all', { params }).then((response) => {
      response.data.forEach((element) => {
        const elementDate = new Date(element.dateTime);
        if ((elementDate.getMonth() + 1
          === (new Date(date.year, date.month, 1).getMonth() + 1))
          && ((elementDate.getFullYear() === (new Date(date.year, date.month, 1).getFullYear())))) {
          const day = elementDate.getDate();
          if (!matches[day]) {
            matches[day] = [];
          }
          matches[`${day}`].push(element);
        }
      });
      return matches;
    });
  }

  function dayFiller(matches) {
    const slots = [];
    const titles = [];
    let dayOfMonth = 1;
    for (let i = 0; i < WEEKDAYS; i += 1) {
      titles.push(<DayTitle id={i} key={i} />);
      const lastDay = new Date(localDate.year, localDate.month + 1, 0).getDate();
      for (let j = 0; j < ROWS; j += 1) {
        const id = i * ROWS + j;
        if ((id > firstDay)
          && (dayOfMonth <= lastDay)) {
          slots.push(<DaySlot
            className="active-day"
            id={id}
            key={id}
            dayOfMonth={dayOfMonth}
            matches={matches[dayOfMonth]}
          />);
          dayOfMonth += 1;
        } else {
          slots.push(<DaySlot
            className="calendar-day"
            id={id}
            key={id}
          />);
        }
      }
    }
    setDayTitles([...titles]);
    setDaySlots([...slots]);
  }

  const handleDayChange = (input) => {
    if (input)setParams({ ...params });
    getMatchesForMonth(localDate).then((matches) => {
      dayFiller(matches);
    });
  };

  const handleFilterChange = (event) => {
    params[event.target.id] = event.target.value === '' ? null : event.target.value;
    setParams({ ...params });
  };

  useEffect(() => {
    getMatchesForMonth(localDate).then((matches) => {
      dayFiller(matches);
    });
  }, [localDate]);

  return (
    <div>
      <Controls
        handleDayChange={handleDayChange}
        handleFilterChange={handleFilterChange}
        params={params}
      />
      <div className="grid-container calendar">
        {dayTitles}
        {daySlots}
      </div>
    </div>
  );
}

Calendar.propTypes = {
  localDate: PropTypes.shape({
    year: PropTypes.number.isRequired,
    month: PropTypes.number.isRequired,
  }).isRequired,
};

export default Calendar;
