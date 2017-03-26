from django.contrib.auth.models import User
from django import forms
from django.utils.translation import ugettext_lazy as _


class RegistrationForm(forms.ModelForm):
    password1 = forms.CharField(widget=forms.PasswordInput(attrs=dict(required=True, max_length=30, render_value=False)), label=_("Password"))
    password2 = forms.CharField(widget=forms.PasswordInput(attrs=dict(required=True, max_length=30, render_value=False)), label=_("Password (again)"))

    def clean(self):
        if 'password1' in self.cleaned_data and 'password2' in self.cleaned_data:
            if self.cleaned_data['password1'] != self.cleaned_data['password2']:
                raise forms.ValidationError(_("The two password fields did not match."))
        return self.cleaned_data

    class Meta:
        model = User
        fields = ['username', 'password1', 'password2', 'email', 'first_name', 'last_name']
