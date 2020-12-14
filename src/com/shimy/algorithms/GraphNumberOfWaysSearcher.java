import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GraphNumberOfWaysSearcher {

  /**
   * Finds the number of possible combinations that marks 3 nodes all equidistant from each other. Given that there are
   * n nodes, n-1 edges and no cycles or unreachable nodes in the graph
   *
   * @param roads A list of the edges in the map given as th pair of nodes they connect
   */
  public int numberOfWays(List<List<Integer>> roads) {
    int result = 0;
    // make a map of the roads of each city
    Map<Integer, List<Integer>> roadsOfCity = new HashMap<>();
    for (List<Integer> road : roads) {
      Integer city1 = road.get(0);
      Integer city2 = road.get(1);
      putValueInMultiValueMap(roadsOfCity, city1, city2);
    }
    // for each city, find how man cities are x steps away
    for (Integer city : roadsOfCity.keySet()) {
      Map<Integer, Integer> citiesByDistance = new HashMap<>();
      numberOfCitiesStepsAway(roadsOfCity, 1, citiesByDistance, Collections.singletonList(city));
      for (Integer nodes : citiesByDistance.values()) {
        result += combinations(nodes);
      }
    }
    return result;
  }

  private void numberOfCitiesStepsAway(Map<Integer, List<Integer>> roadsOfCity, Integer steps,
      Map<Integer, Integer> citiesByDistance, List<Integer> cities) {
    for (Integer nextCity : cities) {
      Integer numberOfCitiesAnotherStepAway = Optional.ofNullable(roadsOfCity.get(nextCity)).map(List::size).orElse(0);
      citiesByDistance.merge(steps, numberOfCitiesAnotherStepAway, Integer::sum);
      if (roadsOfCity.get(nextCity) != null) {
        numberOfCitiesStepsAway(roadsOfCity, steps + 1, citiesByDistance, roadsOfCity.get(nextCity));
      }
    }
  }

  int combinations(Integer numberOfCities) {
    if (numberOfCities < 3) {
      return 0;
    } else {
      return numberOfCities * (numberOfCities - 1) * (numberOfCities - 2) / 6;
    }
  }

  private void putValueInMultiValueMap(Map<Integer, List<Integer>> map, Integer key, Integer value) {
    List<Integer> list = new ArrayList<>();
    list.add(value);
    if (map.get(key) != null) {
      map.get(key).add(value);
    } else {
      map.put(key, list);
    }
  }
}
