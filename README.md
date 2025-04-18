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

# Create some tasks

## Using HTTPIE

```shell 
$ http :9090/new-tasks count=100
```

## Using curl

Example Data: etc/data.json
```json
{
  "count" : 100
}
```

```shell
curl -X POST -H "Content-Type: application/json" -d @etc\data.json  http://localhost:9090/new-tasks
```



# Postgres
```shell
$ docker pull postgres

$ docker run -itd -e POSTGRES_USER=demo -e POSTGRES_PASSWORD=demo -p 5432:5432 -v ./data:/var/lib/postgresql/data --name postgresql postgres

$ docker stop postgres
```
