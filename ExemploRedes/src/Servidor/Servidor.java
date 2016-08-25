package Servidor;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
import jogovelha.JogoVelha;

public class Servidor {
    private static JogoVelha jogo = new JogoVelha();
    
    public static void main(String[] args) throws Exception {
        
        int porta = 2929;
        
        ServerSocket servidor = new ServerSocket(porta);
        
        
        while(true) {
        
            
            System.out.println("Esperando cliente...");
            Socket conexao = servidor.accept();
            System.out.println("Cliente Conectado...");
            
            BufferedReader entradaCliente = 
                    new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            
            DataOutputStream saidaCliente = new DataOutputStream(conexao.getOutputStream());
            
            System.out.println("Cadeias criadas...");
            
            jogo.Jogo();
           int vitoria= jogo.movimento();
           if(vitoria ==1){
        	   JOptionPane.showMessageDialog(null, "O SERVIDOR GANHOU");
           }
           else
           {
        	   JOptionPane.showMessageDialog(null, "O CLIENTE GANHOU");
           }
           
           
            
            
            
        }
    }
}