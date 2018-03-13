**demo spring mongo app**

to build docker image
there is plugin in pom file

```mvn clean install```

and to run it

```docker-compose up```

run jmeter tests
```jmeter -n -t performance.jmx -l result.jtl -e -o dashboard```