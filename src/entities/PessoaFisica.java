package entities;

public class PessoaFisica extends Pessoa{

	
	private Double gastoSaude;
	
	public PessoaFisica() {
		
	}
	
	public PessoaFisica(String nome, double rendaAnual, double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public double calculaImposto() {
		double soma = 0;
		if(getRendaAnual() < 20000) {
			soma += getRendaAnual() * 0.15;
		}
		if(gastoSaude > 0) {
			soma += gastoSaude * 0.5;
		}
		return soma;
	}
	
}
