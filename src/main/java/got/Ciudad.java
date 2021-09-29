package got;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Ciudad extends Lugar {
  private int cantidadDeComercios;
  private int cantidadDeSantuarios;
  private double tasaDeMortalidad;

  public Ciudad(int cantidadDeComercios, int cantidadDeSantuarios, double tasaDeMortalidad) {
    this.cantidadDeComercios = cantidadDeComercios;
    this.cantidadDeSantuarios = cantidadDeSantuarios;
    this.tasaDeMortalidad = tasaDeMortalidad;
  }

  public Ciudad() {

  }
}
