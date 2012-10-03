package tiraha;

/**
 * Luokka toteuttaa erilaisia puun läpikäyntejä.
 */
public class Lapikulut {

    /**
     * Käytössä oleva tekstikäyttöliittymä.
     */
    private Tekstikayttoliittyma kliittyma = new Tekstikayttoliittyma();

    /**
     * Metodi suorittaa parametrina annettulle puulle (AVL- ja binäärihakupuut)
     * esiläpikäynnin.
     *
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void preorder(Solmu solmu) {
        kliittyma.ilmoita(" " + solmu.getAvain());
        if (solmu.getVasen() != null) {
            preorder(solmu.getVasen());
        }
        if (solmu.getOikea() != null) {
            preorder(solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle punamustapuulle esiläpikäynnin.
     *
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void preorderPM(Solmu solmu) {
        kliittyma.ilmoita(" " + solmu.getAvain() + ":" + solmu.getVari());
        if (solmu.getVasen() != null) {
            preorderPM(solmu.getVasen());
        }
        if (solmu.getOikea() != null) {
            preorderPM(solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle puulle (AVL- ja binäärihakupuut)
     * sisäläpikäynnin.
     *
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void inorder(Solmu solmu) {
        if (solmu.getVasen() != null) {
            inorder(solmu.getVasen());
        }
        kliittyma.ilmoita(" " + solmu.getAvain());
        if (solmu.getOikea() != null) {
            inorder(solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle punamustapuulle sisäläpikäynnin.
     *
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void inorderPM(Solmu solmu) {
        if (solmu.getVasen() != null) {
            inorderPM(solmu.getVasen());
        }
        kliittyma.ilmoita(" " + solmu.getAvain() + ":" + solmu.getVari());
        if (solmu.getOikea() != null) {
            inorderPM(solmu.getOikea());
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle puulle (AVL- ja binäärihakupuut)
     * leveyssuuntaisen läpikäynnin.
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void leverorder(Binaarihakupuu puu, Solmu solmu) {
        Jono jono = new Jono(100);
        jono.jonoon(puu.juuri);
        while (!jono.empty()) {
            Solmu x = jono.jonosta();
            kliittyma.ilmoita(" " + x.getAvain());

            if (x.getVasen() != null) {
                jono.jonoon(x.getVasen());
            }

            if (x.getOikea() != null) {
                jono.jonoon(x.getOikea());
            }
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle punamustapuulle leveyssuuntaisen
     * läpikäynnin.
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void leverorderPM(Binaarihakupuu puu, Solmu solmu) {
        Jono jono = new Jono(100);
        jono.jonoon(puu.juuri);
        while (!jono.empty()) {
            Solmu x = jono.jonosta();
            kliittyma.ilmoita(" " + x.getAvain() + ":" + x.getVari());
            if (x.getVasen() != null) {
                jono.jonoon(x.getVasen());
            }
            if (x.getOikea() != null) {
                jono.jonoon(x.getOikea());
            }
        }
    }

    /**
     * Metodi suorittaa parametrina annettulle triepuulle leveyssuuntaisen
     * läpikäynnin. Triepuun juuri on aina "dummy node", jolla ei ole mitään
     * arvoa, joten sitä ei tulosteta.
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void levelorderTrie(Binaarihakupuu puu, Solmu solmu) {
        Jono jono = new Jono(100);
        jono.jonoon(solmu);
        while (!jono.empty()) {
            Solmu x = jono.jonosta();
            if (x != puu.juuri) {
                kliittyma.ilmoita(" " + x.getAvain());
            }
            for (int i = 0; i < 10; ++i) {
                if (x.getLapset()[i] != null) {
                    jono.jonoon(x.getLapset()[i]);
                }
            }
        }
    }

    /**
     * Tulostaa kaikki triepuuhun tallennetut luvut ei niin missään hienossa
     * järjestyksessä.
     *
     * @param puu läpikäytävä puu
     * @param solmu solmu, josta läpikäynti aloitetaan
     */
    public void puunLuvut(Binaarihakupuu puu, Solmu solmu) {
        Jono jono = new Jono(100);
        jono.jonoon(solmu);
        int j = 0;
        while (!jono.empty()) {
            Solmu x = jono.jonosta();
            if (x.getMarkkeri() && x != puu.juuri) {
                Solmu apuS = x;
                int[] taulu = new int[7];
                while (apuS != puu.juuri) {
                    taulu[j] = apuS.getAvain();
                    j++;
                    apuS = apuS.getParent();
                }
                String luku = "";
                for (int r = j - 1; r >= 0; --r) {
                    luku = luku + taulu[r];
                }
                System.out.print(luku + " ");
                j = 0;
                taulu = new int[7];
            }
            for (int i = 0; i < 10; ++i) {
                if (x.getLapset()[i] != null) {
                    jono.jonoon(x.getLapset()[i]);
                }
            }
        }
    }
}
