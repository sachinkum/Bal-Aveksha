from django.contrib import admin
from . import models

admin.site.register(models.AllUsers)
admin.site.register(models.CounsellorSessions)
admin.site.register(models.CounselleeSessions)
