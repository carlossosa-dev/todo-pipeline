package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoList {
    private final List<TodoItem> items = new ArrayList<>();
    private int seq = 1;

    public TodoItem add(String text) {
        if (text == null || text.trim().isEmpty()) return null;
        TodoItem it = new TodoItem(seq++, text);
        items.add(it);
        return it;
    }

    public boolean deleteByPosition(int position) {
        int idx = position - 1;
        if (idx < 0 || idx >= items.size()) return false;
        items.remove(idx);
        return true;
    }

    public List<TodoItem> all() {
        return Collections.unmodifiableList(items);
    }
}
