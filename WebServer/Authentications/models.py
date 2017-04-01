from django.db import models
from django.contrib.auth.models import User


class CustomUser(User):
    '''
    Adds first_name and last_name to required fields in existing User model
    '''

    User.REQUIRED_FIELDS += ['first_name', 'last_name']
