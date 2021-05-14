import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class FileOperations {
    private static String HOME = System.getProperty("Path", "F:\\Bridgelabz\\IdeaWorkspace");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    public void fileOperationDemonstrator() throws IOException {
        //check file existence
        Path homePath = Paths.get(HOME);
        System.out.println("is given home path exists?: " + Files.exists(homePath));

        //Delete file and Check file Not Exists
        Path playPath = Paths.get(HOME + "\\" + PLAY_WITH_NIO);
        if (Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());

        System.out.println("is path not exists?: " + Files.notExists(playPath));

        //create directory
        Files.createDirectory(playPath);
        System.out.println("is path exists?: " + Files.exists(playPath));

        //create file
        IntStream.range(1, 10).forEach(counter -> {
            Path tempFile = Paths.get(playPath + "\\temp" + counter+".txt");
            System.out.println("is tempFile exists?1" + Files.notExists(tempFile));
            try {
                Files.createFile(tempFile);
            } catch (IOException ioe) {
            }
            System.out.println("is file exists?2: " + Files.exists(tempFile));
        });

        //List Files, Directories along with Files with extensions
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path ->
                path.toFile().isFile() &&
                        path.toString().startsWith("temp")).forEach(System.out::println);
    }
}
