from flask import request, jsonify, json
from flask_restful import Resource
from models.fatura import FaturaModel
from sqlalchemy.orm import sessionmaker
from db import session


class FaturaList(Resource):
    def get(self):
        faturas = session.query(FaturaModel).order_by(FaturaModel.data_vencimento)
        faturas = [f.serialize for f in faturas]
        return jsonify(faturas)  # jsonify({'store': stores})


class FaturaResource(Resource):
    def get(self, id):
        fatura = session.query(FaturaModel).get(id)
        return jsonify(fatura.serialize)

    def post(self, categoria):
        session.add(FaturaModel(request.json['id'],
                                request.json['data_vencimento'],
                                request.json['data_pagamento'],
                                request.json['valor']))
        session.commit()
        return json.dumps(request.json), 201

    def delete(self, id):
        fatura = session.query(FaturaModel).get(id)
        session.delete(fatura)
        session.commit()
        return jsonify(fatura.serialize)

    def put(self, id):
        fatura = session.query(FaturaModel).get(id)
        fatura.data_vencimento = request.json.get('data_vencimento', fatura.data_vencimento)
        fatura.data_pagamento = request.json.get('data_pagamento', fatura.data_pagamento)
        fatura.valor = request.json.get('valor', fatura.valor)
        session.commit()
        return jsonify(fatura.serialize)
        #     return {'item': None}, 404

