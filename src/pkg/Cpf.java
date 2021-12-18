package pkg;

import static pkg.Cpfs.*;

public class Cpf {
	private String cpf;
	private boolean formatted;

	public Cpf(String cpf) {
		setCpf(cpf);
		formatted = Cpfs.isFomatted(cpf);
	}

	public String getCpf(boolean formatted) {
		if (formatted && !this.formatted) {
			cpf = formatCpf(cpf);
			formatted = true;
		} else
			return cleanFormat(cpf);
		return cpf;
	}

	private void setCpf(String cpf) {
		returnTheCpfIsValidOrThrowAnRuntimeException(cpf);
		// Apartir desse ponto o CPF é valido e a atribuição deve ser feita
		this.cpf = cpf;
	}

	public boolean  isFomatted() {
		return formatted;
	}

}
