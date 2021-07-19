package model.entities;

import java.io.IOException;

public class Funcoes {
    public static void limparTela(){
        if (System.getProperty("os.name").contains("Windows"))
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {            
            e.printStackTrace();
        } catch (IOException e) {            
            e.printStackTrace();
        }
    else
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {            
            e.printStackTrace();
        }      
    }
}
