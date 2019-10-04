from db import db
from models.categoria import CategoriaModel
from models.fatura import FaturaModel
from sqlalchemy.orm import backref


# Inicio Lancamento
class LancamentoModel(db.Model):
    __tablename__ = 'lancamento'
    id = db.Column(db.Integer, db.Sequence('lancamento_id_seq'), primary_key=True)
    estabelecimento = db.Column(db.String(100), nullable=False)
    data = db.Column(db.Date, nullable=False)
    valor = db.Column(db.Float, nullable=False)
    categoria_id = db.Column(db.Integer, db.ForeignKey("categoria.id"))
    categoria = db.relationship(
        CategoriaModel,
        backref=backref('categoria',
                        uselist=True,
                        cascade='delete,all'))
    fatura_id = db.Column(db.Integer, db.ForeignKey("fatura.id"))
    fatura = db.relationship(
        FaturaModel,
        backref=backref('fatura',
                        uselist=True,
                        cascade='delete,all'))

    def __init__(self, id, estabelecimento, data, valor, categoria, fatura, categoria_id):
        self.id = id
        self.estabelecimento = estabelecimento
        self.data = data
        self.valor = valor
        self.categoria = categoria
        self.fatura = fatura
        self.categoria_id = categoria_id

    @property
    def serialize(self):
        return {
          'id': self.id,
          'estabelecimento': self.estabelecimento,
          'data': self.data.strftime('%d/%m/%Y'),
          'valor': self.valor,
          'categoria': self.categoria.serialize,
          'fatura': self.fatura.serialize
        }

    def json(self):
        return {
                'id': self.id,
                'estabelecimento': self.estabelecimento,
                'data': self.data,
                'valor': self.valor,
                'categoria': {
                    'id': self.id,
                    'nome': self.nome
                },
                'fatura': {
                  'id': self.id,
                  'data_vencimento': self.data_vencimento,
                  'data_pagamento': self.data_pagamento,
                  'valor': self.valor
                }
               }
