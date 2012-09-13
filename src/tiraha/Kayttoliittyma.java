package tiraha;

/**
 * Rajapinta Tekstikäyttöliittymä-luokalle.
 */
public interface Kayttoliittyma {

    public String kysyString(String ilmoitus);

    public int kysyInt(String ilmoitus);

    public void ilmoita(String string);
}
