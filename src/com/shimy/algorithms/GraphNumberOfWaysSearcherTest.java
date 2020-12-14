import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class GraphNumberOfWaysSearcherTest {

  private GraphNumberOfWaysSearcher sut = new GraphNumberOfWaysSearcher();

  @Test
  void test1() {
    List<List<Integer>> roads = new ArrayList<>();
    roads.add(Arrays.asList(0, 1));
    roads.add(Arrays.asList(0, 2));
    roads.add(Arrays.asList(0, 3));

    int ret = sut.numberOfWays(roads);
    assertEquals(1, ret);
  }

  @Test
  void test2() {
    List<List<Integer>> roads = new ArrayList<>();
    roads.add(Arrays.asList(0, 1));
    roads.add(Arrays.asList(1, 2));
    roads.add(Arrays.asList(2, 3));

    int ret = sut.numberOfWays(roads);
    assertEquals(0, ret);
  }

  @Test
  void test3() {
    List<List<Integer>> roads = new ArrayList<>();
    roads.add(Arrays.asList(0, 1));
    roads.add(Arrays.asList(0, 2));
    roads.add(Arrays.asList(0, 3));

    roads.add(Arrays.asList(1, 4));
    roads.add(Arrays.asList(1, 5));

    roads.add(Arrays.asList(2, 6));
    roads.add(Arrays.asList(2, 7));

    roads.add(Arrays.asList(3, 8));
    roads.add(Arrays.asList(3, 9));

    int ret = sut.numberOfWays(roads);
    assertEquals(21, ret);
  }

  @Test
  void test4() {
    List<List<Integer>> roads = new ArrayList<>();
    roads.add(Arrays.asList(0, 1));
    roads.add(Arrays.asList(0, 2));
    roads.add(Arrays.asList(0, 3));
    roads.add(Arrays.asList(1, 4));
    roads.add(Arrays.asList(5, 2));
    roads.add(Arrays.asList(6, 3));

    int ret = sut.numberOfWays(roads);
    assertEquals(1, ret);
  }

  @Test
  void testComb() {
    assertEquals(0, sut.combinations(1));
    assertEquals(1, sut.combinations(3));
    assertEquals(4, sut.combinations(4));
    assertEquals(10, sut.combinations(5));
    assertEquals(20, sut.combinations(6));
  }
}
