import java.util.ArrayList;
import java.util.List;

import classes.Carta;
import classes.Enums.NaipeEnum;
import classes.Enums.numeroEnum;
import classes.Naipe;
import classes.Numero;

public class App {
    public static void main(String[] args) throws Exception {

        List<Carta> baralho = new ArrayList<>();
        for (numeroEnum numero : numeroEnum.values()) {
            for (NaipeEnum naipe: NaipeEnum.values()) {
                Numero c = new Numero(numero);
                Naipe n = new Naipe(naipe);
                
                Carta carta = new Carta(c, n);

                baralho.add(carta);
            }
        }
        limpartela();
        for (Carta carta : baralho) {
            System.out.println(carta.toString());
        }
    }
    private static void limpartela(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
}
