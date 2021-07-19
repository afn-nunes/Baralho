package model.entities;

import java.util.List;

public class Mesa {
    List<Jogador> jogadores;
    int posicao;
    
    @Override
    public String toString() {
        return "Mesa [jogadores=" + jogadores + ", posicao=" + posicao + "]";
    }


}
