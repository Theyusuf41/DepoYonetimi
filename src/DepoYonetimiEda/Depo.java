package DepoYonetimiEda;

import java.util.ArrayList;
import java.util.Scanner;


public class Depo implements urunTanimlama,urunAlis,urunSatis{
   int urunId=1000;
    Scanner scan = new Scanner(System.in);
    ArrayList<Urun>urunList=new ArrayList<Urun>();
    @Override
    public int urunGir(int urunId, int urunMiktarı) {

        int index=urunVarmi(urunId);
        int urunSayisi =urunList.get(index).getUrunmiktar();
        urunSayisi+=urunMiktarı;
        urunList.get(index).setUrunmiktar(urunSayisi);

        return urunSayisi;

    }

    @Override
    public int urunSat(int urunId, int urunMiktarı) {
        int index=urunVarmi(urunId);
        int urunSayisi =urunList.get(index).getUrunmiktar();

        urunSayisi-=urunMiktarı;

        urunList.get(index).setUrunmiktar(urunSayisi);
        return urunSayisi;
    }

    @Override
    public int urunTanimlama(String urunIsmi, String uretici, String birim) {

        Urun yeniUrun=new Urun(++urunId,urunIsmi,uretici,birim);//yeni urun olusturdum
        urunList.add(yeniUrun);//urunliste ekledim
        return yeniUrun.getId();

    }

    @Override
    public void urunRafaKoy(int id, int rafNo) {
        int index = urunVarmi(id);
        urunList.get(index).setRafNo(rafNo);
    }

    public int urunVarmi(int id){//urunun indexini buluyorum
        //Urun yoksa -1, varsa urunun urun listesindeki indexini don
        int index=-1;
        for (int j= 0; j < urunList.size(); j++) {
            if(urunList.get(j).getId()==id){
                index=j;
                break;
            }
        }

        return index;
    }



}
