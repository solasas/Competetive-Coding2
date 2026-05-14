package classcodes;

public class CelebrityProblem {

    public static int WhoisCeleb(int[][] mat) {
        int n = mat.length;
        int top = 0;
        int down = n - 1;

        // Step 1: Find candidate
        while (top < down) {
            if (mat[top][down] == 1) {
                top++;      // top knows down → not celebrity
            } else {
                down--;     // down not known by top → not celebrity
            }
        }

        // If no candidate
        if (top > down)
            return -1;

        // Step 2: Verify candidate
        for (int i = 0; i < n; i++) {
            if (i == top) continue;

            if (mat[top][i] == 1 || mat[i][top] == 0) {
                return -1;
            }
        }

        return top; // celebrity found
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 1, 1},
                {0, 0, 1},
                {0, 0, 0}
        };
        System.out.println(WhoisCeleb(mat)); // Output: 2

    }
}
