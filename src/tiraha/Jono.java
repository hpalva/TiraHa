/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiraha;

/**
 * Luokka luo jonon.
 */
public class Jono {

    /**
     * Solmu-tyyppinen taulukko, johon puun solmut tallennetaan.
     */
    private Solmu[] taulukko;
    /**
     * Solmu-tyyppinen muuttuja, joka on jonon ensimmäinen solmu
     */
    private Solmu paaSolmu;
    /**
     * Integer-tyyppinen muuttuja, joka on jonon pään indeksi.
     */
    private int paa;
    /**
     * Solmu-tyyppinen muuttuja, joka on jonon viimeinen solmu
     */
    private Solmu hantaSolmu;
    /**
     * Integer-tyyppinen muuttuja, joka on jonon hännän indeksi
     */
    private int hanta;
    /**
     * Integer-tyyppinen muuttuja, joka on jonon maksimipituus
     */
    private int n;

    /**
     * Konstruktori määrittelee jonon
     *
     * @param size jonon pituus
     */
    public Jono(int size) {
        paaSolmu = null;
        paa = 0;
        hantaSolmu = null;
        hanta = 0;
        this.n = size;
        taulukko = new Solmu[n];
    }

    /**
     * Metodi lisää parametrina annetun luvun jonon viimeisimmäksi arvoksi
     *
     * @param x Jonoon lisättävä luku
     */
    public void jonoon(Solmu x) {
        taulukko[hanta] = x;
        hanta++;
        hantaSolmu = x;
        if (hanta == n) {
            hanta = 0;
        }
    }

    /**
     * Metodi poistaa jonosta sen ensimmäisen jäsenen
     *
     * @return Jonon ensimmäisen jäsenen
     */
    public Solmu jonosta() {
        Solmu pois = taulukko[paa];
        paa++;
        paaSolmu = taulukko[paa];
        if (paa == n) {
            paa = 0;
        }
        return pois;
    }

    /**
     * Metodi palauttaa tiedon onko jono tyhja
     *
     * @return Jonon ensimmaisen ja viimeisen jasenen
     */
    boolean empty() {
        return paa == hanta;
    }
}