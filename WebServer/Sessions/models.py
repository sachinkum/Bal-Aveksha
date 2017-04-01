from django.db import models
from Counsellor.models import CounsellorDetails
from Counsellee.models import CounselleeDetails


class SessionModel(models.Model):
    sessionID = models.AutoField(primary_key=True)
    counselleeID = models.ForeignKey(CounselleeDetails)
    counsellorID = models.ForeignKey(CounsellorDetails)
    problem = models.CharField(max_length=100)
    description = models.TextField()
    isCompleted = models.BooleanField(default=False)
    reports = models.TextField()
