package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;

public class Excluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Excluir() {
        super();
    }
    
    //Exclui o codigo enviado pela pagina de lista
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conexao con = new Conexao();
		
		try {
			Connection conexao = con.getConexao();
			PreparedStatement sql = conexao.prepareStatement ("delete from mercado where codigoMercadoria = ?");
			sql.setString(1, request.getParameter("codigo"));
			int q = sql.executeUpdate();
			if (q > 0) {
				request.setAttribute("excluido", "true");
			}
			else{
				request.setAttribute("excluido", "false");
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("mercado.jsp");
			dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
