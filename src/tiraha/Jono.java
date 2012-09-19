/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiraha;

/**
 *Luokka luo jonon.
 */
public class Jono {
    
    /**
     * Integer-tyyppinen taulukko, johon jonon arvot tallennetaan.
     */
    private int[] taulukko;
    /**
     * Integer-tyyppinen muuttuja, joka on jonon ensimmäinen arvo
     */
    private int paa;
    /**
     * Integer-tyyppinen muuttuja, joka on jonon viimeinen arvo
     */
    private int hanta;
    /**
     * Integer-tyyppinen muuttuja, joka on jonon maksimipituus
     */
    private int n;

    /**
     * Konstruktori määrittelee jonon
     * @param size jonon pituus
     */
    public Jono(int size) {
        paa = 0;
        hanta = 0;
        this.n = size;
        taulukko = new int[n];
    }
/**
 * Metodi lisää parametrina annetun luvun jonon viimeisimmäksi arvoksi
 * @param x Jonoon lisättävä luku
 */
    public void jonoon(int x) {
        taulukko[hanta] = x;
        hanta++;
        if (hanta == n) {
            hanta = 0;
        }
    }
/**
 * Metodi poistaa jonosta sen ensimmäisen jäsenen
 * @return Jonon ensimmäisen jäsenen 
 */
    public int jonosta() {
        int pois = taulukko[paa];
        paa++;
        if (paa == n) {
            paa = 0;
        }
        return pois;
    }
}