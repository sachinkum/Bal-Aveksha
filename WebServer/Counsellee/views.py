from datetime import date
from django.shortcuts import render
from django.views.generic import FormView
from rest_framework.permissions import IsAuthenticated
from Counsellee.forms import CounselleeDetailsForm
from django.contrib.auth.models import User
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
from Counsellee.models import CounselleeDetails
from Counsellee.serializers import CounselleeDetailsSerializer


@api_view(['GET'])
@authentication_classes((TokenAuthentication, JSONWebTokenAuthentication))
@permission_classes((IsAuthenticated,))
def dashboardView(request):
    '''
    URL: '/dashboard/'
    Opens User Dashboard if user is authenticated
             otherwise responds with HTTP_401_UNAUTHORIZED
    '''
    content = {
        'user': request.user,  # `django.contrib.auth.User` instance.
        'auth': request.auth  # None
    }
    if content['auth'] is not None:
        return render(request, 'homepage/index.html', content)
    else:
        return Response(request, status.HTTP_401_UNAUTHORIZED)

class SetProfile(APIView):
    '''
    retrieves a counsellee profile or sets/update profile 
    '''

    permission_classes = IsAuthenticated
    serializer_class = CounselleeDetailsSerializer

    def get(self, request):

        '''
        
        :param request: 
        :return: 
            status: HTTP_200_OK if existing details found
                    HTTP_404_NOT_FOUND if details not found
        '''
        try:
            counsellee = CounselleeDetails.objects.get(username=request.user.username)
        except CounselleeDetails.DoesNotExist:
            return Response(request,status.HTTP_404_NOT_FOUND)
        serializer = CounselleeDetailsSerializer(counsellee)
        return Response(request,serializer.data,status.HTTP_200_OK)

    def post(self, request):
        '''
        
        :param request: 
        :return:
            status: HTTP_200_OK if requested data is valid
                    HTTP_400_BAD_REQUEST if data not valid
        '''
        deserializer = CounselleeDetailsSerializer(data=request.data)
        if deserializer.is_valid():
            deserializer.save()
            return Response(request, status.HTTP_200_OK)
        return Response(request, status.HTTP_400_BAD_REQUEST)


class ASetProfile(FormView):
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
