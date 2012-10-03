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
        bpuu.binaariLisays(bpuu, 5);
        bpuu.binaariLisays(bpuu, 10);
        bpuu.binaariLisays(bpuu, 2);
        bpuu.binaariLisays(bpuu, 4);

        teka.ilmoita("Binääripuu, esijärjestys: ");
        kulut.preorder(bpuu.getJuuri());

        teka.ilmoita("\nBinääripuu, sisäjärjestys: ");
        kulut.inorder(bpuu.getJuuri());

        teka.ilmoita("\nBinääripuu, leveyssuuntainen järjestys: ");
        kulut.leverorder(bpuu, bpuu.getJuuri());

        AVLpuu apuu = new AVLpuu();
        apuu.lisaa(apuu, 5);
        apuu.lisaa(apuu, 4);
        apuu.lisaa(apuu, 9);
        apuu.lisaa(apuu, 2);
        apuu.lisaa(apuu, 1);

        teka.ilmoita("\nAVL-puu, esijärjestys: ");
        kulut.preorder(apuu.getJuuri());

        teka.ilmoita("\nAVL-puu, sisäjärjestys: ");
        kulut.inorder(apuu.getJuuri());

        teka.ilmoita("\nAVL-puu, leveyssuuntainenjärjestys: ");
        kulut.leverorder(apuu, apuu.getJuuri());

        Punamustapuu pmpuu = new Punamustapuu();
        pmpuu.lisaa(pmpuu, 6);
        pmpuu.lisaa(pmpuu, 5);
        pmpuu.lisaa(pmpuu, 11);
        pmpuu.lisaa(pmpuu, 2);
        pmpuu.lisaa(pmpuu, 4);

        teka.ilmoita("\nPunamustapuu, esijärjestys: ");
        kulut.preorderPM(pmpuu.getJuuri());

        teka.ilmoita("\nPunamustapuu, sisäjärjestys: ");
        kulut.inorderPM(pmpuu.getJuuri());

        teka.ilmoita("\nPunamustapuu, leveyssuuntainen järjestys: ");
        kulut.leverorderPM(pmpuu, pmpuu.getJuuri());

        Triepuu tpuu = new Triepuu();
        tpuu.lisaa(tpuu, 1);
        tpuu.lisaa(tpuu, 4);
        tpuu.lisaa(tpuu, 112);
        tpuu.lisaa(tpuu, 3);
        tpuu.lisaa(tpuu, 33333);
        tpuu.lisaa(tpuu, 33);
        tpuu.lisaa(tpuu, 34);

        teka.ilmoita("\nTriepuu, leveyssuuntainen järjestys: ");
        kulut.levelorderTrie(tpuu, tpuu.getJuuri());

        teka.ilmoita("\nTriepuu,  puussa on luvut: ");
        kulut.puunLuvut(tpuu, tpuu.getJuuri());

        teka.ilmoita("\nTriepuu, jokujärjestys: ");
    }
}
