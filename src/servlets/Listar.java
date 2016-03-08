package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import modelo.Mercadoria;

public class Listar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//busca os dados do banco de dados e envia para a pagina Listar
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DecimalFormat df = new DecimalFormat("###,##0.00");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("pt", "BR"));
        dfs.setMonetaryDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);
		Conexao con = new Conexao();
		
		try {
			Connection conexao = con.getConexao();
			PreparedStatement sql = conexao.prepareStatement ("select * from mercado order by codigoMercadoria");
			ResultSet resultado = sql.executeQuery();
			List<Mercadoria> lista = new ArrayList<Mercadoria>();
			
			while (resultado.next()) {
				Mercadoria mercadoria = new Mercadoria();
				mercadoria.setCodigoMercadoria(resultado.getString("codigoMercadoria"));
				mercadoria.setTipoMercadoria(resultado.getString("tipoMercadoria"));
				mercadoria.setNomeMercadoria(resultado.getString("nomeMercadoria"));
				mercadoria.setQuantidade(resultado.getString("quantidade"));
				mercadoria.setPreco(df.format(resultado.getDouble("preco")));
				mercadoria.setTipoNegocio(resultado.getString("tipoNegocio"));
				lista.add(mercadoria);
			}
			resultado.close();
			
			request.setAttribute("lista", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listar.jsp");
            dispatcher.forward(request, response);
		
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
