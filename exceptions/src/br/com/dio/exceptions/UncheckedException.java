package br.com.dio.exceptions;

import javax.swing.*;

public class UncheckedException {
    public static void main(String[] args) {


        //passando metodo para variavel resultado
        boolean existeError = true;//para controlar a execução do laço [Do While]

        do{
            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador:  ");
            try{
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("O resultado é :"+resultado);
                existeError = false;
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero inteiro");
            } catch (ArithmeticException e){
                JOptionPane.showMessageDialog(null,"Não se pode dividir por Zero ( 0 )");

            }
            finally {
                System.out.println("O programa chegou ate aqui");
            }
        }while (existeError);//se o valor for true vai executar o programa novamente



    }
    //metodo para dividir
    public static int dividir(int a, int b){
        return a / b;
    }

}
