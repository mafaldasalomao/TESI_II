import javax.swing.table.*;
import java.util.*;

import javax.swing.table.AbstractTableModel;

public class BolsistasTableModel extends AbstractTableModel{

	private List<Bolsista> bolsistas = new ArrayList<Bolsista>();//table data- arraylist bolsistas
	private String [] cabecalho = {"Matrícula", "Nome", "Sexo", "Auxilio", "Iniciação", "Curso"};
	
	
	public int getRowCount() {//quantas limhas tem na tabela??
		return bolsistas.size();//é o tamanho do array é o total de linhas
	}//fime metodo getRowCount
	
	public int getColumnCount() {//quantas colunas  tem a tabela??
		return cabecalho.length;//o tamanho do vetor
	}//fim metodo getColumnCount

	public Object getValueAt(int rowIndex, int columnIndex) {//quais itens colocar em cada linha e cada coluna
		Bolsista bolsista = bolsistas.get(rowIndex);//pega o professor do indice
		switch(columnIndex) {
		case 0: return bolsista.getMatricula();
		case 1: return bolsista.getNome();
		case 2: return bolsista.getSexo();
		case 3: return bolsista.getAuxilio();
		case 4: return bolsista.getIniciacao();
		case 5: return bolsista.getCurso();
		default : return null;//se nao for nehum dos anteriores
		
		}
	}//fim metodo getValueAt
	@Override
	public String getColumnName(int column) {//retorna  o nome da coluna
		return cabecalho[column];
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {//pegando o tipo primitivo da coluna
		
		return getValueAt(0, columnIndex).getClass();
	}
	public void addBolsista(Bolsista bolsista) {//adiciona um professor
		bolsistas.add(bolsista);
		fireTableDataChanged();
	}//fim metodo addProfessor
	
	public void removeBolsista(int index) {//remove um professor
		bolsistas.remove(index);
		fireTableDataChanged();
	}//fim do metodo remove professor
	
	public Bolsista getBolsista (int Index) {//pegar um bolsista
		return bolsistas.get(Index);
	}
	public void updBolsista(Bolsista bolsista, int Index) {//atualiza o dado, é sobrescrito
		bolsistas.set(Index, bolsista);
		fireTableDataChanged();
	}
}
