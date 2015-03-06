#Open Biosensing Project

**Note: This is a work in progress! It has only been tested in very limited scenarios.**

No warranties, responsibility, etc. are assumed.

##1. Compatibility and dependencies

Fitbit API:
https://www.fitbit.com/dev/dev

Connecting to the fitbit API using OAuth 1.0. Note, this will soon change to OAuth 2.0 and will
require a new authentication scheme.

Maven is used as the dependency manager, but if the pom.xml file is left out, libraries can be
added directly to the classpath.

Using the OAuth client library for Java scribe-java (via Maven) https://github.com/fernandezpablo85/scribe-java

Also using the gson library (via Maven) to process json output from the API
https://code.google.com/p/google-gson/

##2. (Limited) Instructions for downloading running this source

Register an application to the fitbit API. Details: https://dev.fitbit.com/apps/new

Clone the project. Within the src/main directory, create a second directory called "resources".
In the resources directory, create a new file called "api.properties". In this file, create an
entry called "key=" and trail with your consumer key and a second entry called "secret=" 
followed by your consumer secret. The contents of api.properties should look like this:

```
key=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
secret=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
```

The first time you compile and run the app, you will be asked to copy a URL into your browser, approve,
and the copy the PIN back into the program. If that is successful, any subsequent runs should not
require re-authentication. Note that the authentication process creates a second file within the
resources folder, "authorization.properties", so if this file is missing or corrupted, you will 
have to re-verify.

The program is currently run through the main method in Fitbit.java. You can program what to do based 
on this method, for now. By default, the same user for which the API has been registered is retrieved,
his or her profile data saved to a file "*encodedId*.properties" in the resources folder (where 
encodedId is the actual encoded ID value retrieved from the profile), sleep data for 1 day ago is
pulled from the API, and then it is outputted to a CSV file. Note that the file output location is 
currently hard-coded, and can be changed in FileIO.java.

Multiple improvements coming soon.
