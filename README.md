# 🛠️ Spring Profiler - JVM Metrics & WebSocket Monitoring

This project is a **Java Spring Boot** application designed to monitor **JVM-level metrics** in real-time using **Micrometer**, **Spring Boot Actuator**, and **WebSockets**. It allows developers to analyze memory usage, thread statistics, and other vital JVM stats via REST APIs and WebSocket connections.

---

## 🚀 Features

- 📊 **JVM Monitoring**: Track memory, threads, and other JVM metrics.
- 🔌 **RESTful Endpoints**: Easily query memory and thread stats using HTTP.
- 📡 **WebSocket Integration**: Get live updates pushed to the frontend.
- 🧪 **Spring Boot Actuator**: Full access to built-in operational endpoints.
- ⚙️ **Micrometer Metrics**: Used for gathering JVM and system metrics.
- 🔄 **Real-Time JSON Output**: Structured and streamable format for dashboards.

---

## 📁 Project Structure
spring-profiler/
├── src/
│ └── main/
│ ├── java/
│ │ └── com/yasir/springprofiler/
│ │ ├── SpringProfilerApplication.java # Main Spring Boot class
│ │ ├── controller/
│ │ │ └── JvmMetricsController.java # REST endpoints for JVM metrics
│ │ └── websocket/
│ │ └── MetricsWebSocketHandler.java # WebSocket handler for real-time metrics
│ └── resources/
│ └── application.yml # Application configuration
└── pom.xml # Maven dependencies

