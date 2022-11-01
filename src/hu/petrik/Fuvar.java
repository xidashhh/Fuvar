package hu.petrik;

public class Fuvar {
    private int azonosito;
    private String indulasIdopont;
    private int idotartam;
    private double megtettTavolsag;
    private double vitelDij;
    private double borravalo;
    private String fizetesMod;

    public Fuvar(int azonosito, String indulasIdopont, int idotartam, double megtettTavolsag, double vitelDij, double borravalo, String fizetesMod) {
        this.azonosito = azonosito;
        this.indulasIdopont = indulasIdopont;
        this.idotartam = idotartam;
        this.megtettTavolsag = megtettTavolsag;
        this.vitelDij = vitelDij;
        this.borravalo = borravalo;
        this.fizetesMod = fizetesMod;
    }

    @Override
    public String toString() {
        return  "azonosito=" + azonosito +
                ", indulasIdopont='" + indulasIdopont + '\'' +
                ", idotartam=" + idotartam +
                ", megtettTavolsag=" + megtettTavolsag +
                ", vitelDij=" + vitelDij +
                ", borravalo=" + borravalo +
                ", fizetesMod='" + fizetesMod;
    }

    public int getAzonosito() {
        return azonosito;
    }

    public String getIndulasIdopont() {
        return indulasIdopont;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public double getMegtettTavolsag() {
        return megtettTavolsag;
    }

    public double getVitelDij() {
        return vitelDij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetesMod() {
        return fizetesMod;
    }

    public double getOsszBevetel(){
        return borravalo+vitelDij;
    }

    public double getArany() {
        return borravalo/vitelDij;
    }
}
