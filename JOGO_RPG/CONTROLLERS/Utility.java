package Controllers;

public class Utility {
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
