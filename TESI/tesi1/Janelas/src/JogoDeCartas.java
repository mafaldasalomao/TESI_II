import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;


public class JogoDeCartas extends JFrame{
	private JPanel pnlCartas, pnlBotoes, pnlCarta1, pnlCarta2, pnlCarta3;
	private JButton btnPrimeiro, btnProximo,btnAnterior, btnUltimo;
	
	
	JMenuBar mb;
	JMenu mnCartas,mnAjuda;
	CardLayout cl;

	public JogoDeCartas() {
		setTitle("Jogo de Cartas");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		cl = new CardLayout();
		pnlCartas = new JPanel(cl);
		
		
		pnlCarta1 = new JPanel();
		pnlCarta1.setBackground(Color.RED);
		
		pnlCarta2 = new JPanel();
		pnlCarta2.setBackground(Color.GREEN);
		
		pnlCarta3 = new JPanel();
		pnlCarta3.setBackground(Color.BLUE);
		
		pnlCartas.add(pnlCarta1);
		pnlCartas.add(pnlCarta2);
		pnlCartas.add(pnlCarta3);
		
		
		mb= new JMenuBar();
		
		mnCartas = new JMenu("Cartas");
		mnCartas.setMnemonic(KeyEvent.VK_C);
		mnAjuda = new JMenu("Ajuda");
		mb.add(mnCartas);
		mnCartas.add(new JMenuItem("Primeiro"));
		mnCartas.add(new JMenuItem("Anterior"));
		mnCartas.add(new JSeparator());
		mnCartas.add(new JMenuItem("Próximo"));
		mnCartas.add(new JMenuItem("Último"));
		
		mb.add(mnAjuda);
		mnAjuda.add(new JMenuItem("Sobre"));
		mnAjuda.setMnemonic(KeyEvent.VK_A);
		
		pnlBotoes = new JPanel(new GridLayout(1, 4));
		
		btnPrimeiro = new JButton("Primeiro");
		btnAnterior = new JButton("Anterior");
		btnProximo = new JButton("Próximo");
		btnUltimo = new JButton("Último");
		
		pnlBotoes.add(btnPrimeiro);
		pnlBotoes.add(btnAnterior);
		pnlBotoes.add(btnProximo);
		pnlBotoes.add(btnUltimo);
		
		setJMenuBar(mb);
		add(pnlCartas);
		add(pnlBotoes, BorderLayout.SOUTH);

	}
}