import React from 'react';
import PropTypes from 'prop-types';
import Controls from './Controls';

function Calendar({ localDate }) {
  return (
    <div>
      <Controls />
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
