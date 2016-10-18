#!/bin/bash

mongoimport --db zomato --collection restaurants --drop --file /var/log/restaurants.json

