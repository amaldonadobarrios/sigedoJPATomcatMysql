package entity.estadistica;

public class PostTest {
	String fecha;
	int cant_total;
	int cant_encontrada;
	double indicador;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCant_total() {
		return cant_total;
	}
	public void setCant_total(int cant_total) {
		this.cant_total = cant_total;
	}
	public int getCant_encontrada() {
		return cant_encontrada;
	}
	public void setCant_encontrada(int cant_encontrada) {
		this.cant_encontrada = cant_encontrada;
	}
	public double getIndicador() {
		return indicador;
	}
	public void setIndicador(double indicador) {
		this.indicador = indicador;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cant_encontrada;
		result = prime * result + cant_total;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		long temp;
		temp = Double.doubleToLongBits(indicador);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostTest other = (PostTest) obj;
		if (cant_encontrada != other.cant_encontrada)
			return false;
		if (cant_total != other.cant_total)
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (Double.doubleToLongBits(indicador) != Double.doubleToLongBits(other.indicador))
			return false;
		return true;
	}

}
