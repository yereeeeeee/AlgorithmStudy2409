import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   
    int n = sc.nextInt();
    int k = sc.nextInt();
    int rank = 1;

    int[][] arr = new int[n+1][3];
    
    for(int i = 1; i <= n; i++) {
      int num = sc.nextInt();
      arr[num][0] = sc.nextInt();     //금메달
      arr[num][1] = sc.nextInt();     //은메달
      arr[num][2] = sc.nextInt();     //동메달
    }

    for(int i = 1; i <= n; i++) {
      if(arr[i][0] > arr[k][0]) rank++;                       //금메달비교
      else if(arr[i][0] == arr[k][0] && arr[i][1] > arr[k][1]) rank++;      //은메달비교
      else if(arr[i][0] == arr[k][0] && arr[i][1] == arr[k][1] && arr[i][2] > arr[k][2]) rank++;
    }  //동메달비교

    System.out.println(rank);
  }
}