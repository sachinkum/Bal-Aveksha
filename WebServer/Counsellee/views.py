from datetime import date
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
from django.contrib.auth import authenticate
from django.views.generic import FormView

from Authentications.forms import RegistrationForm
from Counsellee.forms import CounselleeDetailsForm
from . import models
from django.contrib.auth.models import User
from Authentications.serializers import UserSerializer
from django.http import Http404
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from rest_framework.parsers import JSONParser
from Counsellee.models import CounselleeDetails


class SetProfile(FormView):
    form_class = CounselleeDetailsForm
    template_name = 'Profile/setProfile.html'

    def form_valid(self, form):
        if self.request.method == "POST":
            dateOfBirth = form.cleaned_data.get('dateOfBirth')
            today = date.today()
            age = today.year - dateOfBirth.year - ((today.month, today.day) < (dateOfBirth.month, dateOfBirth.day))

            cleanedProfile = CounselleeDetails.objects.create(
                username=self.request.user,
                dateOfBirth=form.cleaned_data.get('dateOfBirth'),
                age=age,
                address=form.cleaned_data.get('address'),
                uid=form.cleaned_data.get('uid'),
                phoneNo=form.cleaned_data.get('phoneNo'),
                gender=form.cleaned_data.get('gender'),
                problem=form.cleaned_data.get('problem'),
                description=form.cleaned_data.get('description')
            )
            cleanedProfile.save()
            return render(self.request, 'Authentications/Index.html', {'userName': User.username})
        else:
            return render(self.request, self.template_name, {'form': form, 'message': 'Something went Wrong'})




