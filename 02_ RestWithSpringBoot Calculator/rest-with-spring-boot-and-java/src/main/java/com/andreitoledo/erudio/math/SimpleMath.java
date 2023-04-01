package com.andreitoledo.erudio.math;

public class SimpleMath {

	// SOMA
	public Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}
	// SUBTRAÇÃO
	public Double subtraction(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}
	// MULTIPLICAÇÃO
	public Double multiplication(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;
	}
	// DIVISÃO
	public Double division(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;
	}
	// MÉDIA
	public Double mean(Double numberOne, Double numberTwo) {
		return (numberOne + numberTwo) / 2;
	}
	// RAIZ QUADRADA
	public Double squareRoot(Double number) {
		return Math.sqrt(number);
	}
}
