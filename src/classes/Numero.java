package classes;

import classes.Enums.numeroEnum;

/**
 * Cartas
 */
public class Numero {

    private numeroEnum tipo;

    public numeroEnum getTipo() {
        return tipo;
    }

    public void setTipo(numeroEnum tipo) {
        this.tipo = tipo;
    }

    public Numero(numeroEnum tipo) {
        this.tipo = tipo;
    }

    
}