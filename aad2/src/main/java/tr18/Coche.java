package tr18;
public class Coche 
{
	String marca;
	String modelo;
	int puertas;
	int kilometros;
	Motor motor;
	public Coche(String marca, String modelo, int puertas, int kilometros, Motor motor) 
	{
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.puertas = puertas;
		this.kilometros = kilometros;
		this.motor = motor;
	}
	public String getMarca() {
		return this.marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return this.modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getPuertas() {
		return this.puertas;
	}
	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}
	public int getKilometros() {
		return this.kilometros;
	}
	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}
	public Motor getMotor() {
		return this.motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
}
