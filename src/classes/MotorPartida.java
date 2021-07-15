package classes;

import java.util.List;

public interface MotorPartida {

    List<Equipe> obterEquipes();
    List<Jogador> obterJogadores();
    
    public void montarDeck() ;
    public void distribuirCartas();
    public void montarEquipes();
    public void iniciarjogo();

}
