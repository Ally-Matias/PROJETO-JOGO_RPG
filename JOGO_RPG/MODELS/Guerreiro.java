package Models;
import java.util.Random;
import java.util.Scanner;

import Controllers.Color;
import Controllers.Utility;

public class Guerreiro extends Player {
    
    public Guerreiro(String nome) {
        this.nome = nome;
        this.classe = 1;
        armaEquip = new Item(78, "Espada", 8, 0);
        armaduraEquip = new Item(79, "Armadura de Couro", 2);
        setArmaduraEquip(armaduraEquip);
        setValues();
        pontosSaude = pontosSaudeMax;
      }

    public Guerreiro(String nome, int pontosSaudeMax, long pontosExperiencia, int level, Item armaduraEquip, Item armaEquip){
        this.nome = nome;
        this.classe = 1;
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
    

    public void setValues() {
        Random aleatorio = new Random();
        if(level ==1){
          pontosSaudeMax = 10;
        }else{
          pontosSaudeMax = pontosSaudeMax + (aleatorio.nextInt(10)) + (level-1);
        }
    }

    public int atacar(int ca) {
        Random aleatorio = new Random();
        int ataque = aleatorio.nextInt(20) + level;
        int dano = aleatorio.nextInt(armaEquip.dano) + level;
        if(ataque>ca){
            System.out.println(Color.YELLOW+"- Voce ataca com " + Color.WHITE+armaEquip +Color.YELLOW+" causando " + Color.CYAN+dano + Color.YELLOW+" de dano"+Color.RESET+"\n\n");
            return dano;
        }else{
            if(ataque<10){
              System.out.println(Color.YELLOW+"- Voce tenta atacar porem erra !"+Color.RESET+"\n\n"); 
            }else{
              System.out.println(Color.YELLOW+"- Voce tenta atacar porem seu ataque foi bloqueado !"+Color.RESET+"\n\n");
            }
            return 0;
        }
    }

    public int turno(Npc npc) {
        setArmaduraEquip(armaduraEquip);
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
            if(level<3){
              while(true){
                System.out.println("Que habilidade deseja usar?\n");
                System.out.println("1. "+Color.YELLOW+"Voadora"+Color.RESET+" -- 2. "+Color.CYAN+"Postura de Guerreiro"+Color.RESET+" -- 0. SAIR");
                opc = scan.next();
                if(Utility.parseCheck(opc)){opc = opc;}else{opc = "100";}
                  if(Integer.parseInt(opc) == 1){
                    return voadora();
                  }else if(Integer.parseInt(opc) == 0){
                  break;
                  }else if(Integer.parseInt(opc) == 2){
                    return postura(npc.classeDeArmadura);
                  }else{
                    System.out.println("\nDigite um comando valido");
                  }
              }
            }else{
              while(true){
                System.out.println("Que habilidade deseja usar?\n");
                System.out.println("1. "+Color.YELLOW+"Voadora"+Color.RESET+" -- 2. "+Color.CYAN+"Postura de Guerreiro"+Color.RESET+" -- 3. "+Color.RED+"Ultimo Suspiro"+Color.RESET+" -- 0. SAIR");
                opc = scan.next();
                if(Utility.parseCheck(opc)){opc = opc;}else{opc = "100";}
                  if(Integer.parseInt(opc) == 1){
                    return voadora();
                  }else if(Integer.parseInt(opc) == 0){
                  break;
                  }else if(Integer.parseInt(opc) == 2){
                    return postura(npc.classeDeArmadura);
                  }else if(Integer.parseInt(opc) == 3){
                    return furia(npc.classeDeArmadura);
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


    @Override
    public String toString() {
      if(level<10){
        return "[ " + nome +  " - "+Color.YELLOW+"Guerreiro"+Color.RESET+" - Nivel: "+Color.CYAN+level+Color.RESET+" ]";
      }else{
        if(level<20){
          return "[ " + nome +  " - "+Color.YELLOW+"Mestre Guerreiro"+Color.RESET+" - Nivel: "+Color.CYAN+level+Color.RESET+" ]";
        }else{
          return "[ " + nome +  " - "+Color.YELLOW+"Lorde da Guerra"+Color.RESET+" - Nivel: "+Color.CYAN+level+Color.RESET+" ]";
        }
      }
    }






    // Habilidades
    public int voadora(){
      Random random = new Random();
      int dano;
      if(level<4){
        System.out.println("- Voce pula e chuta com seus dois pes o inimigo");
        dano = (random.nextInt(9)+2);
        System.out.println(Color.YELLOW + "- Você causou " + dano + " de dano no seu inimigo!" + Color.RESET);
        System.out.println(Color.YELLOW + "- Voce recebeu " + 3 + " de dano na queda" + Color.RESET+"\n");
        pontosSaude = pontosSaude-4;
        return dano;
      }else if(level >= 5 && level <=8){
        System.out.println("- Voce pula e da uma voadora no inimigo");
        dano = (random.nextInt(20)+5);
        System.out.println(Color.YELLOW + "- Você causou " + dano + " de dano no seu inimigo!" + Color.RESET);
        System.out.println(Color.YELLOW + "- Voce recebeu " + 8 + " de dano na queda" + Color.RESET+"\n");
        pontosSaude = pontosSaude-8;
        return dano;
      }else{
        System.out.println("- Voce pula e da uma SUPER voadora no inimigo");
        dano = (random.nextInt(30)+15);
        System.out.println(Color.YELLOW + "- Você causou " + dano + " de dano no seu inimigo!" + Color.RESET);
        System.out.println(Color.YELLOW + "- Voce recebeu " + 15 + " de dano na queda" + Color.RESET+"\n");
        pontosSaude = pontosSaude-15;
        return dano;
      }
    } 

    public int postura(int ca){
      int dano;
      if(level<4){
        System.out.println(Color.YELLOW +"- Voce ataca cautelosamente e mantem uma postura concentrada"+ Color.RESET);
        int valor = 2;
        dano = atacar(ca+2);
        pontosSaude = pontosSaude+valor;
        classeArmadura = classeArmadura+1;
        if(pontosSaude>pontosSaudeMax){pontosSaude = pontosSaudeMax;};
        System.out.println(Color.GREEN + "- Voce regenerou "+ valor + " pontos de saude e \n aumentou "+1+" ponto(s) de armadura no proximo turno do oponente!\n" + Color.RESET);
        return dano-level;
      }else if(level >= 5 && level <=8){
        System.out.println(Color.YELLOW +"- Voce ataca cautelosamente e mantem uma postura concentrada"+ Color.RESET);
        int valor = 3;
        dano = atacar(ca+3);
        pontosSaude = pontosSaude+valor;
        classeArmadura = classeArmadura+2;
        if(pontosSaude>pontosSaudeMax){pontosSaude = pontosSaudeMax;};
        System.out.println(Color.GREEN + "- Voce regenerou "+ valor + " pontos de saude e \n aumentou "+2+" ponto(s) de armadura no proximo turno do oponente!\n" + Color.RESET);
        return dano-5;
      }else{
        System.out.println(Color.YELLOW +"- Voce ataca cautelosamente e mantem uma postura concentrada"+ Color.RESET);
        int valor = level-5;
        dano = atacar(ca+4);
        pontosSaude = pontosSaude+valor;
        classeArmadura = classeArmadura+3;
        if(pontosSaude>pontosSaudeMax){pontosSaude = pontosSaudeMax;};
        System.out.println(Color.GREEN + "- Voce regenerou "+ valor + " pontos de saude e \n aumentou "+3+" ponto(s) de armadura no proximo turno do oponente!\n" + Color.RESET);
        return dano-9;
      }
    }

    public int furia(int ca){
      int dano;
      Random random = new Random();

      if(level<4){
        System.out.println(Color.YELLOW +"- Voce faz uma investida brutal e sem cautela contra o inimigo"+ Color.RESET);
        dano = atacar(ca-1);
        if(pontosSaude > (pontosSaudeMax/2)){
          System.out.println(Color.YELLOW + "- Voce recebeu " + 1 + " de dano e perdeu "+1+" ponto de armadura temporariamente" + Color.RESET+"\n");
          pontosSaude = pontosSaude-1;
          classeArmadura = classeArmadura-1;
          return dano - level-1;
        }else{
          if(pontosSaude>(pontosSaudeMax/4)){
            System.out.println(Color.YELLOW + "- Voce recebeu " + 1 + " de dano e perdeu "+1+" ponto de armadura temporariamente" + Color.RESET+"\n");
            pontosSaude = pontosSaude-1;
            classeArmadura = classeArmadura-1;
            return dano+1;
          }else{
            System.out.println(Color.YELLOW + "- Voce recebeu " + 1 + " de dano e perdeu "+1+" ponto de armadura temporariamente" + Color.RESET+"\n");
            pontosSaude = pontosSaude-1;
            classeArmadura = classeArmadura-1;
            return (dano*2)+5;
          }
        }

      }else if(level >= 5 && level <=8){
        System.out.println(Color.YELLOW +"- Voce faz uma investida implacavel e sem cautela contra o inimigo"+ Color.RESET);
        dano = atacar(ca-1);
        if(pontosSaude > (pontosSaudeMax/2)){
          System.out.println(Color.YELLOW + "- Voce se machucou e recebeu " + 4 + " de dano e perdeu "+2+" ponto de armadura temporariamente" + Color.RESET+"\n");
          pontosSaude = pontosSaude-4;
          classeArmadura = classeArmadura-2;
          return dano - level-1;
        }else{
          if(pontosSaude>(pontosSaudeMax/4)){
            System.out.println(Color.YELLOW + "- Voce se machucou e recebeu " + 4 + " de dano e \nperdeu "+2+" ponto de armadura temporariamente" + Color.RESET+"\n");
            pontosSaude = pontosSaude-4;
            classeArmadura = classeArmadura-2;
            return dano+5;
          }else{
            System.out.println(Color.YELLOW + "- Voce se machucou e recebeu " + 4 + " de dano e \nperdeu "+2+" ponto de armadura temporariamente" + Color.RESET+"\n");
            pontosSaude = pontosSaude-4;
            classeArmadura = classeArmadura-2;
            return (dano*2)+15;
          }
        }
      }else{
        System.out.println(Color.YELLOW +"- Voce faz uma investida implacavel e sem cautela contra o inimigo"+ Color.RESET);
        dano = atacar(ca-3);
        if(pontosSaude > (pontosSaudeMax/2)){
          System.out.println(Color.YELLOW + "- Voce se machucou e recebeu " + 6 + " de dano e perdeu "+3+" ponto de armadura temporariamente" + Color.RESET+"\n");
          pontosSaude = pontosSaude-6;
          classeArmadura = classeArmadura-3;
          return dano - level-1;
        }else{
          if(pontosSaude>(pontosSaudeMax/4)){
            System.out.println(Color.YELLOW + "- Voce se machucou e recebeu " + 6 + " de dano e \nperdeu "+3+" ponto de armadura temporariamente" + Color.RESET+"\n");
            pontosSaude = pontosSaude-6;
            classeArmadura = classeArmadura-3;
            return dano+10;
          }else{
            System.out.println(Color.YELLOW + "- Voce se machucou e recebeu " + 6 + " de dano e \nperdeu "+3+" ponto de armadura temporariamente" + Color.RESET+"\n");
            pontosSaude = pontosSaude-6;
            classeArmadura = classeArmadura-3;
            return (dano*2)+35;
          }
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
