package classes;

public class Carta {
    public Numero numero;
    public Naipe naipe;
    
    public Numero getCarta() {
        return numero;
    }
    public void setCarta(Numero carta) {
        this.numero = carta;
    }
    public Naipe getNaipe() {
        return naipe;
    }
    public void setNaipe(Naipe naipe) {
        this.naipe = naipe;
    }
    public Carta(Numero numero, Naipe naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    @Override
    public String toString() {
        return numero.getTipo() + " de " +  naipe.getTipo();
    }


}
