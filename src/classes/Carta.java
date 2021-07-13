package classes;

import classes.Enums.NaipeCarta;
import classes.Enums.CodigoCarta;

public class Carta {
    private CodigoCarta numero;
    private NaipeCarta naipe;   

    public CodigoCarta getNumero() {
        return numero;
    }

    public void setNumero(CodigoCarta numero) {
        this.numero = numero;
    }

    public NaipeCarta getNaipe() {
        return naipe;
    }

    public void setNaipe(NaipeCarta naipe) {
        this.naipe = naipe;
    }

    @Override
    public String toString() {
        return CodigoCarta.valueOf(numero.getCode())+ " de " +  NaipeCarta.valueOf(naipe.getCode());
    }

    public Carta(CodigoCarta numero, NaipeCarta naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

}
