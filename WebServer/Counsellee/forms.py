from django import forms
from django.utils.translation import ugettext_lazy as _
from Counsellee.models import CounselleeDetails


class CounselleeDetailsForm(forms.ModelForm):
    gender = forms.ChoiceField(choices=['Male', 'Female', 'Other'])

    class Meta:
        model = CounselleeDetails
        fields = ['dateOfBirth', 'address', 'uid', 'phoneNo', 'gender', 'problem', 'description']
