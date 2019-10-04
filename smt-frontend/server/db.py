from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker

engine = create_engine('postgresql://postgres:postgres@localhost:5432/bills')

DBSession = sessionmaker(bind=engine)
session = DBSession()

DBSession = sessionmaker(bind=engine)
session = DBSession()

db = SQLAlchemy()
