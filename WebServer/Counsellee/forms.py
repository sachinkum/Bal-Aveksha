from django import forms
from django.utils.translation import ugettext_lazy as _
from Counsellee.models import CounselleeDetails
from datetime import date


class CounselleeDetailsForm(forms.ModelForm):
    dateOfBirth = forms.DateField()

    class Meta:
        model = CounselleeDetails
        fields = ['dateOfBirth', 'address', 'uid', 'phoneNo', 'gender', 'problem', 'description']
