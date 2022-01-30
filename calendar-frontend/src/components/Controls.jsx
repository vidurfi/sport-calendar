import React from 'react';
import PropTypes from 'prop-types';
import AddControl from './AddControl';
import FilterControl from './FilterControl';

function Controls({
  handleDayChange, handleFilterChange, params,
}) {
  return (
    <div>
      <FilterControl
        handleDayChange={handleDayChange}
        handleFilterChange={handleFilterChange}
        params={params}
      />
      <AddControl handleDayChange={handleDayChange} />
    </div>
  );
}

Controls.propTypes = {
  handleFilterChange: PropTypes.func.isRequired,
  handleDayChange: PropTypes.func.isRequired,
  params: PropTypes.shape({
    team: PropTypes.string,
    city: PropTypes.string,
    sport: PropTypes.string,
  }),
};

Controls.defaultProps = {
  params: {
    team: null,
    city: null,
    sport: null,
  },
};

export default Controls;
