package got;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Lugares")
@Inheritance(strategy = InheritanceType.JOINED)
public class Lugar extends PersistentEntity{

  private String nombre;

  private int anioFundacion;

  private int poblacion;

  public String getNombre() {
    return nombre;
  }

}
