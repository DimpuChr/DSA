package org.dsa.recursion.maze;

import java.util.ArrayList;
import java.util.List;

public class PathCount {

    // suppose you have 3*3 matrix
    // how many ways we can reach the last position
    //just return the total path counts to reach the last position
    // the intend here is we are breaking a large proble to smaller by moving down and right
    //until we reach the base column we found one possible answer , like that it will return all possible counts

    public static void main(String[] args) {
        System.out.println(countPaths(3,3));
        printPaths(3,3,"");
        System.out.println(printPathslist(3,3,""));
        System.out.println(printPathslistDiagnal(3,3,""));

    }

    static int countPaths(int row, int col){

        //the base condition is like any row or col reaches 1 we have only one possible way to reach last position is 1 so returning 1
        if(row ==1 || col == 1){
            return 1;
        }

        //while it going down we are reducing the row count by 1
        int left = countPaths(row-1, col);
        //while it going right so reducing col by 1
        int right = countPaths(row, col-1);
        return left + right;
    }


    static void printPaths(int row, int col,String processed){

        //the base condition is like any row or col reaches 1 we have only one possible way to reach last position is 1 so returning 1
        if(row ==1 && col == 1){
            System.out.println(processed);
            return;
        }

        //while it going down we are reducing the row count by 1
        if(row > 1){
            printPaths(row-1, col,processed + 'D');
        }
        //while it going right so reducing col by 1
        if(col >1){
            printPaths(row, col-1,processed + 'R');
        }
    }

    //return list
    static List<String> printPathslist(int row, int col, String processed){

        //the base condition is like any row or col reaches 1 we have only one possible way to reach last position is 1 so returning 1
        if(row ==1 && col == 1){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        List<String> list = new ArrayList<>();
        //while it going down we are reducing the row count by 1
        if(row > 1){
            list.addAll(printPathslist(row-1, col,processed + 'D'));
        }
        //while it going right so reducing col by 1
        if(col >1){
            list.addAll(printPathslist(row, col-1,processed + 'R'));
        }

        return list;
    }

    //return Diagonal
    static List<String> printPathslistDiagnal(int row, int col, String processed){

        //the base condition is like any row or col reaches 1 we have only one possible way to reach last position is 1 so returning 1
        if(row ==1 && col == 1){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        List<String> list = new ArrayList<>();
        if(row > 1 && col > 1){
            list.addAll(printPathslistDiagnal(row-1, col-1,processed + 'V'));
        }
        //while it going down we are reducing the row count by 1
        if(row > 1){
            list.addAll(printPathslistDiagnal(row-1, col,processed + 'D'));
        }
        //while it going right so reducing col by 1
        if(col >1){
            list.addAll(printPathslistDiagnal(row, col-1,processed + 'R'));
        }


        return list;
    }
}
