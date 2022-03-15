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
    ArrayList lstB = new ArrayList();
    ArrayList lstI = new ArrayList();
    ArrayList lstN = new ArrayList();
    ArrayList lstG = new ArrayList();
    ArrayList lstO = new ArrayList();

    public boolean bingo = false; //ternimar juego

    public void llenarArrayList() {
        this.lstB.add("B");
        this.lstI.add("I");
        this.lstN.add("N");
        this.lstG.add("G");
        this.lstO.add("O");

        this.cargarLista();
    }

    public void cartillaJugador() {
        System.out.println("JUGAR BINGO");
        System.out.println("---------------------------------------------------------------------------------");
        for (int i = 0; i < this.lstB.size(); i++) {
            System.out.println("|\t" + this.lstB.get(i) + "\t|\t" + this.lstI.get(i) + "\t|\t" + this.lstN.get(i) + "\t|\t" + this.lstG.get(i) + "\t|\t" + this.lstO.get(i) + "\t|\t");
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

    public void cargarLista() {
        Random rd = new Random();
        for (int i = 0; i < 5; i++) {
            this.lstB.add(rd.nextInt(15));
            this.lstI.add(rd.nextInt(15) + 15);
            this.lstN.add(rd.nextInt(15) + 30);
            this.lstG.add(rd.nextInt(15) + 45);
            this.lstO.add(rd.nextInt(15) + 60);
        }
    }

    public void bolillasJugador() {
        String[] bolillasCartilla = new String[5];
        bolillasCartilla[0] = "B";
        bolillasCartilla[1] = "I";
        bolillasCartilla[2] = "N";
        bolillasCartilla[3] = "G";
        bolillasCartilla[4] = "O";

        Random rnd = new Random();

        String bolilla = bolillasCartilla[rnd.nextInt(5)];

        int numero = rnd.nextInt(15);
        switch (bolilla) {
            case "B" ->
                this.cartillaB(lstB, numero);
            case "I" -> {
                numero += 15;
                this.cartillaB(lstI, numero);
            }
            case "N" -> {
                numero += 30;
                this.cartillaB(lstN, numero);
            }
            case "G" -> {
                numero += 45;
                this.cartillaB(lstG, numero);
            }
            case "O" -> {
                numero += 60;
                this.cartillaB(lstO, numero);
            }

        }
        System.out.println("NUMERO A JUGAR: " + numero);
    }

    public ArrayList cartillaB(ArrayList lista, int numero) {
        int pos = lista.indexOf(numero);
        if (pos >= 0) {
            lista.set(pos, "X");
        }
        return lista;
    }

    public static void main(String[] args) {
        BingoGameApp bn = new BingoGameApp();
        bn.llenarArrayList();

        Scanner sca = new Scanner(System.in);
        int opcion;

        System.out.println("------------------------------------------------------------");
        System.out.println("              Bienvenido al juego de Bingo Java             ");
        System.out.println("------------------------------------------------------------");
        System.out.println("Tienes dos formas de jugar");
        System.out.println("1. Jugar Full House");
        System.out.println("2. Linea");
        System.out.println("Elige una opcion para continuar: ");
        opcion = sca.nextInt();

        while (!bn.bingo) {
            switch (opcion) {
                case 1 -> {
                    bn.cartillaJugador();
                    bn.bolillasJugador();

                    System.out.println("Presiona la tecla ENTER para rellenar cada espacio.");
                    System.out.println("En cuanto llenes la cartilla escribe la palabra BINGO: ");
                    String bingo = sca.nextLine();
                    if (bingo.equalsIgnoreCase("bingo")) {
                        bn.bingo = !bn.bingo;
                    }
                }
                case 2 -> {
                    System.out.println("Lo siento, mi creador aun esta desarrollando esta opcion");
                    System.out.println("Por lo tanto, podras jugar a Full House");
                    
                    bn.cartillaJugador();
                    bn.bolillasJugador();

                    System.out.println("Presiona la tecla ENTER para rellenar cada espacio.");
                    System.out.println("En cuanto llenes la cartilla escribe la palabra BINGO: ");
                    String bingo = sca.nextLine();
                    if (bingo.equalsIgnoreCase("bingo")) {
                        System.out.println("FELICIDADES! Has ganado!");
                        bn.bingo = !bn.bingo;
                    }  
                }
            }  
        }
    }
}
