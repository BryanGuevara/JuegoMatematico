package juego;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JuegoMatematico {

    public static void main(String[] args) {
        try {
            Random ran = new Random();
            Scanner scan = new Scanner(System.in);
            int ronda = 0;
            String respuestas = "";
            int puntos = 0;

            System.out.println("=================================================== <[Juego]> ===================================================");
            while (ronda <= 4) {
                int num1 = ran.nextInt(100) + 1;
                int num2 = ran.nextInt(100) + 1;
                int result = 0;
                float resp = 0;
                int ope = ran.nextInt(3);

                System.out.print("Ronda " + (ronda + 1) + ": ");
                if (ope == 0) {
                    System.out.print(num1 + "+" + num2 + "=");
                    result = num1 + num2;
                } else if (ope == 1) {
                    System.out.print(num1 + "-" + num2 + "=");
                    result = num1 - num2;
                } else if (ope == 2) {
                    System.out.print(num1 + "X" + num2 + "=");
                    result = num1 * num2;
                }
                resp = scan.nextFloat();

                DecimalFormat df = new DecimalFormat("#.##");
                df.setMinimumFractionDigits(0);
                df.setMaximumFractionDigits(2);

                respuestas = respuestas + "Ronda " + (ronda + 1) + ": ";
                if (result == resp) {
                    if (ronda <= 4) {
                        respuestas = respuestas + df.format(resp) + " es Correcto\n";
                    } else {
                        respuestas = respuestas + df.format(resp) + " es Correcto";
                    }
                    puntos = puntos + 10;
                } else {
                    if (ronda <= 4) {
                        respuestas = respuestas + df.format(resp) + " es Incorrecto, el resultado era: " + df.format(result) + "\n";
                    } else {
                        respuestas = respuestas + df.format(resp) + " es Incorrecto, el resultado era: " + df.format(result);
                    }
                }
                ronda++;
            }
            System.out.println("=================================================== <[Resultados]> ===============================================");
            System.out.print(respuestas);
            System.out.println("Puntaje Final: " + (puntos / 5));
            System.out.println("==================================================================================================================");
        } catch (InputMismatchException e) {
            System.out.println("=================================================== <[Error]> ====================================================");
            System.err.println("Error, solo se admiten numeros");
            System.out.println("==================================================================================================================");
        }
    }
}
