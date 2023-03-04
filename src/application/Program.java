package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contratos;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Departamento: ");
		String departamento = sc.nextLine();

		System.out.print("Nome do funcionario: ");
		String nome = sc.nextLine();

		System.out.print("Level do funcionario (JUNIOR, MID_LEVEL, SENIOR): ");
		String level = sc.nextLine();

		System.out.print("Salario base: ");
		Double salarioBase = sc.nextDouble();

		Trabalhador funcionario = new Trabalhador(nome, WorkerLevel.valueOf(level), salarioBase, new Departamento(departamento));

		System.out.println();

		System.out.print("Quantidade de contratos: ");
		int quantidade = sc.nextInt();

		for (int i = 0; i < quantidade; i++) {
			System.out.print("Data do contrato: ");
			sc.nextLine();
			Date data = sdf.parse(sc.next());
			

			System.out.print("Valor hora: ");
			Double valorHora = sc.nextDouble();

			System.out.print("Horas trabalhadas: ");
			int horas = sc.nextInt();
			
			Contratos contrato = new Contratos(data, valorHora, horas);
			
			funcionario.addContrato(contrato);
		}
		
		System.out.println();
		
		System.out.print("Entre o mes e o ano para calcular o salario MM/yyyy: ");
		String mesAno = sc.next();
		
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome: " +funcionario.getNome());
		System.out.println("Departamento:" + funcionario.getDepartamento().getNome());
		System.out.println("Salario: "+ mesAno +": " + funcionario.salarioMes(mes, ano));
		
		sc.close();
	}

}
