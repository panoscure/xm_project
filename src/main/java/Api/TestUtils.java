package Api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestUtils {

        public static String readJsonFile(String filePath) {
            try {
                return new String(Files.readAllBytes(Paths.get(filePath)));
            } catch (IOException e) {
                throw new RuntimeException("Error reading JSON file: " + e.getMessage());
            }
        }
}
