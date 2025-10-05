package app;

import org.junit.jupiter.api.*;
import java.util.List;

public class TodoListTest {

    private TodoList list;

    @BeforeEach
    void setup() {
        list = new TodoList();
    }

    @Test
    void addAddsItemsInOrder() {
        list.add("A");
        list.add("B");
        List<TodoItem> all = list.all();
        Assertions.assertEquals(2, all.size());
        Assertions.assertEquals("A", all.get(0).getText());
        Assertions.assertEquals("B", all.get(1).getText());
    }

    @Test
    void deleteByPositionRemovesCorrectItem() {
        list.add("A");
        list.add("B");
        list.add("C");
        boolean ok = list.deleteByPosition(2);
        List<TodoItem> all = list.all();
        Assertions.assertTrue(ok);
        Assertions.assertEquals(2, all.size());
        Assertions.assertEquals("A", all.get(0).getText());
        Assertions.assertEquals("C", all.get(1).getText());
    }

    @Test
    void deleteInvalidPositionReturnsFalseAndKeepsItems() {
        list.add("A");
        Assertions.assertFalse(list.deleteByPosition(0));
        Assertions.assertFalse(list.deleteByPosition(2));
        Assertions.assertEquals(1, list.all().size());
    }

    @Test
    void addIgnoresBlankOrNull() {
        list.add("");
        list.add("   ");
        list.add(null);
        Assertions.assertEquals(0, list.all().size());
    }
}
