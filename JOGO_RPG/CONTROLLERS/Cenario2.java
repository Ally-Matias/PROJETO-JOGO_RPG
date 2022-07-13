package Controllers;

import java.util.Scanner;
import Models.*;

public class Cenario2 {
    
    public  static void capitulo1(Player player){
        Scanner teclado = new Scanner(System.in);
        String opc;
        boolean cenarioVencido;
        System.out.print(Color.BLACK_BACKGROUND +Color.PURPLE+"O RESGATE"+Color.RESET+"\n\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Durante sua viagem, voce chega ate a pequena vila de Libertia."+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Na taverna local, voce entra a procura de trabalho e por isso ja se dirije ao quadro de missões,"+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"antes que pudesse chegar, um jovem desesperado adentra o local com roupas rasgadas e ensanguentadas,"+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+Color.CYAN+"- SOCORRO! Alguem me ajude! Fomos atacados por um grupo de pequenos monstros, eles sequestraram meu pai e irmã"+Color.RESET+"\n");

        System.out.print("\n"+Color.BLACK_BACKGROUND+"Voce percebe a oportunidade e diz:"+Color.RESET+"\n\n");
        while(true){
            System.out.print(Color.RESET);
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - Nao se preocupe! Diga-me o caminho que irei salva-los.    "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - Eu! Mas apenas pelo preço correto...                      "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n\n");
            System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção: "+Color.RESET+"\n");
            System.out.print(Color.RESET);
            opc = teclado.next();
            System.out.println();
            if(Utility.parseCheck(opc)){opc = opc;}else{opc = "5";}
            if(Integer.parseInt(opc) == 1){
                System.out.print("\n"+Color.BLACK_BACKGROUND+"O jovem sorri e vai ate voce rapidamente."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+Color.CYAN+"- Muito obrigado! Venha que eu lhe mostrarei o caminho que leva até onde fomos atacados."+Color.RESET+"\n");
                break;
            }else if(Integer.parseInt(opc) == 2){
                System.out.print("\n"+Color.BLACK_BACKGROUND+"As pessoas em volta olham para voce com raiva,"+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"entretanto o jovem vai ate voce desesperado."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+Color.CYAN+"- O que quiser! Somos pobres mas eu farei tudo que posso para lhe pagar bem em ouro!"+Color.RESET+"\n");
                break;
            }else{
                System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!\n\n"+ Color.RESET);
            }
        }

        cenarioVencido = capitulo2(player);

        if(cenarioVencido){
            System.out.println("\n"+Color.GREEN+"Parabéns"+Color.RESET+"! Voce concluiu o cenário com sucesso!!!");
            player.adicionarXp(50);
        }else{
            System.out.println("\nVoce "+Color.RED+"falhou"+Color.RESET+" esse cenario!");
            return;
        }
    }
    
    public static boolean capitulo2(Player player){
        Scanner teclado = new Scanner(System.in);
        String opc;
        boolean cenarioVencido;
        System.out.print("\n"+Color.BLACK_BACKGROUND+"O jovem te leva até a estrada de que veio e lhe mostra o caminho."+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Esse caminho lhe leva ate uma floresta densa e fechada, sem sinal de outras pessoas por perto."+Color.RESET+"\n");
        System.out.print("\n\n"+Color.BLACK_BACKGROUND+"Um tempo depois de andar bastante, voce avista uma figura suspeita."+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"É um homem encapuzado, coberto em um grande manto vindo na direção contrária da sua."+Color.RESET+"\n");
        System.out.print("\n\n"+Color.BLACK_BACKGROUND+"Ao ver ele, o que deseja fazer?."+Color.RESET+"\n\n");

        while(true){
            System.out.print(Color.RESET);
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - Evitar a figura e continuar seu caminho...                "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - Abordar o homem.                                          "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n\n");
            System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção: "+Color.RESET+"\n");
            System.out.print(Color.RESET);
            opc = teclado.next();
            System.out.println();
            if(Utility.parseCheck(opc)){opc = opc;}else{opc = "5";}
            if(Integer.parseInt(opc) == 1){
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Voce continua seu caminho por bastante tempo."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Ate perceber uma fumaça de fogueira ao longe e uma pequena trilha que se desfaz do caminho."+Color.RESET+"\n");
                return capitulo3(player,false);
            }else if(Integer.parseInt(opc) == 2){
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Voce se aproxima do homem encapuzado e o pede informações que possam ajudar na sua busca"+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"O homem parecia ser um velho mercador de especiarias, ele para sua caminhada e com uma expressão calma e sorridente lhe responde:"+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+Color.CYAN+"- Essa floresta é um labirinto, se quiser encontrar logo o esconderijo dessas criaturinhas"+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+Color.CYAN+"- vai precisar seguir um atalho... Eu posso lhe mostrar se quiser..."+Color.RESET+"\n");
                System.out.print("\n\n"+Color.BLACK_BACKGROUND+"A floresta realmente é muito grande, mas não é comum um senhor dessa idade estar sozinho no meio dela"+Color.RESET+"\n\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"O que decide fazer?"+Color.RESET+"\n");
                while(true){
                    System.out.print(Color.RESET);
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - Ignorar a oferta do velho, pode ser uma armadilha         "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - Aceitar a oferta e seguir caminho no atalho               "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n\n");
                    System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção: "+Color.RESET+"\n");
                    System.out.print(Color.RESET);
                    opc = teclado.next();
                    System.out.println();
                    if(Utility.parseCheck(opc)){opc = opc;}else{opc = "5";}
                    if(Integer.parseInt(opc) == 1){
                        return capitulo3(player,false);
                    }else if(Integer.parseInt(opc) == 2){
                        return capitulo3(player,true);
                    }else{
                        System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!\n\n"+ Color.RESET);
                    }
                }
            }else{
                System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!\n\n"+ Color.RESET);
            }
        }
    }
    public static boolean capitulo3(Player player, boolean escolha){
        if(escolha){
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Ao seguir pelo atalho, logo voce escuta gritos de socorro que aumentam a medida que chega mais perto."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Voce finalmente avista um pequeno acampamento em volta da entrada de uma toca."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Os gritos eram de uma menina sendo arrastada por uma grande criatura para dentro da toca."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Antes que pudesse tentar salva-la, você é surpreedido por um Goblin que estava de guarda e bloqueia seu caminho."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Primeiro terá de passar por ele!!!"+Color.RESET+"\n");
            System.out.print(Color.RESET+"\n\n"+Color.RESET);
            Goblin goblin = new Goblin();
            boolean batalha1;
            batalha1 = Player.batalha(goblin, player);
            if(batalha1){
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Após vencer, voce corre em direção a toca, entra rapidamente e segue os gritos que ecoam nos corredores estreitos."+Color.RESET+"\n");
                return capitulo4(player, escolha);
            }else{
                System.out.println("\nVoce "+Color.GREEN+"falhou"+Color.RESET+" esse cenario!");
                return false;
            }
        }else{
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Você então segue seu caminho a procura das pessoas sequestradas."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Após andar por mais tempo ainda, você avista ao longe a fumaça de uma fogueira."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Andando mais um pouco, voce finalmente avista um pequeno acampamento vazio em volta da entrada de uma toca."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Você adentra a toca e segue pelo seu estreito caminho."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Você escuta então gritos fracos porém desesperados vindos do fim do tunel."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Antes que pudesse correr para investigar, você é surpreedido por um Goblin que estava de guarda e bloqueia seu caminho."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Primeiro terá de passar por ele!!!"+Color.RESET+"\n");
            System.out.print(Color.RESET+"\n\n"+Color.RESET);
            Goblin goblin = new Goblin();
            boolean batalha1;
            batalha1 = Player.batalha(goblin, player);
            if(batalha1){
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Após vencer, voce imediatamente vai na direção de onde havia escutado os gritos"+Color.RESET+"\n");
                return capituloFinal(player, escolha);
            }else{
                System.out.println("\nVoce "+Color.GREEN+"falhou"+Color.RESET+" esse cenario!");
                return false;
            }
        }
    }
    public static boolean capitulo4(Player player, boolean escolha){
        if(escolha){
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Você então avista a criatura arrastando a pequena menina para o fim do tunel."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Ao tentar ir em direção e atacar, mais um pequeno goblin aparece para tentar lhe matar."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Derrote-o e salve a garota!!!"+Color.RESET+"\n");
            System.out.print(Color.RESET+"\n\n"+Color.RESET);
            Goblin goblin = new Goblin();
            boolean batalha1;
            batalha1 = Player.batalha(goblin, player);
            if(batalha1){
                return capituloFinal(player, escolha);
            }else{
                return false;
            }
        }else{
            return(capituloFinal(player, escolha));
        }
    }

    public static boolean capituloFinal(Player player, boolean escolha){
        Scanner teclado = new Scanner(System.in);
        String opc;
        if(escolha){
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Você finalmente chega até o fim do tunel..."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"A grande criatura que havia visto antes está no meio de vários ossos e corpos em decomposição."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Ele é parecido com um goblin, porém mais alto, forte e com uma pele verde mais escura e grossa, ao chegar já nota sua presença."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Além dos corpos, também é possível ver a garota chorando com o braço quebrado e outro homem morto próximo a ela"+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+Color.RED+"A criatura ergue seu porrete e se prepara para atacar"+Color.RESET+"\n");
            System.out.print(Color.RESET+"\n\n"+Color.RESET);
            Hobgoblin boss = new Hobgoblin();
            boolean batalha1;
            batalha1 = Player.batalha(boss, player);
            if(batalha1){
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Mesmo não chegando a tempo para salvar o pai dela, você salvou a garota e a levou para seu irmão."+Color.RESET+"\n");
                return true;
            }else{
                return false;
            }
        }else{
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Você finalmente chega até o fim do tunel..."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"A grande criatura que havia visto antes está no meio de vários ossos e corpos em decomposição."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Ele é parecido com um goblin, porém mais alto, forte e com uma pele verde mais escura e grossa, ao chegar já nota sua presença."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"Além dos corpos, também é possível ver os corpos de uma garota e um homem velho, mas ninguém vivo..."+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+Color.RED+"A criatura ergue seu porrete e se prepara para atacar"+Color.RESET+"\n");
            System.out.print("\n"+Color.BLACK_BACKGROUND+"O que decide fazer?"+Color.RESET+"\n");
            while(true){
                System.out.print(Color.RESET);
                System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n");
                System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - Lutar por vingança e derrotar a criatura                  "+Color.YELLOW+"|"+Color.RESET+"\n");
                System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - Não há mais como salva-los, virar as costas e sair...     "+Color.YELLOW+"|"+Color.RESET+"\n");
                System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n\n");
                System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção: "+Color.RESET+"\n");
                System.out.print(Color.RESET);
                opc = teclado.next();
                System.out.println();
                if(Utility.parseCheck(opc)){opc = opc;}else{opc = "5";}
                if(Integer.parseInt(opc) == 1){
                    System.out.print(Color.RESET+"\n\n"+Color.RESET);
                    Hobgoblin boss = new Hobgoblin();
                    boolean batalha1;
                    batalha1 = Player.batalha(boss, player);
                    if(batalha1){
                        System.out.print("\n"+Color.BLACK_BACKGROUND+"Você não chegou a tempo e não salvou ninguem, mas botou um fim nas criaturas que causaram tudo isso."+Color.RESET+"\n");
                        return false;
                    }else{
                        return false;
                }
                }else if(Integer.parseInt(opc) == 2){
                    System.out.print("\n"+Color.BLACK_BACKGROUND+"Você falhou sua missão e não salvou ninguem, para não ser a próxima vítima do monstro, você foge e nunca mais aparece na vila..."+Color.RESET+"\n");
                    return false;
                }else{
                    System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!\n\n"+ Color.RESET);
                }
            }

            
        }
    }

}



/*  
    public boolean capitulo2(){
        
    }
    public booelan capitulo3(){
        
    }
    public boolean capitulo4(){
        
    }







 Você vai até a taverna e confere o quadro de missões.
Uma nova missão foi postada!
"Derrote o grupo de goblins que se esconde no bosque, e salve os reféns."
Você parte em direção ao bosque e encontra uma figura estranha e suspeito. Você pede informação ?
(1: Sim. )
Você descobre a existência de dois caminhos:
O caminho da direita, rápido porém perigoso.
O caminho da esquerda, lento porém seguro.
Qual a sua escolha ?
(2: Sai pra lá xucrute.)
Você segue o caminho normalmente. (caminho da esquerda.)

Direita:
Você segue andando pela trilha, até que ouve um barulho nos arbustos. 2 goblins aparecem, hora da batalha. 
Você derrotou os goblins e prosseguiu o seu caminho até o acampamento.
(mudança de final)

Esquerda:
Você segue andando por um bom tempo pela trilha e avista o acampamento dos goblins ao longe.
(mudança de final)
 
Ao chegar avista 2 guardas no portão. Ambos atentos de prontos para a batalha!
(A cada 3 turnos aparecem mais 2 goblins, com um limite de 4)
Você derrotou os guardas, adentre o acampamento e salve os reféns! (caso ainda tenha goblins vivos eles se juntam para a próxima batalha.)
(Final 1: Você escolheu o caminho da direita e chegou a tempo, os reféns estavam prestes a serem assados por um hobgoblin, você deve vencer!)
(Final 2: Você escolher o caminho da esquerda e não chegou a tempo, os reféns foram assados vivos por um hobgoblin, você lutará por vingança ?)
Parabéns, você derrotou o líder dos goblins e desmantelou o acampamento.
(1: Você salvou os reféns e eles estão muito agradecidos.)
(2: Os reféns estão mortos e você leva os seus corpos de volta à vila.)

*/