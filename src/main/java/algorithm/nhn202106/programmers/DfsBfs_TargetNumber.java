package algorithm.nhn202106.programmers;

public class DfsBfs_TargetNumber {

    public static void main(String[] args) {
        new DfsBfs_TargetNumber().solve();
    }

    private void solve() {
        int result = targetNumber(new int[]{1,1,1,1,1}, 3);
        System.out.println("Result: "+(result == 5)+" / answer: 5 / input: "+result);
    }

    private int targetNumber(int[] numbers, int target){
        return dfs(numbers, 0, 0, target);
    }

    private int dfs(int[] numbers, int node, int sum, int target){
        System.out.println("node: "+node);
        if(node == numbers.length){
            System.out.println("sum: "+sum);
            if(sum == target)
                return 1;
            else
                return 0;
        }
        return dfs(numbers, node+1, sum+numbers[node], target) +
                dfs(numbers, node+1, sum-numbers[node], target);
    }
}
