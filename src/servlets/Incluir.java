package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;

/**
 * Servlet implementation class Incluir
 */
public class Incluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Incluir() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Conexao con = new Conexao();
		try {
			Connection conexao = con.getConexao();
			PreparedStatement sql = conexao.prepareStatement("insert into Mercado (codigoMercadoria, tipoMercadoria, nomeMercadoria, quantidade, preco, "
																				+ "tipoNegocio) values (?,?,?,?,?,?)");
			
			sql.setString(1, request.getParameter("codigo"));
			sql.setString(2, request.getParameter("tipo"));
			sql.setString(3, request.getParameter("nomeMercadoria"));
			sql.setString(4, request.getParameter("quantidade"));
			sql.setString(5, request.getParameter("preco"));
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
			
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			con.closeConexao();
		}
	}

}
