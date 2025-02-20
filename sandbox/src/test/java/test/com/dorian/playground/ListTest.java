package test.com.dorian.playground;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;

class ListTest {

  @DisplayName("Accessing the first element of a list, even if it's null, should not raise NPE")
  @Test
  void shouldRaiseNPE() {
    List<String> list = new ArrayList<>();
    list.add(null);
    assertThatNoException().isThrownBy(() -> list.get(0));
  }
}
