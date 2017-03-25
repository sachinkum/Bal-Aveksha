from django.shortcuts import render
from django import http
from django.views import generic
from . import models


def Index(request):
    num_users = models.AllUsers.objects.all().count()
    return render(request,'WebSite/Index.html',context={'num_users':num_users})


class AllUsers(generic.ListView):
    model = models.AllUsers
    context_object_name = 'all_users_list'
    template_name = 'WebSite/AllUsers.html'
    #return (http.HttpResponse('<h1>Page showing the details of everyone</h1>'))


def CounsellorSessions(request):
    #model = models.CounsellorSessions
    #template_name = 'WebSite/CounsellorSessions.html'
    return (http.HttpResponse('<h1>Page showing counsellings given by a counsellor</h1>'))


def CounselleeSessions(request):
    return (http.HttpResponse('<h1>Page showing counsellings taken by a  counsellee</h1>'))



