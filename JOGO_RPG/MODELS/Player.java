package Models;

import java.util.Scanner;

import Controllers.*;

public abstract class Player implements Comparable{
    public String nome;
    public short classe;
    public int pontosSaude;
    public int pontosSaudeMax;
    public int classeArmadura = 10;
    public long pontosExperiencia = 0;
    public int level = 1;
    public Item armaduraEquip = null;
    public Item armaEquip = null;
    public int pontosExperienciaMax = 50;
    public int armaBuffer;


    public abstract void setValues();
    public abstract int turno(Npc npc);
    public abstract int atacar(int ca);
    public abstract String toString();

    public void curarTotal(){
        pontosSaude = pontosSaudeMax;
    }

    
    public static boolean batalha(Npc npc, Player player){
        System.out.println(Color.YELLOW+"Voce inicia uma batalha com "+ Color.WHITE + npc + Color.YELLOW+"!!!"+Color.RESET+"\n");
        int turno =0;
        while(true){
            turno++;
            System.out.print(Color.WHITE_BACKGROUND+Color.BLACK+"TURNO - "+turno+Color.RESET+Color.RESET);
            npc.pontosSaude = npc.pontosSaude - player.turno(npc);
            if(npc.pontosSaude<=0) {
                System.out.print("# -------------------------------------------------------------- #\n\n");
                System.out.print(Color.GREEN+"- VITORIA - "+Color.RESET);
                System.out.print(Color.RED+npc+Color.RESET+" foi derrotado\n");
                player.adicionarXp(npc.xp);
                System.out.println("\n# -------------------------------------------------------------- #\n");
                player.armaBuffer =0;
                return true;
            }else if(player.pontosSaude<=0){
                System.out.print("# -------------------------------------------------------------- #\n\n");
                System.out.print(Color.RED+"- VOCE MORREU -"+Color.RESET);
                System.out.println("# -------------------------------------------------------------- #\n");
                player.armaBuffer =0;
                return false;
            }
            System.out.println("# -------------------------------------------------------------- #\n");
            System.out.print(Color.WHITE_BACKGROUND+Color.RED+"TURNO - "+turno+Color.RESET);
            player.pontosSaude = player.pontosSaude - npc.turno(player);
            if(player.pontosSaude<=0){
                System.out.println("\n"+Color.RED+"- VOCE MORREU -"+Color.RESET);
                player.armaBuffer =0;
                return false;
            }
            System.out.println("# -------------------------------------------------------------- #\n");
        }
    }

    public void mostraPlayer(){
        System.out.println(toString());
        if(pontosSaude > (pontosSaudeMax/2)){
          System.out.println("HP: "+Color.BLACK_BACKGROUND+Color.GREEN + pontosSaude+Color.WHITE+"/"+Color.GREEN+pontosSaudeMax+Color.RESET + " -- Armadura: "+Color.BLACK_BACKGROUND+Color.YELLOW+classeArmadura+ Color.RESET+" -- Equipado: " +Color.BLACK_BACKGROUND + armaEquip + Color.RESET
        + " -- XP:"+Color.BLACK_BACKGROUND+Color.PURPLE + pontosExperiencia+Color.WHITE+"/"+Color.PURPLE+pontosExperienciaMax+Color.RESET);
        }else{
          if(pontosSaude>(pontosSaudeMax/4)){
            System.out.println("HP: "+Color.BLACK_BACKGROUND+Color.YELLOW + pontosSaude+Color.WHITE+"/"+Color.GREEN+pontosSaudeMax+Color.RESET + " -- Armadura: "+Color.BLACK_BACKGROUND+Color.YELLOW+classeArmadura+ Color.RESET+" -- Equipado: " +Color.BLACK_BACKGROUND + armaEquip + Color.RESET
        + " -- XP:"+Color.BLACK_BACKGROUND+Color.PURPLE + pontosExperiencia+Color.WHITE+"/"+Color.PURPLE+pontosExperienciaMax+Color.RESET);
          }else{
            System.out.println("HP: "+Color.BLACK_BACKGROUND+Color.RED + pontosSaude+Color.WHITE+"/"+Color.GREEN+pontosSaudeMax+Color.RESET + " -- Armadura: "+Color.BLACK_BACKGROUND+Color.YELLOW+classeArmadura+ Color.RESET+" -- Equipado: " +Color.BLACK_BACKGROUND + armaEquip + Color.RESET
        + " -- XP:"+Color.BLACK_BACKGROUND+Color.PURPLE + pontosExperiencia+Color.WHITE+"/"+Color.PURPLE+pontosExperienciaMax+Color.RESET+Color.RESET);
          }
        }
        
    }  

    public void adicionarXp(int xp){
        System.out.println(Color.YELLOW+"Voce ganhou "+Color.PURPLE+xp+Color.YELLOW+" pontos de expeiencia"+Color.RESET);
        pontosExperiencia = pontosExperiencia+xp;
        while(true){
            if(pontosExperiencia>=pontosExperienciaMax){
                level++;
                pontosExperienciaMax = pontosExperienciaMax*2;
                setValues();
                System.out.println(Color.YELLOW+"\nVoce subiu de nivel!!"+Color.RESET);
            }else{
                break;
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public Long getExperiencePoints() {
        return pontosExperiencia;
    }

    public void setExperiencePoints(Long experiencePoints) {
        this.pontosExperiencia = experiencePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public Integer getHealthPoints() {
        return pontosSaude;
    }
    
    public void setHealthPoints(Integer healthPoints) {
        this.pontosSaude = healthPoints;
    }
    
    public void setArmaduraEquip(Item armadura) {
        classeArmadura = 10 + armadura.bonusCa;
        this.armaduraEquip = armadura;
    }

    public void setArmaBuffer(int armaBuffer) {
        this.armaBuffer = armaBuffer;
    }
    public int getArmaBuffer() {
        return armaBuffer;
    }
    public Integer getClasseArmadura() {
        return classeArmadura;
    }

}
