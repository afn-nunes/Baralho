package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Carta;
import classes.Enums.CartasSueca;
import classes.Enums.NaipeCarta;
import classes.Equipe;
import classes.Jogador;
import classes.MotorPartida;

public class PartidaSueca implements MotorPartida{
    private int codigo;
    private List<Carta> baralho;
    private List<Equipe> equipes;
    private List<Jogador> jogadores;

    public PartidaSueca(int codigo) {
       this.codigo = codigo;
       baralho = new ArrayList<>();
       equipes = new ArrayList<>();
       jogadores = new ArrayList<>();
    }

    @Override
    public List<Jogador> obterJogadores() {
        return jogadores;
    }
    @Override
    public List<Equipe> obterEquipes() {
        return equipes;
    }

    @Override
    public void montarDeck() {
        for (CartasSueca codigoCarta : CartasSueca.values()) {
            for (NaipeCarta naipeCarta: NaipeCarta.values()) {                                
                Carta carta = new Carta(codigoCarta, naipeCarta);
                this.baralho.add(carta);
            }
        }
        Collections.shuffle(this.baralho);
    }

    @Override
    public void distribuirCartas(){
        int i = 0;

        while (i < baralho.size()){
            for (Jogador jogador : jogadores) {
                jogador.getListaDeCartas().add(this.baralho.get(i));
                i++;
            }
        }
    }

    @Override
    public void montarEquipes(){
        Collections.shuffle(jogadores);
        int i = 0;        
        for (int j = 0; j < jogadores.size(); j++) { 
            equipes.get(j %2).getJogador().add(jogadores.get(i));
            jogadores.get(i) .setEquipe(equipes.get(j %2));
            i++;            
        }
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String toString(){
        return "************ PARTIDA " + getCodigo() + "************\n" ;        
    }
}
