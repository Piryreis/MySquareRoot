package fr.valentin;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        do {

            System.out.println("\n");

            double number = selectNumber();

            long lastTimeMillis = System.nanoTime();
            double sqrt = mySquareRoot(number);
            long time = System.nanoTime() - lastTimeMillis;
            log("La racine carrée de " + number + " est " + sqrt + ". Calculé en " + time + " nanoSeconde.");

            long lastTimeMillisSqrtFunction = System.nanoTime();
            double sqrtFunction = Math.sqrt(number);
            long timeSqrtFunction = System.nanoTime() - lastTimeMillisSqrtFunction;
            log("AVEC LA FONCTION SQRT() : La racine carrée de " + number + " est " + sqrtFunction + ". Calculé en " + timeSqrtFunction + " nanoSeconde.");

        } while (true);

    }

    public static void log(String message){
        System.out.println("[MySquareRoot]: " + message);
    }

    private static double selectNumber(){

        boolean reponse = false;
        double number = 0;

        while (!reponse){
            log("Quelle racine carrée voulez-vous obtenir ?");
            try {
                number = Double.parseDouble(scanner.nextLine());
                if (number == 0D){
                    log("La valeur ZERO n'a pas de racine carrée.");
                    continue;
                }
                number = Math.abs(number);
                reponse = true;
            } catch (Exception e){
                log("Veuillez choisir un nombre correct.");
            }
        }

        return number;
    }

    /**
     * Algorithme ancien de Héron d'Alexandrie permettant d'obtenir rapidement une valeur approchée de la racine carrée d'un nombre A
     * @param number A
     * @return la racine carrée du nombre A
     */
    public static double mySquareRoot(double number){
        double a;
        double sqrt = number / 2d;

        do {
            a = sqrt;
            sqrt = ( (number / a) + a) / 2;
        } while (Double.compare(a, sqrt) != 0D);

        return sqrt;
    }

}
