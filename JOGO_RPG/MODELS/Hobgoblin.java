package Models;

import java.util.Random;

import Controllers.Color;

public class Hobgoblin extends Npc {
    public static int level = 2;
    public static Random aleatorio = new Random();

    public Hobgoblin() {
        this.nome = toString();
        this.pontosSaude = 12 + aleatorio.nextInt(6);
        this.classeDeArmadura = 10+level;
        this.dano = 7;
        this.xp = 20;
    }

    public int turno(Player player){
        System.out.println();
        System.out.println(Color.YELLOW +"O Hobgoblin te ataca com um grande porrete de madeira"+Color.RESET+"\n");
        Random aleatorio = new Random();
        int ataque = aleatorio.nextInt(20) + level;
        int danoAtaque = aleatorio.nextInt(dano) + level;
        if(ataque>player.classeArmadura){
            System.out.println(Color.YELLOW +"Ele te acerta causando " + Color.RED+danoAtaque+Color.YELLOW + " de dano"+Color.RESET+"\n");
            return danoAtaque;
        }else{
            if(ataque<10){
                System.out.println(Color.YELLOW +"Porem erra"+Color.RESET+"\n");
            }else{
                System.out.println(Color.YELLOW +"Mas voce o "+Color.CYAN+"bloqueia"+Color.RESET+"\n");
            }
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Hobgoblin";
    }

    
}
