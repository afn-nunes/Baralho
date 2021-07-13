package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Enums.CodigoCarta;
import classes.Enums.NaipeCarta;

public class Partida {
    private int codigo;
    private List<Carta> baralho = new ArrayList<>();
    private List<Equipe> equipe = new ArrayList<>();
    private List<Jogador> jogadores = new ArrayList<>();

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public List<Carta> getBaralho() {
        return baralho;
    }

    public List<Equipe> getEquipe() {
        return equipe;
    }

    public Partida(int codigo) {
        this.codigo = codigo;
        this.montarDeck();
    }
    
    private void montarDeck() {
        for (CodigoCarta codigoCarta : CodigoCarta.values()) {
            for (NaipeCarta naipeCarta: NaipeCarta.values()) {                                
                Carta carta = new Carta(codigoCarta, naipeCarta);
                this.baralho.add(carta);
            }
        }
        Collections.shuffle(this.baralho);
    }

    public void distribuirCartas(){
        int i = 0;

        while (i < baralho.size()){
            for (Jogador jogador : jogadores) {
                jogador.getListaDeCartas().add(this.baralho.get(i));
                i++;
            }
        }
    }
}
