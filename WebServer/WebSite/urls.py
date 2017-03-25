from django.conf.urls import url
from django.contrib import admin
from . import views


urlpatterns = [
    url(r'^$', views.Index, name='index'),
    url(r'^AllUsers/$', views.AllUsers.as_view(), name='all_users'),
    url(r'^CounsellorSessions/$', views.CounsellorSessions, name='counsellor_sessions'),
    url(r'^CounselleeSessions/$', views.CounselleeSessions, name='counsellee_sessions'),

]