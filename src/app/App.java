package app;
import classes.Carta;
import classes.Equipe;
import classes.Jogador;
import classes.MotorPartida;

public class App {
    public static void main(String[] args) throws Exception {
        
        MotorPartida partida = new PartidaSueca(1);
        partida.montarDeck();

        partida.obterEquipes().add(new Equipe(1));
        partida.obterEquipes().add(new Equipe(2));
        
        partida.obterJogadores().add(new Jogador(1, "André"));
        partida.obterJogadores().add(new Jogador(2, "Gaspar"));
        partida.obterJogadores().add(new Jogador(3, "Dario"));
        partida.obterJogadores().add(new Jogador(4, "Pinheiro")); 
        
        partida.montarEquipes();

        partida.distribuirCartas();

        limpartela();

        System.out.println(partida);
        
        for (Equipe equipe : partida.obterEquipes()) {
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
