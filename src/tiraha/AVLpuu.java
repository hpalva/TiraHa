package tiraha;

/**
 * Luokka luo AVL-puun.
 */
public class AVLpuu {

    /**
     * Solmu-tyyppinen muuttuja, joka toimii puun juurisolmuna.
     */
    private Solmu juuri;
    /**
     * Solmu-tyyppiset apumuuttujat.
     */
    private Solmu apuSolmu1;
    private Solmu apuSolmu2;
    private Solmu vanhempi;
    private Solmu alipuu;

    /**
     * Jos jonkin solmun lisääminen AVL-puuhun vie puun epätasapainoon ja
     * ongelma on solmun oikeassa alipuussa, metodi pyöräyttää solmua
     * vasemmalle.
     *
     * @param k1 pyöräytettävä solmu
     * @return pyöräytettävän solmun oikea lapsi
     */
    public Solmu pyoritaVasemmalle(Solmu k1) {
        Solmu k2 = k1.getOikea();
        k2.setParent(k1.getParent());
        k1.setParent(k2);
        k1.setOikea(k2.getVasen());
        k2.setVasen(k1);
        if (k1.getOikea() == null) {
            k1.getOikea().setParent(k1);
        }
        apumetodiKorkeuksille(k1, k2);
        return k2;
    }

    /**
     * Jos jonkin solmun lisääminen AVL-puuhun vie puun epätasapainoon ja
     * ongelma on solmun vasemmassa alipuussa, metodi pyöräyttää solmua
     * oikealle.
     *
     * @param k1 pyöräytettävä solmu
     * @return pyöräytettävän solmun vasen lapsi
     */
    public Solmu pyoritaOikealle(Solmu k1) {
        Solmu k2 = k1.getVasen();
        k2.setParent(k1.getParent());
        k1.setParent(k2);
        k1.setVasen(k2.getOikea());
        k2.setOikea(k1);
        if (k1.getVasen() != null) {
            k1.getVasen().setParent(k1);
        }
        apumetodiKorkeuksille(k1, k2);
        return k2;
    }

    /**
     * Jos jonkin solmun lisääminen AVL-puuhun vie puun epätasapainoon ja
     * ongelma on solmun oikean alipuun vasemmassa alipuussa, metodi pyörittää
     * solmua ensin oikealle ja sitten vasemmalle.
     *
     * @param k1 pyöritettävä solmu
     * @return kutsuu pyoritaVasemmalle()-metodia.
     */
    public Solmu pyoritaOikealleSittenVasemmalle(Solmu k1) {
        Solmu k2 = k1.getOikea();
        k1.setOikea(pyoritaOikealle(k2));
        return pyoritaVasemmalle(k1);
    }

    /**
     * Jos jonkin solmun lisääminen AVL-puuhun vie puun epätasapainoon ja
     * ongelma on solmun vasemman alipuun oikeassa alipuussa, metodi pyörittää
     * solmua ensin vasemmalle ja sitten oikealle.
     *
     * @param k1 pyöritettävä solmu
     * @return kutsuu pyoritaOikealle()-metodia.
     */
    public Solmu pyoritaVasemmalleSittenOikealle(Solmu k1) {
        Solmu k2 = k1.getVasen();
        k1.setVasen(pyoritaVasemmalle(k2));
        return pyoritaOikealle(k1);
    }

    /**
     * Metodi lisää parametrina annettavaan puuhun solmun, jolla on parametrina
     * annettava arvo avaimena. Jos puu on tyhjä, tästä solmusta tehdään puun
     * juuri. Jos taas puussa on jo solmuja, viedään uusi solmu puuhun oikealle
     * paikalleen.
     *
     * @param puu Puu, johon solmu lisätään
     * @param avain Solmun avaimena toimiva arvo
     */
    public Solmu insert(AVLpuu puu, int avain) {
        Solmu uusisolmu = new Solmu(avain);

        uusisolmu.setAvain(avain);

        uusisolmu.setVasen(null);
        uusisolmu.setOikea(null);
        uusisolmu.setParent(null);

        if (puu.juuri == null) {
            puu.juuri = uusisolmu;
        } else {
            apuSolmu1 = puu.juuri;
            while (apuSolmu1 != null) {
                apuSolmu2 = apuSolmu1;
                if (uusisolmu.getAvain() < apuSolmu1.getAvain()) {
                    apuSolmu1 = apuSolmu1.getVasen();
                } else {
                    apuSolmu1 = apuSolmu1.getOikea();
                }
                uusisolmu.setParent(apuSolmu2);
                if (uusisolmu.getAvain() < apuSolmu2.getAvain()) {
                    apuSolmu2.setVasen(uusisolmu);
                } else {
                    apuSolmu2.setOikea(uusisolmu);
                }
            }
        }
        return uusisolmu;
    }

    /**
     * Metodi lisää parametrina annettavaan puuhun solmun, jolla on parametrina
     * annettava arvo avaimena. Jos puu on tyhjä, tästä solmusta tehdään puun
     * juuri. Jos taas puussa on jo solmuja, viedään uusi solmu puuhun oikealle
     * paikalleen ja jos tästä seuraa, että puusta tulee epätasapainoinen,
     * metodi toteuttaa tarvittavat toiminpiteet.
     *
     * @param puu Puu, johon solmu lisätään
     * @param avain Solmun avaimena toimiva arvo
     */
    public void lisaa(AVLpuu puu, int avain) {
        Solmu uusisolmu = insert(puu, avain);
        apuSolmu1 = uusisolmu.getParent();
        while (apuSolmu1 != null) {
            if (apuSolmu1.getVasen().getKorkeus() == apuSolmu1.getOikea().getKorkeus() + 2) {
                vanhempi = apuSolmu1.getParent();
                if (apuSolmu1.getVasen().getVasen().getKorkeus() > apuSolmu1.getVasen().getOikea().getKorkeus()) {
                    alipuu = pyoritaOikealle(apuSolmu1);
                } else {
                    alipuu = pyoritaVasemmalleSittenOikealle(apuSolmu1);
                }
                if (vanhempi == null) {
                    puu.juuri = alipuu;
                } else if (vanhempi.getVasen() == apuSolmu1) {
                    vanhempi.setVasen(alipuu);
                } else {
                    vanhempi.setOikea(alipuu);
                }
                if (vanhempi != null) {
                    vanhempi.setKorkeus(Math.max(vanhempi.getVasen().getKorkeus(), vanhempi.getOikea().getKorkeus()) + 1);
                }

            } else if (apuSolmu1.getOikea().getKorkeus() == apuSolmu1.getVasen().getKorkeus() + 2) {
                vanhempi = apuSolmu1.getParent();
                if (apuSolmu1.getOikea().getOikea().getKorkeus() > apuSolmu1.getOikea().getVasen().getKorkeus()) {
                    alipuu = pyoritaVasemmalle(apuSolmu1);
                } else {
                    alipuu = pyoritaOikealleSittenVasemmalle(apuSolmu1);
                }
                if (vanhempi == null) {
                    puu.juuri = alipuu;
                } else if (vanhempi.getVasen() == apuSolmu1) {
                    vanhempi.setVasen(alipuu);
                } else {
                    vanhempi.setOikea(alipuu);
                }
                if (vanhempi != null) {
                    vanhempi.setKorkeus(Math.max(vanhempi.getVasen().getKorkeus(), vanhempi.getOikea().getKorkeus()) + 1);
                }

            }
            apuSolmu1.setKorkeus(Math.max(apuSolmu1.getVasen().getKorkeus(), apuSolmu1.getOikea().getKorkeus()) + 1);
            apuSolmu1 = apuSolmu1.getParent();
        }
    }

    /**
     * Metodi toimii apumetodina korkeuksien asettamiselle.
     * @param k1 solmu, jolle korkeus asetetaan
     * @param k2 solmu, jolle korkeus asetetaan
     */
    public void apumetodiKorkeuksille(Solmu k1, Solmu k2) {
        k1.setKorkeus(Math.max(k1.getVasen().getKorkeus(), k1.getOikea().getKorkeus()) + 1);
        k2.setKorkeus(Math.max(k2.getVasen().getKorkeus(), k2.getOikea().getKorkeus()) + 1);
    }
}
