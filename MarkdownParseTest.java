//imports Junit
import java.util.*;

import javax.crypto.spec.IvParameterSpec;

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
    public void testGetLinks1() throws IOException {
        assertEquals("[https://something.com, some-thing.html]", 
        MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))).toString());
    }

    @Test
    public void testGetLinks2() throws IOException {
        assertEquals("[]", 
        MarkdownParse.getLinks(Files.readString(Path.of("test-file2.md"))).toString());
    }

    @Test
    public void testGetLinks3() throws IOException {
        assertEquals("[]", 
        MarkdownParse.getLinks(Files.readString(Path.of("test-file3.md"))).toString());
    }

    @Test
    public void testGetLinks4() throws IOException {
        assertEquals("[something.html]", 
        MarkdownParse.getLinks(Files.readString(Path.of("test-file4.md"))).toString());
    }
}