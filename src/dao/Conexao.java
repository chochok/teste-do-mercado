package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private Connection conexao;
	
	private Connection abrirConexao() throws SQLException {
		try {
			//Cria o Driver de Conexão
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}
		catch(Exception e) {
			System.err.println("Erro ao carregar o Driver do MySQL -> "+ e.getMessage());			
			throw new SQLException(e);
		}
		
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://127.7.142.2:3306/testedomercado", "admin2lLiE15", "BVN-f6vggtd7");
			
			//Retorna os Dados da Conexão
			return conexao;
		}
		catch(SQLException e) {
			System.err.println("Erro ao obter a conexão com o servidor de Banco de Dados -> "+ e.getMessage());
			throw e;
		}
	}
	
	public void closeConexao() {
		try {
			//Verifica se a Conexão está fechada
			//se não estiver fechada, então fecha
			if((conexao != null) && (! conexao.isClosed())) {
				conexao.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConexao() throws SQLException {
		//Verifica se já existe uma Conexão criada para esta instancia.
		//se não existir, abre uma nova Conexão
		if(conexao == null) {
			conexao = abrirConexao();
		}
		return conexao;
	}
}
