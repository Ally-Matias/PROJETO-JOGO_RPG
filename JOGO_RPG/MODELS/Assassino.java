package Models;
import java.util.Random;
import java.util.Scanner;

import Controllers.*;

public class Assassino extends Player{

    public Assassino(String nome) {
        this.nome = nome;
        this.classe = 3;
        armaEquip = new Item(80, "Espada Curta", 6, 0);
        armaduraEquip = new Item(81, "Armadura de Peles", 1);
        setArmaduraEquip(armaduraEquip); 
        setValues();
        pontosSaude = pontosSaudeMax;
    }

    public Assassino(String nome, int pontosSaudeMax, long pontosExperiencia, int level, Item armaduraEquip, Item armaEquip){
        this.nome = nome;
        this.classe = 3;
        this.pontosSaude = pontosSaudeMax;
        this.pontosSaudeMax = pontosSaudeMax;
        this.pontosExperiencia = pontosExperiencia;
        this.level = level;
        int cont = 50;
        while(cont<this.pontosExperiencia){
          cont = cont*2;
        }
        this.pontosExperienciaMax = cont;
        this.armaduraEquip = armaduraEquip;
        setArmaduraEquip(armaduraEquip);
        this.armaEquip = armaEquip;
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
      + " -- XP:"+Color.BLACK_BACKGROUND+Color.PURPLE + pontosExperiencia+Color.WHITE+"/"+Color.PURPLE+pontosExperienciaMax+Color.RESET);
        }
      }
    }

    public void setValues() {
        Random aleatorio = new Random();
        if(level ==1){
          pontosSaudeMax = 8;
        }else{
          pontosSaudeMax = pontosSaudeMax + (aleatorio.nextInt(8)) + 2;
        }
    }

    public int atacar(int ca) {
        Random aleatorio = new Random();
        int ataqueBase = aleatorio.nextInt(20);
        int ataque = ataqueBase + level;
        int dano = aleatorio.nextInt(armaEquip.dano) + level + armaBuffer;
        if(ataque>ca){
            if(ataqueBase>=19){
                System.out.println("- Voce ataca com " + armaEquip);
                System.out.println("- DANO CRITICO, inflingiu " + (dano*2) + " de dano ");
                return (dano*2);
            }else{
                System.out.println("- Voce ataca com " + armaEquip + " causando " + dano + " de dano");
                return dano;
            }
        }else{
            if(ataque<10){
              System.out.println(Color.YELLOW+"- Voce tenta atacar porem erra !"+Color.RESET+"\n\n"); 
            }else{
              System.out.println(Color.YELLOW+"- Voce tenta atacar porem seu ataque foi "+Color.CYAN+"bloqueado"+Color.RESET+"\n\n");
            }
            return 0;
        }
    }

    public int turno(Npc npc) {
      setArmaduraEquip(armaduraEquip);
      getArmaBuffer();
        while(true){
          Scanner scan = new Scanner(System.in);
          String input, opc;
          System.out.println();
          mostraPlayer();
          System.out.print("\n"+Color.BLACK_BACKGROUND+"Escolha sua proxima acao:"+Color.RESET+Color.RESET);
          System.out.print("\n"+Color.BLACK_BACKGROUND +"1. "+Color.YELLOW+"Ataque Fisico "+Color.RESET);
          System.out.print(Color.BLACK_BACKGROUND +"/ 2. "+Color.YELLOW+"Habilidades "+Color.RESET);
          System.out.print(Color.BLACK_BACKGROUND +"/ 0. "+Color.YELLOW+"Nao Fazer Nada '-'"+Color.RESET+"\n");
          input = scan.next();
          if(Utility.parseCheck(input)){input = input;}else{input = "4";}
          if(Integer.parseInt(input) == 1){
            return atacar(npc.classeDeArmadura);
          }else if (Integer.parseInt(input) == 2){
            while(true){
              System.out.println("Que habilidade deseja usar?\n");
              System.out.println("1. "+Color.RED+"Golpe Letal"+Color.RESET+" -- 2. "+Color.CYAN+"Afiar Arma"+Color.RESET+" -- 0. SAIR");
              opc = scan.next();
              if(Utility.parseCheck(opc)){opc = opc;}else{opc = "100";}
              if(Integer.parseInt(opc) == 1){
                return golpeLetal(npc.classeDeArmadura);
              }else if(Integer.parseInt(opc) == 0){
                break;
              }else if(Integer.parseInt(opc) == 2){
                return afiar();
              }else{
                System.out.println("\nDigite um comando valido");
              }
            }
          }else if(Integer.parseInt(input) == 0){
            System.out.println("- Voce fica imovel");
            return 0;
          }else{
            System.out.println("Digite um comando valido");
          }
        }

    }


    @Override
    public String toString() {
      
      if(level<10){
        return "[ " + nome + " - "+Color.RED+"Assassino"+Color.RESET+" - Nivel: "+Color.CYAN+level+Color.RESET+" ]";
      }else{
        if(level<20){
          return "[ " + nome + " - "+Color.RED+"Carrasco"+Color.RESET+" - Nivel: "+Color.CYAN+level+Color.RESET+" ]";
        }else{
          return "[ " + nome + " - "+Color.RED+"Executor"+Color.RESET+" - Nivel: "+Color.CYAN+level+Color.RESET+" ]";
        }
      }
    }

    public int golpeLetal(int ca){
      int dano;
      if(level<4){
        System.out.println(Color.YELLOW +"- Voce se concentra e tenta acertar um ponto vital do inimigo"+ Color.RESET);
        dano = atacar(ca+2);
        return dano*2;
      }else if(level >= 5 && level <=8){
        System.out.println(Color.YELLOW +"- Voce se concentra bastante e tenta acertar um golpe fatal no inimigo"+ Color.RESET);
        dano = atacar(ca+4);
        return (dano*2)+3;
      }else{
        System.out.println(Color.YELLOW +"- Voce se concentra e tenta acertar um golpe capaz de matar o inimigo"+ Color.RESET);
        dano = atacar(ca+6);
        return (dano*2)+15;
      }
      
    }

    public int afiar(){
      if(level<4){
        if(armaBuffer==0){
          System.out.println(Color.YELLOW +"- Voce usa um composto mistico capaz de afiar sua arma temporariamente\n"+ Color.RESET);
          armaBuffer = 1;
        }else{
          System.out.println(Color.YELLOW +"- Voce usa um composto mistico capaz de afiar sua arma ao maximo!\n"+ Color.RESET);
          armaBuffer = 2;
        }
        return 0;
      }else if(level >= 5 && level <=8){
        if(armaBuffer==0){
          System.out.println(Color.YELLOW +"- Voce usa um composto mistico capaz de afiar sua arma temporariamente\n"+ Color.RESET);
          armaBuffer = 3;
        }else{
          System.out.println(Color.YELLOW +"- Voce usa um composto mistico capaz de afiar sua arma ao maximo!\n"+ Color.RESET);
          armaBuffer = 5;
        }
        return 0;
      }else{
        if(armaBuffer==0){
          System.out.println(Color.YELLOW +"- Voce usa um composto mistico capaz de afiar sua arma temporariamente\n"+ Color.RESET);
          armaBuffer = level-4;
        }else{
          System.out.println(Color.YELLOW +"- Voce usa um composto mistico capaz de afiar sua arma ao maximo!\n"+ Color.RESET);
          armaBuffer = level;
        }
        return 0;
      }
    }

    @Override
    public int compareTo(Object outroPlayer) {
        if(this.pontosExperiencia<((Player) outroPlayer).getExperiencePoints()) return 1;
        else if(this.pontosExperiencia==((Player) outroPlayer).getExperiencePoints()) return 0;
        else return -1;
    }
}
