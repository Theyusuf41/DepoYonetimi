package DepoYonetimiEda;

public class Urun {//pojo class

    private int id;
    private String urunIsmi;
    private String uretici;
    private int urunMiktar;
    private String miktarBirim;
    private int rafNo;


    public int getId() {
        return id;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public int getUrunmiktar() {
        return urunMiktar;
    }

    public String getMiktarBirim() {
        return miktarBirim;
    }

    public int getRafNo() {
        return rafNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public void setUrunmiktar(Integer urunmiktar) {
        this.urunMiktar = urunmiktar;
    }

    public void setMiktarBirim(String miktarBirim) {
        this.miktarBirim = miktarBirim;
    }

    public void setRafNo(Integer rafNo) {
        this.rafNo = rafNo;
    }

    @Override
    public String toString() {
        return "Urun{" +
                "id=" + id +
                ", urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", urunMiktar=" + urunMiktar +
                ", miktarBirim='" + miktarBirim + '\'' +
                ", rafNo=" + rafNo +
                '}';
    }

    public Urun(int id, String urunIsmi, String uretici, String miktarBirim) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktarBirim = miktarBirim;
        this.urunMiktar = 0;


    }
}




