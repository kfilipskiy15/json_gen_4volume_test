import java.io.File;
import java.util.Scanner;

public class InputData {

    public static String gender;
    public static String pathToHeghtXls;
    public static String inputPathToDataFolder;


    public void inputGender(){
        Scanner inputGender = new Scanner(System.in);
        System.out.println("Enter necessary gender (male or female): ");
        String inputhGender = inputGender.next();
        this.gender = String.valueOf(inputhGender);
        inputPathToHeightWithXls();

    }

    public void inputPathToHeightWithXls(){
        Scanner inputHeghtFilePath = new Scanner(System.in);
        System.out.println("Enter path to xls file with height: ");
        String inputhPathToHeightFile = inputHeghtFilePath.next();
        this.pathToHeghtXls = String.valueOf(inputhPathToHeightFile);
        inputFolderPath();
    }



    public void inputFolderPath() throws NullPointerException {
        Scanner inputPathToDataFolder = new Scanner(System.in);
        System.out.println("Enter path to data folder: "); //В этом методе ввод пути к папке с фотосетом и проверка корректности ввода.
        try {
            String path = inputPathToDataFolder.next();
            this.inputPathToDataFolder = String.valueOf(path);
            File directory = new File(path);
            File[] fList = directory.listFiles();
            for (File file : fList) {
                if (file.isDirectory()) {
                    GetFolderOdjects getFolderOdjects = new GetFolderOdjects();
                    getFolderOdjects.getFolderObjects(path);
                }
            }
        } catch (Exception e) {
            System.out.println("Error. Path not found");
            System.exit(1);
        }
    }
}
