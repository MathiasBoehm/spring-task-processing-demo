# Description
Simple spring boot demo playground for parallel task processing on multiple nodes



# Run Demo
Start two service instances

```shell
$ java -jar target/spring-task-processing-demo-0.0.1.jar --server.port=9090 --app.max-new-tasks=10
```
```shell
$ java -jar target/spring-task-processing-demo-0.0.1.jar --server.port=9091 --app.max-new-tasks=10
```

Create some test task instances

```shell
$ http :9090/new-tasks count=100
```
