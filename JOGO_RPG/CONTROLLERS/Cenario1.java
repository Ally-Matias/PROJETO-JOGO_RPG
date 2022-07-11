package Controllers;

import Models.Goblin;
import Models.Player;

public class Cenario1 {
    
    public  static void capitulo1(Player player){
        System.out.print(Color.BLACK_BACKGROUND +Color.PURPLE+"BATALHA TESTE"+Color.RESET);
        System.out.print(Color.RESET+"\n\n"+Color.RESET);
        Goblin goblin = new Goblin();
        boolean batalha1;
        batalha1 = Player.batalha(goblin, player);
        if(batalha1){
            System.out.println("\n"+Color.GREEN+"Parabéns!"+Color.RESET+" Voce terminou o cenario de batalha teste");
            player.adicionarXp(0);
        }else{
            System.out.println("\nVoce "+Color.GREEN+"falhou"+Color.RESET+" esse cenario!");
            return;
        }
    }
}
