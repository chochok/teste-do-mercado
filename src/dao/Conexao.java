package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection conexao;
	
	private Connection abrirConexao() throws SQLException {
		try {
			//CRIA O DRIVER DE CONEX�O
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch(Exception e) {
			System.err.println("Erro ao carregar o Driver do MySQL -> "+ e.getMessage());			
			throw new SQLException(e);
		}
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
			
			//RETORNA OS DADOS DA CONEXAO
			return conexao;
		}
		catch(SQLException e) {
			System.err.println("Erro ao obter a conex�o com o servidor de Banco de Dados -> "+ e.getMessage());
			throw e;
		}
	}
	
	public void closeConexao() {
		try {
			//VERIFICA SE A CONEXAO EST� FECHADA
			//SE N�O ESTIVER FECHADA, ENT�O FECHA
			if(! conexao.isClosed()) {
				conexao.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() throws SQLException {
		//VERIFICA SE J� EXISTE UMA CONEX�O CRIADA PARA ESTA INSTANCIA.
		//SE N�O EXISTIR, ABRE UMA NOVA CONEX�O
		if(conexao == null) {
			conexao = abrirConexao();
		}
		return conexao;
	}
}
