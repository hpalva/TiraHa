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
     * Metodi suorittaa parametrina annettulle puulle esiläpikäynnin
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void preorder(Puu puu, Solmu solmu) {
        if (solmu != null) {
            kliittyma.ilmoita("" + solmu.getAvain());
            preorder(puu, solmu.getVasen());
            preorder(puu, solmu.getOikea());
        }

    }

    /**
     * Metodi suorittaa parametrina annettulle puulle sisäläpikäynnin
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void inorder(Puu puu, Solmu solmu) {
        if (solmu != null) {
            inorder(puu, solmu.getVasen());
            kliittyma.ilmoita("" + solmu.getAvain());
            inorder(puu, solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle puulle leveyssuuntaisen
     * läpikäynnin
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void leverorder(Puu puu, Solmu solmu) {
    }
}
