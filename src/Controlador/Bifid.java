/**
 * @author Juan Manuel Nava Rosales
 * @date 11/septiembre/2022
 * @version 1.0
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
        String cipherText = Encryption( PermutAlphabet, message );       
        
        System.out.println( " Cipher Text : "+ cipherText );
        watchTable(PermutAlphabet);
    }
    
    static void watchTable( int[][] x ){
        for( int i = 0 ; i < x.length ; i++ ){
            for( int j = 0 ; j < x[0].length ; j++ )
                System.out.print( (char)(x[i][j]) );
            System.out.println( "" );
        }
    }
    
    static String Encryption( int[][] table, String message ){
        int indices[] = new int[ message.length()*2 ];
        
        // Búsqueda de pares (índices)
        for( int pos = 0 ; pos < indices.length/2 ; pos++ )        //Iterador de indices
            for( int row = 1 ; row < table.length ; row++ )        //Iterador por filas de Tabla
                for( int col = 1 ; col < table[0].length ; col++ ) //Iterador por columnas de Tabla
                    if( table[row][col] == message.charAt(pos) ){
                        indices[pos]=row-1;
                        indices[pos+4]=col-1;
                    }
        
        for( int i = 0; i < indices.length;i++)
            System.out.print(indices[i]);
        
        String cipherT = "";
        // Búsqueda de cipherText a partir de índices
        for( int ind = 0 ; ind < indices.length ; ind+=2 )      //Iterador de Indices
            for( int row = 1 ; row < table.length ; row++)      //Iterador por filas de Tabla
                for( int col = 1 ; col < table[0].length ; col++)//Iterador por columnas de Tabla
                    if( indices[ind] == (row-1) && indices[ind+1] == (col-1) )
                        cipherT += (char)table[row][col];
        return cipherT;
    }
    
} //End Class