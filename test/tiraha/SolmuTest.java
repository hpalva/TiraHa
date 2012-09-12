package tiraha;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolmuTest {

    Solmu solmu;
    Solmu oikea;
    Solmu vasen;

    public SolmuTest() {
    }

    @Before
    public void setUp() {
        this.solmu = new Solmu(5);
    }

    @Test
    public void korkeusOnAluksiNolla() {
        assertEquals(0, solmu.getKorkeus(), 0.001);
    }

    @Test
    public void korkeudenSetteriToimii() {
        solmu.setKorkeus(2);
        assertEquals(2, solmu.getKorkeus(), 0.001);
    }

    @Test
    public void oikeaLapsiOnNull() {
        assertEquals(null, solmu.getOikea());
    }

    @Test
    public void vasenLapsiOnNull() {
        assertEquals(null, solmu.getVasen());
    }

    @Test
    public void avainOnAluksiParametrinaAnnettuArvo() {
        assertEquals(5, solmu.getAvain(), 0.001);

    }

    @Test
    public void avaimenSetteriToimii() {
        solmu.setAvain(8);
        assertEquals(8, solmu.getAvain(), 0.001);
    }

    @Test
    public void oikeanLapsenSetteriToimii() {
        oikea = new Solmu(9);
        solmu.setOikea(oikea);
        assertEquals(oikea, solmu.getOikea());
    }

    @Test
    public void oikealleLapselleTuleeOikeaAvain() {
        oikea = new Solmu(89);
        solmu.setOikea(oikea);
        assertEquals(89, oikea.getAvain(), 0.001);
    }

    @Test
    public void vasenSetteriToimii() {
        vasen = new Solmu(2);
        solmu.setVasen(vasen);
        assertEquals(2, vasen.getAvain(), 0.001);
    }
    
    @Test
    public void vasemmalleLapselleTuleeOikeaAvain() {
        vasen = new Solmu(3);
        solmu.setVasen(vasen);
        assertEquals(3, vasen.getAvain(), 0.001);
    }
}
