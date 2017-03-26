from django.http import HttpResponseRedirect
from django.shortcuts import render, render_to_response
from django.contrib.auth.models import User
from django.template import RequestContext
from django.views import View
from django.views import generic
from django.views.decorators.csrf import csrf_protect

from WebSite.forms import RegistrationForm
from . import models


#@csrf_protect
def Index(request):
    num_users = models.AllUsers.objects.all().count()
    return render(request, 'WebSite/Index.html', context={'num_users': num_users})


class AllUsers(generic.ListView):
    model = models.AllUsers
    context_object_name = 'all_users_list'
    template_name = 'WebSite/AllUsers.html'
    #return (http.HttpResponse('<h1>Page showing the details of everyone</h1>'))


class RegisterUser(View):
    form_class = RegistrationForm
    template_name = 'registration/register.html'

    def get(self, request):
        form = self.form_class(None)
        return render(request, self.template_name, {'form': form})

    def post(self, request):
        form = self.form_class(request.POST)

        if form.is_valid():
            user = User.objects.create_user(
                username=form.cleaned_data['username'],
                password=form.cleaned_data['password1'],
                email=form.cleaned_data['email'],
                first_name=form.cleaned_data['first_name'],
                last_name=form.cleaned_data['last_name']
            )
            user.save()
            return render(request, 'WebSite/Index.html', context={'title': 'register_success'})


@csrf_protect
def register_success(request):
    return render(request, 'WebSite/Index.html')
