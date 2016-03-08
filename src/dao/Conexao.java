package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection conexao;
	
	private Connection abrirConexao() throws SQLException {
		try {
			//Cria o Driver de Conex�o
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch(Exception e) {
			System.err.println("Erro ao carregar o Driver do MySQL -> "+ e.getMessage());			
			throw new SQLException(e);
		}
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://127.7.142.2:3306/testedomercado", "admin2lLiE15", "BVN-f6vggtd7");
			
			//Retorna os Dados da Conex�o
			return conexao;
		}
		catch(SQLException e) {
			System.err.println("Erro ao obter a conex�o com o servidor de Banco de Dados -> "+ e.getMessage());
			throw e;
		}
	}
	
	public void closeConexao() {
		try {
			//Verifica se a Conex�o est� fechada
			//se n�o estiver fechada, ent�o fecha
			if((conexao != null) && (! conexao.isClosed())) {
				conexao.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() throws SQLException {
		//Verifica se j� existe uma Conex�o criada para esta instancia.
		//se n�o existir, abre uma nova Conex�o
		if(conexao == null) {
			conexao = abrirConexao();
		}
		return conexao;
	}
}
