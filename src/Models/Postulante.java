package Models;
import java.util.*;

public class Postulante {
	
	private String primerNombre, segundoNombre, primerApellido, segundoApellido, sexo, pais_origen, residencia, telefono, correo, titulo, especialidad;
	private List<String> certificaciones, herramientas, lenguajes, conocimiento_general;
	private List<Experiencia_Laboral> experiencias_laborales;
	private int edad, dni, identificador;
	
	public Postulante() {
		certificaciones = new ArrayList();
		herramientas = new ArrayList();
                lenguajes = new ArrayList();
		conocimiento_general = new ArrayList();
		experiencias_laborales = new ArrayList();
	}
	
	public void setNombres(String primerNombre, String segundoNombre) {
		this.primerNombre = primerNombre;
                this.segundoNombre = segundoNombre;
	}
	
	public void setApellidos(String primerApellido, String segundoApellido) {
                this.primerApellido = primerApellido;
                this.segundoApellido = segundoApellido;
	}
	
	public void setEdad(int e) {
		edad = e;
	}
	
	public void setSexo(String genero) {
		sexo = genero;
	}
	
	public void setPais_origen(String pais) {
		pais_origen = pais;
	}
	
	public void setResidencia(String pais) {
		residencia = pais;
	}
	
	public void setTelefono(String tlf) {
		telefono = tlf;
	}
	
	public void setCorreo(String email) {
		correo = email;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
        
        public String getPrimerNombre(){
            return primerNombre;
        }
        
        public String getSegundoNombre(){
            return segundoNombre;
        }
        
        public String getPrimerApellido(){
            return primerApellido;
        }
        
        public String getSegundoApellido(){
            return segundoApellido;
        }
        
        public void setIdentificador(int identificador){
            this.identificador = identificador;
        }
        
        public int getIdentificador(){
            return identificador;
        }
        
        public void setDNI(int dni){
            this.dni = dni;
        }
        
        public int getDNI(){
            return dni;
        }
	
	public void agregarCertificacion(String certificacion) {
		certificaciones.add(certificacion);
	}
	
	public void agregarHerramienta(String herramienta) {
		herramientas.add(herramienta);
	}
        
        public void agregarLenguaje(String lenguaje){
                lenguajes.add(lenguaje);
        }
	
	public void agregarConocimiento(String conocimiento) {
		conocimiento_general.add(conocimiento);
	}
	
	public void agregarExperienciaLaboral(Experiencia_Laboral experiencia) {
		experiencias_laborales.add(experiencia);
	}
        
	public int getEdad() {return edad;}
	public String getSexo() {return sexo;}
	public String getPais_origen() {return pais_origen;}
	public String getResidencia() {return residencia;}
	public String getTelefono() {return telefono;}
	public String getCorreo() {return correo;}
        public String getTitulo() {return titulo;}
	public String getEspecialidad() {return especialidad;}
	public List<String> getHerramientas(){return herramientas;}
        public List<String> getLenguajes(){return lenguajes;}
	public List<String> getCertificaciones(){return certificaciones;}
	public List<String> getConocimiento_general(){return conocimiento_general;}
	public List<Experiencia_Laboral> getExperiencias_laborales(){return experiencias_laborales;}
}
