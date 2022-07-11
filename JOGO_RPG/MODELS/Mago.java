package Models;
import java.util.Random;
import java.util.Scanner;

import Controllers.*;

public class Mago extends Player{

    public Mago(String nome) {
      this.nome = nome;
      this.classe = 2;
      armaEquip = new Item(76, "Cajado", 4, 0);
      armaduraEquip = new Item(77, "robe", 0);
      setArmaduraEquip(armaduraEquip);
      setValues();
      pontosSaude = pontosSaudeMax;
    }

    public Mago(String nome, int pontosSaudeMax, long pontosExperiencia, int level, Item armaduraEquip, Item armaEquip){
      this.nome = nome;
      this.classe = 2;
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
        pontosSaudeMax = 6;
      }else{
        pontosSaudeMax = pontosSaudeMax + (aleatorio.nextInt(6)) + 1;
      }
    }

    public int atacar(int ca) {
      Random aleatorio = new Random();
      int ataque = aleatorio.nextInt(20) + level;
      int dano = aleatorio.nextInt(armaEquip.dano) + 1;
      if(ataque>ca){
          System.out.println("- Voce ataca com " + armaEquip + " causando " + dano + " de dano");
          return dano;
      }else{
          if(ataque<10){
            System.out.println("- Voce tenta atacar porem erra !"); 
          }else{
            System.out.println(Color.YELLOW+"- Voce tenta atacar porem seu ataque foi "+Color.CYAN+"bloqueado"+Color.RESET+"\n\n");
          }
          return 0;
      }
    }
    
    public int turno(Npc npc) {
      while(true){
        Scanner scan = new Scanner(System.in);
        String input, opc;
        System.out.println();
        mostraPlayer();
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Escolha sua proxima acao:"+Color.RESET+Color.RESET);
        System.out.print("\n"+Color.BLACK_BACKGROUND +"1. "+Color.YELLOW+"Ataque Fisico "+Color.RESET);
        System.out.print(Color.BLACK_BACKGROUND +"/ 2. "+Color.YELLOW+"Magias/Habilidades "+Color.RESET);
        System.out.print(Color.BLACK_BACKGROUND +"/ 0. "+Color.YELLOW+"Nao Fazer Nada '-'"+Color.RESET+"\n");
        input = scan.next();
        if(Utility.parseCheck(input)){input = input;}else{input = "4";}
          if(Integer.parseInt(input) == 1){
            return atacar(npc.classeDeArmadura);
          }else if (Integer.parseInt(input) == 2){
          if(level<3){
            while(true){
              System.out.println("Que habilidade deseja usar?\n");
              System.out.println("1. "+Color.YELLOW+"Esfera de Fogo"+Color.RESET+" -- 2. "+Color.GREEN+"Cura Simples"+Color.RESET+" -- 0. SAIR");
              opc = scan.next();
              if(Utility.parseCheck(opc)){opc = opc;}else{opc = "100";}
                if(Integer.parseInt(opc) == 1){
                  return bolaDeFogo();
                }else if(Integer.parseInt(opc) == 0){
                break;
                }else if(Integer.parseInt(opc) == 2){
                  return curaMagica();
                }else{
                  System.out.println("\nDigite um comando valido");
                }
            }
          }else if(level<8){
            while(true){
              System.out.println("Que habilidade deseja usar?\n");
              System.out.println("1. "+Color.YELLOW+"Bola de Fogo"+Color.RESET+" -- 2. "+Color.GREEN+"Cura Magica"+Color.RESET+" -- 3. "+Color.CYAN+"Relampago"+Color.RESET+" -- 0. SAIR");
              opc = scan.next();
              if(Utility.parseCheck(opc)){opc = opc;}else{opc = "100";}
                if(Integer.parseInt(opc) == 1){
                  return bolaDeFogo();
                }else if(Integer.parseInt(opc) == 0){
                break;
                }else if(Integer.parseInt(opc) == 2){
                  return curaMagica();
                }else if(Integer.parseInt(opc) == 3){
                  return projetilRaio();
                }else{
                  System.out.println("\nDigite um comando valido");
                }
            }
          }else{
            while(true){
              System.out.println("Que habilidade deseja usar?\n");
              System.out.println("1. "+Color.YELLOW+"Esfera Negra"+Color.RESET+" -- 2. "+Color.GREEN+"Cura Mestre"+Color.RESET+" -- 3. "+Color.CYAN+"Relampago Rei"+Color.RESET+" -- 4. "+Color.YELLOW+"Sol "+Color.RED+"Cruel"+Color.RESET+" -- 0. SAIR");
              opc = scan.next();
              if(Utility.parseCheck(opc)){opc = opc;}else{opc = "100";}
                if(Integer.parseInt(opc) == 1){
                  return bolaDeFogo();
                }else if(Integer.parseInt(opc) == 0){
                break;
                }else if(Integer.parseInt(opc) == 2){
                  return curaMagica();
                }else if(Integer.parseInt(opc) == 3){
                  return projetilRaio();
                }else if(Integer.parseInt(opc) == 4){
                  return solCruel();
                }else{
                  System.out.println("\nDigite um comando valido");
                }
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


    public int bolaDeFogo() {
        Random aleatorio = new Random();
        if(level < 4){
          System.out.println(Color.YELLOW +"- Voce dispara uma pequena esfera de energia flamejante."+ Color.RESET);
          int valor = aleatorio.nextInt(8) + 1 + level;
          System.out.println(Color.YELLOW + "- Você causou "+ valor + " de dano ao seu inimigo!\n" + Color.RESET);
          return valor;
        }else if(level >= 5 && level <= 8){
          System.out.println(Color.YELLOW +"- Voce dispara uma bola de fogo!!!"+ Color.RESET);
          int valor = aleatorio.nextInt(16) + 4 + level;
          System.out.println(Color.YELLOW + "- Você causou "+ valor + " de dano no seu inimigo!\n" + Color.RESET);
          return valor;
        }else{
          System.out.println(Color.YELLOW +"- Voce invoca uma enorme esfera de "+Color.BLACK+"chamas negras"+Color.RESET+" que consome tudo que ve pela frente!!!");
          int valor = aleatorio.nextInt(30) + 8 + level;
          System.out.println(Color.YELLOW + "- Você causou "+ valor + " de dano no seu inimigo!\n" + Color.RESET);
          return valor;
        }
      }

      public int curaMagica() {
        Random aleatorio = new Random();
        if(level < 4){
          System.out.println(Color.GREEN +"- Você canaliza uma luz curativa capaz de curar ferimentos"+ Color.RESET);
          int valor = aleatorio.nextInt(6) + 1 + level;
          pontosSaude = pontosSaude+valor;
          if(pontosSaude>pontosSaudeMax){pontosSaude = pontosSaudeMax;};
          System.out.println(Color.GREEN + "- Voce curou "+ valor + " pontos de saude!\n" + Color.RESET);
          return 0;
        }else if(level >= 5 && level <= 8){
          System.out.println(Color.GREEN +"- Voce gera um poderoso feixe de luz capaz de curar ferimentos"+ Color.RESET);
          int valor = aleatorio.nextInt(12) + 3 + level;
          pontosSaude = pontosSaude+valor;
          if(pontosSaude>pontosSaudeMax){pontosSaude = pontosSaudeMax;};
          System.out.println(Color.GREEN + "- Voce curou "+ valor + " pontos de saude!\n" + Color.RESET);
          return 0;
        }else{
          System.out.println(Color.GREEN +"- Voce conjura uma entidade luminosa capaz de regenerar e vitalizar!!!");
          int valor = aleatorio.nextInt(24) + 7 + level;
          pontosSaude = pontosSaude+valor;
          if(pontosSaude>pontosSaudeMax){pontosSaude = pontosSaudeMax;};
          System.out.println(Color.GREEN + "- Voce curou "+ valor + " pontos de saude!\n" + Color.RESET);
          return 0;
        }
      }

      public int projetilRaio() {
        Random aleatorio = new Random();
        if(level < 4){
          System.out.println(Color.CYAN +"Você dispara um pequeno raio elétrico em direção ao seu inimigo."+ Color.RESET);
          int valor = aleatorio.nextInt(12) + 4 + level;
          System.out.println(Color.CYAN + "- Você causou "+ valor + " de dano ao seu inimigo!\n" + Color.RESET);
          return valor;
        }else if(level >= 5 && level <= 8){
          System.out.println(Color.CYAN +"- Um poderoso relâmpago emerge assumindo uma forma de serpente na trajetória"+ Color.RESET);
          int valor = aleatorio.nextInt(20) + 7 + level;
          System.out.println(Color.CYAN + "- Você causou "+ valor + " de dano no seu inimigo!\n" + Color.RESET);
          return valor;
        }else{
          System.out.println(Color.CYAN +"- Você dispara uma enorme rajada de raios em forma de dragão liberando energia massiva!!!");
          int valor = aleatorio.nextInt(40) + 20 + level;
          System.out.println(Color.CYAN + "- Você causou "+ valor + " de dano no seu inimigo!\n" + Color.RESET);
          return valor;
        }
      }

      public int solCruel() {
        Random aleatorio = new Random();
        System.out.println(Color.YELLOW +"- Você conjura uma esfera de energia incadescente que irradia o poder de um SOL!!!" + Color.RESET);
        int valor = (aleatorio.nextInt(25) + level) + (aleatorio.nextInt(25) + level) + 20;
        System.out.println(Color.CYAN + "- Você causou "+ valor + " de dano no seu inimigo!\n" + Color.RESET);
         return valor;
      }


    @Override
    public String toString() {
      
      if(level<8){
        return "[ " + nome + " - "+Color.BLUE+"Mago"+Color.RESET+" - Nivel: "+Color.CYAN+level+Color.RESET+" ]";
      }else{
        if(level<20){
          return "[ " + nome + " - "+Color.BLUE+"Feiticeiro"+Color.RESET+" - Nivel: "+Color.CYAN+level+Color.RESET+" ]";
        }else{
          return "[ " + nome + " - "+Color.BLUE+"Arquimago"+Color.RESET+" - Nivel: "+Color.CYAN+level+Color.RESET+" ]";
        }
      }
    }

    @Override
    public int compareTo(Object outroPlayer) {
        if(this.pontosExperiencia<((Player) outroPlayer).getExperiencePoints()) return 1;
        else if(this.pontosExperiencia==((Player) outroPlayer).getExperiencePoints()) return 0;
        else return -1;
    }
}
