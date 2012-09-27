/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiraha;

/**
 *
 * @author Henriikka
 */
public class TiraHa {

    public static void main(String[] args) {
        Tekstikayttoliittyma teka = new Tekstikayttoliittyma();
        Lapikulut kulut = new Lapikulut();

        Binaarihakupuu bpuu = new Binaarihakupuu();
        bpuu.insert(bpuu, 5);
        bpuu.insert(bpuu, 10);
        bpuu.insert(bpuu, 2);
        bpuu.insert(bpuu, 4);

        teka.ilmoita("Binääripuu, esijärjestys: ");
        kulut.preorder(bpuu, bpuu.getJuuri());

        teka.ilmoita("\nBinääripuu, sisäjärjestys: ");
        kulut.inorder(bpuu, bpuu.getJuuri());

        teka.ilmoita("\nBinääripuu, leveyssuuntainen järjestys: ");
        kulut.leverorder(bpuu, bpuu.getJuuri());

        AVLpuu apuu = new AVLpuu();
        apuu.lisaa(apuu, 5);
        apuu.lisaa(apuu, 4);
        apuu.lisaa(apuu, 9);
        apuu.lisaa(apuu, 2);
        apuu.lisaa(apuu, 1);
        
        teka.ilmoita("\nAVL-puu, esijärjestys: ");
        kulut.preorder(apuu, apuu.getJuuri());
        
        teka.ilmoita("\nAVL-puu, sisäjärjestys: ");
        kulut.inorder(apuu, apuu.getJuuri());
        
        teka.ilmoita("\nAVL-puu, leveyssuuntainenjärjestys: ");
        kulut.leverorder(apuu, apuu.getJuuri());

        AVLpuu pmpuu = new AVLpuu();
        pmpuu.lisaa(pmpuu, 6);
        pmpuu.lisaa(pmpuu, 5);
        pmpuu.lisaa(pmpuu, 11);
        pmpuu.lisaa(pmpuu, 2);
        pmpuu.lisaa(pmpuu, 4);
        
        teka.ilmoita("\nPunamustapuu, esijärjestys: ");
        kulut.preorder(pmpuu, pmpuu.getJuuri());
        
//        teka.ilmoita("\nPunamustapuu, sisäjärjestys: ");
//        kulut.inorder(pmpuu, pmpuu.getJuuri());
//        
//        teka.ilmoita("\nPunamustapuu, leveyssuuntainen järjestys: ");
//        kulut.leverorder(pmpuu, pmpuu.getJuuri());
    }
}
