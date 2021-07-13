package classes;

import java.util.ArrayList;
import java.util.List;

public class Jogador{
    private int codigo;
    private String nome;
    private Equipe equipe;
    private Partida partida;
    private List<Carta> listaDeCartas = new ArrayList<>();

    
    public Equipe getEquipe() {
        return equipe;
    }
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
    public List<Carta> getListaDeCartas() {
        return listaDeCartas;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public Partida getPartida() {
        return partida;
    }
    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public void setListaDeCartas(List<Carta> listaDeCartas) {
        this.listaDeCartas = listaDeCartas;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Jogador(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return " -- " + nome;
    }

    
}
