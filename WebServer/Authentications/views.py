from django.http import HttpResponse
from django.http import HttpResponseRedirect
from django.shortcuts import render, render_to_response, redirect
from django.contrib.auth.models import User
from django.template import RequestContext
from django.template import loader
from django.urls import reverse_lazy
from django.views import View
from django.views import generic
from django.views.decorators.csrf import csrf_protect
from Counsellee.models import CounselleeDetails
from Counsellee.forms import CounselleeDetailsForm

from Authentications.forms import RegistrationForm
from . import models


def Index(request):
    return render(request, 'Authentications/Index.html', {'user': request.user})


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
            return render(request, 'Authentications/Index.html', {'userName': User.username})
        else:
            message = 'Something Went wrong please fill in correct details'
            form = self.form_class(None)
            return render(request, self.template_name, {'form': form, 'message' : message})


@csrf_protect
def register_success(request):
    return render(request, 'Authentications/Index.html')
