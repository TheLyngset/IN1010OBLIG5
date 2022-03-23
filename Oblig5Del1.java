import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Oblig5Del1 {
    public static void main(String[] args) {
        SubsekvensRegister subsekvensRegister = new SubsekvensRegister();
        File metadata = new File("testdatalitenlike/metadata.csv");
        try (Scanner scanner = new Scanner(metadata)) {
            while(scanner.hasNext()){
                String[] linje = scanner.nextLine().split(",");
                if(linje[0].startsWith("fil")){
                    subsekvensRegister.leggTil(SubsekvensRegister.lesSubsekvenserFraFil(new File("testdatalitenlike/" + linje[0])));
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Antall subsekvensMaps: "+subsekvensRegister.hentRegisterliste().size());

        HashMap<String,Subsekvens> sammenslattSubsekvensMap = new HashMap<>();
        for(HashMap<String,Subsekvens> subsekvensMap:subsekvensRegister.hentRegisterliste()){
            sammenslattSubsekvensMap = SubsekvensRegister.slaaSammen(sammenslattSubsekvensMap, subsekvensMap);
        }
        int stoerstForekomst = 0;
        Subsekvens subsekvens = null;
        for(String key:sammenslattSubsekvensMap.keySet()){
            int forekomst = sammenslattSubsekvensMap.get(key).getForekomster();
            if(forekomst > stoerstForekomst){ 
                stoerstForekomst = forekomst;
                subsekvens = sammenslattSubsekvensMap.get(key);
            }
        }
        System.out.println(subsekvens);

    }
}
