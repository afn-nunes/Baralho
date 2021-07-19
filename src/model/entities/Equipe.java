package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private int pontuacao;
    private int codigo;
    private List<Jogador> jogador = new ArrayList<>();    
     
    public int getPontuacao() {
        return pontuacao;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public List<Jogador> getJogador() {
        return jogador;
    }
    public void setJogador(List<Jogador> jogador) {
        this.jogador = jogador;
    }
    public void setPontuacao(int pontuacao) {
        this.pontuacao += pontuacao;
    }
    public int getcodigo() {
        return codigo;
    }
    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }

    public Equipe(int codigo) {
        this.codigo = codigo;
    }
    @Override
    public String toString() {        
        return "Equipe: " + codigo + " - Pontuação: " + getPontuacao();        
    }

    
}
