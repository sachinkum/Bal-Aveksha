from django.conf.urls import url
from django.contrib import admin
from . import views


urlpatterns = [
    url(r'^$', views.Index, name='index'),
    # url(r'^register/$', views.RegisterUser.as_view(), name='register'),
    # url(r'^register/success/$', views.register_success, name='register_success'),

]