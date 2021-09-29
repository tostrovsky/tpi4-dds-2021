package got;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("aerea")
public class Aerea extends FuerzaMilitar {
  private int cantidadDragones;

  @Override
  public void atacarA(Lugar lugar) {
  }
}
