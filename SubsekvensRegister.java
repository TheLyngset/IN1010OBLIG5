import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SubsekvensRegister {
    private ArrayList<HashMap<String,Subsekvens>> registerListe = new ArrayList<>();
    
    public void leggTil(HashMap<String,Subsekvens> register){
        registerListe.add(register);
    }
    public void leggTil(HashMap<String,Subsekvens> register, int pos){
        registerListe.add(pos, register);
    }
    public HashMap<String,Subsekvens> hentSubsekvens(int pos){
        return registerListe.get(pos);
    }

    public int stoerelse(){
        return registerListe.size();
    }

    public ArrayList<HashMap<String,Subsekvens>> hentRegisterliste(){
        return registerListe;
    }

    public static HashMap<String,Subsekvens> lesSubsekvenserFraFil(File fil){
        Scanner scanner;
        HashMap<String,Subsekvens> hashMap = new HashMap<>();
        try {
            scanner = new Scanner(fil);
            System.out.println("Scanner opprettet");
            while(scanner.hasNextLine()){
                System.out.println("Kjoerer while loop");
                ArrayList<String> linje = new ArrayList<>(Arrays.asList(scanner.nextLine().split("(?!^)")));
                if(linje.size() <= 1)break;
                String subsekvens = "";
                for(int i = 0; i < linje.size(); i++){
                    System.out.println("kjoerer for loop");
                    try {
                        linje.get(i+2);
                    } catch (Exception e) {
                        break;
                    }
                    subsekvens = linje.get(i) + linje.get(i+1) + linje.get(i+2);
                    hashMap.put(subsekvens, new Subsekvens(subsekvens, 1));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fil ikke funnet!");
        }
        return hashMap;
    }
    public static HashMap<String,Subsekvens> slaaSammen(HashMap<String,Subsekvens> subsekvensMap1, HashMap<String,Subsekvens> subsekvensMap2){
        HashMap<String,Subsekvens> subsekvensMap = new HashMap<>();
        for(String key1:subsekvensMap1.keySet()){
            for(String key2:subsekvensMap2.keySet()){
                if(key1.equals(key2)){
                    int forekomster = subsekvensMap1.get(key1).getForekomster() + subsekvensMap2.get(key2).getForekomster();
                    subsekvensMap.put(key1, new Subsekvens(key1, forekomster));
                }
                else{
                    if(!subsekvensMap.containsKey(key1)) subsekvensMap.put(key1, subsekvensMap1.get(key1));
                    if(!subsekvensMap.containsKey(key2)) subsekvensMap.put(key2, subsekvensMap2.get(key2));
                }
            }
        }
        if(subsekvensMap1.isEmpty()) subsekvensMap = subsekvensMap2;
        if(subsekvensMap2.isEmpty()) subsekvensMap = subsekvensMap1;

        return subsekvensMap;
    }
}
