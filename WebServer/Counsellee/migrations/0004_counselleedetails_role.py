# -*- coding: utf-8 -*-
# Generated by Django 1.10.6 on 2017-03-29 07:46
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Counsellee', '0003_auto_20170327_1825'),
    ]

    operations = [
        migrations.AddField(
            model_name='counselleedetails',
            name='role',
            field=models.CharField(default='Counsellee', max_length=10),
        ),
    ]
