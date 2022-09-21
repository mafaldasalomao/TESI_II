import java.sql.*;

public class Conexao {

	private Connection con = null;
	private Statement stm = null;
	private boolean conectado=false;

	//	public Conexao() {
	//
	//		try {
	//			Class.forName("com.mysql.jdbc.Maria");
	//			System.out.println("Driver carregado com sucesso!");
	//		} catch (ClassNotFoundException e) {
	//			System.out.println("Classe do driver não localizada!");
	//		}
	//
	//	}
	public boolean conecte(String urlBanco, String userName, String userPasswd) {
		if(conectado) {
			System.out.println("Já está conectado!");
		}
		else {
			try {
				con = DriverManager.getConnection(urlBanco, userName, userPasswd);
				stm = con.createStatement();
				System.out.println("Conexão efetuada com sucesso!");
				conectado =true;
			} catch (SQLException sqle) {
				System.out.printf("Erro # %d (%s) \n", sqle.getErrorCode(), sqle.getMessage());
				conectado= false;
			}
		}
		return conectado;
	}
	public void desconecte() {
		if(!conectado) {
			System.out.println("Já está desconectado!");
		}else {
			try {
				con.close();
				System.out.println("Conexão encerrada com sucesso!");
				conectado=false;
			} catch (SQLException sqle) {
				System.out.printf("Erro # %d (%s) \n", sqle.getErrorCode(), sqle.getMessage());
			}
		}
	}
	public ResultSet consulte(String sqlQuery) {
		if(conectado) {
			try {
				return stm.executeQuery(sqlQuery);
			} catch (SQLException sqle) {
				System.out.printf("Erro # %d (%s) \n", sqle.getErrorCode(), sqle.getMessage());
				return null;
			}
		}else {
			System.out.println("Não está conectado");
			return null;
		}
	}
}
