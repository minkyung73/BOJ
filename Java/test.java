import java.util.Arrays;

public class test {
    static int[] arr = {1, 3, 5, 7, 9};
    static int[] sel = new int[2];
    static boolean[] visited = new boolean[5];

    public static void main(String[] args) {
        recursive(0, 0);
    }

    public static void recursive(int idx, int k) {
        if(k == sel.length) {
            System.out.println(Arrays.toString(sel));
            return ;
        }

        for(int i = idx ; i<arr.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sel[k] = arr[i];
                recursive(i + 1, k+1);
                visited[i] = false;
            }
        }
    }
}
