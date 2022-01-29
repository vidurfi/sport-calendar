import './App.css';
import React, {useEffect} from 'react';
import { decrementMonth, incrementMonth, setFilters } from './frontend';

function App() {
  return (
    <div>
      <div>
        <div className="content title">SportCalendar</div>
        <div className="content subtitle year">2022</div>
        <div className="content">
            <button onClick={()=>decrementMonth()}>{String.fromCharCode(8592)}</button>
          <div className="subtitle inline month">1</div>
            <button onClick={()=>incrementMonth()}>{String.fromCharCode(8594)}</button>
        </div>
      </div>
      <div className="content">
        <div className="content filtercontrols inline">
          <div className="inline">
            City
            <input id="cityFilterInput" className="inline" type="text"/>
          </div>
          <div className="inline">
            Sport
            <input id="sportFilterInput" type="text"/>
          </div>
          <div className="inline">
            Team
            <input id="teamFilterInput" type="text"/>
          </div>
            <button onClick={()=>setFilters()}>Set filters</button>
        </div>
    </div>
      <table id="calendar" className="calendar" onLoad={useEffect(()=>{setFilters()})}>
        <thead>
          <tr>
            <th>Monday</th>
            <th>Tuesday</th>
            <th>Wednesday</th>
            <th>Thursday</th>
            <th>Friday</th>
            <th>Saturday</th>
            <th>Sunday</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td id="1"><div className="calendar-day"></div></td>
            <td id="2"><div className="calendar-day"></div></td>
            <td id="3"><div className="calendar-day"></div></td>
            <td id="4"><div className="calendar-day"></div></td>
            <td id="5"><div className="calendar-day"></div></td>
            <td id="6" className="active-day"><div className="calendar-day">1</div></td>
            <td id="7" className="active-day"><div className="calendar-day">2</div></td>
          </tr>
          <tr>
            <td id="8" className="active-day"><div className="calendar-day">3</div></td>
            <td id="9" className="active-day"><div className="calendar-day">4</div></td>
            <td id="10" className="active-day"><div className="calendar-day">5</div></td>
            <td id="11" className="active-day"><div className="calendar-day">6</div></td>
            <td id="12" className="active-day"><div className="calendar-day">7</div></td>
            <td id="13" className="active-day"><div className="calendar-day">8</div></td>
            <td id="14" className="active-day"><div className="calendar-day">9</div></td>
          </tr><tr>
            <td id="15" className="active-day"><div className="calendar-day">10</div></td>
            <td id="16" className="active-day"><div className="calendar-day">11</div></td>
            <td id="17" className="active-day"><div className="calendar-day">12</div></td>
            <td id="18" className="active-day"><div className="calendar-day">13</div></td>
            <td id="19" className="active-day"><div className="calendar-day">14</div></td>
            <td id="20" className="active-day"><div className="calendar-day">15</div></td>
            <td id="21" className="active-day"><div className="calendar-day">16</div></td>
          </tr><tr>
            <td id="22" className="active-day"><div className="calendar-day">17</div></td>
            <td id="23" className="active-day"><div className="calendar-day">18</div></td>
            <td id="24" className="active-day"><div className="calendar-day">19</div></td>
            <td id="25" className="active-day"><div className="calendar-day">20</div></td>
            <td id="26" className="active-day"><div className="calendar-day">21</div></td>
            <td id="27" className="active-day"><div className="calendar-day">22</div></td>
            <td id="28" className="active-day"><div className="calendar-day">23</div></td>
          </tr><tr>
            <td id="29" className="active-day"><div className="calendar-day">24</div></td>
            <td id="30" className="active-day"><div className="calendar-day">25</div></td>
            <td id="31" className="active-day"><div className="calendar-day">26</div></td>
            <td id="32" className="active-day"><div className="calendar-day">27</div></td>
            <td id="33" className="active-day"><div className="calendar-day">28</div></td>
            <td id="34" className="active-day"><div className="calendar-day">29</div></td>
            <td id="35" className="active-day"><div className="calendar-day">30</div></td>
          </tr><tr>
            <td id="36" className="active-day"><div className="calendar-day">31</div></td>
            <td id="37" ><div className="calendar-day"></div></td>
            <td id="38" ><div className="calendar-day"></div></td>
            <td id="39" ><div className="calendar-day"></div></td>
            <td id="40" ><div className="calendar-day"></div></td>
            <td id="41" ><div className="calendar-day"></div></td>
            <td id="42" ><div className="calendar-day"></div></td>
          </tr>
          </tbody>
    </table>
  </div>
  );
};

export default App;
