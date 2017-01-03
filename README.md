# MapServiceBrokerForCloudFoundry
This is a service which is used as a service broker in the PCF. 

to use:

git clone https://github.com/santoshkar/MapServiceBrokerForCloudFoundry.git

mvn clean install
cf push --random-route
cf apps

You should be able to see the application under the list.

View the service broker and URL
=================================
cf cf service-brokers

here you should be able to see the URL. To test the URL, you can use in the broswer as:
<URL>/v2/catalog

Register service broker to market place
========================================
cf create-service-broker hashmap-broker santosh santosh <URL of service broker> --space-scoped
