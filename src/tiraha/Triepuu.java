package tiraha;

/**
 * Luokka luo triepuun.
 */
public class Triepuu extends Binaarihakupuu {

/**
 * Konstruktori määrittelee triepuun
 */
    public Triepuu() {
        juuri = new Solmu();
    }

/**
 * Metodi lisää puuhun uuden luvun jakaen sen merkit(=numerot) eri solmuihin ylhäältä alaspäin.  
 * @param puu puu, johon luku lisätään
 * @param luku luku, joka puuhun lisätään
 */
    public void lisaa(Triepuu puu, int luku) {
        Solmu solmu = juuri;
        String sana = "" + luku;
        if(sana.length()==0){
            solmu.setMarkkeri(true);
        }
        for(int i = 0; i<sana.length(); ++i){
            Solmu lapsi = solmu.subLapsi(solmu,sana.charAt(i));
            if(lapsi!=null){
                solmu = lapsi;
            }else{
                String avain = "" + sana.charAt(i);
                solmu.setLapsi(solmu, new Solmu(Integer.parseInt(avain)));
                solmu = solmu.subLapsi(solmu, sana.charAt(i));
            }
            if(solmu!=null && i == sana.length()-1){
                solmu.setMarkkeri(true);
            }
        }
    }
}