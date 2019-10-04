import os
import sys

from sqlalchemy.ext.declarative import declarative_base

from sqlalchemy.orm import relationship, scoped_session, sessionmaker, backref
from sqlalchemy import create_engine
from models.categoria import CategoriaModel

from db import db

engine = create_engine('postgresql://postgres:postgres@localhost:5432/bills')
db_session = scoped_session(sessionmaker(autocommit=False,
                                         autoflush=False,
                                         bind=engine))
Base = declarative_base()
Base.query = db_session.query_property()

