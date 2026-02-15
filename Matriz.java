public class Matriz {
    public static void main(String[] args) {
        int [][] matriz = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        recorrerMatriz(matriz,0,0);
    }
    public static void recorrerMatriz(int[][] matriz, int i, int j) {
        if (i == matriz.length) {
            return;
        }

        if (j == matriz[0].length) {
            recorrerMatriz(matriz, i + 1, 0);
            return;
        }
        System.out.println(matriz[i][j] + " ");
        recorrerMatriz(matriz, i, j + 1);
    }
}