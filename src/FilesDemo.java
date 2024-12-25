import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FilesDemo {
    public static void main(String[] args) {
        try {
            //writeToFile();
            readFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readFile() throws IOException{
        try(FileReader reader = new FileReader("example.txt")){
            int tav;
            while((tav = reader.read()) != -1){
                System.out.println(tav);
            }
        }
    }

    private static void writeToFile() throws IOException {
        try(FileWriter writer = new FileWriter("example.txt", true)) {
            writer.write("yada yada\n");
        } // close();
    }
}
