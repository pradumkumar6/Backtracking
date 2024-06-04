public class maxNumberOfAchievable {
  int result = 0;

  public void backtrack(int idx, int count, int resultant[], int requests[][]) {
    // base case
    if (idx >= requests.length) {
      for (int i : resultant) {
        if (i != 0) {
          return;
        }
      }
      result = Math.max(result, count);
      return;
    }
    // take
    resultant[requests[idx][0]]--;
    resultant[requests[idx][1]]++;
    backtrack(idx + 1, count + 1, resultant, requests);
    // non take
    resultant[requests[idx][0]]++;
    resultant[requests[idx][1]]--;
    backtrack(idx + 1, count, resultant, requests);

  }

  public int maximumRequests(int n, int[][] requests) {
    int resultant[] = new int[n];
    backtrack(0, 0, resultant, requests);
    return result;
  }

}
