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
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void preorder(Solmu solmu) {
        kliittyma.ilmoita(" " + solmu.getAvain());
        if (solmu.getVasen() != null) {
            preorder(solmu.getVasen());
        }
        if (solmu.getOikea() != null) {
            preorder(solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle punamustapuulle esiläpikäynnin
     *
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void preorderPM(Solmu solmu) {
        kliittyma.ilmoita(" " + solmu.getAvain() + ":" + solmu.getVari());
        if (solmu.getVasen() != null) {
            preorderPM(solmu.getVasen());
        }
        if (solmu.getOikea() != null) {
            preorderPM(solmu.getOikea());
        }


    }

    /**
     * Metodi suorittaa parametrina annettulle puulle (AVL- ja binäärihakupuut)
     * sisäläpikäynnin
     *
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void inorder(Solmu solmu) {
        if (solmu.getVasen() != null) {
            inorder(solmu.getVasen());
        }
        kliittyma.ilmoita(" " + solmu.getAvain());
        if (solmu.getOikea() != null) {
            inorder(solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle punamustapuulle sisäläpikäynnin
     *
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void inorderPM(Solmu solmu) {
        if (solmu.getVasen() != null) {
            inorderPM(solmu.getVasen());
        }
        kliittyma.ilmoita(" " + solmu.getAvain() + ":" + solmu.getVari());
        if (solmu.getOikea() != null) {
            inorderPM(solmu.getOikea());
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
