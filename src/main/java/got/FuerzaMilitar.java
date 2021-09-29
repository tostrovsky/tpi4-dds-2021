package got;

import javax.persistence.*;

//Se cambio la interfaz a clase abstracta pa poder hacer el single table
@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_fuerza")
public abstract class FuerzaMilitar extends PersistentEntity{
  abstract void atacarA(Lugar lugar);
}
