package br.com.loja.teste;

import br.com.loja.util.CriptografiaUtils;

public class TesteCriptografia {
	
	public static void main(String[] args) {
		try {
			System.out.println(CriptografiaUtils.criptografar("K123456"));
			System.out.println(CriptografiaUtils.criptografar("K123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}