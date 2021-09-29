package got;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import static org.junit.jupiter.api.Assertions.*;

public class RegionTest extends AbstractPersistenceTest implements WithGlobalEntityManager {

  @BeforeEach
  public void setup() {
    this.beginTransaction();
  }

  @AfterEach
  public void tearDown() {
    this.rollbackTransaction();
  }

  @Test
  public void puedePersistirUnaRegion() {
    Lugar winterfell = new Castillo(10, 2);
    Casa stark = new Casa("stark", 10, 2020, null, null, winterfell );

    Region region = new Region("El norte", stark, Arrays.asList(winterfell));
    entityManager().persist(winterfell);
    entityManager().persist(stark);
    entityManager().persist(region);
    assertEquals(1, entityManager().createQuery("from Region", Region.class).getResultList().size());
  }
  @Test void sePersistenLasCasitas(){
    Lugar winterfell = new Castillo(10, 2);
    Casa stark = new Casa("stark", 10, 2020, null, null, winterfell );
    Casa hulk = new Casa("hulk", 4, 2021, stark, null, winterfell );

    entityManager().persist(winterfell);
    entityManager().persist(stark);
    entityManager().persist(hulk);
    assertEquals(2, entityManager().createNativeQuery("select * from casa").getResultList().size());
  }
}
