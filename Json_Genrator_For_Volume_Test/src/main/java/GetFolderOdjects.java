
import java.io.File;
import java.util.ArrayList;

public class GetFolderOdjects {

    public void getFolderObjects(String pathToDataFolder) {
        File directory = new File(pathToDataFolder);
        //get all the files from a directory
        ArrayList<File> folderObjects = new ArrayList<File>();
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isDirectory()) {
                folderObjects.add(file);
            }
        }
        CreateJson.createJson(folderObjects);
    }
}
//получаем список папок по указанному пути.



