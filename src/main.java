import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;
import sun.plugin.cache.FileVersion;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Pattern p;
        Matcher m;
        boolean encontrou = false;
        while(true){
            System.out.println("Escolha a opção: \n1) Data\n2)Email do tipo @gmail.com\n3)Telefone");
            int choice = Integer.parseInt(read.nextLine());
            switch (choice) {
                case(1):
                    //Nesse regex eu uso a formatação de horas, em hora, minuto e segundos. Tenho o simbolo literal da separação
                    p = Pattern.compile("(\\d\\d:\\d\\d:\\d\\d)");
                    m = p.matcher(JOptionPane.showInputDialog("Digite o horário: "));
                    while(m.find()){
                        //No método find() ele irá informar se a hora informada está correspondendo a formatação, caso sim irá marcar o horário
                        JOptionPane.showMessageDialog(null, "Horário marcado com sucesso: " + m.group());
                        encontrou = true;
                    }
                    if(!encontrou){
                        //Caso a hora não esteja na formatação correta ela não será marcada
                        JOptionPane.showMessageDialog(null,"Horário inválido");
                    }

                    return;
                case(2):
                    //Nesse regex eu utilizo a formatação de um e-mail gmail, onde necessita apenas que antes do @ tenha algum caracter de a até z
                    p = Pattern.compile(".@gmail.com");
                    m = p.matcher(JOptionPane.showInputDialog("Digite o email: "));
                    while(m.find()){
                        //Caso o e-mail informado corresponda a formatação ele será cadastrado
                        JOptionPane.showMessageDialog(null, "E-mail" + m.group() + " cadastrado com sucesso.");
                        encontrou = true;
                    }
                    if(!encontrou){
                        //Caso não corresponda a formatação será informado
                        JOptionPane.showMessageDialog(null,"Formato do e-mail é inválido!");
                    }
                    return;
                case(3):
                    //Aqui eu uso a formatação de uma telefone, com seu ddd e a divisão dos 4 digitos
                    p = Pattern.compile(".\\d\\d.9\\d\\d\\d\\d.\\d\\d\\d\\d");
                    m = p.matcher(JOptionPane.showInputDialog("Digite o numero de telefone: "));
                    while(m.find()){
                        //Caso o telefone corresponda a formatação da regex ele será cadastrado com sucesso
                        JOptionPane.showMessageDialog(null, "Telefone " + m.group() + " cadastrado com sucesso.");
                        encontrou = true;
                    }
                    if(!encontrou){
                        //Caso ele não esteja no formato da regex ele não será cadastrado
                        JOptionPane.showMessageDialog(null,"Telefone inválido!");
                    }
                    return;
            }


        }
    }
}
