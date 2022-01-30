import React from 'react';
import PropTypes from 'prop-types';

function DaySlot({
  id, dayOfMonth, className, matches,
}) {
  function add(matchArray) {
    const match = [];
    matchArray?.forEach((element) => {
      const date = new Date(element.dateTime);
      const time = `${date.getHours()}:${(date.getMinutes() < 10 ? '0' : '') + date.getMinutes()}`;
      const homeTeam = element.homeTeam.name;
      const awayTeam = element.awayTeam.name;
      const city = element.stadium.city.name;
      const sport = element.sport.name;
      const stadium = element.stadium.name;
      match.push(<div key={element.id} className="matchday">{`${time}: ${homeTeam} - ${awayTeam} at ${stadium}, ${city} (${sport})`}</div>);
    });
    return match;
  }

  return (
    <div className={`day-slot ${className}`} id={id}>
      {dayOfMonth}
      {add(matches)}
    </div>
  );
}

DaySlot.propTypes = {
  id: PropTypes.number.isRequired,
  className: PropTypes.string.isRequired,
  dayOfMonth: PropTypes.number,
  matches: PropTypes.arrayOf(PropTypes.shape(
    {
      id: PropTypes.number.isRequired,
      dateTime: PropTypes.string.isRequired,
      homeTeam: PropTypes.shape({
        id: PropTypes.number.isRequired,
        name: PropTypes.string.isRequired,
        city: PropTypes.shape({
          id: PropTypes.number.isRequired,
          name: PropTypes.string.isRequired,
        }).isRequired,
        sport: PropTypes.shape({
          id: PropTypes.number.isRequired,
          name: PropTypes.string.isRequired,
        }).isRequired,
      }).isRequired,
      awayTeam: PropTypes.shape({
        id: PropTypes.number.isRequired,
        name: PropTypes.string.isRequired,
        city: PropTypes.shape({
          id: PropTypes.number.isRequired,
          name: PropTypes.string.isRequired,
        }).isRequired,
        sport: PropTypes.shape({
          id: PropTypes.number.isRequired,
          name: PropTypes.string.isRequired,
        }).isRequired,
      }).isRequired,
      sport: PropTypes.shape({
        id: PropTypes.number.isRequired,
        name: PropTypes.string.isRequired,
      }).isRequired,
      stadium: PropTypes.shape({
        id: PropTypes.number.isRequired,
        name: PropTypes.string.isRequired,
        city: PropTypes.shape({
          id: PropTypes.number.isRequired,
          name: PropTypes.string.isRequired,
        }).isRequired,
      }).isRequired
      ,
    },
  )),
};

DaySlot.defaultProps = {
  dayOfMonth: null,
  matches: null,
};

export default DaySlot;
