import React from 'react';
import PropTypes from 'prop-types';
import AddControl from './AddControl';
import FilterControl from './FilterControl';

function Controls({ localDate }) {
  return (
    <div>
      <FilterControl />
      <AddControl />
    </div>
  );
}

Controls.propTypes = {
  localDate: PropTypes.shape({
    year: PropTypes.number.isRequired,
    month: PropTypes.number.isRequired,
  }).isRequired,
};

export default Controls;
