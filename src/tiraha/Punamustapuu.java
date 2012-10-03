package tiraha;

/**
 * Luokka luo punamustapuun.
 */
public class Punamustapuu extends Binaarihakupuu {

    /**
     * Metodi pyörittää parametrina annettua solmua vasemmalle, koska solmu on
     * aiheuttanut epätasapainon eli solmun vanhempi ja solmu itse ovat
     * punaiset.
     *
     * @param solmu solmu, jota tulee pyörittää
     */
    public void pyoritaVasemmalle(Solmu solmu) {
        Solmu apu = solmu.getOikea();
        solmu.setOikea(apu.getVasen());
        if (apu.getVasen() != null) {
            apu.getVasen().setParent(solmu);
        }
        apu.setParent(solmu.getParent());
        if (solmu.getParent() == null) {
            juuri = apu;
        } else {
            if (solmu == solmu.getParent().getVasen()) {
                solmu.getParent().setVasen(apu);
            } else {
                solmu.getParent().setOikea(apu);
            }
        }
        apu.setVasen(solmu);
        solmu.setParent(apu);
    }

    /**
     * Metodi pyörittää parametrina annettua solmua oikealle, koska solmu on
     * aiheuttanut epätasapainon eli solmun vanhempi ja solmu itse ovat
     * punaiset.
     *
     * @param solmu Solmu, jota tulee pyörittää
     */
    public void pyoritaOikealle(Solmu solmu) {
        Solmu apu = solmu.getVasen();
        solmu.setVasen(apu.getOikea());
        if (apu.getOikea() != null) {
            apu.getOikea().setParent(solmu);
        }
        apu.setParent(solmu.getParent());
        if (solmu.getParent() == null) {
            juuri = apu;
        } else {
            if (solmu == solmu.getParent().getOikea()) {
                solmu.getParent().setOikea(apu);
            } else {
                solmu.getParent().setVasen(apu);
            }
        }
        apu.setOikea(solmu);
        solmu.setParent(apu);
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
        Solmu uusi = puu.binaariLisays(puu, avain);
        uusi.setVari("puna");
        Solmu apu;

        while (uusi.getParent() != null && uusi.getParent().getVari().equals("puna")) {
            if (uusi.getParent() == uusi.getParent().getParent().getVasen()) {
                apu = uusi.getParent().getParent().getOikea();
                if (apu != null && apu.getVari().equals("puna")) {
                    uusi.getParent().setVari("musta");
                    apu.setVari("musta");
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
                apu = uusi.getParent().getParent().getVasen();
                if (apu != null && apu.getVari().equals("puna")) {
                    uusi.getParent().setVari("musta");
                    apu.setVari("musta");
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
