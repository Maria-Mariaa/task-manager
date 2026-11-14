package edu.ipi.taskmanager;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final JdbcClient jdbc;

    public TaskService(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    public List<Task> list() {
        return jdbc.sql("SELECT id, title, completed FROM tasks ORDER BY id")
                .query(Task.class)
                .list();
    }

    public Task create(String title) {
        return jdbc.sql("""
                INSERT INTO tasks (title) VALUES (:title)
                RETURNING id, title, completed
                """)
                .param("title", title)
                .query(Task.class)
                .single();
    }

    public Optional<Task> complete(long id) {
        return jdbc.sql("""
                UPDATE tasks SET completed = TRUE WHERE id = :id
                RETURNING id, title, completed
                """)
                .param("id", id)
                .query(Task.class)
                .optional();
    }

    public Optional<Task> toggle(long id) {
        return jdbc.sql("""
                UPDATE tasks SET completed = NOT completed WHERE id = :id
                RETURNING id, title, completed
                """)
                .param("id", id)
                .query(Task.class)
                .optional();
    }

    public Optional<Task> rename(long id, String title) {
        return jdbc.sql("""
                UPDATE tasks SET title = :title WHERE id = :id
                RETURNING id, title, completed
                """)
                .param("id", id)
                .param("title", title)
                .query(Task.class)
                .optional();
    }

    public void deleteCompleted() {
        jdbc.sql("DELETE FROM tasks WHERE completed").update();
    }

    public boolean delete(long id) {
        return jdbc.sql("DELETE FROM tasks WHERE id = :id")
                .param("id", id)
                .update() > 0;
    }
}
