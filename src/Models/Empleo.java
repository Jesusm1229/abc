package Models;

import java.util.*;

public class Empleo {
	
	private List<String> especialidades, herramientas, lenguajes, certificacionesSugeridas, nivelesAcademicos, tipoProyectos;
	private int menorEdad, mayorEdad, codContrato;
        private String nombre_empresa, sexo, domicilio, modo, nacionalidad, descripcion, correo;
	
	public Empleo() {
		especialidades = new ArrayList();
		herramientas = new ArrayList();
                lenguajes = new ArrayList();
		certificacionesSugeridas = new ArrayList();
                nivelesAcademicos = new ArrayList();
                tipoProyectos = new ArrayList();
	}
	
	public List<String> getEspecialidades() { return especialidades; }
	public List<String> getHerramientasManejadas() {return herramientas;}
        public List<String> getLenguajesManejados(){return lenguajes;}
	public List<String> getCertificacionesSugeridas() {return certificacionesSugeridas;}
        public List<String> getNivelesAcademicos() { return nivelesAcademicos;}
        public List<String> getTipoProyectos() {return tipoProyectos;}
	public int getMenorEdad() {return menorEdad;}
	public int getMayorEdad() {return mayorEdad;}
        public int getCodContrato() {return codContrato;}
        public String getNombreEmpresa() {return nombre_empresa;}
        public String getSexo() {return sexo;}
        public String getDomicilio() { return domicilio;}
        public String getModo() {return modo;}
        public String getNacionalidad() {return nacionalidad;}
        public String getDescripcion() {return descripcion;}
        public String getCorreo() { return correo;}
        
        public void setEspecialidades(String especialidad) { especialidades.add(especialidad); }
	public void setHerramientasManejadas(String herramienta) { herramientas.add(herramienta);}
        public void setLenguajesManejados(String lenguaje) { lenguajes.add(lenguaje);}
	public void setCertificacionesSugeridas(String certificacionSugerida) {certificacionesSugeridas.add(certificacionSugerida);}
        public void setNivelesAcademicos(String nivelAcademico) { nivelesAcademicos.add(nivelAcademico);}
        public void setTipoProyectos(String tipoProyecto) { tipoProyectos.add(tipoProyecto);}
	public void setMenorEdad(int menorEdad) {this.menorEdad = menorEdad;}
	public void setMayorEdad(int mayorEdad) { this.mayorEdad = mayorEdad;}
        public void setNombreEmpresa(String nombre_empresa) { this.nombre_empresa = nombre_empresa;}
        public void setCodContrato(int codContrato) { this.codContrato = codContrato;}
        public void setSexo(String sexo) {this.sexo = sexo;}
        public void setDomicilio(String domicilio) { this.domicilio = domicilio;}
        public void setModo(String modo){this.modo = modo;}
        public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}
        public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
        public void setCorreo(String correo) { this.correo = correo;}
}
