package level.second.task.second;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest<T> {

    private TreeNode node;

    @BeforeEach
    private void fill() throws Exception {
        node = new TreeNode(0);
        node.add(2);
        node.add(-1);
        node.add(3);
    }

    @Test
    public void getHeight() {
        assertEquals(3, node.maxDepth());
    }

    @Test
    public void addShouldThrowException() {
        assertThrows(Exception.class, () -> {
            node.add(2);
        });
    }

    @Test
    public void addShouldNotThrowException() {
        int expVal=1;
        try {
            assertEquals(expVal,node.add(expVal).getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}