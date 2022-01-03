# Zomboid Server

A ready to go distribution of Project Zomboid multiplayer (41.60) shipped as a Docker container.

# Prerequisites

I had to create a `project-zomboid.jar` file by running `jar cvf project-zomboid.jar ./**/*.class` from the installation directory of zomboid.

I then had to install that jar into my local maven repository with the following command:

```
mvn install:install-file -Dfile=./project-zomboid.jar -DgroupId=zombie -DartifactId=zombie -Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true
```
