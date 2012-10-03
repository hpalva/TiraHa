/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiraha;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henriikka
 */
public class JonoTest {
 
    private Jono jono;
    private Solmu testisolmu;
 
    public JonoTest() {
    }
 
    @Before
    public void setUp() {
        jono = new Jono(2);
    }
 
    @Test
    public void aluksiJonoOnTyhja() {
        assertTrue(jono.empty());
    }
 
    @Test
    public void aluksiPaanArvoOnNolla() {
        assertEquals(jono.paa, 0, 0.001);
    }
 
    @Test
    public void aluksiHannanArvoOnNolla() {
        assertEquals(jono.hanta, 0, 0.001);
    }
 
    @Test
    public void aluksiPaasolmuOnNull() {
        assertEquals(jono.paaSolmu, null);
    }
 
    @Test
    public void aluksiHantasolmuOnNull() {
        assertEquals(jono.hantaSolmu, null);
    }
 
    @Test
    public void aluksiTaulukonKokoOnParametrinaAnnettuLuku() {
        assertEquals(jono.koko, 2, 0.0001);
    }
 
    @Test
    public void jonossaYksiSolmuJaTamaSolmuOnHantasolmu() {
        testisolmu = new Solmu(2);
        jono.jonoon(testisolmu);
        assertEquals(jono.hantaSolmu, testisolmu);
    }
 
    @Test
    public void jonossaYksiSolmuJaTalloinPaaOnNolla() {
        testisolmu = new Solmu(2);
        jono.jonoon(testisolmu);
        assertEquals(jono.paa, 0, 0.0001);
    }
 
    @Test
    public void jonossaYksiSolmuJaTalloinHantaOnYksi() {
        testisolmu = new Solmu(2);
        jono.jonoon(testisolmu);
        assertEquals(jono.hanta, 1, 0.0001);
    }
 
    @Test
    public void jonoTaynnaJaTalloinHantaOnNolla() {
        testisolmu = new Solmu(2);
        jono.jonoon(testisolmu);
        testisolmu = new Solmu(3);
        jono.jonoon(testisolmu);
        assertEquals(jono.hanta, 0, 0.0001);
    }
 
    @Test
    public void otettaessaJonostaSolmuSaadaanEnsimmaisenaLisattySolmu() {
        testisolmu = new Solmu(2);
        jono.jonoon(testisolmu);
        jono.jonoon(new Solmu(3));
        assertEquals(jono.jonosta(), testisolmu);
    }
 
    @Test
    public void otettaessaJonostaSolmuPoisPaasolmuksiNouseeSeuraavaJonossaOlevaSolmu() {
        jono.jonoon(new Solmu(3));
        testisolmu = new Solmu(2);
        jono.jonoon(testisolmu);
        jono.jonosta();
        assertEquals(jono.paaSolmu, testisolmu);
    }
 
    @Test
    public void josJonossaVainYksiSolmuPaaOnNolla() {
        jono.jonoon(new Solmu(3));
        assertEquals(jono.paa, 0, 0.0001);
    }
}
