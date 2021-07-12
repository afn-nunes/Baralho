package classes;

import classes.Enums.NaipeEnum;

public class Naipe {

    private NaipeEnum tipo;

    public NaipeEnum getTipo() {
        return tipo;
    }

    public void setTipo(NaipeEnum tipo) {
        this.tipo = tipo;
    }

    public Naipe(NaipeEnum tipo) {
        this.tipo = tipo;
    }
        
}
