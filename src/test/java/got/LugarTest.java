package got;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import javax.persistence.TypedQuery;

import static org.junit.jupiter.api.Assertions.*;

public class LugarTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

  @BeforeEach
  public void setup() {
    this.beginTransaction();
  }

  @AfterEach
  public void tearDown() {
    this.rollbackTransaction();
  }

  @Test
  public void puedePersistirUnCastillo() {

    Castillo castillito = new Castillo(10, 2);
    entityManager().persist(castillito);
    assertEquals(castillito, entityManager().createQuery("from Castillo", Castillo.class).getResultList().get(0));
  }

  @Test
  public void puedePersistirUnaCiudad() {

    entityManager().persist(new Ciudad(2,2,0.1));
    assertEquals(1, entityManager().createQuery("from Ciudad", Ciudad.class).getResultList().size());
  }

  @Test
  public void puedeRecuperarLugares() {
    entityManager().persist(new Castillo(10, 2));
		entityManager().persist(new Ciudad(2,2,0.1));

    TypedQuery<Lugar> query = entityManager().createQuery("from Lugar", Lugar.class);
    assertEquals(2, query.getResultList().size());
  }


}
