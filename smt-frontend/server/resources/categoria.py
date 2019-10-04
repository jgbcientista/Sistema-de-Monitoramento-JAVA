from flask import request, jsonify, json
from flask_restful import Resource
from models.categoria import CategoriaModel
from sqlalchemy.orm import sessionmaker
from db import session


class CategoriaList(Resource):
    def get(self):
        categorias = session.query(CategoriaModel).order_by(CategoriaModel.nome)
        categorias = [c.serialize for c in categorias]
        return jsonify(categorias)  # jsonify({'store': stores})


class CategoriaResource(Resource):
    def get(self, id):
        categoria = session.query(CategoriaModel).get(id)
        return jsonify(categoria.serialize)

    def post(self, categoria):
        session.add(CategoriaModel(request.json['id'], request.json['nome']))
        session.commit()
        return json.dumps(request.json), 201

    def delete(self, id):
        categoria = session.query(CategoriaModel).get(id)
        session.delete(categoria)
        session.commit()
        return jsonify(categoria.serialize)

    def put(self, id):
        categoria = session.query(CategoriaModel).get(id)
        categoria.nome = request.json.get('nome', categoria.nome)
        session.commit()
        return jsonify(categoria.serialize)
        #     return {'item': None}, 404

