package classes;

import classes.Enums.NaipeCarta;
import classes.Enums.CartasSueca;

public class Carta {
    private CartasSueca numero;
    private NaipeCarta naipe;   
    private int pontuacao;
    
    public CartasSueca getNumero() {
        return numero;
    }
public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    
    public void setNumero(CartasSueca numero) {
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
        return "    --" + CartasSueca.valueOf(numero.getCode())+ " DE " +  NaipeCarta.valueOf(naipe.getCode());
    }

    public Carta(CartasSueca numero, NaipeCarta naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

}
