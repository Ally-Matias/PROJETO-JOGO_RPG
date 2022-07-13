package Models;

import java.util.Random;

import Controllers.Color;

public class Goblin extends Npc {
    public static int level = 1;
    public static Random aleatorio = new Random();

    //Pequena criatura verde que trabalha em bandos.
    public Goblin() {
        this.nome = toString();
        this.pontosSaude = 5 + aleatorio.nextInt(3);
        this.classeDeArmadura = 10+level;
        this.dano = 6;
        this.xp = 5;
    }

    public int turno(Player player){
        System.out.println();
        System.out.println(Color.YELLOW +"O Goblin tenta te atacar com uma pequena adaga"+Color.RESET+"\n");
        Random aleatorio = new Random();
        int ataque = aleatorio.nextInt(20) + level;
        int danoAtaque = aleatorio.nextInt(dano) + level;
        if(ataque>player.classeArmadura){
            System.out.println(Color.YELLOW +"Ele te acerta causando " + Color.RED+danoAtaque+Color.YELLOW + " de dano"+Color.RESET+"\n");
            return danoAtaque;
        }else{
            if(ataque<10){
                System.out.println(Color.YELLOW +"Porem erra miseravelmente :("+Color.RESET+"\n");
            }else{
                System.out.println(Color.YELLOW +"Mas voce o "+Color.CYAN+"bloqueia"+Color.RESET+"\n");
            }
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Goblin";
    }

    
}
