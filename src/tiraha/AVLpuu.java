package tiraha;

/**
 * Luokka luo AVL-puun.
 */
public class AVLpuu extends Puu {

    /**
     * Solmu-tyyppinen muuttuja, joka toimii puun juurisolmuna.
     */
    private Solmu juuri;
    /**
     * Solmu-tyyppiset apumuuttujat.
     */
    // private Solmu apuSolmu1;
//    private Solmu vanhempi;
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
        //k1=2;
        //k2=4;
        Solmu k2 = k1.getOikea();
        k2.setParent(k1.getParent());
        k1.setParent(k2);
        k1.setOikea(k2.getVasen());
        k2.setVasen(k1);
        if (k1.getOikea() != null) {
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
        //k1=5
        //k2=4
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
        //k1=5
        //k2=2;
        Solmu k2 = k1.getVasen();
        k1.setVasen(pyoritaVasemmalle(k2));
        return pyoritaOikealle(k1);
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
     * @return lisätty solmu
     */
    public Solmu lisaa(AVLpuu puu, int avain) {
        Solmu uusisolmu = insert(puu, avain);
        if (uusisolmu.getParent() == null) {
            return uusisolmu;
        }
        Solmu apuSolmu = uusisolmu.getParent();
        Solmu ongelma = uusisolmu.getParent();
        int temp1;
        int temp2;
        int temp3;
        int temp4;
        while (apuSolmu != null) {
            temp1 = -1;
            temp2 = -1;
            temp3 = -1;
            temp4 = -1;
            if (apuSolmu.getVasen() != null) {
                temp1 = apuSolmu.getVasen().getKorkeus();
            }
            if (apuSolmu.getOikea() != null) {
                temp2 = apuSolmu.getOikea().getKorkeus();
            }
            if (temp1 == temp2 + 2) {

                Solmu vanhempi = apuSolmu.getParent();

                if (apuSolmu.getVasen() != null && apuSolmu.getVasen().getVasen() != null) {
                    temp3 = apuSolmu.getVasen().getVasen().getKorkeus();
                }
                if (apuSolmu.getVasen() != null && apuSolmu.getVasen().getOikea() != null) {
                    temp4 = apuSolmu.getVasen().getOikea().getKorkeus();
                }
                if (temp3 > temp4) {
                    alipuu = pyoritaOikealle(ongelma.getParent());
                } else {
                    alipuu = pyoritaVasemmalleSittenOikealle(ongelma.getParent());
                }
                if (vanhempi == null) {
                    puu.juuri = alipuu;
                } else if (vanhempi.getVasen() == apuSolmu) {
                    vanhempi.setVasen(alipuu);
                } else {
                    vanhempi.setOikea(alipuu);
                }
                apumetodiVanhemmanKorkeudelle(vanhempi);
                return uusisolmu;
            }
            temp1 = -1;
            temp2 = -1;
            temp3 = -1;
            temp4 = -1;
            if (apuSolmu.getOikea() != null) {
                temp1 = apuSolmu.getOikea().getKorkeus();
            }
            if (apuSolmu.getVasen() != null) {
                temp2 = apuSolmu.getVasen().getKorkeus();
            }
            if (temp1 == temp2 + 2) {
                Solmu vanhempi = apuSolmu.getParent();
                if (apuSolmu.getOikea() != null && apuSolmu.getOikea().getOikea() != null) {
                    temp3 = apuSolmu.getOikea().getOikea().getKorkeus();
                }
                if (apuSolmu.getOikea() != null && apuSolmu.getOikea().getVasen() != null) {
                    temp4 = apuSolmu.getOikea().getVasen().getKorkeus();
                }
                if (temp3 > temp4) {
                    alipuu = pyoritaVasemmalle(ongelma.getParent());
                } else {
                    alipuu = pyoritaOikealleSittenVasemmalle(ongelma.getParent());
                }
                if (vanhempi == null) {
                    puu.juuri = alipuu;
                } else if (vanhempi.getVasen() == apuSolmu) {
                    vanhempi.setVasen(alipuu);
                } else {
                    vanhempi.setOikea(alipuu);
                }
                apumetodiVanhemmanKorkeudelle(vanhempi);
                return uusisolmu;
            }
            temp3 = temp4 = -1;
            if (apuSolmu.getVasen() != null) {
                temp3 = apuSolmu.getVasen().getKorkeus();
            }
            if (apuSolmu.getOikea() != null) {
                temp4 = apuSolmu.getOikea().getKorkeus();
            }
            apuSolmu.setKorkeus(Math.max(temp3, temp4) + 1);
            apuSolmu = apuSolmu.getParent();

        }
        return uusisolmu;
    }

    /**
     * Metodi toimii apumetodina korkeuksien asettamiselle.
     *
     * @param k1 solmu, jolle korkeus asetetaan
     * @param k2 solmu, jolle korkeus asetetaan
     */
    private void apumetodiKorkeuksille(Solmu k1, Solmu k2) {
        int temp1 = -1;
        int temp2 = -1;
        if (k1.getVasen() != null) {
            temp1 = k1.getVasen().getKorkeus();
        }
        if (k1.getOikea() != null) {
            temp2 = k1.getOikea().getKorkeus();
        }
        k1.setKorkeus(Math.max(temp1, temp2) + 1);
        temp1 = temp2 = -1;
        if (k2.getVasen() != null) {
            temp1 = k2.getVasen().getKorkeus();
        }
        if (k2.getOikea() != null) {
            temp2 = k2.getOikea().getKorkeus();
        }
        k2.setKorkeus(Math.max(temp1, temp2) + 1);
    }

    private void apumetodiVanhemmanKorkeudelle(Solmu vanhempi) {
        int temp1 = -1;
        int temp2 = -1;
        if (vanhempi != null) {
            if (vanhempi.getVasen() != null) {
                temp1 = vanhempi.getVasen().getKorkeus();
            }
            if (vanhempi.getOikea() != null) {
                temp2 = vanhempi.getOikea().getKorkeus();
            }
            vanhempi.setKorkeus(Math.max(temp1, temp2) + 1);
        }
    }
}
