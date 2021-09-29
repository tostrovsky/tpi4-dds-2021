package got;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("terrestre")
public class Terrestre extends FuerzaMilitar {
  private int cantidadSoldados;

  @Override
  public void atacarA(Lugar lugar) {

  }
}
