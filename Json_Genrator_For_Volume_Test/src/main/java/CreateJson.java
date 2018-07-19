import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class CreateJson {

// проверка если в папке есть файл - взять его путь.
    public static  ArrayList<String> getFilePathList(String targetDir){
        File directory=new File(targetDir);
        //get all the files from a directory
        ArrayList<String> filePathList=new ArrayList<String>();
        File[]fList=directory.listFiles();
        for(File file:fList){
            if(file.isFile()){
                filePathList.add(String.valueOf(file.getPath()));
            }
        }
        return filePathList;
    }

    //В этом методе происходит итерация по объекту File. из нее вытаскивается name папки и путь.  По пути идет итерация путей файлов в папке..
    //Затем эти пути подставляются в filePathFront, filePathSide.
    public static void createJson(ArrayList<File> folderObjects) {
        JsonArray jsonArray = null;
        try {
            ArrayList<File> folderObjectList = folderObjects;
            ArrayList<Object> userSetHeight = HeightProcessing.readHeightFromFile();//инициализируем массив с ростом
            jsonArray = new JsonArray();
            Iterator<File> dirObjectIterator = folderObjectList.iterator(); //итерация по массиву folderObjectList
            Iterator<Object> userHeightIterator = userSetHeight.iterator(); //инициализация итератора роста

            while (dirObjectIterator.hasNext()) {
                JsonObject nameObject = new JsonObject(); // создали объект json.
                File currentDirObject = dirObjectIterator.next(); //объект file currentDirObject присваивается итератору.
                Object height = userHeightIterator.next();

                ArrayList<String> filePathList = getFilePathList(currentDirObject.getPath()); //массив filePathList = getFilePathList! currentDirObject получает путь из folderObjectList
                nameObject.addProperty("name", currentDirObject.getName()); // currentDirObject получает имя папки и вставляет его в name json
                nameObject.addProperty("height", height.toString());
                nameObject.addProperty("gender", InputData.gender);
                nameObject.addProperty("angle", "0");
                nameObject.addProperty("filePathFront", filePathList.get(0));// получает filePathFront из filePathList
                nameObject.addProperty("filePathSide", filePathList.get(1));// получает filePathFront из filePathList
                jsonArray.add(nameObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        WriteJsonFile writeJsonFile = new WriteJsonFile();
        writeJsonFile.writeJsonFile(jsonArray);
    }
}
