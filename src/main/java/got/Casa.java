package got;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

//Desnormalizo el lugar y extraigo sólo el nombre, que es lo que nos interesa
@Entity
@Table
public class Casa extends PersistentEntity{
  private String nombre;
  private int patrimonio;
  private int anioFundacion;

  @ManyToOne
  private Casa vasallaDe;

  //@OneToMany
  //private List<Casa> casasVallasadas;
  @OneToMany
  private Collection<FuerzaMilitar> fuerzasMilitares;

  @Transient
  private Lugar origen;
  //se establece en el constructor el nombre, como this.nombreLugar = origen.getNombre();
  private String nombreLugar;

  public Casa() {

  }

  public String nombreLugarOrigen() {
    return this.nombreLugar;
  }

  public Casa(String nombre, int patrimonio, int anioFundacion, Casa vasallaDe,
              Collection<FuerzaMilitar> fuerzasMilitares, Lugar origen) {
    this.nombre = nombre;
    this.patrimonio = patrimonio;
    this.anioFundacion = anioFundacion;
    this.vasallaDe = vasallaDe;
    this.fuerzasMilitares = fuerzasMilitares;
    this.origen = origen;
    this.nombreLugar = origen.getNombre();
  }
}

