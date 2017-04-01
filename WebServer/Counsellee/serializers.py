from rest_framework import serializers
from Counsellee.models import CounselleeDetails


class CounselleeDetailsSerializer(serializers.ModelSerializer):
    class Meta:
        model = CounselleeDetails
        exclude = ('role', )

