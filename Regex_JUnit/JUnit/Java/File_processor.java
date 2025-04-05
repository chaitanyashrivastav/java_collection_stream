package org.example ;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class File_processor{
    public void writeToFile(String filename, String content) throws IOException{
        Files.writeString(Path.of(filename) , content) ;
    }
    public String readFromFile(String filename) throws IOException{
        return Files.readString(Path.of(filename));
    }
}