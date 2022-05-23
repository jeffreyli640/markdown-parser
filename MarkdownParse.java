import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then take up to
        // the next )
        int currentIndex = 0;
        
        while(currentIndex < markdown.length()) {
           
            int openBracket = markdown.indexOf("[", currentIndex);
            
            //System.out.println(currentIndex + " "  + toReturn.toString());
            
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            
            if(openBracket == -1 || closeBracket == -1
                  || closeParen == -1 || openParen == -1) {
                return toReturn;
            }
            if(openBracket > 0) {
                if(markdown.charAt(openBracket - 1) == '!') {
                    openBracket = markdown.indexOf("[",openBracket + 1);
                    if(openBracket == -1) {
                        return toReturn;
                    }
                }
            }
            
            String potentialLink = markdown.substring(openParen + 1, closeParen);
            //if(potentialLink.indexOf(" ") == -1 && potentialLink.indexOf("\n") == -1) {
                toReturn.add(potentialLink.replaceAll("\\s", ""));
                currentIndex = closeParen + 1;
            //}
            //else {
                //currentIndex = currentIndex + 1;
            //}
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links.toString());
        System.out.println("All links found");
    }
}