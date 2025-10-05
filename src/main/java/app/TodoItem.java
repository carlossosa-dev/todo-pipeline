package app;

import java.time.Instant;

public class TodoItem {
    private final int id;
    private String text;
    private final Instant createdAt = Instant.now();

    public TodoItem(int id, String text) {
        this.id = id;
        this.text = text == null ? "" : text.trim();
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public Instant getCreatedAt() { return createdAt; }
}
