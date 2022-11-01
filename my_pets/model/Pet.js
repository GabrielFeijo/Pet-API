
const mongoose = require('mongoose');
const Schema = mongoose.Schema;

let Pet = new Schema({
  name: {
    type: String
  },
  age: {
    type: String
  },
  dogbreed: {
    type: String
  },
  url: {
    type: String
  }
},{
    collection: 'pet'
});

module.exports = mongoose.model('Pet', Pet);



    