from db import db


class CategoriaModel(db.Model):
    __tablename__ = 'categoria'

    id = db.Column(db.Integer, primary_key=True)
    nome = db.Column(db.String(50))

    def __init__(self, id, nome):
        self.id = id
        self.nome = nome

    @property
    def serialize(self):
      return {
        'id': self.id,
        'nome': self.nome
      }

    def json(self):
      return {'id': self.id, 'nome': self.nome}
