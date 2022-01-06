import mysql2 from 'mysql2/promise';
import express from 'express';
import cors from 'cors';

const app = express();
const port = 3000;
app.use(cors());
app.use(express.json());

let matches;

let connectionJson = {
  host: 'localhost',
  user: 'root',
  password: 'root',
  database: 'sport_calendar'
}



app.get('/', (req, res) => {
  res.status(200).end();
});

app.post('/getMatchForMonth', async (req, res) => {
  let connection = await mysql2.createConnection(connectionJson);
  let sql = "SELECT * FROM match_view "
  if ('filters' in req.body) {
    sql += "WHERE ";
    let conditions = []
    if ('city' in req.body.filters) conditions.push("CITY='" + req.body.filters.city + "' ");
    if ('sport' in req.body.filters) conditions.push("SPORT='" + req.body.filters.sport + "' ");
    if ('team' in req.body.filters) conditions.push("HOME_TEAM='" + req.body.filters.team + "' OR AWAY_TEAM='" + req.body.filters.team + "'");
    sql += conditions.join('AND ');
  }
  sql += ";";
  matches = await connection.execute(sql);
  let responseArray = [];
  let currentDate = new Date(req.body.year, req.body.month, 1);
  matches[0].forEach(element => {
    if ((element.DATE.getMonth() == currentDate.getMonth()) && (element.DATE.getYear() == currentDate.getYear())) {
      responseArray.push(element);
    }
  })
  await connection.end();
  res.status(200).send(responseArray);
});

app.listen(port, () => {
  console.log(`App listening on port ${port}...`);
});
