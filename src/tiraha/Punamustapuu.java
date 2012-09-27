package tiraha;

/**
 * Luokka luo punamustapuun.
 */
public class Punamustapuu extends Puu {

    /**
     * Solmu-tyyppinen muuttuja, joka toimii puun juurisolmuna.
     */
    private Solmu juuri;

    /**
     * Metodi pyörittää parametrina annettua solmua vasemmalle, koska solmu on
     * aiheuttanut epätasapainon eli solmun vanhempi ja solmu itse ovat
     * punaiset.
     *
     * @param solmu Solmu, jota tulee pyörittää
     */
    public void pyoritaVasemmalle(Solmu solmu) {
        Solmu y = solmu.getOikea();
        solmu.setOikea(y.getVasen());
        if (y.getVasen() != null) {
            y.getVasen().setParent(solmu);
        }
        y.setParent(solmu.getParent());
        if (solmu.getParent() == null) {
            juuri = y;
        } else {
            if (solmu == solmu.getParent().getVasen()) {
                solmu.getParent().setVasen(y);
            } else {
                solmu.getParent().setOikea(y);
            }
        }
        y.setVasen(solmu);
        solmu.setParent(y);
    }

    /**
     * Metodi pyörittää parametrina annettua solmua oikealle, koska solmu on
     * aiheuttanut epätasapainon eli solmun vanhempi ja solmu itse ovat
     * punaiset.
     *
     * @param solmu Solmu, jota tulee pyörittää
     */
    public void pyoritaOikealle(Solmu solmu) {
        Solmu y = solmu.getVasen();
        solmu.setVasen(y.getOikea());
        if (y.getOikea() != null) {
            y.getOikea().setParent(solmu);
        }
        y.setParent(solmu.getParent());
        if (solmu.getParent() == null) {
            juuri = y;
        } else {
            if (solmu == solmu.getParent().getOikea()) {
                solmu.getParent().setOikea(y);
            } else {
                solmu.getParent().setVasen(y);
            }
        }
        y.setOikea(solmu);
        solmu.setParent(y);
    }

    /**
     * Metodi lisää parametrina annettavaan puuhun solmun, jolla on parametrina
     * annettava arvo avaimena. Jos puu on tyhjä, tästä solmusta tehdään puun
     * juuri. Jos taas puussa on jo solmuja, viedään uusi solmu puuhun oikealle
     * paikalleen ja jos tästä seuraa, että puusta tulee epätasapainoinen
     * (=puussa on peräkkäin kaksi punaista solmua) metodi toteuttaa tarvittavat
     * toimenpiteet. Juuren väriksi tulee aina musta ja lisättävä solmu on aina
     * punainen.
     *
     * @param puu Puu, johon solmu lisätään
     * @param avain Solmun avaimena toimiva arvo
     * @return Lisätty solmu
     */
    public Solmu lisaa(Punamustapuu puu, int avain) {
        Solmu uusi = puu.insert(puu, avain);
        uusi.setVari("puna");
        Solmu y;

        while (uusi.getParent() != null && uusi.getParent().getVari().equals("puna")) {
            if (uusi.getParent() == uusi.getParent().getParent().getVasen()) {
                y = uusi.getParent().getParent().getOikea();
                if (y != null && y.getVari().equals("puna")) {
                    uusi.getParent().setVari("musta");
                    y.setVari("musta");
                    uusi.getParent().getParent().setVari("puna");
                    uusi = uusi.getParent().getParent();
                } else {
                    if (uusi == uusi.getParent().getOikea()) {
                        uusi = uusi.getParent();
                        pyoritaVasemmalle(uusi);

                    }
                    uusi.getParent().setVari("musta");
                    uusi.getParent().getParent().setVari("puna");
                    pyoritaOikealle(uusi.getParent().getParent());
                }
            } else {
                y = uusi.getParent().getParent().getVasen();
                if (y != null && y.getVari().equals("puna")) {
                    uusi.getParent().setVari("musta");
                    y.setVari("musta");
                    uusi.getParent().getParent().setVari("puna");
                    uusi = uusi.getParent().getParent();
                } else {
                    if (uusi == uusi.getParent().getVasen()) {
                        uusi = uusi.getParent();
                        pyoritaOikealle(uusi);
                    }
                    uusi.getParent().setVari("musta");
                    uusi.getParent().getParent().setVari("puna");
                    pyoritaVasemmalle(uusi.getParent().getParent());
                }
            }

        }
        puu.getJuuri().setVari("musta");
        return uusi;
    }
}
