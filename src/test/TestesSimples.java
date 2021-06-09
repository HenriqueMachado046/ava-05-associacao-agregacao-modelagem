package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

public class TestesSimples {

  @Test
  public void queEhVerdadeiro() {
    assertTrue("failure - should be true", true);
  }

  @Test
  public void queEhFalso() {
    assertFalse("failure - should be false", false);
  }

  @Test
  public void queObjetosSaoIguais() {
    assertEquals("failure - strings are not equal", "text", "text");
  }

  @Test
  public void queObjetosNaoSaoIguais() {
    assertNotEquals("failure - strings are not equal", "text", "Text");
  }

  @Test
  public void queArraysSaoIguais() {
    byte[] esperado = "trial".getBytes();
    byte[] defato = "trial".getBytes();
    assertArrayEquals("failure - byte arrays not same", esperado, defato);
  }

  @Test
  public void queEhNulo() {
    assertNull("should be null", null);
  }

  @Test
  public void queNaoEhNulo() {
    assertNotNull("should not be null", new Object());
  }

  @Test
  public void queObjetosSaoOMesmo() {
    Integer num = Integer.valueOf(768);
    assertSame("should be same", num, num);
  }

  @Test
  public void queObjetosNaoSaoOsMesmo() {
    assertNotSame("should not be same Object", new Object(), new Object());
  }

  @Test
  public void queLancaExcecao() {
    int[] values = {0, 1, 2};
    try {
      System.out.println(values[3]);
      fail("IndexOutOfBoundsException has not been thrown");
    } catch (IndexOutOfBoundsException e) {
      /* propositalmente vazio */
    }
  }

  @Test
  @Ignore
  public void testeIgnorado() {
    assertTrue("not true", false);
  }
}
