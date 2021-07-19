package app;
import model.entities.Funcoes;
import model.entities.Jogador;
import model.entities.MotorPartida;

public class App {
    public static void main(String[] args) throws Exception{
        
        MotorPartida partida = new PartidaSueca(1);       
        partida.obterJogadores().add(new Jogador(1, "André"));
        partida.obterJogadores().add(new Jogador(2, "Gaspar"));
        partida.obterJogadores().add(new Jogador(3, "Dario"));
        partida.obterJogadores().add(new Jogador(4, "Pinheiro")); 
        
        partida.montarEquipes();

        partida.distribuirCartas();      

        Funcoes.limparTela();
        System.out.println(partida);
        
        partida.iniciarjogo();

    }

}
