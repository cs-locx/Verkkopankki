package verkkopankki.logiikka;

import javax.swing.SwingUtilities;
import verkkopankki.gui.*;

public class Main {

    public static void main(String[] args) {

        Jarjestelma j = new Jarjestelma();
        
        Asiakas osku = new Asiakas("Oskari", "Johansson", "oskajoha", "banaan1");
        j.lisaaAsiakas(osku);
        j.luoTili(osku);
        j.luoTili(osku);
        j.luoTili(osku);
        j.luoTili(osku);
        
        Asiakas sanni = new Asiakas("Sanni", "Visakko", "sannivisakko", "eiole");
        j.lisaaAsiakas(sanni);
        j.luoTili(sanni);
        
        Asiakas admin = new Asiakas("admin", "", "admin", "admin");
        j.lisaaAsiakas(admin);
        j.luoTili(admin);
        
        admin.getTilit().get(0).muutaSaldoa(100000000);
        
        j.tilisiirto(admin.getTilit().get(0), osku.getTilit().get(0), 100000);   
        j.tilisiirto(osku.getTilit().get(0), sanni.getTilit().get(0), 10000);
        j.tilisiirto(osku.getTilit().get(0), sanni.getTilit().get(0), 10000);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 145);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 100);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 267);
        j.tilisiirto(sanni.getTilit().get(0), osku.getTilit().get(0), 2365);
        
        Kayttoliittyma kl = new Kayttoliittyma(j);
        SwingUtilities.invokeLater(kl);

    }

}
