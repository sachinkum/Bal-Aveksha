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
from django.contrib.auth import authenticate, login
from Authentications.forms import RegistrationForm
from . import models
from django.contrib.auth.models import User
from Authentications.serializers import UserSerializer
from django.http import Http404
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from Counsellee import urls


def homepageView(request):
    return render(request, 'homepage/index.html')

def Index(request):
    return render(request, 'Home/index.html', {'user': request.user})


class RegisterUser(View):
    form_class = RegistrationForm
    template_name = 'registration/register.html'

    def get(self, request):
        form = self.form_class(None)
        return render(request, self.template_name, {'form': form})

    def post(self, request):
        form = self.form_class(request.POST)

        if form.is_valid():
            user = form.save(commit=False)

            username = form.cleaned_data['username']
            password = form.cleaned_data['password1']
            email = form.cleaned_data['email']
            first_name=form.cleaned_data['first_name']
            last_name=form.cleaned_data['last_name']
            user.set_password(password)
            user.save()

            user = authenticate(username=username, password=password)

            if user is not None:
                if user.is_active:
                    login(request, user)
                    return render(request, 'Profile/profileRedirect.html', {'username': username})
                else:
                    return render(request, self.template_name, {'form': form, 'message': 'Could not activate'})
            else:
                return render(request, self.template_name, {'form': form, 'message': 'Could not login'})

        else:
            message = 'Something Went wrong please fill in correct details'
            form = self.form_class(None)
            return render(request, self.template_name, {'form': form, 'message': message})


@csrf_protect
def register_success(request):
    return render(request, 'Authentications/Index.html')

#
# class UserList(APIView):
#     """
#     List all albums, or create a new album.
#     """
#     # def get(self, request, format=None):
#     #     user = User.objects.all()
#     #     serializer = UserSerializer(user, many=True)
#     #     return Response(serializer.data)
#
#     def get(self, request, format = None):
#         serializer=UserSerializer(data=request.data)
#  #        serializer = UserSerializer(data=request.data)
#   #       if serializer.is_valid():
#              #serializer.save()
#         user = authenticate(username="arjun1234", password="123456")
#         if user is not None:
#             return Response(user, status=status.HTTP_200_OK)
#         else:
#             return Response(serializer.errors, status=status.HTTP_401_UNAUTHORIZED)