package br.com.dio.exceptions;

import javax.swing.*;
import java.io.*;

public class ExceptionCustomizada_1 {
    public static void main(String[] args) {
        String nomeDoArquivo = JOptionPane.showInputDialog("Nome do Arquivo a ser exibido");

        imprimirArquinoNoConsole(nomeDoArquivo);
        System.out.println("\nCom exception ou não, o programa continua");

    }
    //metodo para imprimir arquivo
    public static void imprimirArquinoNoConsole(String nomeDoArquivo) {
        try {
            BufferedReader bufferedReader = lerArquivo(nomeDoArquivo);//criando buffer
            String line = bufferedReader.readLine();//ler as linha do arquivo
            //BufferedWriter abaixo para abrir o console)
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
            do {
                bufferedWriter.write(line);//escrever linha
                bufferedWriter.newLine();//criando proxima linha
                line = bufferedReader.readLine();//lendo proxima linha
            } while (line != null);//enquanto linha for diferente de nulo ou vazio
            bufferedWriter.flush();//descarregar
            bufferedReader.close();//fechar
        } catch (ImpossivelAbertudaDeArquivoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ocorreu um erro" +
                    "inesperado entre em contato com o suporte " + e.getMessage());
            e.printStackTrace();
        }

    }
    //metodo para ler o arquivo
    public static BufferedReader lerArquivo(String nomeDoArquivo) throws ImpossivelAbertudaDeArquivoException {
        File file = new File(nomeDoArquivo);//para enviar via exception personalizada
        try {//tentar
            return new BufferedReader(new FileReader(nomeDoArquivo));
        } catch (FileNotFoundException e) {
            throw new ImpossivelAbertudaDeArquivoException(file.getName(), file.getPath());
        }
    }
}
/*criando fora da chave da classe, assim é como se tive-se criando em outro arquivo
criando exception customizada, que será uma extensão da classe Exception*/

class ImpossivelAbertudaDeArquivoException extends Exception{
    //atributos
    private String nomeDoArquivo;
    private String diretorioDoArquivo;

    //Abaixo é criado o contrutor
    public ImpossivelAbertudaDeArquivoException(String nomeDoArquivo, String diretorioDoArquivo) {
        super("O arquivo "+nomeDoArquivo+" não foi encontrado do diretorio "+diretorioDoArquivo);
        this.nomeDoArquivo = nomeDoArquivo;
        this.diretorioDoArquivo = diretorioDoArquivo;
    }

    @Override
    public String toString() {
        return "ImpossivelAbertudaDeArquivoException{" +
                "nomeDoArquivo='" + nomeDoArquivo + '\'' +
                ", diretorioDoArquivo='" + diretorioDoArquivo + '\'' +
                '}';
    }
}
