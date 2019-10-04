from flask import request, jsonify, json
from flask_restful import Resource
from models.lancamento import LancamentoModel
from sqlalchemy.orm import sessionmaker
from db import session


class LancamentoList(Resource):
    def get(self):
      lancamentos = session.query(LancamentoModel).order_by(LancamentoModel.data)
      lancamentos = [l.serialize for l in lancamentos]
      return jsonify(lancamentos)  # jsonify({'store': stores})


class LancamentoResource(Resource):
    def get(self, id):
        lancamento = session.query(LancamentoModel).get(id)
        return jsonify(lancamento.serialize)

    def post(self, lancamento):
        session.add(LancamentoModel(request.json['id'],
                               request.json['estabelecimento'],
                               request.json['data'],
                               request.json['valor']))
        session.commit()
        return json.dumps(request.json)

    def put(self, id):
        lancamento = session.query(LancamentoModel).get(id)
        lancamento.estabelecimento = request.json.get('estabelecimento', lancamento.estabelecimento)
        lancamento.data = request.json.get('data', lancamento.data)
        lancamento.valor = request.json.get('valor', lancamento.valor)

        categoria = request.json['categoria']
        print(categoria['id'])
        # lancamento.categoria.id = categoria['id']
        lancamento.categoria_id = categoria['id']
        # lancamento.fatura.id = request.json.get('fatura.id', lancamento.fatura.id)

        session.commit()
        return jsonify(lancamento.serialize)

    def delete(self, id):
        lancamento = session.query(LancamentoModel).get(id)
        session.delete(lancamento)
        session.commit()
        return jsonify(lancamento.serialize)


