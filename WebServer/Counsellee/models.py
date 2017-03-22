from __future__ import unicode_literals
#from django.contrib.auth.models import User
from django.db import models
from django.db.models.signals import post_save
from django.dispatch import receiver


class Counsellee(models.Model):
    # username = models.CharField(max_length=100,primary_key=True)
    emailID = models.CharField(max_length=100,primary_key=True)
    password = models.CharField(max_length=100)
    firstName = models.CharField(max_length=100)
    lastName = models.CharField(max_length=100)
    dateOfBirth = models.DateField
    gender = models.CharField(max_length=20)
    phoneNumber = models.IntegerField()
    address = models.CharField(max_length=300)
    problem = models.CharField(max_length=50)
    uid = models.BigIntegerField()
    description = models.TextField()
