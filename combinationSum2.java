import java.util.*;

public class combinationSum2 {
  public static void backtrack(int idx, int arr[], int target, List<List<Integer>> ans, List<Integer> ds) {
    if (target == 0) {
      ans.add(new ArrayList<>(ds));
      return;
    }
    for (int i = idx; i < arr.length; i++) {
      if (i > idx && arr[i] == arr[i - 1]) {
        continue;
      }
      if (arr[i] > target) {
        break;
      }
      ds.add(arr[i]);
      backtrack(i + 1, arr, target - arr[i], ans, ds);
      ds.remove(ds.size() - 1);
    }
  }

  public static List<List<Integer>> combinationSum2Problem(int candidates[], int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(0, candidates, target, ans, new ArrayList<>());
    return ans;

  }

  public static void main(String args[]) {
    int candidates[] = { 8, 1, 3, 7, 2, 1, 5 };
    int target = 12;
    System.out.println(combinationSum2Problem(candidates, target));
  }
}