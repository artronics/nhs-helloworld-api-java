## Hello World user restricted NHS Digital API

A sample project demonstrating how to perform [oauth2](https://oauth.net/2/) authentication to access user restricted api.

#### Useful links
- [NHS Developer resource](https://digital.nhs.uk/developer)
- [Hello World API Tutorial](https://digital.nhs.uk/developer/api-tutorials)

## Running Application
You need [jdk](https://docs.datastax.com/en/jdk-install/doc/jdk-install/installOpenJdkDeb.html) version 1.8 or later and, also [Maven](http://maven.apache.org/) to build and run the code.
Clone this repo and run this command:
```shell script
CLIENT_ID=<client_id> CLIENT_SECRET=<client_secret> mvn spring-boot:run
```

**Note**: Use your `client_id` and `client_password`. Please refer to [this tutorial](https://digital.nhs.uk/developer/api-tutorials) to register your application and get your client id and secret.

Now open a browser window and enter `http://localhost:8080/secured` this is a secured resource and you should see an NHS login page.
Enter your credentials and you should see a web page with the jwt token. You can use this token to access secured resource:

```shell script
$ curl -X GET -H "Authorization: Bearer <paste your access_token here>" https://internal-dev.api.service.nhs.uk/hello-world/hello/user
{
  "message": "Hello User!"
}%
```

