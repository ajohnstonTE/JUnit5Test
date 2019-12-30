import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestClass {
  @Test
  void shouldRunAndPassAsExpected() {
  }

  public static Stream<Arguments> nothing() {
    return Stream.of(Arguments.arguments());
  }

  @ParameterizedTest
  @MethodSource("nothing")
  public void shouldRunAndFailAsExpected() {
    Assertions.fail();
  }

  static Stream<Arguments> throwException() {
    if (true) throw new RuntimeException("Stop");
    return Stream.of(Arguments.arguments());
  }

  @ParameterizedTest
  @MethodSource("throwException")
  void willNotBeLoggedAsFailingDespiteNotRunning() {
    Assertions.fail();
  }
}