package modelo;

public class Mercadoria {

	private String codigoMercadoria;
	private String tipoMercadoria;
	private String nomeMercadoria;
	private String quantidade;
	private String preco;
	private String tipoNegocio;
	
	public String getCodigoMercadoria() {
		return codigoMercadoria;
	}
	
	public String getTipoMercadoria() {
		return tipoMercadoria;
	}
	
	public String getNomeMercadoria() {
		return nomeMercadoria;
	}
	
	public String getQuantidade() {
		return quantidade;
	}
	
	public String getPreco() {
		return preco;
	}
	
	public String getTipoNegocio() {
		return tipoNegocio;
	}

	public void setCodigoMercadoria(String codigoMercadoria) {
		this.codigoMercadoria = codigoMercadoria;
	}

	public void setTipoMercadoria(String tipoMercadoria) {
		this.tipoMercadoria = tipoMercadoria;
	}

	public void setNomeMercadoria(String nomeMercadoria) {
		this.nomeMercadoria = nomeMercadoria;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public void setTipoNegocio(String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}
}
