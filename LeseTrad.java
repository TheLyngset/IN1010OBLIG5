import java.io.File;

public class LeseTrad implements Runnable{
    Monitor1 monitor1;
    String filnavn;
    public LeseTrad(Monitor1 monitor1, String filnavn){
        this.monitor1 = monitor1;
        this.filnavn = filnavn;
    }

    public void run(){
        File fil = new File(filnavn);
        monitor1.leggTil(SubsekvensRegister.lesSubsekvenserFraFil(fil));
    }
}
