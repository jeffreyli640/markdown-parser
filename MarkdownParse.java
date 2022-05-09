//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            if(openBracket > 0){
                if(markdown.charAt(openBracket - 1) == '!') {
                    openBracket = markdown.indexOf("[",openBracket + 1);
                    if(openBracket == -1) {
                        break;
                    }
                }
            }
            int closeBracket = markdown.indexOf("]", openBracket);
            
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            
            System.out.println(openBracket + " " + closeBracket + " " + openParen + " " + closeParen);



            if(openParen == -1 || closeParen == -1) {
                break;
            }
            String link = markdown.substring(openParen + 1, closeParen);
            link = link.replaceAll("\\s", "");
            toReturn.add(link);
            currentIndex = closeParen + 1;
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