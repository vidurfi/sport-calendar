import mysql2 from 'mysql2/promise';
import express from 'express';
import cors from 'cors';
import config from './config.js';

const app = express();
app.use(cors());
app.use(express.json());

const connectionJson = config.connectionJson;
const port = config.backendPort;

app.get('/', (req, res) => {
  res.status(200).end();
});

app.post('/getMatchForMonth', async (req, res) => {
  const matches = await getFilteredMatches(req.body);
  const responseArray = [];
  const currentDate = new Date(req.body.year, req.body.month, 1);
  matches.forEach(element => {
    if ((element.DATE.getMonth() == currentDate.getMonth()) && (element.DATE.getYear() == currentDate.getYear())) {
      responseArray.push(element);
    }
  })
  res.status(200).send(responseArray);
});

async function getFilteredMatches(body) {
  const connection = await mysql2.createConnection(connectionJson);
  const matches = await connection.execute(buildQuery(body));
  await connection.end();
  return matches[0];
}

function buildQuery(body) {
  let sql = "SELECT * FROM match_view "
  if ('filters' in body) {
    sql += "WHERE ";
    const conditions = []
    if ('city' in body.filters) conditions.push("CITY='" + body.filters.city + "' ");
    if ('sport' in body.filters) conditions.push("SPORT='" + body.filters.sport + "' ");
    if ('team' in body.filters) conditions.push("(HOME_TEAM='" + body.filters.team + "' OR AWAY_TEAM='" + body.filters.team + "')");
    sql += conditions.join('AND ');
  }
  sql += ";";
  return sql;
}

app.listen(port, () => {
  console.log(`App listening on port ${port}...`);
});
