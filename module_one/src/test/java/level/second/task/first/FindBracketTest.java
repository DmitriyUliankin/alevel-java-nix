package level.second.task.first;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindBracketTest {

    private FindBracket finder=new FindBracket();

    @Test
    public void getBracket(){
        assertEquals(true,finder.brackets(""));
        assertEquals(true,finder.brackets("[]{}()"));
        assertEquals(false, finder.brackets("abcd9("));
        assertNotEquals(true,finder.brackets("abcd9(jlf{fgh)}"));
    }

}