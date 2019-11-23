# e.Pilot backend applicant test

The aim of the application is to check if the given number is multipled of 7 or 5.

## Service Description
You should be able to start the example application by executing com.epilot.Application, which starts a webserver on port 8080 (http://localhost:8080).

The project is based on a small web service which uses the following technologies:

* Java 1.8
* Spark
* Maven

You should be aware of the following conventions while you are working on this exercise:

 * All new entities should have an ID with type of Long and a date_created with type of ZonedDateTime.
 * The architecture of the web service is built with the following components:
 	* DTOs: Objects which are used for outside communication via the API
    * Controller: Implements the processing logic of the web service, parsing of parameters and validation of in- and outputs.
    * Service: Implements the business logic and handles the access to the PaymentBean.
	* Util: Implements the converter for JSON objects.
	* Exception: Implements the custom exception classes.
	
To test the service we can using example as Request:

POST: localhost:8080/fiz
{
	"number":25
}

values can be sent as string or numbers, the value in number should present the number wanted to be checked if it is multipled of 5 or not, 
and if so response will be as below, and the value should always present integer value, in case of float, null or 0 exception will be returned.

{
    "multipled": true
}

multipled would be true or false depend on the result.


POST: localhost:8080/baz
{
	"number":21
}

values can be sent as string or numbers, the value in number should present the number wanted to be checked if it is multipled of 5 or not, and if so response will be as below:
{
    "multipled": true
}

multipled would be true or false depend on the result.


The application can be also run using docker using the following comment:

* docker build -t foo . && docker run -p 8080:8080 -it foo


Thanks!