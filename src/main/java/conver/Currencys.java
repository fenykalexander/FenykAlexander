package conver;

import java.awt.*;
import javax.swing.*;


public class Currencys extends JPanel{
    public boolean check(String input){
        try{
            double y=Double.parseDouble(input);//проверка на то что вводимые числа не содержат лишних знаков,т.е. содержат только цифры.
            if (y>=0||y<0);
            return true;
        }catch(NumberFormatException e) {//одно ю из двух исключений метода,второе-если введена пустая строка
            return false;
        }
    }
    public void rubToDollar(double put){//метод перевода рублей в деньги)))
        double dol=put/64.47;
        JOptionPane.showMessageDialog(null,"Посчитано  : " +dol+" dollar");
    }
    public void rubToEuro(double put){
        double euro=put/71.53;
        JOptionPane.showMessageDialog(null,"Посчитано  : " +euro+" euro");
    }
    public void dollarToEuro(double put){
        double eu=put/64.47;
        JOptionPane.showMessageDialog(null,"Переведено  : " +eu+" dollar");

    }
    public void euroToDollar(double put){//метод для перевода из долларов в евро

        double d=put/71.53;
        JOptionPane.showMessageDialog(null,"Переведено  : " +d+" euro");
    }
}



