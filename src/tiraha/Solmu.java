package tiraha;

/**
 * Luokka luo solmun.
 */
public class Solmu {

    /**
     * Solmu-tyyppinen muuttuja, jota käytetään solmun vasempana lapsena
     */
    private Solmu vasen;
    /**
     * Solmu-tyyppinen muuttuja, jota käytetään solmun oikeana lapsena
     */
    private Solmu oikea;
    /**
     * Integer-tyyppinen muuttuja, jota käytetään solmun avain arvona
     */
    private int avain;
    /**
     * Integer-tyyppinen muuttuja, jota käytetään solmun korkeuden arvona
     */
    private int korkeus;
    /**
     * Solmu-tyyppinen muuttuja, jota käytetään solmun vanhempana solmuna
     */
    private Solmu parent;
    /**
     * Solmu-tyyppinen muuttuja, jota käytetään puun juurena.
     */
    private Solmu juuri;

    /**
     * Konstruktori määrittelee solmun.
     *
     * @param avain Avaimeksi asetettava arvo
     * @param vasen Vasemmaksi lapseksi asetettava solmu
     * @param oikea Oikeaksi lapseksi asetettava solmu
     */
    public Solmu(int avain, Solmu vasen, Solmu oikea) {
        this.avain = avain;
        this.vasen = vasen;
        this.oikea = oikea;
        korkeus = 0;
    }

    /**
     * Vaihtoehtoinen konstruktori, joka määrittelee solmun.
     *
     * @param avain Avaimeksi asetettava arvo
     */
    public Solmu(int avain) {
        this.avain = avain;
        // vasen ja oikea ovat null
    }

    /**
     * Getteri vasemmalle lapselle.
     *
     * @return Vasemman lapsen
     */
    public Solmu getVasen() {
        return vasen;
    }

    /**
     * Setteri vasemmalle lapselle
     *
     * @param vasen Vasemmaksi lapseksi asetettava solmu
     */
    public void setVasen(Solmu vasen) {
        this.vasen = vasen;
        //vasen.setKorkeus(vasen.getParent().getKorkeus() + 1);
    }

    /**
     * Setteri oikealle lapselle
     *
     * @param oikea Oikeaksi lapseksi asetettava solmu
     */
    public void setOikea(Solmu oikea) {
        this.oikea = oikea;
        //oikea.setKorkeus(oikea.getParent().getKorkeus() + 1);
    }

    /**
     * Getteri oikealle lapselle.
     *
     * @return Oikean lapsen
     */
    public Solmu getOikea() {
        return oikea;
    }

    /**
     * Getteri solmun avaimen arvolle.
     *
     * @return avaimen arvon
     */
    public int getAvain() {
        return avain;
    }

    /**
     * Setteri solmun avaimen arvolle
     *
     * @param avain Solmun avaimen arvoksi asetettava luku
     */
    public void setAvain(int avain) {
        this.avain = avain;
    }

    /**
     * Getteri solmun vanhemmalle.
     *
     * @return Solmun vanhemman
     */
    public Solmu getParent() {
        return parent;
    }

    /**
     * Setteri solmun vanhemmalle
     *
     * @param parent Solmun vanhempi
     */
    public void setParent(Solmu parent) {
        this.parent = parent;
    }

    /**
     * Getteri solmun korkeudelle.
     *
     * @return Solmun korkeuden
     */
    public int getKorkeus() {
        return korkeus;
    }

    /**
     * Setteri solmun korkeudelle
     *
     * @param korkeus Solmun korkeus
     */
    public void setKorkeus(int korkeus, Solmu solmu) {
        this.korkeus = korkeus;
//        if (korkeus == 0) {
//            juuri = solmu;
//        }
    }

//    public Solmu getJuuri() {
//        return juuri;
//    }
//    public String toString() {
//        String l, r;
//
//        if (vasen == null) {
//            l = "null";
//        } else {
//            l = vasen.toString();
//        }
//
//        if (oikea == null) {
//            r = "null";
//        } else {
//            r = oikea.toString();
//        }
//
//        return "Solmu[" + avain + ", " + l + ", " + r + "]";
//    }
}
