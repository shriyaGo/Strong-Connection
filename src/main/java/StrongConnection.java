package main.java;

import static java.util.stream.Collectors.toUnmodifiableList;

import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StrongConnection {

  class CharConnection {

    char char1;
    char char2;

    public CharConnection(char char1, char char2) {
      this.char1 = char1;
      this.char2 = char2;
    }

    @Override
    public int hashCode() {
      return Objects.hash(char1, char2);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof CharConnection)) {
        return false;
      }
      CharConnection that = (CharConnection) o;
      return (char1 == that.char1 && char2 == that.char2)
          || (char1 == that.char2 && char2 == that.char1);
    }

    public char getChar1() {
      return char1;
    }

    public char getChar2() {
      return char2;
    }
  }

  /**
   * Problem Description: We want to know the strong connection between two characters in a text
   * based on how many times two characters are placed adjacent to each other in the input text.
   *
   * <p>Write a java function that accepts an input string text and returns the list of string
   * representing the strongest connections between 2 characters.
   *
   * @param inputText String to check the strong connection in.
   * @return String list containing characters with strong connection.
   * @throws IllegalArgumentException if {@code inputText} is null or empty.
   */
  public List<String> getStrongestConnection(String inputText) {
    if (inputText == null || inputText.isEmpty()) {
      throw new IllegalArgumentException("Please provide some input text.");
    }

    inputText = inputText.toLowerCase(Locale.ROOT);
    List<String> words = Splitter.on(" ").omitEmptyStrings().trimResults().splitToList(inputText);

    List<CharConnection> connections =
        words.stream()
            .map(
                word -> {
                  char[] wordChars = word.toCharArray();
                  List<CharConnection> wordConnections = new ArrayList<>();
                  for (int i = 0; i < wordChars.length - 1; i++) {
                    wordConnections.add(new CharConnection(wordChars[i], wordChars[i + 1]));
                  }
                  return wordConnections;
                })
            .flatMap(List::stream)
            .collect(toUnmodifiableList());

    Map<CharConnection, Long> connectionsMap =
        connections.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Long maxValue = connectionsMap.values().stream().max(Comparator.naturalOrder()).get();

    return connectionsMap.entrySet().stream()
        .filter(entry -> entry.getValue().equals(maxValue))
        .map(
            entry ->
                String.format(
                    "%s <-> %s : %d",
                    entry.getKey().getChar1(), entry.getKey().getChar2(), entry.getValue()))
        .sorted()
        .collect(toUnmodifiableList());
  }
}