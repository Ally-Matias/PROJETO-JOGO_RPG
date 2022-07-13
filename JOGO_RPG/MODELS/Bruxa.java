package Models;

import java.util.Random;

import Controllers.Color;

public class Bruxa extends Npc {
    public static int level = 6;
    public static Random aleatorio = new Random();
    public int veneno = 1;

    //Praticante de artes místicas e criadora de poções e venenos.
    public Bruxa() {
        this.nome = toString();
        this.pontosSaude = 35 + aleatorio.nextInt(20);
        this.classeDeArmadura = 10+level-3;
        this.dano = 10;
        this.xp = 20;
    }

    public int turno(Player player){
        System.out.println();
        System.out.println(Color.YELLOW +"A bruxa te ataca com uma adaga mágica"+Color.RESET+"\n");
        Random aleatorio = new Random();
        int ataque = aleatorio.nextInt(20) + level;
        int danoAtaque = aleatorio.nextInt(dano) + level;
        int danoVeneno = veneno;
        if(ataque>player.classeArmadura){
            System.out.println(Color.YELLOW +"Ele te acerta causando " + Color.RED+danoAtaque+Color.YELLOW + " de dano e "+ Color.GREEN+danoVeneno+Color.YELLOW +" de dano de veneno"+Color.RESET+"\n");
            veneno = veneno*2;
            return danoAtaque+danoVeneno;
        }else{
            if(ataque<10){
                System.out.println(Color.YELLOW +"Porem erra"+Color.RESET+"\n");
            }else{
                System.out.println(Color.YELLOW +"Mas voce a "+Color.CYAN+"bloqueia"+Color.RESET+"\n");
            }
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Bruxa";
    }

    
}