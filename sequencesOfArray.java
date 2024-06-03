import java.util.*;

public class sequencesOfArray {
  public static void backtrack(int idx, ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> ans,
      ArrayList<Integer> curr) {
    ans.add(new ArrayList<>(curr));
    for (int i = idx; i < nums.size(); i++) {
      if (i > idx && nums.get(i) == nums.get(i - 1)) {
        continue;
      }
      curr.add(nums.get(i));
      backtrack(i + 1, nums, ans, curr);
      curr.remove(curr.size() - 1);
    }

  }

  public static ArrayList<ArrayList<Integer>> AllSubsets(ArrayList<Integer> nums) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    Collections.sort(nums);
    ArrayList<Integer> curr = new ArrayList<>();
    backtrack(0, nums, ans, curr);
    return ans;
  }

}
