import React from 'react';
import PropTypes from 'prop-types';
import DAY from '../Day.json';

function DayTitle({ id }) {
  return <div className="day-title" id={id}>{ Object.keys(DAY)[id]}</div>;
}

DayTitle.propTypes = {
  id: PropTypes.number.isRequired,
};

export default DayTitle;
