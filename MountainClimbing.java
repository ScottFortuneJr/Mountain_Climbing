package com.gradescope.mountainclimbing;

import java.util.ArrayList;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner; // Import the Scanner class to read text files
import java.lang.String;
import java.lang.Math;

public class MountainClimbing{

    /**
     * Reads the file, runs the algorithm, outputs a ArrayList of Integers
     */
    public ArrayList<Integer> mountainClimbing() throws java.io.FileNotFoundException{
        ArrayList<Integer> outputArrayList;
        outputArrayList = new ArrayList<Integer>();

        /* FILL ME IN */
        //initialize filer reader
        File input = new File("input");
        Scanner reader = new Scanner(input);
        int numTests = reader.nextInt();
        int numRows = 0;
        int numColumns = 0;
        for(int i = 0; i < numTests; i++){
            numRows = reader.nextInt();
            numColumns = reader.nextInt();
            int[][] G = new int[numRows][numColumns];
            int[][] S = new int[numRows][2];
            for(int j = 0; j < numRows; j++){
                for(int k = 0; k < numColumns; k++){
                    G[j][k] = reader.nextInt();
                    //DELETE System.out.println(G[j][k]);
                }
            }
            //perform algorithm on each test
            outputArrayList.add(mountainHelper(G,S));
        }
        reader.close();
        return outputArrayList;
    }

    private static int mountainHelper(int[][] G, int[][] S){
        int N = G.length;
        int M = G[0].length;
        S[0][0] = G[0][0];
        //initialize first row
        for(int i = 1; i < N; i++){
            S[i][0] = S[i-1][0] + G[i][0]; 
        }
        //fill in the rest of the rows
        for(int k = 1; k < M; k++){
            S[0][1] = S[0][0] + G[0][k];
            for(int j = 1; j < N; j++){
                //choose between going right or down
                S[j][1] = G[j][k] + Math.max(S[j-1][1], S[j][0]);
            }
            for(int l = 0; l < N; l++){
                S[l][0] = S[l][1];
            }
        }
        //System.out.println(S[N-1][1]);
        return S[N-1][1];
    }

     //public static void main(String[] args) throws FileNotFoundException {
     //    mountainClimbing();
     //}
}

