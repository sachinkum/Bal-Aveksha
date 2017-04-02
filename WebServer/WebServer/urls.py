"""WebServer URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.10/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf import settings
from django.conf.urls import url
from django.contrib import admin
from django.conf.urls import include
from django.views.generic import RedirectView
from django.conf.urls import url
from django.contrib import admin
from rest_framework.urlpatterns import format_suffix_patterns
from Authentications import views
from rest_framework_jwt.views import obtain_jwt_token
from rest_framework_jwt import views as jwt_views
from django.conf.urls.static import static



urlpatterns = [
    url(r'^admin/', admin.site.urls),
    url(r'^Authentications/', include('Authentications.urls')),
    url(r'^Counsellee/', include('Counsellee.urls')),
    url(r'^signup/', views.signupView),
    # url(r'^Counsellor/',include('Counsellor.urls')),
    url(r'^(?P<username>[\w]+)/setprofile',views.setprofileView),
    url(r'^$', views.homepageView),
    url(r'^accounts/', include('django.contrib.auth.urls')),
    url(r'^auth/', include('djoser.urls.authtoken')),
    url(r'^account/', include('djoser.urls')),
    url(r'^auth/login/', jwt_views.obtain_jwt_token, name='auth'),
    # url(r'^auth/logout/',)
    url(r'^Sessions/', include('Sessions.urls')),
    url(r'^userrole/', views.checkUser),
    url(r'^(?P<username>[\w]+)/counsellordashboard/', views.counsellorDashboardView),
    url(r'^(?P<username>[\w]+)/counselleedashboard/', views.counselleeDashboardView),
]
if settings.DEBUG:
    urlpatterns += static(settings.STATIC_URL, document_root=settings.STATIC_URL)
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
# urlpatterns = format_suffix_patterns(urlpatterns)
