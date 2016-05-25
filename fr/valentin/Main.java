package fr.valentin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        double number = selectNumber();

        long lastTimeMillis = System.nanoTime();

        double sqrt = mySquareRoot(number);

        long time = System.nanoTime() - lastTimeMillis;

        log("La racine carr�e de " + number + " est " + sqrt + ". Calcul� en " + time + " nanoS4econde.");
    }

    public static void log(String message){
        System.out.println("[MySquareRoot]: " + message);
    }

    private static double selectNumber(){
        Scanner scanner = new Scanner(System.in);
        boolean reponse = false;
        double number = 0;

        while (!reponse){
            log("Quelle racine carr�e voulez-vous obtenir ?");
            try {
                number = Double.parseDouble(scanner.nextLine());
                reponse = true;
            } catch (Exception e){
                log("Veuillez choisir un nombre correct.");
            }
        }

        return number;
    }

    /**
     * Algorithme ancien de H�ron d'Alexandrie permettant d'obtenir rapidement une valeur approch�e de la racine carr�e d'un nombre A
     * @param number
     * @return
     */
    public static double mySquareRoot(double number){
        double a = number / 2d;
        double sqrt;
        double newsqrt;

        /*while (true){
            newsqrt = ( (number / a) + a) / 2;
            if (Double.compare(a, newsqrt) < 0.001) {
                sqrt = a;
                break;
            }
            else {
                a = newsqrt;
            }
        }*/

       for (int i = 0; i < 3000; i++){
            a = ( (number / a) + a) / 2;
       }
       sqrt = a;

        return sqrt;
    }
}
