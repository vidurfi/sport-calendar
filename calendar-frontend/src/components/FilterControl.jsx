import React from 'react';
import PropTypes from 'prop-types';
import Button from './Button';

function FilterControl({
  handleDayChange, handleFilterChange,
}) {
  const handleSubmit = () => {
    handleDayChange();
  };

  return (
    <form className="content">
      <label htmlFor="team" className="content">
        Team:
        <input id="team" type="text" onChange={handleFilterChange} />
      </label>
      <label htmlFor="city" className="content">
        City:
        <input id="city" type="text" onChange={handleFilterChange} />
      </label>
      <label htmlFor="sport" className="content">
        Sport:
        <input id="sport" type="text" onChange={handleFilterChange} />
      </label>
      <Button type="button" text="Filter" onClick={handleSubmit}>Filter</Button>
    </form>
  );
}

FilterControl.propTypes = {
  handleFilterChange: PropTypes.func.isRequired,
  handleDayChange: PropTypes.func.isRequired,
  params: PropTypes.shape({
    team: PropTypes.string,
    city: PropTypes.string,
    sport: PropTypes.string,
  }),
};

FilterControl.defaultProps = {
  params: {
    team: null,
    city: null,
    sport: null,
  },
};

export default FilterControl;
