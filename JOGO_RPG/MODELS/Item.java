package Models;

import Controllers.Color;
import Models.*;

public class Item implements Comparable{
    public int id;
    public String nome;
    public Integer dano = null;
    public int enchant;
    public Integer bonusCa = null;

    //Item Normal
    public Item(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //Armadura
    public Item(int id, String nome, int bonusCa) {
        this.id = id;
        this.nome = nome;
        this.bonusCa = bonusCa;
    }

    //Arma
    public Item(int id, String nome, int dano, int enchant) {
        this.id = id;
        this.nome = nome;
        this.dano = dano;
        this.enchant = enchant;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        if(enchant>0){
            return Color.PURPLE+nome;
        }else{
            return this.nome;
        }
    }

    @Override
    public int compareTo(   Object outroItem) {
        if(this.id<((Item) outroItem).getId()) return -1;
        else if(this.id==((Item) outroItem).getId()) return 0;
        else return 1;
    }

}
