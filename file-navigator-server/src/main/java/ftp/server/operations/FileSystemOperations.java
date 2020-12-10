
package ftp.server.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystemOperations {

  private String currentPath = "/tmp";

  public List<String> performLsOperation() throws IOException {
    return Files.list(Paths.get(currentPath)).map(Path::toString)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  public String performCdOperation(String folderPath) throws IOException {
    List<String> directories =
        Files.list(Paths.get(currentPath)).filter(Files::isDirectory).map(Path::toString)
            .collect(Collectors.toCollection(ArrayList::new));

    for (String temp : directories) {
      System.out.println(temp);
      if (temp.equals(folderPath)) {
        currentPath = currentPath + "/" + folderPath;
        return currentPath;
      }
    }
    return currentPath;
  }
}
