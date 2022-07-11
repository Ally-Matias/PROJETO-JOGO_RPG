import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Controllers.*;
import Models.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Save.carregar();
        System.out.println(Color.RESET);
        System.out.println("BEM VINDO!\n");
        Player player;
        while(true){
            player = menuPrincipal();
            if(player == null){
                Save.salvar();
                System.out.print(Color.RESET);
                System.out.println("FIM");
                break;
            }else{
                System.out.print(Color.RESET);
                Save.salvar();
                menuPersonagem(player);
            }
        }
        Save.salvar();
    }

    public static Player menuPrincipal(){
        Scanner teclado = new Scanner(System.in);
        ArrayList<Player> playersRank = new ArrayList<>();
        String nome;
        String opcao;
        String classe;
        String opcPersonagem; 
        int cont;
        int number;
        Player player;
        while(true){
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"#"+Color.RESET+Color.BLACK_BACKGROUND+"#--     "+Color.RED+Color.BLACK_BACKGROUND+"R"+Color.PURPLE+Color.BLACK_BACKGROUND+"P"+Color.BLUE+Color.BLACK_BACKGROUND+"G "+Color.YELLOW+Color.BLACK_BACKGROUND+"INTERATIVO"+Color.RESET+Color.BLACK_BACKGROUND+"    --"+Color.YELLOW+"#"+Color.RESET+Color.BLACK_BACKGROUND+"#"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|-----------------------------|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - Iniciar Jogo      "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - Novo Personagem   "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 3 - Delete Personagem "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 4 - Ranking de EXP    "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 0 - Encerrar          "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|-----------------------------|"+Color.RESET+"\n\n");
            System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção:"+Color.RESET+"\n");

            opcao = teclado.next();
            if(parseCheck(opcao)){opcao = opcao;}else{opcao = "6";}
            System.out.println();
            if(Integer.parseInt(opcao) == 0){
                return null;
            }else if(Integer.parseInt(opcao) == 2){
                System.out.print(Color.BLACK_BACKGROUND+"Primeiro, digite o nome de seu personagem:"+ Color.RESET+" ");
                nome = teclado.next();
                System.out.println();
                System.out.println();
                while(true){
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"#"+Color.RESET+Color.BLACK_BACKGROUND+"#--  "+Color.CYAN+"ESCOLHA SUA CLASSE"+Color.RESET+Color.BLACK_BACKGROUND+"   --"+Color.YELLOW+"#"+Color.WHITE+"#"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|-----------------------------|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - "+Color.YELLOW+"Guerreiro         |"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - "+Color.BLUE+"Mago              "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 3 - "+Color.RED+"Assassino         "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 0 - Cancelar          "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|-----------------------------|"+Color.RESET+"\n\n");
                    System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção: "+Color.RESET+"\n");
                    classe = teclado.next();
                    if(parseCheck(classe)){classe = classe;}else{classe = "5";}
                    System.out.println();
                    if(Integer.parseInt(classe) == 1||Integer.parseInt(classe) == 0||Integer.parseInt(classe) == 2||Integer.parseInt(classe) == 3){
                        break;
                    }else{
                        System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!\n\n"+ Color.RESET);
                    }
                }
                if(Integer.parseInt(classe) == 1){
                    player = new Guerreiro(nome);
                    Personagens.players.add(player); 
                    System.out.println(Color.GREEN+Color.BLACK_BACKGROUND+"Parabens"+Color.RESET+Color.BLACK_BACKGROUND+", o personagem: "+ Color.RESET + player +Color.BLACK_BACKGROUND+" foi criado!"+Color.RESET+"\n\n");
                }else if(Integer.parseInt(classe) == 2){
                    player = new Mago(nome);
                    Personagens.players.add(player);
                    System.out.println(Color.GREEN+Color.BLACK_BACKGROUND+"Parabens"+Color.RESET+Color.BLACK_BACKGROUND+", o personagem: "+ Color.RESET + player +Color.BLACK_BACKGROUND+" foi criado!"+Color.RESET+"\n\n");
                }else if(Integer.parseInt(classe) == 3){
                    player = new Assassino(nome);
                    Personagens.players.add(player);
                    System.out.println(Color.GREEN+Color.BLACK_BACKGROUND+"Parabens"+Color.RESET+Color.BLACK_BACKGROUND+", o personagem: "+ Color.RESET + player +Color.BLACK_BACKGROUND+" foi criado!"+Color.RESET+"\n\n");
                }
                
            }
            else if(Integer.parseInt(opcao) == 1){
                if(Personagens.players.size()==0){
                    System.out.println(Color.YELLOW +"Primeiro, crie um personagem, nao ha nenhum!!!\n\n"+ Color.RESET);
                }else{
                    while(true){
                        System.out.println("\n"+Color.BLACK_BACKGROUND+"Escolha seu personagem:"+ Color.RESET);
                        System.out.println(Color.BLACK_BACKGROUND+"(Digite o numero referente a ordem)"+ Color.RESET+"\n");
                        cont = 0;
                        System.out.print("1. ");
                        while(true){
                            System.out.print(Personagens.players.get(cont));
                            if((cont+1)==Personagens.players.size()){
                                System.out.print("\n\n\n");
                                break;
                            }else{
                                cont++;
                                System.out.print("\n"+(cont+1)+". ");
                            }
                        }
                        opcPersonagem = teclado.next();
                        if(parseCheck(opcPersonagem)){opcPersonagem = opcPersonagem;}else{opcPersonagem = opcPersonagem.valueOf(-1);}
                        number = (Integer.parseInt(opcPersonagem))-1;
                        if(number<0 || number>(Personagens.players.size()-1)) {
                            System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!"+ Color.RESET);
                        }else{
                            System.out.println();
                            return Personagens.players.get(number);
                        }
                    }
                }
            }else if(Integer.parseInt(opcao) == 3){
                if(Personagens.players.size()==0){
                    System.out.println(Color.YELLOW +"Nao ha personagens para deletar!!!\n\n"+ Color.RESET);
                }else{
                    while(true){
                        System.out.println("\n"+Color.BLACK_BACKGROUND+"Escolha seu personagem para deletar:"+ Color.RESET);
                        System.out.println(Color.BLACK_BACKGROUND+"(Digite o numero referente a ordem)"+ Color.RESET+"\n");
                        cont = 0;
                        System.out.print("1. ");
                        while(true){
                            System.out.print(Personagens.players.get(cont));
                            if((cont+1)==Personagens.players.size()){
                                System.out.print("\n\n\n");
                                break;
                            }else{
                                cont++;
                                System.out.print("\n"+(cont+1)+". ");
                            }
                        }
                        opcPersonagem = teclado.next();
                        if(parseCheck(opcPersonagem)){opcPersonagem = opcPersonagem;}else{opcPersonagem = opcPersonagem.valueOf(-1);}
                        number = (Integer.parseInt(opcPersonagem))-1;
                        if(number<0 || number>(Personagens.players.size()-1)) {
                            System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!"+ Color.RESET);
                        }else{
                            System.out.println();
                            System.out.println((Personagens.players.get(number))+Color.RED+" foi removido!"+Color.RESET+"\n");;
                            Personagens.players.remove(number);
                            Save.deletar(number);
                            break;
                        }
                    }
                }
            }else if(Integer.parseInt(opcao) == 4){
                if(Personagens.players.size()==0){
                    System.out.println(Color.YELLOW +"Nao ha personagens para ranquear!!!\n\n"+ Color.RESET);
                }else{
                    while(true){
                        System.out.println("\n"+Color.BLACK_BACKGROUND+"Ranking Personagens - "+Color.PURPLE+" +Pontos de Experiencia"+ Color.RESET+"\n");
                        playersRank = new ArrayList<>(Personagens.players);
                        Collections.sort(playersRank);
                        cont = 0;
                        System.out.print(Color.YELLOW+"1"+Color.RESET+". ");
                        while(true){
                            System.out.print(playersRank.get(cont)+" - XP: "+Color.PURPLE+playersRank.get(cont).pontosExperiencia+Color.WHITE+"/"+Color.PURPLE+playersRank.get(cont).pontosExperienciaMax+Color.RESET);
                            if(  ((cont+1)==playersRank.size())  || (cont+1)==10 ){
                                System.out.print("\n");
                                break;
                            }else{
                                cont++;
                                if(cont<=2){
                                    System.out.print("\n"+Color.YELLOW+(cont+1)+Color.RESET+". ");
                                }else{
                                    System.out.print("\n"+(cont+1)+". ");
                                }
                            }
                        }
                        System.out.println("\n"+Color.BLACK_BACKGROUND+"Digite qualquer coisa para continuar: "+ Color.RESET);
                        opcPersonagem = teclado.next();
                        System.out.println();
                        break;
                    }
                }
            }
            
            else{
                System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!\n\n"+ Color.RESET);
            }
        }
        
    }

    public static void menuPersonagem(Player player){
        String opcao, opcAlt; 
        String continuar, nome;
        Scanner teclado = new Scanner(System.in);
        while(true){
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"#"+Color.RESET+Color.BLACK_BACKGROUND+"#--     "+Color.WHITE+"MENU PRINCIPAL"+Color.RESET+Color.BLACK_BACKGROUND+"    --"+Color.YELLOW+"#"+Color.WHITE+"#"+Color.RESET+"\n");
            System.out.print(Color.RESET);
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|-----------------------------|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - "+Color.PURPLE+"Cenarios          "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - "+Color.CYAN+"Ver Personagem    "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 3 - "+Color.YELLOW+"Como jogar?       "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 0 - Sair              "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|-----------------------------|"+Color.RESET+"\n\n");
            System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção: "+Color.RESET+"\n");
            System.out.print(Color.RESET);
            opcao = teclado.next();
            if(parseCheck(opcao)){opcao = opcao;}else{opcao = "5";}
            if(Integer.parseInt(opcao) == 0){
                System.out.println("\n");
                break;
            }else if (Integer.parseInt(opcao) == 1){
                while(true){
                    System.out.print("\n"+Color.BLACK_BACKGROUND +Color.YELLOW+"#"+Color.RESET+Color.BLACK_BACKGROUND+"#--        "+Color.PURPLE+"CENARIOS"+Color.RESET+Color.BLACK_BACKGROUND+"       --"+Color.YELLOW+"#"+Color.WHITE+"#"+Color.RESET+"\n");
                    System.out.print(Color.RESET);
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|-----------------------------|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - Batalha Teste     "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - O Resgate         "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 3 - Monstros da Noite "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 0 - Sair              "+Color.YELLOW+"|"+Color.RESET+"\n");
                    System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|-----------------------------|"+Color.RESET+"\n\n");
                    System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção: "+Color.RESET+"\n");
                    System.out.print(Color.RESET);
                    opcAlt = teclado.next();
                    System.out.println();
                    if(parseCheck(opcAlt)){opcAlt = opcAlt;}else{opcAlt = "5";}
                    if(Integer.parseInt(opcAlt) == 0){
                        break;
                    }else if(Integer.parseInt(opcAlt) == 1){
                        System.out.println("\n\n\n");
                        System.out.print(Color.BLACK_BACKGROUND+"Cenario iniciado"+Color.RESET+" - ");
                        Cenario1.capitulo1(player);
                        player.curarTotal();
                        System.out.println("\n" + Color.BLACK_BACKGROUND +"Voce pode selecionar um novo cenario para jogar:"+Color.RESET);
                    }else if(Integer.parseInt(opcAlt) == 2){
                        System.out.println("\n\n\n");
                        System.out.print(Color.BLACK_BACKGROUND+"Cenario iniciado"+Color.RESET+" - ");
                        Cenario2.capitulo1(player);
                        player.curarTotal();
                        System.out.println("\n" + Color.BLACK_BACKGROUND +"Voce pode selecionar um novo cenario para jogar:"+Color.RESET);
                    }else if(Integer.parseInt(opcAlt) == 3){
                        System.out.println("\n\n\n");
                        System.out.print(Color.BLACK_BACKGROUND+"Cenario iniciado"+Color.RESET+" - ");
                        Cenario3.capitulo1(player);
                        player.curarTotal();
                        System.out.println("\n" + Color.BLACK_BACKGROUND +"Voce pode selecionar um novo cenario para jogar:"+Color.RESET);
                    }else{
                        System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!\n\n"+ Color.RESET);
                    }
                }
            }else if(Integer.parseInt(opcao) == 2){
                player.mostraPlayer();
                System.out.print(Color.BLACK_BACKGROUND +"Deseja mudar o nome do seu personagem? 1.Sim 0.Nao "+Color.RESET+"\n");
                opcAlt = teclado.next();
                if(Integer.parseInt(opcAlt) == 1){
                    System.out.print(Color.BLACK_BACKGROUND +"Digite o novo nome para "+Color.RESET+player+Color.BLACK_BACKGROUND+": "+Color.RESET+"\n");
                    player.nome = teclado.next();
                    System.out.println("\n"+Color.BLACK_BACKGROUND +"Nome alterado com sucesso!"+Color.RESET+"\n\n");
                }else{
                    System.out.println("\n\n");
                }
                
            }else if(Integer.parseInt(opcao) == 3){
                System.out.println("\nPara jogar, voce precisa primeiro selecionar um cenario.\nUm cenario e uma historia ou uma batalha para seu personagem passar.\nCaso voce morra ou falhe o cenario, nao tem problema, seu personagem se cura e voce pode tentar novamente!\nDigite qualquer coisa para continuar :D\n");
                continuar = teclado.next();
                System.out.print("\n\n");
                System.out.println();
            }else{
                System.out.println(Color.YELLOW +"\nDigite uma opcao valida!!!\n\n"+ Color.RESET);
            }
        }
    }

    public static boolean parseCheck(String text){
        int x;
        try{
            x = Integer.parseInt(text);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}

/*          Menu Exemplo

            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"#"+Color.RESET+Color.BLACK_BACKGROUND+"#--     "+Color.RED+Color.BLACK_BACKGROUND+"R"+Color.PURPLE+Color.BLACK_BACKGROUND+"P"+Color.BLUE+Color.BLACK_BACKGROUND+"G "+Color.YELLOW+Color.BLACK_BACKGROUND+"INTERATIVO"+Color.RESET+Color.BLACK_BACKGROUND+"    --"+Color.YELLOW+"#"+Color.RESET+Color.BLACK_BACKGROUND+"#"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|-----------------------------|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 1 - Guerreiro         "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 2 - Mago              "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 3 - Assassino         "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|"+Color.RESET+Color.BLACK_BACKGROUND +" Opção 0 - Sair              "+Color.YELLOW+"|"+Color.RESET+"\n");
            System.out.print(Color.BLACK_BACKGROUND +Color.YELLOW+"|-----------------------------|"+Color.RESET+"\n\n");
            System.out.print(Color.BLACK_BACKGROUND +"Digite uma opção: "+Color.RESET+"\n");


            Menu antigo cenarios

                    System.out.print("##--        Cenarios       --##\n\n");
                    System.out.print("|-----------------------------|\n");
                    System.out.print("| Opção 1 - Batalha Teste     |\n");
                    System.out.print("| Opção 2 - Floresta Negra    |\n");
                    System.out.print("| Opção 0 - Sair              |\n");
                    System.out.print("|-----------------------------|\n");
                    System.out.print("Digite uma opção: \n\n");


                    Menu antigo classes

                    System.out.println("Agora escolha sua classe!\n");
                    System.out.print("|-----------------------------|\n");
                    System.out.print("| Opção 1 - Guerreiro         |\n");
                    System.out.print("| Opção 2 - Mago              |\n");
                    System.out.print("| Opção 3 - Assassino         |\n");
                    System.out.print("| Opção 0 - Voltar Menu       |\n");
                    System.out.print("|-----------------------------|\n\n");

                    Menu antigo MENU

                    System.out.print("##--          Menu        --##\n\n");
                    System.out.print("|-----------------------------|\n");
                    System.out.print("| Opção 1 - Cenarios          |\n");
                    System.out.print("| Opção 2 - Ver Personagem    |\n");
                    System.out.print("| Opção 3 - Como jogar?       |\n");
                    System.out.print("| Opção 0 - Sair              |\n");
                    System.out.print("|-----------------------------|\n");
                    System.out.print("Digite uma opção: \n\n");
 */