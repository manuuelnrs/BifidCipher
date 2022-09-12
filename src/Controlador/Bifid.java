/**
 * @author Juan Manuel Nava Rosales
 * @date 11/septiembre/2022
 * @brief Bidif Cipher Algorithm - Cryptography - Practice 1
 * @version 1.0
 */
package Controlador;
import Vista.Principal;

public class Bifid {
    public static int[][] PermutAlphabet = {{'_','0','1','2','3','4'},
                                            {'0','E','N','C','R','Y'},
                                            {'1','P','T','A','B','D'},
                                            {'2','F','G','H','I','K'},
                                            {'3','L','M','O','Q','S'},
                                            {'4','U','V','W','X','Z'}};
    
    public static void main(String[] args) {
        String key = "ENCRYPT";
        
        // MAIN PROGRAM DISPLAY //
        Principal.GUIPrincipal();
        
        //Desarrollo en consola de Practica 1
        System.out.println( "Key: " + key );
        String message = "MEET ME ON FRIDAY";
        String cipherText = Encryption( PermutAlphabet, message );   
        System.out.println( "Cipher Text: "+ cipherText );
        String messageOrg = Decryption( PermutAlphabet, cipherText );
        System.out.println("Decipher Text : "+ messageOrg);
        watchTable(PermutAlphabet);
        // inciso 2 (a)
        System.out.println("\n\tEncrypt: BRING ALL YOUR MONEY");
        String cipherText2 = Encryption( PermutAlphabet, "BRING ALL YOUR MONEY" );
        System.out.println( "Cipher Text: "+ cipherText2 );
        // inciso 2 (b) 
        System.out.println("\n\tDecrypt: PDRRNGBENOPNIAGGF");
        String messageOrg2 = Decryption( PermutAlphabet, "PDRRNGBENOPNIAGGF" );
        System.out.println("Decipher Text : "+ messageOrg2);
    }
    
    /**
    * @brief función que permite ver la tabla en consola
    * @param tabla tipo Array 2D
    */
    static void watchTable( int[][] x ){
        for( int i = 0 ; i < x.length ; i++ ){
            for( int j = 0 ; j < x[0].length ; j++ )
                System.out.print( (char)(x[i][j]) );
            System.out.println( "" );
        }
    }
    
    /**
    * @brief función que aplica algoritmo de Bidif para cifrar mensaje
    * @param table tipo Array 2D
    * @param message mensaje original a cifrar
    * @return String Cipher Text
    */
    public static String Encryption( int[][] table, String message ){
        message = message.replace(" ","");
        int indices[] = new int[ message.length()*2 ];
        
        // Búsqueda de pares (índices)
        for( int pos = 0 ; pos < indices.length/2 ; pos++ )        //Iterador de indices
            for( int row = 1 ; row < table.length ; row++ )        //Iterador por filas de Tabla
                for( int col = 1 ; col < table[0].length ; col++ ) //Iterador por columnas de Tabla
                    if( table[row][col] == message.charAt(pos) ){
                        indices[pos]=row-1;
                        indices[pos+message.length()]=col-1;
                    }
        
        // Búsqueda de cipherText a partir de índices
        String cipherT = "";
        for( int ind = 0 ; ind < indices.length ; ind+=2 )      //Iterador de Indices
            for( int row = 1 ; row < table.length ; row++)      //Iterador por filas de Tabla
                for( int col = 1 ; col < table[0].length ; col++)//Iterador por columnas de Tabla
                    if( indices[ind] == (row-1) && indices[ind+1] == (col-1) )
                        cipherT += (char)table[row][col];
        return cipherT;
    }
    
    /**
    * @brief función que aplica algoritmo de Bidif para decifrar mensaje
    * @param table tipo Array 2D
    * @param cipherT Cipher Text
    * @return String Message Decrypt
    */
    public static String Decryption(int[][] table, String cipherT){
        int indices[] = new int[ cipherT.length()*2 ];
        
        // Búsqueda de pares (índices)
        for( int pos = 0, i = 0 ; pos < indices.length ; pos+=2, i++ )        //Iterador de indices
            for( int row = 1 ; row < table.length ; row++ )        //Iterador por filas de Tabla
                for( int col = 1 ; col < table[0].length ; col++ ) //Iterador por columnas de Tabla
                    if( table[row][col] == cipherT.charAt(i) ){
                        indices[pos]=row-1;
                        indices[pos+1]=col-1;
                    }
        
        // Búsqueda del mensaje a partir de índices
        String message = "";
        for( int ind = 0 ; ind < indices.length/2 ; ind++ )      //Iterador de Indices
            for( int row = 1 ; row < table.length ; row++)      //Iterador por filas de Tabla
                for( int col = 1 ; col < table[0].length ; col++)//Iterador por columnas de Tabla
                    if( indices[ind] == (row-1) && indices[ind+cipherT.length()] == (col-1) )
                        message += (char)table[row][col];
        return message;
    }
    
} //End Class