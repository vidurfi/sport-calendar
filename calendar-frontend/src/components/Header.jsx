import React from 'react';
import PropTypes from 'prop-types';
import DateControl from './DateControl';

function Header({
  localDate, incrementMonth, decrementMonth,
}) {
  return (
    <div>
      <h1 className="content title">
        Sport Calendar
      </h1>
      <DateControl
        localDate={localDate}
        incrementMonth={incrementMonth}
        decrementMonth={decrementMonth}
      />
    </div>
  );
}

Header.propTypes = {
  localDate: PropTypes.shape({
    year: PropTypes.number.isRequired,
    month: PropTypes.number.isRequired,
  }).isRequired,
  incrementMonth: PropTypes.func.isRequired,
  decrementMonth: PropTypes.func.isRequired,
};

export default Header;
