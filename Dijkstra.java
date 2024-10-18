import java.util.*;

public class Dijkstra
{
  static int[][] adj;
  static int[] visited;
  static int[][] dist;
  public static void main(String args[])
  {
    Scanner take = new Scanner(System.in);
    System.out.println("Enter the number of nodes ");
    int n = take.nextInt();
    adj = new int[n][n];
    visited = new int[n];
    dist = new int[n][2];
    System.out.println("Enter the weights from 0 to "+n);
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        System.out.print("Enter the weights from "+i+" to "+j+" ");
        adj[i][j]=take.nextInt();
      }
    }
    dist[0][0]=0;
    dist[0][1]=0;
    for(int i=1;i<n;i++){
      if(adj[0][i]!=-1){
        dist[i][0]=adj[0][i];
        dist[i][1]=0;
      }
      dist[i][0]=Integer.MAX_VALUE;
    }
    Queue<Integer> q = new LinkedList<>();
    q.offer(0);
    while(!q.isEmpty()){
      //System.out.println("ENtered");
      int current = q.poll();
      if(visited[current]==0){
        visited[current]=1;
        for(int i=0;i<n;i++){
          if(current!=i && adj[current][i]!=-1){
            q.offer(i);
            if(dist[i][0]>(adj[current][i]+dist[current][0])){
              dist[i][0]=adj[current][i]+dist[current][0];
              dist[i][1]=current;
            }
          }
        }
      }
    }
    for(int i=0;i<n;i++){
      System.out.println(i+" ("+dist[i][0]+","+dist[i][1]+")");
    }

  }
}