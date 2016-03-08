package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;

public class Incluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Incluir() {
        super();
    }
    
    //Inclui os dados enviados pela pagina incluir, no banco de dados
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conexao con = new Conexao();
		try {
			Connection conexao = con.getConexao();
		    if(validaRegistro(conexao, request.getParameter("codigo"))){
		    	PreparedStatement sql = conexao.prepareStatement("insert into mercado (codigoMercadoria, tipoMercadoria, nomeMercadoria, quantidade, preco, "
		    																		+ "tipoNegocio) values (?,?,?,?,?,?)");

				sql.setString(1, request.getParameter("codigo"));
				sql.setString(2, request.getParameter("tipo"));
				sql.setString(3, request.getParameter("nomeMercadoria"));
				sql.setString(4, request.getParameter("quantidade"));
				sql.setString(5, request.getParameter("preco").replace(",", "."));
				sql.setString(6, request.getParameter("tipoNegocio"));
				int q = sql.executeUpdate();
				if (q > 0) {
					request.setAttribute("inserido", "true");
				}
				else{
					request.setAttribute("inserido", "false");
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("mercado.jsp");
				dispatcher.forward(request, response);
		    }else{
		    	request.setAttribute("incluiu", "false");
                RequestDispatcher dispatcher = request.getRequestDispatcher("incluir.jsp");
                dispatcher.forward(request, response);
		    }
			
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			con.closeConexao();
		}
	}
	
    private boolean validaRegistro(Connection conexao, String codigo) throws SQLException {
    
    	PreparedStatement sql = conexao.prepareStatement("select * from mercado where codigoMercadoria = ?");
        sql.setInt(1, new Integer(codigo));
        ResultSet resultado = sql.executeQuery();
        if (resultado.next()){
        	return false;
        }
        
        return true;
    }

}
