package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.common.collect.ImmutableList;
import main.java.StrongConnection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StrongConnectionTest {

  StrongConnection strongConnection = new StrongConnection();

  @Test
  public void getStrongestConnection_returnsStrongConnections() {
    // Act & Assert.
    assertEquals(
        ImmutableList.of("o <-> n : 3"),
        strongConnection.getStrongestConnection("String to check strong connection"));
  }

  @Test
  public void getStrongestConnection_withMultipleStrongConnection_returnsAllStrongConnections() {
    // Act & Assert.
    assertEquals(
        ImmutableList.of("n <-> g : 3", "o <-> n : 3", "s <-> t : 3", "t <-> r : 3"),
        strongConnection.getStrongestConnection(
            "String string to check multiple strong connections"));
  }

  @Test
  public void getStrongestConnection_withEmptyInput_throwsException() {
    // Act & Assert.
    assertThrows(IllegalArgumentException.class, () -> strongConnection.getStrongestConnection(""));
  }

  @Test
  public void getStrongestConnection_withNullInput_throwsException() {
    // Act & Assert.
    assertThrows(
        IllegalArgumentException.class, () -> strongConnection.getStrongestConnection(null));
  }
}