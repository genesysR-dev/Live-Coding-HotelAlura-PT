package jdbc.model;

import java.sql.Date;

public class Reserva {
	private Integer id;
	private Date DataEntrada;
	private Date DataSaida;
	private String Valor;
	private String FormaPagamento;
	
	public Reserva(Date DataEntrada, Date DataSaida, String Valor, String FormaPagamento) {
		super();
		this.DataEntrada = DataEntrada;
		this.DataSaida = DataSaida;
		this.Valor = Valor;
		this.FormaPagamento = FormaPagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return DataEntrada;
	}

	public Date getDataSaida() {
		return DataSaida;
	}

	public String getValor() {
		return Valor;
	}

	public String getFormaPagamento() {
		return FormaPagamento;
	}
	
	

}
