import React from 'react';
import PropTypes from 'prop-types';
import MONTH from '../Month.json';

function Date({ localDate }) {
  return (
    <div className="inline">
      <div className="content subtitle">{localDate.year}</div>
      {' '}
      <div className="content month">{Object.keys(MONTH)[localDate.month - 1]}</div>
    </div>
  );
}

Date.propTypes = {
  localDate: PropTypes.shape({
    year: PropTypes.number.isRequired,
    month: PropTypes.number.isRequired,
  }).isRequired,
};

export default Date;
