package tiraha;

/**
 * Luokka luo binäärihakupuun sekä toimii AVL-, punamusta- ja triepuuluokkien
 * yläluokkana.
 */
public class Binaarihakupuu {

    /**
     * Solmu-tyyppinen muuttuja, jota käytetään puun juurena.
     */
    public Solmu juuri = null;
    /**
     * Solmu-tyyppiset apumuuttujat.
     */
    private Solmu apuSolmu1 = null;
    private Solmu apuSolmu2 = null;

    /**
     * Metodi lisää parametrina annettavaan puuhun solmun, jolla on parametrina
     * annettava arvo avaimena. Jos puu on tyhjä, tästä solmusta tehdään puun
     * juuri. Jos taas puussa on jo solmuja, viedään uusi solmu puuhun oikealle
     * paikalleen.
     *
     * @param puu puu, johon solmu lisätään
     * @param avain solmun avaimena toimiva arvo
     */
    public Solmu binaariLisays(Binaarihakupuu puu, int avain) {
        Solmu uusisolmu = new Solmu(avain);
        uusisolmu.setVasen(null);
        uusisolmu.setOikea(null);
        uusisolmu.setParent(null);

        if (puu.juuri == null) {
            puu.juuri = uusisolmu;
            return uusisolmu;
        }
        apuSolmu1 = puu.juuri;
        while (apuSolmu1 != null) {
            apuSolmu2 = apuSolmu1;
            if (uusisolmu.getAvain() < apuSolmu1.getAvain()) {
                apuSolmu1 = apuSolmu1.getVasen();
            } else {
                apuSolmu1 = apuSolmu1.getOikea();
            }
        }
        uusisolmu.setParent(apuSolmu2);
        if (uusisolmu.getAvain() < apuSolmu2.getAvain()) {
            apuSolmu2.setVasen(uusisolmu);
            uusisolmu.setKorkeus(0);
            int temp = -1;
            if (apuSolmu2.getOikea() != null) {
                temp = apuSolmu2.getOikea().getKorkeus();
            }
            uusisolmu.getParent().setKorkeus(Math.max(uusisolmu.getKorkeus(), temp) + 1);
        } else {
            apuSolmu2.setOikea(uusisolmu);
            uusisolmu.setKorkeus(0);
            int temp = -1;
            if (apuSolmu2.getVasen() != null) {
                temp = apuSolmu2.getVasen().getKorkeus();
            }
            uusisolmu.getParent().setKorkeus(Math.max(uusisolmu.getKorkeus(), temp) + 1);
        }
        return uusisolmu;
    }

    /**
     * Metodi toimii puun juuren getterinä.
     *
     * @return puun juuri
     */
    public Solmu getJuuri() {
        return juuri;
    }
}
