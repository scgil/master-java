package com.cursojava.principal;

public class Main {
	
	public static void esParImpar() throws Exception {
		int num = (int) ((Math.random() *100) + 1);
		
		if(num % 2 == 0) {
			//System.out.println("El numero "+num+" es Par.");
			throw new Exception("El numero "+num+" es Par.");
		}else {
			throw new Exception("El numero "+num+" es Impar.");
		}

	}

	public static void main(String[] args) {
		try {
			esParImpar();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
}
