import axios from 'axios';
import React, { useState, useEffect } from 'react';
import DateTimePicker from 'react-datetime-picker';
import PropTypes from 'prop-types';
import Button from './Button';

function AddControl({ handleDayChange }) {
  const [sportsState, setSportsState] = useState([]);
  const [teamsState, setTeamsState] = useState([]);
  const [stadiumsState, setStadiumsState] = useState([]);
  const [dateValue, setDateValue] = useState(new Date());
  const [matchState, setMatchState] = useState(
    {
      dateTime: '2022-01-01T12:30:00',
      homeTeam: {
        id: 1,
      },
      awayTeam: {
        id: 1,
      },
      sport: {
        id: 1,
      },
      stadium: {
        id: 1,
      },
    },
  );

  async function getSports() {
    const sports = [];
    return axios.get('http://localhost:8080/sports/all').then((response) => {
      response.data.forEach((element) => {
        sports.push(element);
      });
      return sports;
    });
  }

  async function getTeams() {
    const teams = [];
    return axios.get('http://localhost:8080/teams/all').then((response) => {
      response.data.forEach((element) => {
        teams.push(element);
      });
      return teams;
    });
  }

  async function getStadiums() {
    const stadiums = [];
    return axios.get('http://localhost:8080/stadiums/all').then((response) => {
      response.data.forEach((element) => {
        stadiums.push(element);
      });
      return stadiums;
    });
  }

  function sportFiller(sports) {
    const sportArray = [];
    sports.forEach((element) => {
      sportArray.push(<option value={element.id} key={element.id}>{element.name}</option>);
    });
    setSportsState([...sportArray]);
  }

  function stadiumFiller(stadiums) {
    const stadiumArray = [];
    stadiums.forEach((element) => {
      stadiumArray.push(<option value={element.id} key={element.id}>{`${element.name}, ${element.city.name}`}</option>);
    });
    setStadiumsState([...stadiumArray]);
  }

  function teamFiller(teams) {
    const teamArray = [];
    teams.forEach((element) => {
      teamArray.push(<option value={element.id} key={element.id}>{element.name}</option>);
    });
    setTeamsState([...teamArray]);
  }

  useEffect(() => {
    getSports().then((response) => {
      sportFiller(response);
    });
    getStadiums().then((response) => {
      stadiumFiller(response);
    });
    getTeams().then((response) => {
      teamFiller(response);
    });
  }, []);

  const handleChange = (event) => {
    const { target } = event;
    const { id } = target;
    const { value } = target;
    const item = matchState;
    item[id].id = value;
    setMatchState(item);
  };

  function addSportSelector() {
    return (
      <select defaultValue={1} id="sport" onChange={handleChange}>
        {sportsState}
      </select>
    );
  }

  function addStadiumSelector() {
    return (
      <select defaultValue={1} id="stadium" onChange={handleChange}>
        {stadiumsState}
      </select>
    );
  }

  function addTeamSelector(selector) {
    return (
      <select defaultValue={1} id={selector} onChange={handleChange}>
        {teamsState}
      </select>
    );
  }

  const addMatch = () => {
    const item = matchState;
    dateValue.setHours(dateValue.getHours() + 1);
    item.dateTime = dateValue;
    setMatchState(item);
    axios.post('http://localhost:8080/matches/addMatch', matchState).then((response) => {
      // eslint-disable-next-line no-console
      if (response.status !== 200) console.warn(response.status);
      else handleDayChange();
    });
  };

  return (
    <form className="content">
      <label htmlFor="sport-selector">
        <DateTimePicker className="datepicker" onChange={setDateValue} value={dateValue} />
        {addTeamSelector('homeTeam')}
        {addTeamSelector('awayTeam')}
        {addStadiumSelector()}
        {addSportSelector()}
      </label>
      <Button text="Add match" onClick={addMatch} />
    </form>
  );
}

AddControl.propTypes = {
  handleDayChange: PropTypes.func.isRequired,
};

export default AddControl;
