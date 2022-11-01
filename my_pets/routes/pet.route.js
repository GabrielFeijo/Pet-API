const express = require('express');
const app = express();
const userRoutes = express.Router();

let Pet = require('../model/Pet');

// api to add pet
userRoutes.route('/add').post(function (req, res) {
  let pet = new Pet(req.body);
  pet.save()
  .then(pet => {
    res.status(200).json({'Info:': 'sucesso','mssg': 'Pet adicionado com sucesso!'});
  })
  .catch(err => {
    res.status(409).send({'Info:': 'erro','mssg': 'Não foi possível salvar no banco de dados!'});
  });
});

// api to get pets
userRoutes.route('/').get(function (req, res) {
  Pet.find(function (err, pets){
    if(err){
      res.status(400).send({'Info:': 'erro','mssg': 'Algo deu errado!'});
    }
    else {
      res.status(200).json({'Info:': 'sucesso','Pets': pets});
    }
  });
});

// api to get pet
userRoutes.route('/:id').get(function (req, res) {
  let id = req.params.id;
  Pet.findById(id, function (err, pet){
    if(err){
      res.status(400).send({'Info:': 'erro','mssg': 'Algo deu errado!'});
    }
    else {
      res.status(200).json({'Info:': 'sucesso','Pet': pet});
    }
  });
});

// api to update route
userRoutes.route('/:id').put(function (req, res) {
    Pet.findById(req.params.id, function(err, pet) {
    if (!pet){
      res.status(400).send({'Info:': 'erro','mssg': 'Não foi possível encontrar dados!'});
    } else {
        pet.name = req.body.name;
        pet.age = req.body.age;
        pet.dogbreed = req.body.dogbreed;
        pet.url = req.body.url;

        pet.save().then(business => {
          res.status(200).json({'Info:': 'sucesso','mssg': 'Atualização completa!'});
      })
    }
  });
});

// api for delete
userRoutes.route('/:id').delete(function (req, res) {
  Pet.findByIdAndRemove({_id: req.params.id}, function(err,){
    if(err){
      res.status(400).send({'Info:': 'erro','mssg': 'Algo deu errado!'});
    }
    else {
      res.status(200).json({'Info:': 'sucesso','mssg': 'Deletado com sucesso!'});
    }
  });
});

module.exports = userRoutes;