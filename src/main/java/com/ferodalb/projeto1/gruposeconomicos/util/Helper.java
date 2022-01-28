package com.ferodalb.projeto1.gruposeconomicos.util;

public class Helper {

	
	
	
	public static boolean onlyNumbers(String valor) {
		return valor != null && !valor.trim().isEmpty() && valor.matches("^[0-9]*$");
	}

	public static boolean isCnpj(String valor) {
		
		boolean isNumeric = onlyNumbers(valor);
		
		if (!isNumeric) {
			return false;
		} else {
			if (valor.length() != 14) {
				return false;
			} else {
				return true;
			}
		}	
	}
	
	public static boolean isRaiz(String valor) {
		
		boolean isNumeric = onlyNumbers(valor);
		
		if (!isNumeric) {
			return false;
		} else {
			if (valor.length() != 8) {
				return false;
			} else {
				return true;
			}
		}	
	}
	
	
}
