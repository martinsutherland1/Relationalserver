const express = require('express');
const app = express();

const cors = require('cors');

const port = process.env.PORT || 5002

app.use(cors());
app.use(express.json());
const MongoClient = require('mongodb').MongoClient;
const createRouter = require('./helpers/create_router.js');


MongoClient.connect('mongodb://0.0.0.0:27017')
.then((client) => {
  const db = client.db('users');
  const dataCreator = db.collection('data');
  const dataRouter = createRouter(dataCreator);
  app.use('/api/users', dataRouter);

  
})
.catch(console.err);

app.listen(port, function () {
  console.log(`Listening on port ${ this.address().port }`);
});