import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of equations (rows):");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of variables (columns):");
        int cols = scanner.nextInt();

        double[][] matrix = new double[rows][cols];
        double[] b = new double[rows];

        System.out.println("Enter the coefficients matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Enter the right-hand side vector:");
        for (int i = 0; i < rows; i++) {
            b[i] = scanner.nextDouble();
        }

        double[][] augmentedMatrix = new double[rows][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                augmentedMatrix[i][j] = matrix[i][j];
            }
            augmentedMatrix[i][cols] = b[i];
        }

        double[][] rrefMatrix = rref(augmentedMatrix);

        System.out.println("The matrix in Reduced Row Echelon Form (RREF) is:");
        for (double[] row : rrefMatrix) {
            for (double value : row) {
                System.out.printf("%8.4f", value);
            }
            System.out.println();
        }

        boolean isConsistent = checkConsistency(rrefMatrix);
        if (isConsistent) {
            double[] solution = getSolution(rrefMatrix);
            System.out.println("The solution to the system is:");
            for (int i = 0; i < solution.length; i++) {
                System.out.printf("x%d = %8.4f\n", i + 1, solution[i]);
            }
        } else {
            System.out.println("The system of equations is inconsistent. Solving using least squares method.");
            double[] solution = solveLeastSquares(matrix, b);
            System.out.println("The least squares solution to the system is:");
            for (int i = 0; i < solution.length; i++) {
                System.out.printf("x%d = %8.4f\n", i + 1, solution[i]);
            }
        }
    }

    public static double[][] rref(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int lead = 0;
        for (int r = 0; r < rows; r++) {
            if (lead >= cols) {
                return matrix;
            }
            int i = r;
            while (matrix[i][lead] == 0) {
                i++;
                if (i == rows) {
                    i = r;
                    lead++;
                    if (cols == lead) {
                        return matrix;
                    }
                }
            }

            // Swap rows i and r
            double[] temp = matrix[i];
            matrix[i] = matrix[r];
            matrix[r] = temp;

            double lv = matrix[r][lead];
            for (int j = 0; j < cols; j++) {
                matrix[r][j] /= lv;
            }

            for (i = 0; i < rows; i++) {
                if (i != r) {
                    lv = matrix[i][lead];
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] -= lv * matrix[r][j];
                    }
                }
            }
            lead++;
        }
        return matrix;
    }

    public static boolean checkConsistency(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            boolean allZero = true;
            for (int j = 0; j < cols - 1; j++) { // Check only coefficient part
                if (matrix[i][j] != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero && matrix[i][cols - 1] != 0) { // Right-hand side is not zero
                return false;
            }
        }
        return true;
    }

    public static double[] getSolution(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[] solution = new double[cols - 1];

        for (int i = rows - 1; i >= 0; i--) {
            int pivotCol = -1;
            for (int j = 0; j < cols - 1; j++) {
                if (matrix[i][j] != 0) {
                    pivotCol = j;
                    break;
                }
            }
            if (pivotCol == -1) {
                continue; // Skip this row, it doesn't contribute to any solution
            }
            solution[pivotCol] = matrix[i][cols - 1];
            for (int j = pivotCol + 1; j < cols - 1; j++) {
                solution[pivotCol] -= matrix[i][j] * solution[j];
            }
        }
        return solution;
    }

    public static double[] solveLeastSquares(double[][] A, double[] b) {
        int rows = A.length;
        int cols = A[0].length;

        // Compute A^T * A
        double[][] ATA = new double[cols][cols];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < rows; k++) {
                    ATA[i][j] += A[k][i] * A[k][j];
                }
            }
        }

        // Compute A^T * b
        double[] ATb = new double[cols];
        for (int i = 0; i < cols; i++) {
            for (int k = 0; k < rows; k++) {
                ATb[i] += A[k][i] * b[k];
            }
        }

        // Solve ATA * x = ATb using Gaussian elimination
        double[][] augmentedMatrix = new double[cols][cols + 1];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols; j++) {
                augmentedMatrix[i][j] = ATA[i][j];
            }
            augmentedMatrix[i][cols] = ATb[i];
        }

        double[][] rrefMatrix = rref(augmentedMatrix);

        double[] solution = new double[cols];
        for (int i = 0; i < cols; i++) {
            solution[i] = rrefMatrix[i][cols];
        }

        return solution;
    }
}
