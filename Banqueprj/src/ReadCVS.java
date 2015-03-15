
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadCVS {

    public static String search(String id) {

        String fileToParse = "C:\\Users\\Louis\\Desktop\\Banqueprj\\src\\fichier.csv";
        BufferedReader fileReader = null;

        final String DELIMITER = ";";

        String line = "";

        try {
            fileReader = new BufferedReader(new FileReader(fileToParse));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            while ((line = fileReader.readLine()) != null) {

                String[] tokens = line.split(DELIMITER);
                if (tokens[0].equals(id)) {
                    try {
                        fileReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return tokens[1];
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}






