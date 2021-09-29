package got;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("naval")
public class Naval extends FuerzaMilitar {
  private int cantidadBarcos;

  @Override
  public void atacarA(Lugar lugar) {

  }
}
