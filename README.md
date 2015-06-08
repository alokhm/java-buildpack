# Dynatrace Service Broker Deployment and Registration

Java spring boot application has been developed for service-broker which will give profile, server details for dynatrace server and collector which has been used for dynatrace agent to send trace data to them. This service-broker will be registered in cloudfoundry , so that in future we can create a service and from the service bind VCAP_SERVICES values to any application.

## Steps to deploy and register service broker

## Maven and Java
The application is Java spring boot application and packaged as a executable JAR file. To build the application user needs maven build tool.

## Deploy service broker application in cloud foundry
Here our assumption is you have preinstalled CF CLI .To deploy application either user needs manifest file where user will make all required entries or user can directoly push the application by using arguments via CF CLI. If user is not passing buildpack url then default cloud foundary buildpack url will be used
here

To deploy run the following commands:
If user is having manifest file
```bash
$ mvn package
$ cf push
```
If user is passing arguments from CF CLI
```bash
$ mvn package
$ cf push <app_name> –p <jar_name>
```

## Register Service-broker in cloud foundry 
To register servicebroker in cloud foundary use following steps:
```bash
$ cf create-service-broker <service_broker> <username> <password> <url_for_service_broker>
```

## Marketplace 
List all services,plans and desription
```bash
$ cf marketplace
```
## Create Service from Service broker 
```bash
$ cf create-service <service_broker> <plans> <service_name>
```
Now user can bind any application with this created service.

## Environment Variables
Since the application is designed to work in a PaaS environment, all configuration is done with environment variables.  The `server` and `profile` value is the only one that is provided by Dynatrace.  All others are unique to a deployment.

| Key | Description
| --- | -----------
| `server` | The Dynatrace server ip with portnumber to provide to all applications.  
| `profile` | The profile that can used for mentioning agent-name during setting java agent path.  This can be any value.


## Model Notes
The model is for the REST/Controller level. It can be extended as needed.
