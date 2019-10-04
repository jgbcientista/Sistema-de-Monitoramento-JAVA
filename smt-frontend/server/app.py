#!/usr/bin/python

from flask import Flask
from flask_restful import Api
from flask_jwt import JWT
from resources.database_setup import Base
from flask_cors import CORS

from resources.lancamento import LancamentoList, LancamentoResource
# from resources.security import authenticate, identity
from db import engine
from resources.categoria import CategoriaList, CategoriaResource
from resources.user import UserResource
from resources.fatura import FaturaList, FaturaResource

app = Flask(__name__)
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
app.secret_key = 'jose'
api = Api(app)
CORS(app)
# jwt = JWT(app, authenticate, identity)

Base.metadata.bind = engine


@app.route("/")
def index():
    return "Hello!"


# Categoria
api.add_resource(CategoriaList, '/categorias')
api.add_resource(CategoriaResource, '/categorias/<int:id>')

# Lancamento
api.add_resource(LancamentoList, '/lancamentos')
api.add_resource(LancamentoResource, '/lancamentos/<int:id>')

# User
api.add_resource(UserResource, '/users')

# Fatura
api.add_resource(FaturaList, '/faturas')


if __name__ == '__main__':
    app.debug = True
    app.run(host = '0.0.0.0', port = 5000)
