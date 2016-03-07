package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;

/**
 * Servlet implementation class Listar
 */
public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Listar() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Conexao con = new Conexao();
		
		try {
			Connection conexao = con.getConexao();
			PreparedStatement sql = conexao.prepareStatement ("select * from mercado order by codigoMercadoria");
			ResultSet resultado = sql.executeQuery();

			out.println("<head>");
			out.println("<meta http-equiv='Content-Type' content='text/html; charset=ISO-8859-1'>");
			out.println("<title>Lista de Operações</title>");
			out.println("</head>");
			out.println("<body bgcolor='#FFFFCC'>");
			out.println("<h1> <center> Lista de Operações </center> </h1>");
			out.println("<br>");
			out.println("<table border=1 align='center'>");
			out.println("<tr>");
				out.println("<td width='185'><h3>Código de Mercadoria</h3></td>");
				out.println("<td width='185'><h3>Tipo de Mercadoria</h3></td>");
				out.println("<td width='185'><h3>Nome da Mercadoria</h3></td>");
				out.println("<td width='120'><h3>Quantidade</h3></td>");
				out.println("<td width='140'><h3>Preço</h3></td>");
				out.println("<td width='150'><h3>Tipo de Negócio</h3></td>");
			out.println("</tr>");

			while (resultado.next()) {
				out.println("<tr>");
				out.println("<td>"+resultado.getString("codigoMercadoria")+"</td>");
				out.println("<td>"+resultado.getString("tipoMercadoria")+"</td>");
				out.println("<td>"+resultado.getString("nomeMercadoria")+"</td>");
				out.println("<td>"+resultado.getString("quantidade")+"</td>");
				out.println("<td>"+resultado.getString("preco")+"</td>");
				out.println("<td>"+resultado.getString("tipoNegocio")+"</td>");
				out.println("<td><a href='./Excluir?codigo="+resultado.getString("codigoMercadoria")+"'>Excluir</a></td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("<center><a HREF='./mercado.jsp' > Voltar </a></center>");
			
			out.println("</body>");
			resultado.close();
		
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
