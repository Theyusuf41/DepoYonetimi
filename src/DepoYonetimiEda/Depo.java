package DepoYonetimiEda;

import java.util.ArrayList;


public class Depo implements urunTanimlama,urunAlis,urunSatis{
   int urunId=1000;
    ArrayList<Urun>urunList=new ArrayList<Urun>();
    @Override
    public int urunGir(int urunId, int girilecekMiktar) {

        int index= getUrunIndex(urunId);
        int mevcutMiktar =urunList.get(index).getUrunmiktar();
        mevcutMiktar+=girilecekMiktar;
        urunList.get(index).setUrunmiktar(mevcutMiktar);

        return mevcutMiktar;

    }

    @Override
    public int urunSat(int urunId, int cikarilacakMiktar) {
        int index= getUrunIndex(urunId);
        int mevcutMiktar =urunList.get(index).getUrunmiktar();

        mevcutMiktar-=cikarilacakMiktar;

        urunList.get(index).setUrunmiktar(mevcutMiktar);
        return mevcutMiktar;
    }

    @Override
    public int urunTanimlama(String urunIsmi, String uretici, String birim) {

        Urun yeniUrun=new Urun(++urunId,urunIsmi,uretici,birim);//yeni urun olusturdum
        urunList.add(yeniUrun);//urunliste ekledim
        return yeniUrun.getId();

    }

    @Override
    public void urunRafaKoy(int id, int rafNo) {
        int index = getUrunIndex(id);
        urunList.get(index).setRafNo(rafNo);
    }

    public int getUrunIndex(int id){//urunun indexini buluyorum
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
