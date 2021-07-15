package classes;

import java.util.ArrayList;
import java.util.List;

import app.PartidaSueca;
import classes.Enums.NaipeCarta;

public class Rodada {
    private int numero;
    private PartidaSueca partida;    
    private int turno;
    private List<Jogador> jogadores = new ArrayList<>();    
    private List<Carta> cartas = new ArrayList<>();
    private Jogador JogadorDoTurno;

    public Jogador getJogadorDoTurno() {
        return JogadorDoTurno;
    }
    public void setJogadorDoTurno() {
        if ((getNumero() == 1) &&(getTurno() ==1)){
            this.JogadorDoTurno = (getJogador().get((int) Math.random() * 4));        
        }else if((this.JogadorDoTurno != null) && getJogador().indexOf(JogadorDoTurno) == 3){
            this.JogadorDoTurno = getJogador().get(0);
        }else{
            this.JogadorDoTurno = getJogador().get(getJogador().indexOf(JogadorDoTurno) + 1);
        }

    }

    private int pontuacao;
    private NaipeCarta naipe;

    public NaipeCarta getNaipe() {
        return naipe;
    }
    public void setNaipe(NaipeCarta naipe) {
        this.naipe = naipe;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public PartidaSueca getPartida() {
        return partida;
    }
    public void setPartida(PartidaSueca partida) {
        this.partida = partida;
    }
    public int getTurno() {
        return turno;
    }
    public void setTurno(int turno) {
        this.turno = turno;
    }
    public List<Jogador> getJogador() {
        return jogadores;
    }

    public List<Carta> getCarta() {
        return cartas;
    }

    public int getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    public Rodada(int numero) {
        this.numero = numero;
    }
  
}
