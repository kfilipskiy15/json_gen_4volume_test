import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import java.io.FileWriter;
import java.io.IOException;

public class WriteJsonFile {

    public void writeJsonFile(JsonArray jsonArray) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(jsonArray);
        String outputFilePath = InputData.inputPathToDataFolder + "out.json";
        try {
            FileWriter writer = new FileWriter(outputFilePath);
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error in output file path");
            System.exit(1);
            e.printStackTrace();
        }
        System.out.println("Success");
        System.exit(1);
    }
}
