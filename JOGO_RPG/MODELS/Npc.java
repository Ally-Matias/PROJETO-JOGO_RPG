package Models;
public abstract class Npc {
    String nome;
    public int pontosSaude;
    int classeDeArmadura;
    int dano;
    int xp;


    public abstract int turno(Player player);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getClasseDeArmadura() {
        return classeDeArmadura;
    }

    public void setClasseDeArmadura(int classeDeArmadura) {
        this.classeDeArmadura = classeDeArmadura;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    
}

