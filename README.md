Task Manager

A simple task management web application built with Java, Spring Boot, PostgreSQL, and Docker.

About the Project

The purpose of this project is to help users organize their daily tasks in one place. Users can create tasks, view their task list, change task statuses, and delete tasks.

The application has a minimalistic interface and focuses on essential task management features.

Technologies Used

- **Java** — main programming language
- **Spring Boot** — backend framework
- **PostgreSQL** — database
- **HTML, CSS, JavaScript** — frontend
- **Docker and Docker Compose** — containerization

Project Structure

- `src/main/java/` — backend source code
- `src/main/resources/static/` — frontend files
- `src/main/resources/` — application configuration and database resources
- `compose.yaml` — Docker Compose configuration
- `pom.xml` — Maven project configuration

How to Run

1. Install Docker Desktop.
2. Open a terminal in the project folder.
3. Run:

docker compose -p taskmanager-minimal-demo up --build -d


4. Open http://localhost:8081 in your browser.


Future Improvements

- User authentication
- Task priorities and deadlines
- Categories and reminders
