package entidade;

import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {
	private String titular;
	private int numeroConta;
	private float saldo;
	private ArrayList<Operacao> operacoes = new ArrayList<Operacao>();

	public float getSaldo() {
		
		return saldo;
	}

	public float debito(float valor) {
		saldo -= valor;
		Operacao op = new Operacao (valor, "DEBITO", new Date()); 
		operacoes.add(op);
		return saldo;
		
	}

	public float credito(float valor) {
		saldo += valor;
		Operacao op = new Operacao (valor, "CREDITO", new Date());
		operacoes.add(op);
		return saldo;
	}

	public ArrayList<Operacao> extrato() {
		return operacoes;
	}

	public float transferencia(float valor, ContaCorrente ccDestino) {
		this.debito(valor);
		ccDestino.credito(valor);
		return saldo;
	}

	public String getTitular() {
		return titular;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public ContaCorrente(int numeroConta, String titular) {
		super();
		this.numeroConta = numeroConta;
		this.titular = titular;
	}

	
	
}
