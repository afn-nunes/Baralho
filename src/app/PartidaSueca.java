package app;

import java.util.ArrayList;
import java.util.Arrays;
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

            Rodada rodada = new Rodada(i + 1,  Arrays.asList( jogadores.get(0),  jogadores.get(1),  jogadores.get(2),  jogadores.get(3)));
            
            for (Jogador jogador : jogadores) {
                jogador.setCartaDoTurno(null);
            }

            for (int j = 0; j < 4; j++) {                
                imprimirMesa(); 

                rodada.setTurno(j + 1); 
                rodada.setJogadorDoTurno();                                
                int indiceJogador = rodada.getJogador().indexOf(rodada.getJogadorDoTurno());
                System.out.printf("Rodada: %s - Turno: %s - Jogador: %s \n",  rodada.getNumero(),  rodada.getTurno(),  rodada.getJogadorDoTurno());
                sc.nextLine();
                
                Funcoes.limparTela();
                imprimirMesa();
                System.out.printf("%s - Informe o código da carta: \n",  rodada.getJogadorDoTurno());
                rodada.getJogador().get(indiceJogador).
                            getListaDeCartas().
                            stream().forEach(c -> System.out.println((int )(rodada.getJogador().get(indiceJogador).getListaDeCartas().indexOf(c)  + 1 ) + " - " + c));
                            
                int codigo = sc.nextInt();
                sc.nextLine();

                rodada.getJogador().get(indiceJogador).setCartaDoTurno(rodada.getJogadorDoTurno().getListaDeCartas().get(codigo -1));
                jogadores.get(jogadores.indexOf(rodada.getJogadorDoTurno())).
                                getListaDeCartas().remove(rodada.getJogadorDoTurno().getListaDeCartas().get(codigo -1));
                Funcoes.limparTela();
            }

            Funcoes.limparTela();  
        }    
                
        sc.close();
    }

    private void imprimirMesa(){    
        for (Equipe equipe : equipes) {
            System.out.println(equipe + "\n");
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
