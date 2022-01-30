import React from 'react';
import PropTypes from 'prop-types';
import Date from './Date';
import Button from './Button';

function DateControl({
  localDate, incrementMonth, decrementMonth,
}) {
  return (
    <div className="content">
      <Button text="<" onClick={decrementMonth} />
      <Date localDate={localDate} />
      <Button text=">" onClick={incrementMonth} />
    </div>
  );
}

DateControl.propTypes = {
  localDate: PropTypes.shape({
    year: PropTypes.number.isRequired,
    month: PropTypes.number.isRequired,
  }).isRequired,
  incrementMonth: PropTypes.func.isRequired,
  decrementMonth: PropTypes.func.isRequired,
};

export default DateControl;
