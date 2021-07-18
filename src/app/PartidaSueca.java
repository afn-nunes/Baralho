package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import classes.Carta;
import classes.Enums.CartasSueca;
import classes.Enums.NaipeCarta;
import classes.Equipe;
import classes.Funcoes;
import classes.Jogador;
import classes.MotorPartida;
import classes.Rodada;

public class PartidaSueca implements MotorPartida{    
    private int codigo; 
    private int numeroRodadas;
    private NaipeCarta cartaTrunfo;
    private Jogador jogadorProximaRodada;    
    private List<Carta> baralho = new ArrayList<>();
    private List<Equipe> equipes= new ArrayList<>();
    private List<Jogador> jogadores = new ArrayList<>(); 
    private List<Rodada> rodadas = new ArrayList<>();    

     public Jogador getJogadorProximaRodada() {
        return jogadorProximaRodada;
    }

    public void setJogadorProximaRodada(Jogador jogador) {
        this.jogadorProximaRodada = jogador;
    }

    public List<Rodada> getRodadas() {
        return rodadas;
    }

    public int getNumeroRodadas() {
        return numeroRodadas;
    }
    public NaipeCarta getCartaTrunfo() {
        return cartaTrunfo;
    }

    public void setCartaTrunfo(NaipeCarta cartaTrunfo) {
        this.cartaTrunfo = cartaTrunfo;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public PartidaSueca(int codigo) {
       this.codigo = codigo;
       this.numeroRodadas = 10;      
       montarDeck();

       obterEquipes().add(new Equipe(1));
       obterEquipes().add(new Equipe(2));
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
        setPontuacaoCartas();
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

    private void setPontuacaoCartas(){
        for (Carta carta : baralho) {
           switch (carta.getNumero()) {
               case AZ: 
                    carta.setPontuacao(11);                   
                break;
               case SETE: 
                    carta.setPontuacao(10);                   
                break;
               case REI: 
                    carta.setPontuacao(4);                   
                break;
               case VALETE: 
                    carta.setPontuacao(3);                   
                break;
               case DAMA: 
                    carta.setPontuacao(2);                   
                break;           
               default:
                    carta.setPontuacao(0);
           }
        }
    }

    public String toString(){
        return "************ PARTIDA " + getCodigo() + " - Trunfo: " + getCartaTrunfo() + "************\n" ;        
    }

    public void iniciarjogo(){
        Scanner sc = new Scanner(System.in);

        while (rodadas.size() < 10){        
            Rodada rodada = new Rodada(jogadores);
            rodadas.add(rodada);

            for (Jogador jogador : rodada.getJogador()) {
                jogador.setCartaDoTurno(null);
            }
            
            rodada.setPartida(this);
            rodada.iniciar(sc);

            equipes.get(equipes.indexOf(getJogadorProximaRodada().getEquipe())).setPontuacao(rodada.getPontuacao());

            Funcoes.limparTela(); 
            imprimirMesa();
            
            System.out.printf("Jogador com maior carta: %s\n", getJogadorProximaRodada());            
            System.out.printf("Pontuação da rodada: %s", rodada.getPontuacao());
            sc.nextLine();
            Funcoes.limparTela();  
        }    
                
        sc.close();
    }

    public void imprimirMesa(){    
        for (Equipe equipe : equipes) {
            System.out.println(equipe);
            for (Jogador jogador : equipe.getJogador()) {
                if (jogador.getCartaDoTurno() ==null)
                    System.out.println(jogador);
                else
                    System.out.println(jogador + " - " + jogador.getCartaDoTurno());    
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
