from django.db import models
from django.contrib.auth.models import User
from datetime import date


class CounselleeDetails(models.Model):
    username = models.ForeignKey(User, on_delete=models.CASCADE)
    dateOfBirth = models.DateField()
    age = models.IntegerField()
    address = models.CharField(max_length=1000)
    uid = models.BigIntegerField()
    phoneNo = models.BigIntegerField()
    gender = models.CharField(max_length=6)
    problem = models.CharField(max_length=100)
    description = models.TextField()
    role = models.CharField(max_length=10, default='Counsellee')
