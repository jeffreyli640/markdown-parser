//imports Junit
import java.util.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*;

//Creates the test class
public class MarkdownParseTest {
    
    //Tells Junit that this is a test method
    @Test
    public void addition() {
        //Checks if the expected is the same as actual
        assertEquals(2, 1+1);
    }

    @Test
    public void testGetLinks() throws IOException {
        assertEquals("[https://something.com, some-thing.html]", 
        MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))).toString());
    }
}
