from django.db import models
from django.contrib.auth.models import User
from datetime import date


class CounsellorDetails(models.Model):
    username = models.ForeignKey(User, on_delete=models.CASCADE)
    dateOfBirth = models.DateField()
    age = models.IntegerField()
    address = models.CharField(max_length=1000)
    uid = models.BigIntegerField()
    phoneNo = models.BigIntegerField()
    gender = models.CharField(max_length=6)
    speciality = models.CharField(max_length=100)
    role = models.CharField(max_length=10, default='Counsellor')
    isIdle = models.BooleanField(default=True)
    noOfSessions = models.IntegerField(default=0)

