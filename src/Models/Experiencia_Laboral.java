package Models;

public class Experiencia_Laboral {
	
	private String empresa, cargo;
	private int year_ingreso, year_salida;
	
	public Experiencia_Laboral() {	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setYear_ingreso(int ingreso) {
		year_ingreso = ingreso;
	}
	
	public void setYear_salida(int salida) {
		year_salida = salida;
	}
	
	public String getEmpresa() { return empresa; }
	public String getCargo() { return cargo; }
	public int getYear_ingreso() { return year_ingreso; }
	public int getYear_salida() { return year_salida; }
}
