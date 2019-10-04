from flask import request, jsonify, abort, url_for, json
from db import session
from models.user import UserModel as User
from flask_restful import Resource


class UserResource(Resource):
    def get(self):
        pass

    def post(self):
        username = request.json.get('username')
        password = request.json.get('password')
        if username is None or password is None:
          abort(400)  # missing arguments
        if session.query(User).filter_by(username=username).first() is not None:
          abort(400)  # existing user
        user = User(username=username)
        user.hash_password(password)
        session.add(user)
        session.commit()
        # return jsonify({'username': user.username}), 201, {'Location': url_for('get_user', id=user.id, _external=True)}
        return request.json, 201
