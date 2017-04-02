from django.db import models
from Counsellee.models import CounselleeDetails
from Counsellor.models import CounsellorDetails
from django.contrib.auth.models import User

from WebServer.settings import MEDIA_ROOT


class SessionDetails(models.Model):
    sessionID = models.AutoField(primary_key=True)
    counselleeID = models.ForeignKey(CounselleeDetails, on_delete=models.CASCADE)
    counsellorID = models.ForeignKey(CounsellorDetails, on_delete=models.CASCADE)
    isCompleted = models.BooleanField(default=False)
    sessionDate = models.DateField()
    problem = models.CharField(max_length=100)
    description = models.TextField()
    reports = models.FileField(upload_to=MEDIA_ROOT)
    counselleefiles = models.FileField(null=True, upload_to= MEDIA_ROOT)

    def __str__(self):
        return "session ID: "+str(self.sessionID)+" Counsellee ID: "+str(self.counselleeID)+" Counsellor ID: "+str(self.counsellorID)