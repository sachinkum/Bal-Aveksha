from django.db import models

class AllUsers(models.Model):
    '''
    Model containing details of all users - Counsellors and Counsellees. The foreign key is the UserID.
    '''
    first_name = models.CharField(max_length=200)
    last_name = models.CharField(max_length=200)
    is_counsellor = models.BooleanField(default=False)
    uid = models.BigIntegerField()
