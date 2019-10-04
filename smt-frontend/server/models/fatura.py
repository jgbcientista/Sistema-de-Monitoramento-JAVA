from db import db


class FaturaModel(db.Model):
    __tablename__ = 'fatura'

    id = db.Column(db.Integer, primary_key=True)
    data_vencimento = db.Column(db.Date, nullable=False)
    data_pagamento = db.Column(db.Date, nullable=False)
    valor = db.Column(db.Float, nullable=False)

    def __init__(self, id, data_vencimento, data_pagamento, valor):
        self.id = id
        self.data_vencimento = data_vencimento
        self.data_pagamento = data_pagamento
        self.valor = valor

    @property
    def serialize(self):
        return {
          'id': self.id,
          'data_vencimento': self.data_vencimento.strftime('%d/%m/%Y'),
          'data_pagamento': self.data_pagamento.strftime('%d/%m/%Y'),
          'valor': self.valor
        }

    def json(self):
        return {
          'id': self.id,
          'data_vencimento': self.data_vencimento,
          'data_pagamento': self.data_pagamento,
          'valor': self.valor
        }

