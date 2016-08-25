package jogovelha;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JogoVelha extends JFrame {
   
	ImageIcon Fundo = new ImageIcon(getClass().getResource("galaxia.jpg")); 
	ImageIcon Foguete = new ImageIcon(getClass().getResource("foguete.png"));
	ImageIcon Meteoro = new ImageIcon(getClass().getResource("meteoro.fw.png"));
	ImageIcon Alien = new ImageIcon(getClass().getResource("alien.gif"));
	
	JLabel lFog = new JLabel(Foguete);
	JLabel lMet = new JLabel(Meteoro);
	JLabel lFundo = new JLabel(Fundo);
	JLabel lAlien1 = new JLabel(Alien);
	JLabel lAlien2 = new JLabel(Alien);
	JLabel lAlien3 = new JLabel(Alien);
	
	int posFogX=0;
	int posFogY=460;
	
	
	
	public void Jogo(){
		JOptionPane.showMessageDialog(null, "MOVIMENTE O FOGUETE COM O TECLADO\nFAÇA-O CHEGAR ATE AS REDONDEZAS DO METEORO");
		JOptionPane.showMessageDialog(null, "FIQUE LONGE DAS REDONDEZAS DOS ALIENS");
		infoJanela();
		editar();
		
}
	int vitoria=0;
public int movimento(){
		vitoria=0;
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode()==38){
					posFogY -=10;
				}
				if(e.getKeyCode()==40){
					posFogY +=10;
				}
				if(e.getKeyCode()==37){
					posFogX -=10;
				}
				if(e.getKeyCode()==39){
					posFogX +=10;
				}
				if (colisao(lFog, lMet)){
					vitoria=1;
				}
				if(colisao(lFog, lAlien1)){
					int posFogX=0;
					int posFogY=460;
				}
				if(colisao(lFog, lAlien2)){
					int posFogX=0;
					int posFogY=460;
				}if(colisao(lFog, lAlien3)){
					int posFogX=0;
					int posFogY=460; 
				}
				
				 if (posFogX < 0){
					 posFogX=0;
				 }
				 if (posFogX > 580){
					 posFogX=580;
				 }
				 if (posFogY < 0){
					 posFogY = 0;
				 }
				 if (posFogY > 460){
					 posFogY=460;
				 }
				 
				lFog.setBounds(posFogX, posFogY, 100, 200);;
				//System.out.println(posFogX + ", "+ posFogY);
			
			}
		});
		return vitoria;
		
		
		
	}
	
	public void editar(){
		lFog.setBounds(posFogX, posFogY, 200, 200);
		lMet.setBounds(600, 0, 80, 80);
		lFundo.setBounds(0, 0, 700, 700);
		lAlien1.setBounds(50, 50, 100, 100);
		lAlien2.setBounds(300, 500, 100, 100);
		lAlien3.setBounds(400, 100, 100, 100);
	}
	
	public void infoJanela(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		add(lFog);
		add(lMet);
		add(lAlien1);
		add(lAlien2);
		add(lAlien3);
		add(lFundo);
		
	}
	
	public boolean colisao(Component a, Component b){
		int aX = a.getX();
		int aY = a.getY();
		int ladoDireitoA = aX+a.getWidth();
		int ladoEsquerdoA = aX;
		int ladoBaixoA = aY+a.getHeight();
		int ladoCimaA = aY;
		
		int bX = b.getX();
		int bY = b.getY();
		int ladoDireitoB = bX+b.getWidth();
		int ladoEsquerdoB = bX;
		int ladoBaixoB = bY+b.getHeight();
		int ladoCimaB = bY;
		
		boolean bateu = false;
		
		boolean cDireita=false;
		boolean cCima = false;
		boolean cBaixo=false;
		boolean cEsquerda=false;
		
		if(ladoDireitoA>=ladoEsquerdoB){
			cDireita=true;
		}
		if(ladoCimaA<=ladoBaixoB){
			cCima=true;
		}
		if(ladoBaixoA>=ladoCimaB){
			cBaixo=true;
		}
		if(ladoEsquerdoA<=ladoDireitoB){
			cEsquerda=true;
		}
		if(cDireita && cEsquerda && cBaixo &&cCima){
			bateu=true;
		}
		return bateu;
	}
	
	
}