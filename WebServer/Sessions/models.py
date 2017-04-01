from django.db import models
from Counsellee.models import CounselleeDetails
from Counsellor.models import CounsellorDetails
from django.contrib.auth.models import User


class SessionDetails(models.Model):
    sessionID = models.AutoField(primary_key=True)
    counselleeID = models.ForeignKey(CounselleeDetails, on_delete=models.CASCADE)
    counsellorID = models.ForeignKey(CounsellorDetails, on_delete=models.CASCADE)
    isCompleted = models.BooleanField(default=False)
    sessionDate = models.DateField()
    problem = models.CharField(max_length=100)
    description = models.TextField()
    reports = models.TextField()

