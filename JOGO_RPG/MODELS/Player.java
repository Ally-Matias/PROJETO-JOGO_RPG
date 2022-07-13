package Models;

import java.util.Scanner;

import Controllers.*;

public abstract class Player implements Comparable{
    public String nome;
    public short classe;
    public int pontosSaude;
    public int pontosSaudeMax;

    //a classe de armadura serve como uma quantidade mínima a ser superada pela tentativa de
    // ataque do inimigo para poder acertar um ataque
    public int classeArmadura = 10;

    public long pontosExperiencia = 0;
    public int level = 1;

    //Armadura oferece ajustes de classeArmadura em seus atributos, já a Arma possui o atributo de dano para o cálculo no método de ataque.
    public Item armaduraEquip = null;
    public Item armaEquip = null;

    public int pontosExperienciaMax = 50;

    //armaBuffer é uma variavel sem inicialização no construtor que serve para guardar
    //valores extras de dano temporarios e restritos a uma batalha
    public int armaBuffer;

    //Método necessário para a evolução de nível em qualquer Player, mas que varia dependendo
    //da subclasse que o invcoa, pois cada classe evolui de maneira diferente.
    public abstract void setValues();

    //Método que faz o Player declarar uma açao de combate, é necessário em todo Player porém cada
    //subclasse de player o usa de maneira diferente.
    public abstract int turno(Npc npc);
    public abstract int atacar(int ca);
    public abstract String toString();

    //método chamado ao terminar um cenário.
    //Para que o Player fique pronto e curado para realizar novos cenários 100%.
    public void curarTotal(){
        pontosSaude = pontosSaudeMax;
    }

    
    //Método estático usado toda vez que alguma batalha entre Player e um Npc deve ocorrer.
    //O método recebe como parametros um Player e um Npc e inicia um loop infinito que chama os métodos de turno de ambos.
    //O loop encerra caso os pontosSaude de Npc cheguem a zero, retornando true, significando a vitória do Player.
    //Já no caso dos pontosSaude de Player também chegarem a zero, retorna false, significando a derrota e morte do Player.
    public static boolean batalha(Npc npc, Player player){
        System.out.println(Color.YELLOW+"Voce inicia uma batalha com "+ Color.WHITE + npc + Color.YELLOW+"!!!"+Color.RESET+"\n");
        int turno =0;
        while(true){
            //Turnos recebem como parametro o adversário, pois as ações tomadas dependem dos atributos do adversário.
            //Eles retornam um valor inteiro, que representa o dano casuado naquele turno.
            //O Npc recebe dano nos pontosSaude de acordo com o dano que o método de turno do Player retornou.
            //Já o Player recebe dano nos pontosSaude de acordo com o dano que o método de turno do Npc retornou.
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

    //Mostr atributos do Player no determinado momento que sejam relevantes ao combate
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

    //Adiciona XP e aciona o metodo setValues para ajustar os atributos de acordo com o nível
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
    
    //Ajusta a classeArmadura atual para que fique de acordo com o bonus gerado pela armaduraEquip
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
