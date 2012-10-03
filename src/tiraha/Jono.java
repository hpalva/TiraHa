package tiraha;

/**
 * Luokka luo jonon.
 */
public class Jono {

    /**
     * Solmu-tyyppinen taulukko, johon puun solmut tallennetaan.
     */
    public Solmu[] taulukko;
    /**
     * Solmu-tyyppinen muuttuja, joka on jonon ensimmäinen solmu
     */
    public Solmu paaSolmu;
    /**
     * Integer-tyyppinen muuttuja, joka on jonon pään indeksi.
     */
    public int paa;
    /**
     * Solmu-tyyppinen muuttuja, joka on jonon viimeinen solmu
     */
    public Solmu hantaSolmu;
    /**
     * Integer-tyyppinen muuttuja, joka on jonon hännän indeksi
     */
    public int hanta;
    /**
     * Integer-tyyppinen muuttuja, joka on jonon maksimipituus
     */
    public int koko;

    /**
     * Konstruktori määrittelee jonon
     *
     * @param koko jonon pituus
     */
    public Jono(int koko) {
        paaSolmu = null;
        paa = 0;
        hantaSolmu = null;
        hanta = 0;
        this.koko = koko;
        taulukko = new Solmu[koko];
    }

    /**
     * Metodi lisää parametrina annetun luvun jonon viimeisimmäksi arvoksi.
     *
     * @param solmu jonoon lisättävä luku
     */
    public void jonoon(Solmu solmu) {
        taulukko[hanta] = solmu;
        hanta++;
        hantaSolmu = solmu;
        if (hanta == koko) {
            hanta = 0;
        }
    }

    /**
     * Metodi poistaa jonosta sen ensimmäisen jäsenen.
     *
     * @return jonon ensimmäinen jäsen
     */
    public Solmu jonosta() {
        Solmu pois = taulukko[paa];
        paa++;
        paaSolmu = taulukko[paa];
        if (paa == koko) {
            paa = 0;
        }
        return pois;
    }

    /**
     * Metodi palauttaa tiedon siitä, onko jono tyhjä.
     *
     * @return jonon ensimmainen ja viimeinen jäsen
     */
    boolean empty() {
        return paa == hanta;
    }
}