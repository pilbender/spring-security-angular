# Spring Security Angular Frontend

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

```
ng build --watch
ng build --configuration development --watch <-- Does work right now.
```

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build
### Full Build
Build the full project, frontend and backend
```
mvn clean install -Pnpm
```

### Frontend only
To build the project.
```
ng build
```
or to watch the frontend for changes
```
ng build --watch
```

### Backend only
```
mvn clean install
```

## Debug
This can be used in conjuction with 
```
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.config.location=file:src/main/resources/application.properties" -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
```
Or
```
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005 -jar target/spring-security-angular-1.0.0-SNAPSHOT.jar
```

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).
