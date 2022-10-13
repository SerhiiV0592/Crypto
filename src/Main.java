import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = args[1];

        Encoder encoder = new Encoder();
        FilePath filePath = new FilePath();

        String text = Files.readString(Path.of(args[1]));


        if (args[0].equalsIgnoreCase("encode")) {
            Path outputFile = Path.of(filePath.filePathForEncoded(path));

            int key = Integer.parseInt(args[2]);

            String encodedText = (encoder.encode(text, key));
            Files.writeString(outputFile, encodedText);
        } else if (args[0].equalsIgnoreCase("decode")) {
            Path outputFile = Path.of(filePath.filePathForDecoded(path));

            int key = Integer.parseInt(args[2]);

            String decodedText = (encoder.decode(text, key));
            Files.writeString(outputFile, decodedText);
        } else if (args[0].equalsIgnoreCase("bruteforce")) {
            StaticAnalysis staticAnalysis = new StaticAnalysis();
            String exampleText = Files.readString(Path.of(args[2]));
            Path outputFile = Path.of(filePath.filePathForBruteForce(path));

            int bruteForceKey = (staticAnalysis.bruteForce(text, exampleText));

            String bruteForcedText = (encoder.decode(text, bruteForceKey));
            Files.writeString(outputFile, bruteForcedText);
        }
    }
}
