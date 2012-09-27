package tiraha;

/**
 * Luokka luo triepuun.
 */
public class Triepuu extends Puu {

    /**
     * Solmu-tyyppinen muuttuja, joka toimii puun juurisolmuna.
     */
    private Solmu juuri;
    
    public Solmu lisaa(Triepuu puu, String sana){
        juuri = new Solmu("");
        Solmu solmu = juuri;
        if(sana.length()==0){
            solmu.setMarkkeri(true);
        }
        for(int i = 0; i<sana.length(); i++){
           Solmu lapsi = new Solmu(sana.charAt(i));
           
           if(solmu.getVasen()==null){     
               solmu.setVasen(lapsi);
           }else{
               solmu.setOikea(lapsi);
           }
           if(lapsi!=null){
               solmu = lapsi;
           }else{
               solmu.getVasen();
           }
        }
        
        return null;
    }
}
