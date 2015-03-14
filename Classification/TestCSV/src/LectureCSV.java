import javax.jws.soap.SOAPBinding;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Louis on 14/03/2015.
 */
public class LectureCSV {

    public static void main(String[] args) {
        LectureCSV test = new LectureCSV();
    }

    LectureCSV(){
        try
        {
            String chemin = "fichier.csv";
            BufferedReader fichier_source = new BufferedReader(new FileReader(chemin));
            String chaine;
            int i = 1;

            while((chaine = fichier_source.readLine())!= null)
            {
                if(i > 1)
                {
                    String[] tabChaine = chaine.split(";");
                    //Tu effectues tes traitements avec les données contenues dans le tableau
                    //La première information se trouve à l'indice 0
                }
                i++;
            }
            fichier_source.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Le fichier est introuvable !");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
