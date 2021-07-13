package app;
import classes.Carta;
import classes.Equipe;
import classes.Jogador;
import classes.Partida;

public class App {
    public static void main(String[] args) throws Exception {
        
        Partida partida = new Partida(1); 

        partida.getJogadores().add(new Jogador(1, "André"));
        partida.getJogadores().add(new Jogador(2, "Gaspar"));
        partida.getJogadores().add(new Jogador(3, "Dario"));
        partida.getJogadores().add(new Jogador(4, "Pinheiro")); 
        
        partida.montarEquipes();

        partida.distribuirCartas();

        limpartela();

        System.out.println(partida);
        
        for (Equipe equipe : partida.getEquipe()) {
             System.out.println(equipe + " - Participantes: \n");
             for (Jogador jogador : equipe.getJogador()) {
                 System.out.println(jogador);

                 for (Carta carta : jogador.getListaDeCartas()) {
                    System.out.println(carta);
                 }
             }
             System.out.println();
        }
    }

    private static void limpartela(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
}
