# SNS Producer ![image](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![image](https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white) ![image](https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white)

Project for sending notifications to a topic [SNS](https://aws.amazon.com/sns) using SpringBoot.

This project makes use of the [custom-logging-starter](https://github.com/natanaelmartinezassis/custom-logging-starter)
library developed for sending logs to [Logstash](https://www.elastic.co/pt/logstash/)
and/or [AWS Kinesis](https://aws.amazon.com/pt/kinesis/).

Messages sent to the SNS are encapsulated with the automatically generated traceId and spandId and can be injected into
the MDC of the application that consumes the
message. [See: [SQS Consumer](https://github.com/natanaelmartinezassis/sqs-consumer)]

---

# How To

### First Step: build

Build the application to generate the *.jar artifact.

```
$ ./mvnw clean package
```

### Second Step: docker image

Generate the application docker image.

```
$ cd docker-compose/
$ docker-compose build sns-producer
```

### Third Step: localstack and application containers

Create localstack and application containers using docker-compose.

```
$ docker-compose up -d
```

### Fourth Step: create SNS topic

Create the SNS topic for sending notifications.

```
$ aws --endpoint-url=http://localhost:4566 sns create-topic --name add-foobar-topic
```

### Fifth Step: test

Send a request.

```
$  curl -X POST \
    --header 'content-type: application/json' \
    --url http://localhost:8080/v1/foobar/add \
    --data '{"foo": "1234567890","bar": "12345678000190","value": 123.45}' \
    -w "%{http_code}\n"
```
