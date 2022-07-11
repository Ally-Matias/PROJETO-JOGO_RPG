package Controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Models.*;

public class Save {
    public static void salvar(){
        int save = 0;
        for (Player player : Personagens.players) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("save"+save+".txt"));
                int cont = 0;
                    String[] personagem = {
                        " ",
                        ""+player.armaEquip.id,
                        ""+player.armaEquip.nome,
                        ""+player.armaEquip.dano,
                        ""+player.armaEquip.enchant,
                        ""+player.armaduraEquip.id,
                        ""+player.armaduraEquip.nome,
                        ""+player.armaduraEquip.bonusCa,
                        ""+player.nome,
                        ""+player.classe,
                        ""+player.pontosSaudeMax,
                        ""+player.pontosExperiencia,
                        ""+player.level,
                    };
                    for (String element : personagem){
                    writer.write(element);
                    if(cont<12){writer.write("\n");}
                    cont++;
                    }
                writer.close();
                save++;
            } catch (Exception e) {
                save++;
            }
        }
    }

    public static void deletar(int indice){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("save"+indice+".txt"));
                writer.write("");
                salvar();
                BufferedWriter writer2 = new BufferedWriter(new FileWriter("save"+Personagens.players.size()+".txt"));
                writer.write("");
                writer.close();
            } catch (Exception e) {
            }
    }

    public static void carregar(){
        int cont = 0;
        while(true){
            try {
                BufferedReader reader = new BufferedReader(new FileReader("save"+cont+".txt"));
                String a,b,c,d,e,f,g,h,i,j,k,l;
                try {
                    String line = reader.readLine();
                    while ( (line = reader.readLine()) != null){
                        a = new String(line);
                        line = reader.readLine();
                        b = new String(line);
                        line = reader.readLine();
                        c = new String(line);
                        line = reader.readLine();
                        d = new String(line);
                        line = reader.readLine();
                        e = new String(line);
                        line = reader.readLine();
                        f = new String(line);
                        line = reader.readLine();
                        g = new String(line);
                        line = reader.readLine();
                        h = new String(line);
                        line = reader.readLine();
                        i = new String(line);
                        line = reader.readLine();
                        j = new String(line);
                        line = reader.readLine();
                        k = new String(line);
                        line = reader.readLine();
                        l = new String(line);
                        
                        Item armadura = new Item(Integer.parseInt(a),b,Integer.parseInt(c),Integer.parseInt(d));
                        Item arma = new Item(Integer.parseInt(e),f,Integer.parseInt(g));
    
                        Player player;
                        if (Integer.parseInt(i)==1){
                            player = new Guerreiro(h,Integer.parseInt(j),Long.parseLong(k),Integer.parseInt(l), arma, armadura);
                            Personagens.players.add(player);
                        } else if (Integer.parseInt(i)==2){
                            player = new Mago(h,Integer.parseInt(j),Long.parseLong(k),Integer.parseInt(l), arma, armadura);
                            Personagens.players.add(player);
                        }else if (Integer.parseInt(i)==3){
                            player = new Assassino(h,Integer.parseInt(j),Long.parseLong(k),Integer.parseInt(l), arma, armadura);
                            Personagens.players.add(player);
                        }
                    }
                } catch (IOException ex) {
                    break;
                }
                cont++;
            } catch (FileNotFoundException ex) {   
                break;  
            }
            
        }
        }
    }
