# response-builder
AccessGate Labs Response Builder is a standard Java written wrapper to help your application REST APIs produce standard/exception responses. The manager follows certain nomenclatures and semantics to produce responses that are easy to consume and quick to interpret.

Licensed under the Apache License, Version 2.0 (the "License") you may not use this file except in compliance with the License. You may obtain a copy of the License at https://www.apache.org/licenses/LICENSE-2.0.

- Author: [Ekansh Tiwari](https://linkedin.com/in.reachekansh)
- Since: 1.0.0
- Current version: 1.0.4
- See: https://github.com/AccessGateLabs/response-builder

- Website: https://www.accessgatelabs.com
- LinkedIn: https://www.linkedin.com/company/AccessGateLabs

<img src="https://ddq9rurjysv4s.cloudfront.net/logo/logo.svg" alt="AccessGate Labs Logo" width="160px">

Requirements
------------

- [Spring](https://start.spring.io/)
- [Dependency](https://mvnrepository.com/) 1.0.3 (Maven or Gradle)

Response Builder
---------------------
Many customizations have already been written but you are most welcome to customize it for your application requirement.

*Note:* This project supports [HATEOAS](https://en.wikipedia.org/wiki/HATEOAS) (Hypermedia as the Engine of Application State) making it easy for your application to dynamically pass links and next actions that can be performed by the API consumer. You can refer to Hypermedia-driven REST web service with Spring (`https://spring.io/guides/gs/rest-hateoas/`).

### Getting started
Add the dependency:

> `Maven`
```sh
<dependency>
    <groupId>com.accessgatelabs.oss</groupId>
  	<artifactId>response-builder</artifactId>
  	<version>1.0.4</version>
</dependency>
```

Create a `class` to `extends` `RestExceptionHandler` from `com.accessgatelabs.oss.builder.exceptions` package and annotate it with `@ControllerAdvice(basePackages = "com.your_package")`
More information on @ControllerAdvice can be found [here](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ControllerAdvice.html).

```java
@ControllerAdvice(basePackages = "com.your_package")
public class CustomRestExceptionHandler extends RestExceptionHandler {
	
  ...
	
}
```

Contributing
---------------------------

AccessGate Labs is the work of contributors like you. We value your inputs!

To contribute, please read the contribution guidelines: [Contributing to AccessGate Labs](.github/CONTRIBUTING.md)

Issues on GitHub are intended to be related to bugs or feature requests with provider codebase. See https://www.accessgatelabs.com/docs/community/index.html for a list of community resources to ask questions about AccessGate Labs.
