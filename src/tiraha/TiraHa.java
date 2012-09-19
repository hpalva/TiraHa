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

//        Binaarihakupuu bpuu = new Binaarihakupuu();
//            bpuu.insert(bpuu, 5);
//            bpuu.insert(bpuu, 10);
//            bpuu.insert(bpuu, 2);
//            bpuu.insert(bpuu, 4);
//        
        Lapikulut kulut = new Lapikulut();
//        kulut.preorder(bpuu, bpuu.getJuuri());
//        kulut.inorder(bpuu, bpuu.getJuuri());

        AVLpuu apuu = new AVLpuu();
        apuu.lisaa(apuu, 5);
        apuu.lisaa(apuu, 4);
        apuu.lisaa(apuu, 9);
        apuu.lisaa(apuu, 2);
        apuu.lisaa(apuu, 1);
        kulut.preorder(apuu, apuu.getJuuri());
        

    }
}
