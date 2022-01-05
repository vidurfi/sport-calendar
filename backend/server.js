import moment from 'moment';
import mysql2 from 'mysql2';
import express from 'express';
import sequelize from 'sequelize';
import cors from 'cors';

let matches;
const app = express();
const port = 3000;
app.use(cors());
app.use(express.json());

let connection = mysql2.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'root',
  database: 'sport_calendar'
})

connection.connect((err) => {
  if (err) throw err;
  let sql = "SELECT * FROM match_view;"
  connection.query(sql, (err, results) => {
    if (err) throw err;
    matches = results;
  })
});

app.get('/', (req, res) => {
  res.status(200).end();
});

app.post('/getMatchForDay', (req, res) => {
  matches.foreach()
  res.status(200).send(req.body);
});

app.listen(port, () => {
  console.log(`App listening on port ${port}...`);
});
