import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CadastroDeBolsistasComModelo extends JFrame{


	private JTable tblBolsistas; //desenha a tablela - table object
	private BolsistasTableModel tmBolsistas;//modela a tabela - table model
	private JPanel pnlControles, pnlRotulos, pnlCampos, pnlBotoes, pnlSexo, pnlAuxilio, pnlIniciacao;
	private JTextField fldMatricula, fldNome;
	private JRadioButton rbMasculino, rbFeminino;
	private ButtonGroup bgSexo;
	private JCheckBox chkPasse, chkAlimentacao, chkCreche;
	private JCheckBox chkPibic, chkPivic, chkPibiti;
	private JComboBox<String> cmbCurso;
	private JButton btnSalvar, btnExcluir;
	static final String imagesPath = new String("images/"); 
	AcaoSalvar actSalvar= new AcaoSalvar();
	AcaoExcluir actExcluir = new AcaoExcluir();

	private static final int INCLUINDO = 0 ;
	private static final int EDITANDO = 1 ;
	private int status = INCLUINDO;

	/*=====================CONSTRUTOR===========================================*/
	public CadastroDeBolsistasComModelo() {
		setTitle("Cadastro de Professores");
		setSize(750, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//setResizable(false);

		tmBolsistas = new BolsistasTableModel();
		//		{
		//			public boolean isCellEditable(int rowIndex, int ColumnIndex) {
		//				return false;
		//			}
		//		};

		tblBolsistas = new JTable(tmBolsistas);
		tblBolsistas.addMouseListener(new HabilitarEdicaoExclusao());
		tblBolsistas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



		pnlControles = new JPanel(new BorderLayout());
		pnlRotulos = new JPanel(new GridLayout(6, 1));
		pnlCampos = new JPanel(new GridLayout(6, 1));
		pnlSexo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlAuxilio = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlIniciacao = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlBotoes = new JPanel();

		rbMasculino = new JRadioButton("Masculino");
		rbFeminino = new JRadioButton("Feminino");
		bgSexo = new ButtonGroup();
		bgSexo.add(rbMasculino);
		bgSexo.add(rbFeminino);
		pnlSexo.add(rbMasculino);
		pnlSexo.add(rbFeminino);

		chkPasse = new JCheckBox("Passe livre");
		chkAlimentacao = new JCheckBox("Alimentação");
		chkCreche = new JCheckBox("Creche");
		pnlAuxilio.add(chkPasse);
		pnlAuxilio.add(chkAlimentacao);
		pnlAuxilio.add(chkCreche);

		chkPibic = new JCheckBox("PIBIC");
		chkPivic = new JCheckBox("PIVIC");
		chkPibiti = new JCheckBox("PIBITI");
		pnlIniciacao.add(chkPibic);
		pnlIniciacao.add(chkPivic);
		pnlIniciacao.add(chkPibiti);

		cmbCurso = new JComboBox<String>(new String [] {"Sistemas de Informação", "Direito","Esquerdo"});



		fldMatricula = new JTextField(3);
		fldNome = new JTextField(20);

		pnlRotulos.add(new JLabel("Matrícula"));
		pnlRotulos.add(new JLabel("Nome"));
		pnlRotulos.add(new JLabel("Sexo"));
		pnlRotulos.add(new JLabel("Auxílio"));
		pnlRotulos.add(new JLabel("Iniciação"));
		pnlRotulos.add(new JLabel("Curso"));

		pnlCampos.add(fldMatricula);
		pnlCampos.add(fldNome);
		pnlCampos.add(pnlSexo);
		pnlCampos.add(pnlAuxilio);
		pnlCampos.add(pnlIniciacao);
		pnlCampos.add(cmbCurso);

		btnSalvar = new JButton(actSalvar);
		btnExcluir = new JButton(actExcluir);
		btnExcluir.setEnabled(false);

		pnlBotoes.add(btnSalvar);
		pnlBotoes.add(btnExcluir);

		pnlControles.add(pnlRotulos, BorderLayout.WEST);
		pnlControles.add(pnlCampos);
		pnlControles.add(pnlBotoes, BorderLayout.SOUTH);



		add(new JScrollPane(tblBolsistas));
		add(pnlControles, BorderLayout.SOUTH);
		/*=========================================================================*/

	}
	public void limparCampos() {//limpa todos os campos quando salvar e excluir
		fldMatricula.setText("");
		fldNome.setText("");
		bgSexo.clearSelection();
		chkPasse.setSelected(false);
		chkAlimentacao.setSelected(false);
		chkCreche.setSelected(false);
		chkPibic.setSelected(false);
		chkPivic.setSelected(false);
		chkPibiti.setSelected(false);
		cmbCurso.setSelectedIndex(0);
	}
	private Bolsista descarregarCampos() {
		Bolsista bolsista;
		int matricula;
		String nome;
		String sexo ="";
		String auxilio;
		String iniciacao;
		String curso;
		ArrayList<String> lAuxilio,lIniciacao;

		matricula = Integer.parseInt(fldMatricula.getText());
		nome = fldNome.getText();
		if(rbMasculino.isSelected()) {
			sexo = "Masculino";
		}
		if(rbFeminino.isSelected()) {
			sexo = "Feminino";
		}
		lAuxilio = new ArrayList<String>();
		if(chkPasse.isSelected()) {
			lAuxilio.add(chkPasse.getText());
		}
		if(chkAlimentacao.isSelected()) {
			lAuxilio.add(chkAlimentacao.getText());
		}
		if(chkCreche.isSelected()) {
			lAuxilio.add(chkCreche.getText());
		}

		auxilio = lAuxilio.toString();
		auxilio = auxilio.substring(1, auxilio.length()-1);


		lIniciacao = new ArrayList<String>();
		if(chkPibic.isSelected()) {
			lIniciacao.add(chkPibic.getText());
		}
		if(chkPivic.isSelected()) {
			lIniciacao.add(chkPivic.getText());
		}
		if(chkPibiti.isSelected()) {
			lIniciacao.add(chkPibiti.getText());
		}

		iniciacao = lIniciacao.toString();
		iniciacao = iniciacao.substring(1, iniciacao.length()-1);
		curso = (String)cmbCurso.getSelectedItem();
		bolsista = new Bolsista(matricula, nome, sexo, auxilio, iniciacao, curso);
		return bolsista;
	}

	private void carregarCampos(Bolsista bolsista) {
		fldMatricula.setText(bolsista.getMatricula()+"");
		fldNome.setText(bolsista.getNome());
		if(bolsista.getSexo().equals("Masculino")) {
			rbMasculino.setSelected(true);
		}else {
			rbFeminino.setSelected(true);
		}
		chkPasse.setSelected(bolsista.getAuxilio().contains(chkPasse.getText()));
		chkAlimentacao.setSelected(bolsista.getAuxilio().contains(chkAlimentacao.getText()));
		chkCreche.setSelected(bolsista.getAuxilio().contains(chkCreche.getText()));

		chkPibic.setSelected(bolsista.getIniciacao().contains(chkPibic.getText()));
		chkPivic.setSelected(bolsista.getIniciacao().contains(chkPivic.getText()));
		chkPibiti.setSelected(bolsista.getIniciacao().contains(chkPibiti.getText()));

		cmbCurso.setSelectedItem(bolsista.getCurso());
	}

	/*=========================================acoes=========================================*/
	class AcaoSalvar extends AbstractAction{

		AcaoSalvar(){
			super("Salvar");
			putValue(MNEMONIC_KEY, KeyEvent.VK_S);
			putValue(SHORT_DESCRIPTION, "Salvar dados do bolsista!");
			putValue(SMALL_ICON, new ImageIcon(imagesPath+"general/Save16.gif"));

		}


		@Override
		public void actionPerformed(ActionEvent e) {
			Bolsista bolsista = descarregarCampos();
			switch(status) {
				case INCLUINDO:
				tmBolsistas.addBolsista(bolsista);
				break;
				case EDITANDO:
				tmBolsistas.updBolsista(bolsista, tblBolsistas.getSelectedRow());
				break;
			}


	
			JOptionPane.showMessageDialog(null, "Professor incluido com sucesso!",
					"Cadastro de Professores",JOptionPane.INFORMATION_MESSAGE);
			limparCampos();
			fldMatricula.requestFocus();
			status = INCLUINDO;
			btnExcluir.setEnabled(false);
		}

	}
	class AcaoExcluir extends AbstractAction{

		AcaoExcluir(){
			super("Excluir");
			putValue(MNEMONIC_KEY, KeyEvent.VK_E);
			putValue(SHORT_DESCRIPTION, "Inclui um professor na tabela!");
			putValue(SMALL_ICON, new ImageIcon(imagesPath+"general/Delete16.gif"));

		}


		@Override
		public void actionPerformed(ActionEvent e) {
						tmBolsistas.removeBolsista(tblBolsistas.getSelectedRow());
						btnExcluir.setEnabled(false);
			JOptionPane.showMessageDialog(null, "Bolsista excluido com sucesso!",
					"Cadastro de Professores",JOptionPane.INFORMATION_MESSAGE);
			limparCampos();
			fldMatricula.requestFocus();
			btnExcluir.setEnabled(false);
		}
	}

	/*====================================Mouse===========================================*/

	class HabilitarEdicaoExclusao extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			if(tblBolsistas.getSelectedRow()>=0) {
				Bolsista bolsista = tmBolsistas.getBolsista((tblBolsistas.getSelectedRow()));
				carregarCampos(bolsista);
				status = EDITANDO;
				btnExcluir.setEnabled(true);
			}
			else
				btnExcluir.setEnabled(false);
		}
	}
}
