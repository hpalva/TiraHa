package tiraha;

/**
 * Luokka toteuttaa kolme erilaista puun läpikulkua
 */
public class Lapikulut {

    /**
     * Puu-tyyppinen muuttuja, joka määritellään metodeissa siksi puuksi, joka
     * käydään läpi
     */
    private Puu puu;
    /**
     * Käytössä oleva tekstikäyttöliittymä
     */
    private Tekstikayttoliittyma kliittyma = new Tekstikayttoliittyma();

    /**
     * Metodi suorittaa parametrina annettulle puulle (AVL- ja binäärihakupuut)
     * esiläpikäynnin
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void preorder(Puu puu, Solmu solmu) {
//        kliittyma.ilmoita(" " + solmu.getAvain());
        if (solmu.getVasen() != null) {
            System.out.println(" solmusta " + solmu.getAvain() + " mentiin vasemmalle : " + solmu.getOikea().getAvain());
            preorder(puu, solmu.getVasen());
        }
        if (solmu.getOikea() != null) {
            System.out.println("solmusta " + solmu.getAvain() + " mentiin oikealle : " + solmu.getOikea().getAvain());
            preorder(puu, solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle punamustapuulle esiläpikäynnin
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void preorderPM(Puu puu, Solmu solmu) {
        if (solmu != null) {
            kliittyma.ilmoita(" " + solmu.getAvain() + ":" + solmu.getVari());
            preorderPM(puu, solmu.getVasen());
            preorderPM(puu, solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle puulle (AVL- ja binäärihakupuut)
     * sisäläpikäynnin
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void inorder(Puu puu, Solmu solmu) {
        if (solmu.getVasen() != null) {
            inorder(puu, solmu.getVasen());
        }
        kliittyma.ilmoita(" " + solmu.getAvain());
        if (solmu.getOikea() != null) {
            inorder(puu, solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle punamustapuulle sisäläpikäynnin
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void inorderPM(Puu puu, Solmu solmu) {
        if (solmu != null) {
            inorderPM(puu, solmu.getVasen());
            kliittyma.ilmoita(" " + solmu.getAvain() + ":" + solmu.getVari());
            inorderPM(puu, solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle puulle (AVL- ja binäärihakupuut)
     * leveyssuuntaisen läpikäynnin
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void leverorder(Puu puu, Solmu solmu) {
        Jono jono = new Jono(100);
        jono.jonoon(puu.juuri);
        while (!jono.empty()) {
            Solmu x = jono.jonosta();
            kliittyma.ilmoita(" " + x.getAvain());

            if (x.getVasen() != null) {
                jono.jonoon(x.getVasen());
            }

            if (x.getOikea() != null) {
                jono.jonoon(x.getOikea());
            }
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle punamustapuulle leveyssuuntaisen
     * läpikäynnin
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void leverorderPM(Puu puu, Solmu solmu) {
        Jono jono = new Jono(100);
        jono.jonoon(puu.juuri);
        while (!jono.empty()) {
            Solmu x = jono.jonosta();
            kliittyma.ilmoita(" " + x.getAvain() + ":" + x.getVari());

            if (x.getVasen() != null) {
                jono.jonoon(x.getVasen());
            }

            if (x.getOikea() != null) {
                jono.jonoon(x.getOikea());
            }
        }
    }
}
