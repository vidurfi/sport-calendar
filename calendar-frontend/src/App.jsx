import React, { useState } from 'react';
import Header from './components/Header';
import Calendar from './components/Calendar';

import MONTH from './Month.json';

function App() {
  const [localDate, setLocalDate] = useState({
    year: 2022,
    month: MONTH.January,
  });

  const incrementMonth = () => {
    const local = localDate;
    if (local.month === MONTH.December) {
      local.year += 1;
      local.month = MONTH.January;
    } else local.month += 1;
    setLocalDate({ ...local });
  };

  const decrementMonth = () => {
    const local = localDate;
    if (local.month === MONTH.January) {
      local.year -= 1;
      local.month = MONTH.December;
    } else local.month -= 1;
    setLocalDate({ ...local });
  };

  return (
    <div className="container">
      <Header
        localDate={localDate}
        incrementMonth={incrementMonth}
        decrementMonth={decrementMonth}
      />
      <Calendar localDate={localDate} />
    </div>
  );
}

export default App;
