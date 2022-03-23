public class Subsekvens{
    private int forekomster;
    private String subsekvens;

    
    public Subsekvens(String subsekvens, int forekomster){
        this.forekomster = forekomster;
        this.subsekvens = subsekvens;
    }
    public Subsekvens(){}
    public String getSubsekvens() {
        return subsekvens;
    }
    public int getForekomster() {
        return forekomster;
    }
    public void setForekomster(int forekomster) {
        this.forekomster = forekomster;
    }
    public void setSubsekvens(String subsekvens) {
        this.subsekvens = subsekvens;
    }
    @Override
    public String toString() {
        return "(" + subsekvens + "," + forekomster + ")";
    }
}