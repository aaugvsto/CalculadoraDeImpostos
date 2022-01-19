package entities;

public class PessoaJuridica extends Pessoa {

	private Integer numeroFuncionarios;
	
	public PessoaJuridica() {
		
	}
	
	public PessoaJuridica(String nome, double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}

	@Override
	public double calculaImposto() {
		double soma = 0;
		if(numeroFuncionarios > 10) {
			soma += getRendaAnual() * 0.14;
		}else {
			soma += getRendaAnual() * 0.16;
		}
		return soma;
	}
	
}
