package br.com.dio.exceptions;

import javax.swing.*;
import java.io.*;

/*Objetivo da classe = imprimir arquivo no console*/
public class CheckedException {
    public static <String, FileNotFoundException> void main(String[] args) {
        java.lang.String nomeDoArquivo = "romance-black-crouch.txt";
        java.lang.Object JOptionPane;
        try {
            imprimirArquivoNoConsole(nomeDoArquivo);
        } catch (FileNotFoundException e){//erro de arquivo não encontrado.
            JOptionPane.showMessageDialog(null,"Revise o nome do arquivo que vc deseja imprimir "+e.getCause());
        }
        catch (IOException e) {//outro erro que não esta relacionado a encontrar o arquivo
            JOptionPane.showMessageDialog(null,"Ocorreu um erro inesperado, entre em contato como o suporte! "+e.getCause());
        }finally {
            System.out.println("Chegou no finally");
        }

        System.out.println("Apesar da exception ou não o programa continua");

    }
    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
        File file = new File(nomeDoArquivo);

        /*Abaixo padrão decorator, criando um buffer para imprimir o documento no console*/
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.getName()));

        String line = bufferedReader.readLine();//lendo linha por linha contida no buffer a cima

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));/*aqui
        esta abrindo o console utilizando o System.out*/

        do{
            bufferedWriter.write(line);//escrevendo na linha
            bufferedWriter.newLine();//criando a proxima linha
            line = bufferedReader.readLine();//lendo a proxima linha
        } while (line!=null);
        bufferedWriter.flush();//descarregar
        bufferedReader.close();//fechar o fluxo
    }
}
