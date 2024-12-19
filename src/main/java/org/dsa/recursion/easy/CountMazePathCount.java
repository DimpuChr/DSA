package org.dsa.recursion.easy;

public class CountMazePathCount {

    public static void main(String[] args) {

        int n =3;
        int m =3;
        System.out.println(countPath(0,0,n,m));
    }

    public static int countPath(int i, int j, int n, int m){

        if(i== n || j == m){
            return 0;
        }

        if(i == n-1 && j == m-1){
            return 1;
        }

        int downcount = countPath(i+1, j, n, m);
        int rightCount = countPath(i, j+1,n ,m);
        return downcount + rightCount;
    }
}
