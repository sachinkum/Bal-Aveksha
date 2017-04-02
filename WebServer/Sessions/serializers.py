from Sessions.models import SessionDetails
from rest_framework import serializers


class SessionSerializer(serializers.ModelSerializer):
    class Meta:
        model = SessionDetails
        fields = '__all__'
