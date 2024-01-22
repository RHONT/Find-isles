/**
 * Задачка. Найти количество островов
 * Пример
 * 1 0 1
 * 1 0 1
 * 1 0 1 - 2 острова
 *
 * 1 0 1
 * 0 1 0
 * 1 0 1 - 5 островов
 */
public class Main {
    public static void main(String[] args) {
        char[][] arr={
                {'1','0','1'},
                {'0','1','1'},
                {'1','0','1'}
        };
        int countIsles=calcIsles(arr);
        System.out.println(countIsles);

        System.out.println("Hello world!");
    }

    private static int calcIsles(char[][] arr) {
        int result=0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (Character.isDigit(arr[i][j])){
                    if (arr[i][j]=='1') {
                       result++;
                       searchDust(arr,i,j);
                    }
                }
            }

        }

        return result;
    }

    private static void searchDust(char[][] arr, int i, int j) {
        for (int k = i; k < arr[0].length; k++) {
            if (arr[k][j]=='0' || arr[k][j]=='x') {
                arr[k][j]='x';
                break;
            } else {
                arr[k][j]='x';
                searchLeft(arr,k,j-1);
                searchRight(arr,k,j+1);
            }
        }

    }

    private static void searchRight(char[][] arr, int i, int j) {
        for (int k = j; k <arr.length ; k++) {
            if (arr[i][k]=='0' || arr[i][k]=='x') {
                arr[i][k]='x';
                break;
            } else {
                arr[i][k]='x';
            }
        }
    }

    private static void searchLeft(char[][] arr, int i, int j) {
        for (int k = j; k >=0 ; k--) {
            if (arr[i][k]=='0' || arr[i][k]=='x') {
                arr[i][k]='x';
                break;
            } else {
                arr[i][k]='x';
            }
        }
    }


}