package Controllers;

import Controllers.Color;
import Models.*;
import java.util.Scanner;

public class Cenario3 {
    
    public static void capitulo1(Player player){
        Scanner input = new Scanner(System.in);
        String decisao;
        System.out.print(Color.BLACK_BACKGROUND +Color.PURPLE+"MONSTROS DA NOITE"+Color.RESET);
        System.out.print(Color.RESET+"\n\n"+Color.RESET);

        System.out.println(" ");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"É inverno, você foi contratado pelo rei de Novingard para investigar uma certa area onde cada vez mais rumores de pessoas desaparecidas surgem..."+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Os moradores da vila já não saem mais de casa, seja o que vem causando esses incidentes, restringe toda a area a um medo constante."+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Parece ser uma missão de alto nível, mas por isso você a aceitou."+Color.RESET+"\n");

        System.out.println("\n"+Color.BLACK_BACKGROUND +Color.PURPLE+"A DECISÃO"+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Após caminhar toda a tarde, você se aproxima da mata que fica aos arredores da vila."+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Antes que pudesse chegar mais perto do vilarejo, você tem a impressão de escutar um sussurro chamando seu nome."+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Ao tentar procurar de onde a voz veio, logo você percebe uma grande caverna escura que estava logo ao lado."+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Você averigua a caverna e sua entrada, até que escuta um grito estridente de desespero vindo de dentro."+Color.RESET+"\n");
        System.out.print("\n"+Color.BLACK_BACKGROUND+Color.CYAN+"- SOCORRO!"+Color.RESET+"\n");
        
        System.out.print("\n"+Color.BLACK_BACKGROUND+"Qual sua decisão?"+Color.RESET+"\n\n");
        while(true){
            System.out.print(Color.RESET);
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - Acender uma tocha e entrar na caverna em direção ao grito "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - Continuar seu caminho até a vila.                         "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n\n");
            System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção: "+Color.RESET+"\n");
            System.out.print(Color.RESET);
            decisao = input.next();
            System.out.println();
            if(Utility.parseCheck(decisao)){decisao = decisao;}else{decisao = "5";}
            if(Integer.parseInt(decisao) == 1){
                System.out.print("\n"+Color.BLACK_BACKGROUND+Color.GREEN+"- Você tem coragem, a recompensa por ela virá logo a seguir..."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Sem pensar muito você decide entrar na caverna com apenas uma tocha para clarear."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Você não enxerga quase nada a sua frente, até que avista o que parece ser uma pessoa caída e sozinha."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Ao chegar mais perto e clarear, percebe ser uma jovem moça de cabelos ruivos, "+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"ela está coberta de sangue e quase desmaiando, até que ergue o braço em sua direção pedindo ajuda com um olhar desesperado."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"O que você faz?"+Color.RESET+"\n\n");
                while(true){
                    System.out.print(Color.RESET);
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - Ir em direção da moça e salva-la antes que morra.         "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - Ignora-la e continuar focado na missão.                   "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|---------------------------------------------------------------------|"+Color.RESET+"\n\n");
                    System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção: "+Color.RESET+"\n");
                    System.out.print(Color.RESET);
                    decisao = input.next();
                    System.out.println();
                    if(Utility.parseCheck(decisao)){decisao = decisao;}else{decisao = "5";}
                    if(Integer.parseInt(decisao) == 1){
                        System.out.print("\n"+Color.BLACK_BACKGROUND+"Ao se aproximar da jovem, sua tocha se apaga..."+Color.RESET+"\n");
                        System.out.print("\n"+Color.BLACK_BACKGROUND+"Todo o ambiente parece estar frio de repente, você percebe que algo está errado e logo entra em postura de combate"+Color.RESET+"\n");
                        System.out.print("\n"+Color.BLACK_BACKGROUND+Color.RED+"- Bela tentativa..."+Color.RESET+"\n");
                        System.out.print("\n"+Color.BLACK_BACKGROUND+"Você então é apunlhado pelas costas, mesmo não sendo um golpe fatal, logo seu corpo todo se paraliza"+Color.RESET+"\n");
                        System.out.print("\n"+Color.BLACK_BACKGROUND+"Ao cair no chão, logo seus sentidos se esvaem e você perde a consciência enquanto sente mais apunhaladas em seu corpo caído"+Color.RESET+"\n");
                        System.out.println("\nVoce "+Color.RED+"falhou"+Color.RESET+" esse cenario!");
                        System.out.print("# -------------------------------------------------------------- #\n\n");
                        System.out.print(Color.RED+"- VOCE MORREU -"+Color.RESET);
                        System.out.println("# -------------------------------------------------------------- #\n");
                        return;
                    }else if(Integer.parseInt(decisao) == 2){
                        System.out.print("\n"+Color.BLACK_BACKGROUND+"Você anda cautelosamente mantendo sua guarda, ignorando a moça."+Color.RESET+"\n");
                        System.out.print("\n"+Color.BLACK_BACKGROUND+"Todo o ambiente parece estar frio de repente, a moça então começa a se levantar,"+Color.RESET+"\n");
                        System.out.print("\n"+Color.BLACK_BACKGROUND+Color.RED+"- Ótimos instintos..."+Color.RESET+"\n");
                        System.out.print("\n"+Color.BLACK_BACKGROUND+"o corpo dela começa a se contorcer e logo seu rosto se deforma e sua mandibula cai,"+Color.RESET+"\n");
                        System.out.print("\n"+Color.BLACK_BACKGROUND+"uma adaga mágica se forma na mão dela e ela logo parte em sua direção para atacar-te"+Color.RESET+"\n");
                        System.out.print(Color.RESET+"\n\n"+Color.RESET);
                        Bruxa bruxa = new Bruxa();
                        boolean batalha1;
                        batalha1 = Player.batalha(bruxa, player);
                        if(batalha1){
                            System.out.print("\n"+Color.BLACK_BACKGROUND+"Você mata a bruxa que cai no chão enquanto vira cinzas"+Color.RESET+"\n");
                            System.out.print("\n"+Color.BLACK_BACKGROUND+"Quando ela morreu, você pode perceber todos os sinais de magia, culto as trevas e corpos em decomposição"+Color.RESET+"\n");
                            System.out.print("\n"+Color.BLACK_BACKGROUND+"Acontece que ela na verdade sava magia negra para causar problemas, maldições e assassinatos na area local"+Color.RESET+"\n");
                            System.out.print("\n"+Color.BLACK_BACKGROUND+"Aos poucos a população da vila percebeu que os desaparecimentos pararam e eles haviam sido salvos, você logo recebeu sua recompensa..."+Color.RESET+"\n");
                            System.out.println("\n"+Color.GREEN+"Parabéns"+Color.RESET+"! Voce concluiu o cenário com sucesso!!!");
                            player.adicionarXp(150);
                            return;
                        }else{
                            System.out.println("\nVoce "+Color.RED+"falhou"+Color.RESET+" esse cenario!");
                            return;
                        }
                    }else{
                        System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!\n\n"+ Color.RESET);
                    }
                }
            }else if(Integer.parseInt(decisao) == 2){
                System.out.print("\n"+Color.BLACK_BACKGROUND+Color.GREEN+"- Você foi covarde, mas a noite não falhará em lhe achar..."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"A caverna poderia ser uma armadilha, mas a vila também pode guardar ameaças."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Com isso em mente e a noite dando as caras, você para pra acampar logo a frente, tomando tempo para tomar uma boa decisão"+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Depois de pouco tempo você escuta passos entre a vegetação, ao procurar de onde estão vindo, você logo percebe o grande vulto se esgueirando."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"É uma criatura humanóide horrível, com braços compridos como os de um macaco e um corpo volumoso e deformado."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"Ao ver as orelhas pontudas e o sangue negro que escorria de suas feridas, você teve certeza que era um "+Color.RED+"Orc."+Color.RESET+"\n");
                System.out.print("\n"+Color.BLACK_BACKGROUND+"O monstro parte em investida em sua direção, é matar ou morrer!!!!"+Color.RESET+"\n");
                System.out.print(Color.RESET+"\n\n"+Color.RESET);
                        Orc orc = new Orc();
                        boolean batalha1;
                        batalha1 = Player.batalha(orc, player);
                        if(batalha1){
                            System.out.print("\n"+Color.BLACK_BACKGROUND+"A criatura morre, deixando restos mortais impregnados em magia"+Color.RESET+"\n");
                            System.out.print("\n"+Color.BLACK_BACKGROUND+"Você leva sua cabeça até o rei e mostra ao vilarejo, fazendo com que todos reconheçam sua capacidade e fiquem agradecidos e aliviados."+Color.RESET+"\n");
                            System.out.print("\n"+Color.BLACK_BACKGROUND+"Você é bem recompensado, porém algum tempo depois novos rumores surgem"+Color.RESET+"\n");
                            System.out.print("\n"+Color.BLACK_BACKGROUND+"Acontece que os desaparecimentos voltaram, e só pioram."+Color.RESET+"\n");
                            System.out.print("\n"+Color.BLACK_BACKGROUND+"Todos perdem a esperança, não acreditam mais em salvação, a vila cada vez mais caminha em direção a ruína"+Color.RESET+"\n");
                            System.out.println("\nVoce "+Color.RED+"falhou"+Color.RESET+" esse cenario!");
                            return;
                        }else{
                            System.out.println("\nVoce "+Color.RED+"falhou"+Color.RESET+" esse cenario!");
                            return;
                        }
            }else{
                System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!\n\n"+ Color.RESET);
            }
        }
        
    }
}
