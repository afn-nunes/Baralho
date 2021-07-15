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
    public int getNumeroRodadas() {
        return numeroRodadas;
    }

    private List<Carta> baralho;
    private List<Equipe> equipes;
    private List<Jogador> jogadores;
    private List<Rodada> rodadas = new ArrayList<>();

    
     private NaipeCarta cartaTrunfo;

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
       baralho = new ArrayList<>();
       equipes = new ArrayList<>();
       jogadores = new ArrayList<>(); 
       
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
        return "************ PARTIDA " + getCodigo() + "************\n" ;        
    }

    public void iniciarjogo(){
        Scanner sc = new Scanner(System.in);        

        for (int i = 0; i < getNumeroRodadas();i++) {            
            Funcoes.limparTela();           
            imprimirMesa(
                jogadores.get(0).getNome(), 
                jogadores.get(1).getNome(), 
                jogadores.get(2).getNome(),
                jogadores.get(3).getNome()); 

            Rodada rodada = new Rodada(i + 1);
            
            rodada.getJogador().add( jogadores.get(0));
            rodada.getJogador().add( jogadores.get(1));
            rodada.getJogador().add( jogadores.get(2));
            rodada.getJogador().add( jogadores.get(3));

            for (int j = 0; j < 4; j++) {
                rodada.setTurno(j + 1); 
                rodada.setJogadorDoTurno();

                System.out.printf("Rodada: %s - Turno: %s - Jogador: %s \n",  rodada.getNumero(),  rodada.getTurno(), rodada.getJogadorDoTurno());                                  
                sc.nextLine();      
            }     
            rodadas.add(rodada);
            Funcoes.limparTela();  
        }    
                
        sc.close();
    }

    private void imprimirMesa(String jogador1, String jogador2, String jogador3,  String jogador4){
        System.out.printf(String.format("%s\n %s\n %s\n %s\n", jogador1, jogador2, jogador3, jogador4));        
    }
}
