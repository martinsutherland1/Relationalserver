const express = require('express');
const app = express();

const cors = require('cors');

app.use(cors());
app.use(express.json());
const MongoClient = require('mongodb').MongoClient;
const createRouter = require('./helpers/create_router.js');


MongoClient.connect('mongodb://localhost:27017')
.then((client) => {
  const db = client.db('dataGenerator');
  const dataCreator = db.collection('data');
  const dataRouter = createRouter(dataCreator);
  app.use('/api/data', dataRouter);

  
})
.catch(console.err);

app.listen(5002, function () {
  console.log(`Listening on port ${ this.address().port }`);
});