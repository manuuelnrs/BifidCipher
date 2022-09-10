/*
*/
package Controlador;

import java.util.*;

public class Bifid {
    public static void main(String[] args) {
        String key = "ENCRYPT";
        
        int[][] PermutAlphabet = {  {'_','0','1','2','3','4'},
                                    {'0','E','N','C','R','Y'},
                                    {'1','P','T','A','B','D'},
                                    {'2','F','G','H','I','K'},
                                    {'3','L','M','O','Q','S'},
                                    {'4','U','V','W','X','Z'}};
               
        System.out.println( "Key: " + key );
        String message = "HOLA";
        
        int indices[] = new int[ message.length()*2 ];
        Encryption( PermutAlphabet, indices, message );
        
        System.out.println("INDICES: ");
        for( int i = 0; i < indices.length; i++)
            System.out.println(indices[i]);
        
        
        System.out.println("");
        watchTable(PermutAlphabet);
    }
    
    static void watchTable( int[][] x ){
        for( int i = 0 ; i < x.length ; i++ ){
            for( int j = 0 ; j < x[0].length ; j++ )
                System.out.print( (char)(x[i][j]) );
            System.out.println( "" );
        }
    }
    
    static void Encryption( int[][] x, int[] indices, String message ){
        for( int pos = 0 ; pos < indices.length/2 ; pos++ ){
            for( int row = 1 ; row < x.length ; row++ ){
                for( int col = 1 ; col < x[0].length ; col++ ){
                    if( x[row][col] == message.charAt(pos) ){
                        indices[pos]=row-1;
                        indices[pos+4]=col-1;
                        System.out.println("Pareja "+(row-1)+","+(col-1)+" de "+ (char)(x[row][col]) );
                    }
                }
            }
        }
    }
    
} //End Class