import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class ConexaoApp {
	private static final String URL_DB="jdbc:mysql://localhost/academico";
	public static void main(String[] args) {

		Conexao cnx = new Conexao();
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;// sao os dados que descrevem todas as estruturas de dados
		int qtdColunas,qtdTentativas=0;
		String dbUsusario, dbSenha,strConsulta;
		Scanner leitor = new Scanner(System.in);
		boolean conectado = false;
		do {
			System.out.print("Usuário: ");
			dbUsusario = leitor.nextLine();
			System.out.print("Senha: ");
			dbSenha = leitor.nextLine();
			conectado=cnx.conecte(URL_DB, dbUsusario, dbSenha);
			qtdTentativas++;
		}while(!conectado && qtdTentativas < 3);
		if(!conectado) {
			System.out.println("Você esgotou as tentativas de conexão");
		}else {
			System.out.println("Forneça consultaSQL para consulta ao banco!");
			System.out.print("meuSQL> ");
			strConsulta = leitor.nextLine();

			while(strConsulta.compareToIgnoreCase("quit")!=0) {



				rs = cnx.consulte(strConsulta);
				if(rs == null) {
					System.out.println("Consulta sem resultados");
				}else {
					try {
						rsmd = rs.getMetaData();//se quiser perguntar qualquer coisa usa o rsmd
						qtdColunas = rsmd.getColumnCount(); //quantas colunas tem
						for(int i =1; i<=qtdColunas;i++) {
							System.out.printf("%-40s", rsmd.getColumnLabel(i).toUpperCase());
						}
						System.out.println();
						while(rs.next()) {
							for(int i =1; i<=qtdColunas;i++) {
								System.out.printf("%-40s", rs.getObject(i));
							}
							System.out.println();
						}

					} catch (SQLException sqle) {
						System.out.printf("Erro # %d (%s) \n", sqle.getErrorCode(), sqle.getMessage());
					}


				}
				System.out.print("meuSQL> ");
				strConsulta = leitor.nextLine();

			}
			cnx.desconecte();
			leitor.close();
		}

	}


}
