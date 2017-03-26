from rest_framework import serializers
from django.contrib.auth.admin import User

"""
Model Serializer class for model-Users
"""


class UserSerializer(serializers.ModelSerializer):

    class Meta:
        model = User
        fields = ('id', 'email', 'first_name', 'last_name', 'password')

    def create(self, validated_data):
        """
        Create and return a new `User` instance, given the validated data.
        """
        return User.objects.create(**validated_data)

    def update(self, instance, validated_data):
        """
        Update and return an existing `User` instance, given the validated data.
        """
        instance.id = validated_data.get('id', instance.id)
        instance.email = validated_data.get('email', instance.email)
        instance.first_name = validated_data.get('first_name', instance.first_name)
        instance.last_name = validated_data.get('l_name', instance.last_name)
        instance.password = validated_data.get('password', instance.password)
        instance.save()
        return instance
