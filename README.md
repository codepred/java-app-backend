# java-maven-starter-project

Here is a starter project for backend.

## Instructions

### IntelliJ IDEA

1. Open IntelliJ IDEA and select _File > Open..._.
2. Choose the java-maven-starter-project directory and click _OK_.
3. Select _File > Project Structure..._ and ensure that the Project SDK and language level are set to use Java 17.
4. Open the Maven view with _View > Tool Windows > Maven_.
5. In the Maven view, under _Plugins > dependency_, double-click the `dependency:unpack` goal. This will unpack the native libraries into $USER_HOME/.arcgis.
6. In the Maven view, run the `compile` phase under _Lifecycle_ and then the `exec:java` goal to run the app.

### Command Line

1. `cd` into the project's root directory.
2. Run `./mvnw dependency:unpack` on Linux/Mac or `mvnw.cmd dependency:unpack` on Windows to unpack the native libraries to $USER_HOME/.arcgis.
3. Run `./mvnw compile exec:java` on Linux/Mac or `mvnw.cmd compile exec:java` on Windows to run the app.

