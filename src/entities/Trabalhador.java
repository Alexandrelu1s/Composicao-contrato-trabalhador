package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Trabalhador {
	private String nome;
	private WorkerLevel level;
	private Double salarioBase;
	
	private Departamento departamento;
	
	private List<Contratos> list = new ArrayList<>();
	
	public Trabalhador(String nome, WorkerLevel level, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.level = level;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public List<Contratos> getList() {
		return list;
	}
	
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void addContrato (Contratos contrato) {
		list.add(contrato);
	}
	
	public void removeContrato(Contratos contrato) {
		list.remove(contrato);
	}
	
	public Double salarioMes(int mes, int ano) {
		Calendar cal = Calendar.getInstance();
		
		for(Contratos c : list) {
			cal.setTime(c.getData());
			int c_mes = 1 + cal.get(Calendar.MONTH);
			int c_ano =  cal.get(Calendar.YEAR);
			
			if(c_mes == mes && c_ano == ano) {
				
				salarioBase += c.valorTotal();
			}
		}
		return salarioBase;
	}
	
	
}
