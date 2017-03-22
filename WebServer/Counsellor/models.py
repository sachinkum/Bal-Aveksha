from __future__ import unicode_literals

from django.db import models


class Counsellor(models.Model):
    username = models.CharField(max_length=100,primary_key=True)
    emailID = models.CharField(max_length=100)
    password = models.CharField(max_length=100)
    firstName = models.CharField(max_length=100)
    lastName = models.CharField(max_length=100)
    dateOfBirth = models.DateField
    gender = models.CharField(max_length=20)
    phoneNumber = models.IntegerField()
    address = models.CharField(max_length=300)
    specialisation = models.CharField(max_length=50)
    uid = models.BigIntegerField()





