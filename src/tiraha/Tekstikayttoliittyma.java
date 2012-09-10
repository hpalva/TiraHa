package tiraha;


import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henriikka
 */
public class Tekstikayttoliittyma implements Kayttoliittyma {
    
    private static Scanner lukija = new Scanner(System.in);

    /**
     * Metodi kysyy käyttäjältä standardisyöttövirrasta Stringiä ja palauttaa sen
     *
     * @param   ilmoitus Käyttäjälle tulostettava ilmoitus ennen inputtia
     * @return Käyttäjän syöttämä sisääntulo
     */
    @Override
    public String kysyString(String ilmoitus) {
        System.out.println(ilmoitus);
        return lukija.nextLine();
    }

    /**
     * Metodi kysyy käyttäjältä syötettä ja tarkistaa onko se sopiva int 
     * tyyppiseksi, jos kyllä niin se palautetaan, jos ei niin kysytään 
     * uudestaan virheilmoituksen kera.
     * @param ilmoitus käyttäjälle tulostettava ilmoitus ennen inputtia
     * @return Käyttäjän syöttämä kokonaisluku
     */
    @Override
    public int kysyInt(String ilmoitus) {
        System.out.println(ilmoitus);
        while (true) {
            try {
                return Integer.parseInt(lukija.nextLine());
            } catch (Exception e) {
                System.out.println("Syöttämäsi ei ollut luku. Yritä uudestaan.");
                continue;
            }
        }
    }
    /**
     * Tulostaa käyttäjälle metodille syötetyn tekstin
     * @param string Merkkijono joka tulostetaan käyttäjälle
     */
    @Override
    public void ilmoita(String ilmoitus) {
        System.out.println(ilmoitus);
    }
    
}