import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor1 {
    Lock lock = new ReentrantLock();
    SubsekvensRegister subsekvensRegister;

    public Monitor1(){

    }
    public void leggTil(HashMap<String,Subsekvens> register){
        lock.lock();
        try{subsekvensRegister.leggTil(register);}
        finally{lock.unlock();}
    }
    public void leggTil(HashMap<String,Subsekvens> register, int pos){
        lock.lock();
        try{subsekvensRegister.leggTil(register, pos);}
        finally{lock.unlock();}
    }
    public HashMap<String,Subsekvens> hentSubsekvens(int pos){
        lock.lock();
        try{return subsekvensRegister.hentSubsekvens(pos);}
        finally{lock.unlock();}
    }
    public int stoerelse(){
        lock.lock();
        try{return subsekvensRegister.stoerelse();}
        finally{lock.unlock();}
    }
    public ArrayList<HashMap<String,Subsekvens>> hentRegisterliste(){
        lock.lock();
        try{return subsekvensRegister.hentRegisterliste();}
        finally{lock.unlock();}
    }
    
}
