package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import app.PartidaSueca;
import classes.Enums.NaipeCarta;

public class Rodada {          
    private int turno;
    private List<Jogador> jogadores = new ArrayList<>();    
    private List<Carta> cartas = new ArrayList<>();
    private List<Integer> turnos = Arrays.asList(1,2,3,4);
    private Jogador JogadorDoTurno;
    private Carta cartadoTurno;
    private Carta maiorCarta;
    private Carta cartaDeCorte;
    private int pontuacao;
    private NaipeCarta naipe;
    private PartidaSueca partida;

    
    public Carta getCartaDeCorte() {
        return cartaDeCorte;
    }
    public void setCartaDeCorte(Carta cartaDeCorte) {
        this.cartaDeCorte = cartaDeCorte;
    }

    public Carta getMaiorCarta() {
        return maiorCarta;
    }
    public void setMaiorCarta(Carta maiorCarta) {
        this.maiorCarta = maiorCarta;
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

    public Jogador getJogadorDoTurno() {
        return JogadorDoTurno;
    }

    public void setJogadorDoTurno() {
        if (getTurno() ==1){
            this.JogadorDoTurno = partida.getJogadorProximaRodada();
        }else if((this.JogadorDoTurno != null) && getJogador().indexOf(JogadorDoTurno) == 3){
            this.JogadorDoTurno = getJogador().get(0);
        }else{
            this.JogadorDoTurno = getJogador().get(getJogador().indexOf(JogadorDoTurno) + 1);
        }
    }

    public Carta getCartadoTurno() {
        return cartadoTurno;
    }

    public void setCartadoTurno(Carta cartadoTurno) {
        this.cartadoTurno = cartadoTurno;
    }

    public int getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(int pontuacao) {
        this.pontuacao += pontuacao;
    }

    public NaipeCarta getNaipe() {
        return naipe;
    }
    public void setNaipe(NaipeCarta naipe) {
        this.naipe = naipe;
    }

    public PartidaSueca getPartida() {
        return partida;
    }
    public void setPartida(PartidaSueca partida) {
        this.partida = partida;
    }

    public Rodada(List<Jogador> jogadores) {        
        this.jogadores = jogadores;

    }
    public void validarVencedorRodada(Carta cartaJogada){
        if(turno == 1){
            setNaipe(cartaJogada.getNaipe());
            setMaiorCarta(cartaJogada);
            if(cartaJogada.getNaipe() == partida.getCartaTrunfo()){
                setCartaDeCorte(cartaJogada);
            }
            partida.setJogadorProximaRodada( getJogadorDoTurno());
        }else if( (cartaJogada.getNaipe() == partida.getCartaTrunfo()) && (getCartaDeCorte() == null)){
            setCartaDeCorte(cartaJogada);
            partida.setJogadorProximaRodada(getJogadorDoTurno());                    
        }else if( (cartaJogada.getNaipe() == partida.getCartaTrunfo()) && (cartaJogada.getPontuacao() > cartaDeCorte.getPontuacao())){
            setCartaDeCorte(cartaJogada);
            partida.setJogadorProximaRodada(getJogadorDoTurno()); 
        } else if (cartaJogada.getNaipe() == this.getNaipe() && (cartaJogada.getPontuacao() > getMaiorCarta().getPontuacao())){
            setMaiorCarta(cartaJogada);
            partida.setJogadorProximaRodada( getJogadorDoTurno());                    
        }    
    }
    
    public void iniciar(Scanner sc){
        turnos.forEach(turno ->{        
            Funcoes.limparTela();                               
            setTurno(turno);

            if((partida.getRodadas().indexOf(this) == 0) && (getTurno() == 1)){
                partida.setJogadorProximaRodada(getJogador().get((int) Math.random() * 4));
            }

            setJogadorDoTurno();

            int indiceJogador = getJogador().indexOf(getJogadorDoTurno());
            List<Carta> cartas = getJogador().get(indiceJogador).getListaDeCartas();

            if((partida.getRodadas().indexOf(this) == 0) && (getTurno() == 1)){
                partida.setCartaTrunfo(cartas.get((int) Math.random() * cartas.size()).getNaipe());
            }

            

            System.out.println(partida);
            partida.imprimirMesa();
            System.out.printf("Rodada: %s - Turno: %s - Jogador: %s \n\n",  partida.getRodadas().indexOf(this) + 1,  getTurno(),  getJogadorDoTurno());                                                            
            System.out.printf("%s - Informe o código da carta: \n",  getJogadorDoTurno());

            if((turno == 1)||(!(cartas.stream().anyMatch(c -> c.getNaipe() == getNaipe())))){
                cartas.stream().forEach(c -> System.out.println((int )(cartas.indexOf(c)  + 1 ) + " - " + c));
            }else {
                cartas.stream().filter(c -> c.getNaipe() == getNaipe()).forEach(c -> System.out.println((int )(cartas.indexOf(c)  + 1 ) + " - " + c));
            }
            
            int codigo = sc.nextInt() -1;
            Carta cartaJogada = cartas.get(codigo);
            sc.nextLine();

            getJogador().get(indiceJogador).setCartaDoTurno(cartaJogada);            
            setPontuacao(cartaJogada.getPontuacao());
            validarVencedorRodada(cartaJogada);   
            cartas.remove(cartaJogada); 
        });
    }
}
