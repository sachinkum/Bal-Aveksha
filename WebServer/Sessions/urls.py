from django.conf.urls import url
from django.contrib import admin
from . import views

urlpatterns = [
    url(r'^requestSession/', views.allotCounsellor, name='allot_counsellor'),
    url(r'^counselleeSession/',views.counselleeSessions),
    url(r'^counsellorSession',views.counsellorSessions),
]