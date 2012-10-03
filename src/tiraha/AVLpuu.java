package tiraha;

/**
 * Luokka luo AVL-puun.
 */
public class AVLpuu extends Binaarihakupuu {

    /**
     * Solmu-tyyppinen apumuuttuja.
     */
    private Solmu alipuu;

    /**
     * Jos jonkin solmun lisääminen AVL-puuhun vie puun epätasapainoon ja
     * ongelma on solmun oikeassa alipuussa, metodi pyöräyttää solmua
     * vasemmalle.
     *
     * @param pyoritettava pyöräytettävä solmu
     * @return pyöräytettävän solmun oikea lapsi
     */
    public Solmu pyoritaVasemmalle(Solmu pyoritettava) {
        Solmu apu = pyoritettava.getOikea();
        apu.setParent(pyoritettava.getParent());
        pyoritettava.setParent(apu);
        pyoritettava.setOikea(apu.getVasen());
        apu.setVasen(pyoritettava);
        if (pyoritettava.getOikea() != null) {
            pyoritettava.getOikea().setParent(pyoritettava);
        }
        apumetodiKorkeuksille(pyoritettava, apu);
        return apu;
    }

    /**
     * Jos jonkin solmun lisääminen AVL-puuhun vie puun epätasapainoon ja
     * ongelma on solmun vasemmassa alipuussa, metodi pyöräyttää solmua
     * oikealle.
     *
     * @param pyoritettava pyöräytettävä solmu
     * @return pyöräytettävän solmun vasen lapsi
     */
    public Solmu pyoritaOikealle(Solmu pyoritettava) {
        Solmu apu = pyoritettava.getVasen();
        apu.setParent(pyoritettava.getParent());
        pyoritettava.setParent(apu);
        pyoritettava.setVasen(apu.getOikea());
        apu.setOikea(pyoritettava);
        if (pyoritettava.getVasen() != null) {
            pyoritettava.getVasen().setParent(pyoritettava);
        }
        apumetodiKorkeuksille(pyoritettava, apu);
        return apu;
    }

    /**
     * Jos jonkin solmun lisääminen AVL-puuhun vie puun epätasapainoon ja
     * ongelma on solmun oikean alipuun vasemmassa alipuussa, metodi pyörittää
     * solmua ensin oikealle ja sitten vasemmalle.
     *
     * @param pyoritettava pyöritettävä solmu
     * @return kutsuu pyoritaVasemmalle()-metodia
     */
    public Solmu pyoritaOikealleSittenVasemmalle(Solmu pyoritettava) {
        Solmu apu = pyoritettava.getOikea();
        pyoritettava.setOikea(pyoritaOikealle(apu));
        return pyoritaVasemmalle(pyoritettava);
    }

    /**
     * Jos jonkin solmun lisääminen AVL-puuhun vie puun epätasapainoon ja
     * ongelma on solmun vasemman alipuun oikeassa alipuussa, metodi pyörittää
     * solmua ensin vasemmalle ja sitten oikealle.
     *
     * @param pyoritettava pyöritettävä solmu
     * @return kutsuu pyoritaOikealle()-metodia
     */
    public Solmu pyoritaVasemmalleSittenOikealle(Solmu pyoritettava) {
        Solmu apu = pyoritettava.getVasen();
        pyoritettava.setVasen(pyoritaVasemmalle(apu));
        return pyoritaOikealle(pyoritettava);
    }

    /**
     * Metodi lisää parametrina annettavaan puuhun solmun, jolla on parametrina
     * annettava arvo avaimena. Jos puu on tyhjä, tästä solmusta tehdään puun
     * juuri. Jos taas puussa on jo solmuja, viedään uusi solmu puuhun oikealle
     * paikalleen ja jos tästä seuraa, että puusta tulee epätasapainoinen,
     * metodi toteuttaa tarvittavat toimenpiteet.
     *
     * @param puu puu, johon solmu lisätään
     * @param avain solmun avaimena toimiva arvo
     * @return lisätty solmu
     */
    public Solmu lisaa(AVLpuu puu, int avain) {
        Solmu uusi = binaariLisays(puu, avain);
        if (uusi.getParent() == null) {
            return uusi;
        }
        Solmu apuSolmu = uusi.getParent();
        Solmu ongelma = uusi.getParent();
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
                return uusi;
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
                return uusi;
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
        return uusi;
    }

    /**
     * Metodi toimii apumetodina korkeuksien asettamiselle.
     *
     * @param solmu1 solmu, jolle korkeus asetetaan
     * @param solmu2 solmu, jolle korkeus asetetaan
     */
    private void apumetodiKorkeuksille(Solmu solmu1, Solmu solmu2) {
        int temp1 = -1;
        int temp2 = -1;
        if (solmu1.getVasen() != null) {
            temp1 = solmu1.getVasen().getKorkeus();
        }
        if (solmu1.getOikea() != null) {
            temp2 = solmu1.getOikea().getKorkeus();
        }
        solmu1.setKorkeus(Math.max(temp1, temp2) + 1);
        temp1 = temp2 = -1;
        if (solmu2.getVasen() != null) {
            temp1 = solmu2.getVasen().getKorkeus();
        }
        if (solmu2.getOikea() != null) {
            temp2 = solmu2.getOikea().getKorkeus();
        }
        solmu2.setKorkeus(Math.max(temp1, temp2) + 1);
    }

    /**
     * Metodi muuttaa parametrina annettavan solmun korkeuden.
     *
     * @param vanhempi solmu, jonka korkeus muutetaan
     */
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
