package Controllers;

public class Utility {

    //Método para checar se uma String é capaz de ser convertida a um inteiro.
    public static boolean parseCheck(String text){
        int x;
        try{
            x = Integer.parseInt(text);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
