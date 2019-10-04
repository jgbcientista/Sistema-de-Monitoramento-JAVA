from db import db
from passlib.apps import custom_app_context as pwd_context


class UserModel(db.Model):
    __tablename__ = 'user'

    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(32))
    password = db.Column(db.String(64))

    # def __init__(self, id, username, password):
    #     self.id = id
    #     self.username = username
    #     self.password = password
    #
    def json(self):
        return {'name': self.username, 'password': self.password}

    def hash_password(self, password):
        self.password = pwd_context.encrypt(password)

    def verify_password(self, password):
        return pwd_context.verify(password, self.password)

    def serialize(self):
        return {
          'id': self.id,
          'username': self.username,
          'password': self.password
        }
