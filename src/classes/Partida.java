package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Enums.CodigoCarta;
import classes.Enums.NaipeCarta;

public class Partida {
    private int codigo;
    private List<Carta> baralho = new ArrayList<>();
    private List<Equipe> equipes = new ArrayList<>();
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
        return equipes;
    }

    public Partida(int codigo) {
        this.codigo = codigo;
        this.montarDeck();

        getEquipe().add(new Equipe(1));
        getEquipe().add(new Equipe(2));
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

    public void montarEquipes(){
        Collections.shuffle(jogadores);
        int i = 0;        
        for (int j = 0; j < jogadores.size(); j++) { 
            equipes.get(j %2).getJogador().add(jogadores.get(i));
            jogadores.get(i) .setEquipe(equipes.get(j %2));
            i++;            
        }
    }

    public String toString(){
        return "************ PARTIDA " + getCodigo() + "************\n" ;        
    }
}
