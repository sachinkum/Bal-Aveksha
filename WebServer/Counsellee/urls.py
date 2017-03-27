from django.conf.urls import url
from django.contrib import admin
from . import views


urlpatterns = [
    url(r'^profile/$', views.SetProfile.as_view(), name='profile'),
    ]