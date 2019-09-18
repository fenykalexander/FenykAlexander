package conver;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Currencys currencys = new Currencys();//
        Object[] variant0 = {"DOLLAR", "EURO", "quite"};//массив вариантов в диалоговом окне
        Object[] variant1 = {"Пересчет", "Выход"};//
        Object[] variant2={"Перевод в euro","quite"};//
        Object[] variant3={"Перевод в dol","quite"};//


        while (true) {//запускаем цикл работы
            String input = JOptionPane.showInputDialog(null, " Счет валюты");//диалоговое окно для ввода данных
            System.out.println(input);//вывод вводимых данных на экран

            if (currencys.check(input) == true) {//если введенные данные прошли провепку
                double put = Double.parseDouble(input);//создаем переменную put

                int choice1 = JOptionPane.showOptionDialog(null, "Выбери валюту", "Твои варианты", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, variant0, variant0[2]);//инициализируем диалоговое окно после нажатия enter при вводе данных


                if (choice1 == 0) {// если выбрал вариант доллары
                    currencys.rubToDollar(put);

                    int choice2 = JOptionPane.showOptionDialog(null, "Еще раз ?", "Твои варианты", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, variant1, variant1[1]);


                    int choice3 = JOptionPane.showOptionDialog(null, "Выбери валюту", "Твои варианты", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, variant2, variant2[1]);
                    if (choice3==0){//если выбрал вариант перевода долларов в евро
                        currencys.euroToDollar(put);
                        break;
                    }


                    if (choice2 == 0) {//если выбрал вариант выйти в диалоговом окне


                    } else {
                        break;
                    }




                } else if (choice1 == 1) {
                    currencys.rubToEuro(put);

                    int choice2 = JOptionPane.showOptionDialog(null, "Еще раз ?", "Твои варианты", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, variant1, variant1[1]);


                    int choice4 = JOptionPane.showOptionDialog(null, "Еще раз ?", "Твои варианты", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, variant3, variant3[1]);
                    if (choice4==0){
                        currencys.dollarToEuro(put);
                        break;
                    }


                } else {
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, " Неверный ввод");//а это если данные не прошли проверку при вводе


            }
        }
    }
}



