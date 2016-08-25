package jogovelha;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Cliente {
    private static JogoVelha jogo = new JogoVelha();

    public static void main(String[] args) throws Exception {
        
        String host = "192.168.25.23";
        int porta = 2929;
        String situacaoTabuleiro;
        
        System.out.println("Rodando...");
        System.out.println("Conectando com servidor...");
        
        Socket socketCliente = new Socket(host, porta);
        System.out.println("Conectado...");
        
        System.out.println("Criando cadeias...");
        
        BufferedReader entradaServidor = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        DataOutputStream saidaServidor = new DataOutputStream(socketCliente.getOutputStream());
        System.out.println("Cadeias criadas...");
        
        jogo.Jogo();
        
       
      
        entradaServidor.close();
        saidaServidor.close();
        socketCliente.close();
    }
}