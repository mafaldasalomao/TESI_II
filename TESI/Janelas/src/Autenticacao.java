import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Autenticacao extends JFrame implements ActionListener{
	private JPanel pnlRotulos, pnlCampos, pnlBotoes;
	private JLabel lblNome, lblSenha;
	private JTextField fldNome;
	private JPasswordField fldSenha;
	private JButton btnEntrar, btnCancelar;
	public Autenticacao() {
		setTitle("Autenticação");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		pnlRotulos = new JPanel(new GridLayout(2, 1));
		pnlCampos = new JPanel(new GridLayout(2, 1));
		pnlBotoes = new JPanel(new GridLayout(1, 2));
		
		lblNome = new  JLabel("Nome");
		lblSenha = new  JLabel("Senha");
		
		fldNome = new JTextField();
		fldSenha = new JPasswordField();
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(this);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		
		pnlRotulos.add(lblNome);
		pnlRotulos.add(lblSenha);
		
		pnlCampos.add(fldNome);
		pnlCampos.add(fldSenha);
		
		pnlBotoes.add(btnEntrar);
		pnlBotoes.add(btnCancelar);
		
		add(pnlRotulos, BorderLayout.WEST);
		add(pnlCampos);
		add(pnlBotoes, BorderLayout.SOUTH);
		pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnEntrar) {
			if(fldNome.getText().equals(fldSenha.getText()) ){
				JOptionPane.showMessageDialog(this, "Sucesso no rocesso de autenticação", "Autenticação", JOptionPane.INFORMATION_MESSAGE);
			}else {
				JOptionPane.showMessageDialog(this, "Falha no rocesso de autenticação", "Autenticação", JOptionPane.ERROR_MESSAGE);
			}
				
		}
		if(e.getSource()==btnCancelar) {
			System.exit(0);
		}
	}
	
}
