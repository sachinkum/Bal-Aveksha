from django.http.response import JsonResponse, HttpResponse
from django.shortcuts import render

# Create your views here.
from django.utils.six import BytesIO
from django.views.decorators.csrf import csrf_exempt
from rest_framework import status
from rest_framework.authentication import TokenAuthentication
from rest_framework.decorators import api_view, authentication_classes, permission_classes
from rest_framework.generics import ListAPIView
from rest_framework.parsers import JSONParser
from rest_framework.permissions import IsAuthenticated
from rest_framework.views import APIView
from rest_framework_jwt.authentication import JSONWebTokenAuthentication
from Sessions.serializers import SessionSerializer
from Counsellor.models import CounsellorDetails
from Counsellee.models import CounselleeDetails
from Sessions.models import SessionDetails
from datetime import date
from rest_framework.response import Response
from django.contrib.auth.models import User
from django.contrib.sessions.models import Session
from django.utils import timezone
import json


def requestSessionView(request):
    '''

    request method: POST
    :returns details containing form data

    '''
    # stream=BytesIO(request.data)
    # data = JSONParser().parse(stream)
    # serializer = SessionSerializer(data=data)
    # serializer.is_valid()
    # userid = serializer
    # data = json.loads(request.body.decode("utf-8"))
    # username = data['username']
    print("here")
    data=request.POST
    details = {}
    details['userid'] = data['username']
    details['problem'] = data['problem']
    details['description'] = data['description']
    return details




def get_all_logged_in_users():
    # Query all non-expired sessions
    # use timezone.now() instead of datetime.now() in latest versions of Django
    sessions = Session.objects.filter(expire_date__gte=timezone.now())
    uid_list = []

    # Build a list of user ids from that query
    for session in sessions:
        data = session.get_decoded()
        uid_list.append(data.get('_auth_user_id', None))

    # Query all logged in users based on id list
    return User.objects.filter(id__in=uid_list)


@api_view(['POST'])
@authentication_classes([TokenAuthentication, JSONWebTokenAuthentication])
@permission_classes([IsAuthenticated])
def allotCounsellor(request):
    allottedCounsellor = None
    details = requestSessionView(request)
    print(details)
    freeCounsellors = CounsellorDetails.objects.filter(isidle=True)
    print("fc")
    for counsellor in freeCounsellors:
        if counsellor.speciality == details['problem']:
            allottedCounsellor = counsellor
            print(allottedCounsellor)
            break
    print("after for loop")
    if allottedCounsellor is None:
        print("first cond")
        return HttpResponse("NA")

    else:
        u_id = User.objects.get(username=details['userid']).id
        counselleeInstance = CounselleeDetails.objects.get(username_id=u_id)
        newSession = SessionDetails.objects.create(
            counselleeID=counselleeInstance,
            problem=details['problem'],
            description=details['description'],
            sessionDate=date.today(),
            counsellorID=allottedCounsellor
        )
        newSession.save()
        allottedCounsellor.isidle = False
        allottedCounsellor.noofsessions += 1
        allottedCounsellor.save()
        print(newSession)
        return HttpResponse(newSession)
        # return render(request,context={'session ID':newSession.sessionID})


@csrf_exempt
@permission_classes([IsAuthenticated])
@authentication_classes([JSONWebTokenAuthentication, TokenAuthentication])
def counselleeSessions(request):
    if request.method == 'GET':
        username = request.GET['username']
        u_id = User.objects.get(username=username).id
        query_set = SessionDetails.objects.filter(counselleeID_id=u_id)
        serializer = SessionSerializer(query_set,many=True)
        print(tuple(serializer.data))
        return JsonResponse(tuple(serializer.data),safe=False)


@csrf_exempt
@permission_classes([IsAuthenticated])
@authentication_classes([JSONWebTokenAuthentication, TokenAuthentication])
def counsellorSessions(request):
    if request.method == 'GET':
        username = request.GET['username']
        u_id = User.objects.get(username=username).id
        query_set = SessionDetails.objects.filter(counsellorID_id=u_id)
        serializer = SessionSerializer(query_set)
        print(tuple(serializer.data))
        return JsonResponse(tuple(serializer.data))
