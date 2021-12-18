package pkg;

import java.util.stream.Stream;

class Cpfs {
	private static int factor;

	// Auxiliares
	public static String[] getCpfFields(String cpf) {
		return cpf.split("[\\.|-]");
	}

	public static String[] getStringNumbers(String cpf) {
		return cleanFormat(cpf).split("");
	}

	// Validação
	public static void returnTheCpfIsValidOrThrowAnRuntimeException(String cpf) {
		var stringNumbers = getStringNumbers(cpf);

		factor = 10;
		stepOfValidadtion(stringNumbers, 9);

		factor = 11;
		stepOfValidadtion(stringNumbers, 10);
	}

	private static void stepOfValidadtion(String[] cpfField, int validatorNumberIndex) {
		final var limitOfNumbersToProcess = validatorNumberIndex;
		var resultOfProcess = Stream.of(cpfField)
				.map(Integer::parseInt)
				.limit(limitOfNumbersToProcess)
				.map(field -> field * factor--)
				.reduce(Integer::sum)
				.get();
		int result = (resultOfProcess * 10) % 11;
		if (result != Integer.parseInt(cpfField[validatorNumberIndex]))
			throw new RuntimeException("Invalid CPF");
	}

	// Formatação
	public static boolean isFomatted(String cpf) {
		return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d\\d");
	}

	public static String formatCpf(String cpf) {
		var fields = getCpfFields(cpf);
		return fields[0] + "." + fields[1] + "." + fields[2] + "-" + fields[3];
	}
	
	public static String cleanFormat(String cpf) {
		return cpf.replaceAll("[\\.|-]", "");
	}
}
