package bingogameapp;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Daniel-Reyes
 */
public class BingoGameApp {
    /**
     * @param args the command line arguments
     */

    ArrayList Lb = new ArrayList();
    ArrayList Li = new ArrayList();
    ArrayList Ln = new ArrayList();
    ArrayList Lg = new ArrayList();
    ArrayList Lo = new ArrayList();

    boolean bingo = false; //ternimar juego

    public void ilistas() {
        this.Lb.add("B");
        this.Li.add("I");
        this.Ln.add("N");
        this.Lg.add("G");
        this.Lo.add("O");

        this.glista();
    }

    public void mcartilla() {
        System.out.println("---------------------------------------------------------------------------------");
        for (int i = 0; i < this.Lb.size(); i++) {
            System.out.println("|\t" + this.Lb.get(i) + "\t|\t" + this.Li.get(i) + "\t|\t" + this.Ln.get(i) + "\t|\t" + this.Lg.get(i) + "\t|\t" + this.Lo.get(i) + "\t|\t");
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

    public void glista() {
        Random rd = new Random();
        for (int i = 0; i < 5; i++) {
            this.Lb.add(rd.nextInt(15));
            this.Li.add(rd.nextInt(15) + 15);
            this.Ln.add(rd.nextInt(15) + 30);
            this.Lg.add(rd.nextInt(15) + 45);
            this.Lo.add(rd.nextInt(15) + 60);
        }
    }

    public void bolillas() {
        String[] bolillas = new String[5];
        bolillas[0] = "B";
        bolillas[1] = "I";
        bolillas[2] = "N";
        bolillas[3] = "G";
        bolillas[4] = "O";

        Random rd = new Random();

        String bolilla = bolillas[rd.nextInt(5)];

        int numero = rd.nextInt(15);
        switch (bolilla) {
            case "B" ->
                this.xcartilla(Lb, numero);
            case "I" -> {
                numero += 15;
                this.xcartilla(Li, numero);
            }
            case "N" -> {
                numero += 30;
                this.xcartilla(Ln, numero);
            }
            case "G" -> {
                numero += 45;
                this.xcartilla(Lg, numero);
            }
            case "O" -> {
                numero += 60;
                this.xcartilla(Lo, numero);
            }
        }
        System.out.println(bolilla + numero);
    }

    public ArrayList xcartilla(ArrayList lista, int numero) {
        int pos = lista.indexOf(numero);
        if (pos >= 0) {
            lista.set(pos, "X");
        }
        return lista;
    }

    public static void main(String[] args) {
        BingoGameApp bn = new BingoGameApp();
        bn.ilistas();

        Scanner sc = new Scanner(System.in);
        while (!bn.bingo) {
            bn.mcartilla();
            bn.bolillas();

            System.out.println("Es bingo?");
            String bingo = sc.nextLine();
            if (bingo.equalsIgnoreCase("bingo")) {
                bn.bingo = !bn.bingo;
            }
        }
    }
}
