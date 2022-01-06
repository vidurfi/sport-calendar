import express from 'express';
import { fileURLToPath } from 'url';
import { dirname } from 'path';
import cors from 'cors';

const app = express();
const port = 8000;
app.use(cors());

const __dirname = fileURLToPath(dirname(import.meta.url));
app.use(express.static('./public'));

app.listen(port, () => {
  console.log(`Listening on port ${port}...`)
});

app.get('/', (req, res) => {
  res.sendFile('./public/index.html', { root: __dirname });
});
