# springboot-undertow

## Problem with high cpu usage after performance test:
1. Run feeder-service: ```cd feeder-service && ./gradlew bootRun```
  - service is running on port 8081 with one endpoint data
2. Run consumer-service: ```cd consumer-service && ./gradlew bootRun```
  - service is running on port 8080 with one endpoint consume
3. Run performance test (30-60 sec should be enough) e.g: wrk/jmeter/gatling
  - ```wrk -t4 -c100 -d60 http://localhost:8080/consume```
4. After test you can observe that cpu is still used
