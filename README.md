# Java gRPC Demo

A clean, minimal Java gRPC example that shows the full flow from `.proto` contract to a running server and client.

This project demonstrates:
- Defining an RPC in Protocol Buffers (`proto3`)
- Generating Java gRPC code via Maven
- Running a gRPC server on port `50051`
- Calling the server from a blocking Java client

## Why gRPC Is Language Agnostic

gRPC uses `.proto` contracts as the source of truth, so APIs are defined independently of any single language.
The same contract can generate client and server code for Java, Go, Python, C++, Node.js, and many more.
Since implementations share the same schema and wire format over HTTP/2, cross-language communication is reliable.
This is ideal for polyglot architectures where each service can use the language best suited to its needs.

## Tech Stack

- Java `17`
- Maven
- gRPC Java `1.63.0`
- Protocol Buffers `3.25.0`

## Prerequisites

Make sure the following are installed:
- JDK 17+
- Maven 3.8+

Verify:

```bash
java -version
mvn -version
```

## Build the Project

From the project root:

```bash
mvn clean compile
```

This command also generates the Java code from `hello.proto`.

## Run the Application

Use two terminals.

### 1) Start the Server

PowerShell (Windows):

```powershell
mvn exec:java "-Dexec.mainClass=server.HelloServer"
```

### 2) Run the Client

In another terminal:

```powershell
mvn exec:java "-Dexec.mainClass=client.HelloClient"
```

## RPC Contract

```proto
service HelloService {
  rpc sayHello (HelloRequest) returns (HelloResponse);
}

message HelloRequest {
  string name = 1;
}

message HelloResponse {
  string message = 1;
}
```

## Common Commands

```bash
# Regenerate protobuf/gRPC classes and compile
mvn clean compile

# Build jar/artifacts
mvn clean package
```

## Next Improvements (Optional)

- Add unit/integration tests for service and client.
- Add TLS for secure gRPC communication.
- Add unary input validation and structured logging.
- Add support for streaming RPCs.
