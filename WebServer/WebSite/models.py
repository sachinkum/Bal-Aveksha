from django.db import models

class AllUsers(models.Model):
    '''
    Model containing details of all users - Counsellors and Counsellees. The foreign key is the UserID.
    '''
    first_name = models.CharField(max_length=200)
    last_name = models.CharField(max_length=200)
    is_counsellor = models.BooleanField(default=False)
    date_of_birth = models.DateField
    uid = models.BigIntegerField()
    username = models.CharField(max_length=100)
    emailID = models.EmailField


class CounsellorSessions(models.Model):
    username = models.ForeignKey('AllUsers', on_delete=models.CASCADE)
    duration = models.TimeField
    #clientID =
    #recording
    #report


class CounselleeSessions(models.Model):
    username = models.ForeignKey('AllUsers', on_delete=models.CASCADE)
    duration = models.TimeField
    # docID
    #report
    #recording