package DepoYonetimiEda;

import java.util.Scanner;

public class Islemler {

    static Scanner scan = new Scanner(System.in);
    static Depo depo = new Depo();//Depodaki meth. call etmak için obj create edildi

    public static final String W = "\u001B[37m";
    public static final String R = "\u001B[31m";
    public static final String G = "\u001B[32m";
    public static final String Y = "\u001B[33m";
    public static final String B = "\u001B[34m";

    public static void girisEkrani() {
        System.out.println(R + "========================== İŞLEMLER =======================\r\n"
                + "   ____________________             ____________________    \n"
                + "   | 1-URUN LISTESI  |            | 2-URUN TANIMLA      |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    \n"
                + "   ____________________             ____________________    \n"
                + "   | 3-URUN RAFLAMA  |            | 4-URUN GIRIS        |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯    \n"
                + "   ____________________             ____________________    \n"
                + "   | 5-URUN CIKIS    |            | 6-CIKIS             |   \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯       " + B);

        System.out.print("Islem seciniz : ");
        boolean catchCalistiMi=false;
        int secim=0;
        try {
            String secimText = scan.nextLine();
            secim = Integer.parseInt(secimText);
        }
        catch (Exception exp){
            System.out.println("Hatali giris yaptiniz. Tekrar deneyiniz.");
            catchCalistiMi=true;
        }

        switch (secim) {
            case 1:
                urunListesi();
                girisEkrani();
                break;
            case 2:
                urunTanimlama();
                urunListesi();
                girisEkrani();
                break;
            case 3:
                urunRaflama();
                urunListesi();
                girisEkrani();
                break;
            case 4:
                urunGiris();
                urunListesi();
                girisEkrani();
                break;
            case 5:
                urunCikis();
                urunListesi();
                girisEkrani();
                break;
            case 6:
                cikis();
                break;
            default:
                if(!catchCalistiMi){
                    System.out.println("Hatali deger girdiniz.1 ile 6 arasinda bir deger giriniz");
                }
                girisEkrani();

        }

    }


    private static void cikis() {
        System.out.println("Sistemden cikiyorsunuz");
    }

    private static void urunCikis() {
        try {
            System.out.println("urunId giriniz");
            String uruntext = scan.nextLine();
            int urunId = Integer.parseInt(uruntext);

            System.out.println("cikarilacak urun miktari giriniz");
            String cikarilacakMiktarText= scan.nextLine();
            int cikarilacakMiktar = Integer.parseInt(cikarilacakMiktarText);

            int index = depo.getUrunIndex(urunId);
            int mevcutMiktar = depo.urunList.get(index).getUrunmiktar();
            if (mevcutMiktar < cikarilacakMiktar) {
                System.out.println("Girdiginiz miktar, mevcut miktardan fazladir. Tekrar giris yapiniz.");
            } else {
                int yeniMiktar = depo.urunSat(urunId, cikarilacakMiktar);
                System.out.println("Urun cikisi yapilmistir.Urun miktari:" + yeniMiktar);
            }
        } catch (Exception e) {
            System.out.println("Hatali giris yaptiniz.Tekrar deneyiniz");
        }
    }

    private static void urunGiris() {

        try {
            System.out.println("urunId giriniz");
            String uruntext= scan.nextLine();
            int urunId = Integer.parseInt(uruntext);
            System.out.println("girilecek urun miktari giriniz");
            String urunMiktarText = scan.nextLine();
            int girilecekMiktar = Integer.parseInt(urunMiktarText);

            System.out.println("Urun girisi yapilmistir.Urun miktari:" + (depo.urunGir(urunId, girilecekMiktar)));

        } catch (Exception e) {
            System.out.println("Hatali giris yaptiniz.Tekrar deneyin.");
        }
    }
    private static void urunListesi() {

        System.out.println("depo.urunList = " + depo.urunList);
    }


    private static void urunRaflama() {

        //kulanicidan urun id sini al
        //kullanicidan urun raf numarasini al
        //urunun indexini bul (depo.urunVarmi methodu)

        //eger index -1 ise urun yok mesaji bas
        //eger urun var ise depo.urunRafaKoy methodunu cagir

        try {
            System.out.println("urun id'si girin");
            String uruntext = scan.nextLine();
            int urunId = Integer.parseInt(uruntext);
            System.out.println("urun raf numarasi girin");
            String urunRafText = scan.nextLine();
            int urunRafNo = Integer.parseInt(urunRafText);
            int sonuc = depo.getUrunIndex(urunId);
            if (sonuc == -1) {
                System.out.println("urun listede bulunmamaktadir");
            } else {
                if (depo.urunList.get(sonuc).getUrunmiktar() == 0) {
                    System.out.println("Yerlestirecek urun miktari bulunamadi.Once urun girisi yapmalisiniz");
                } else {
                    depo.urunRafaKoy(urunId, urunRafNo);
                    System.out.println("urun rafa yerlestirildi");
                }
            }
        }catch(Exception e){
            System.out.println("Hatali giris yaptiniz.Tekrar deneyin.");
        }
    }

    public static void urunTanimlama() {

            System.out.println("Urun ismi giriniz");
            String isim = scan.nextLine();
            System.out.println("Urun uretici ismi giriniz");
            String uretici = scan.nextLine();
            System.out.println("Urun birimi giriniz");
            String birim = scan.nextLine();

            int yeniUrunId = depo.urunTanimlama(isim, uretici, birim);
            System.out.println("Urununuz olusturuldu.YeniUrunId:" + (yeniUrunId));

        }
    }
