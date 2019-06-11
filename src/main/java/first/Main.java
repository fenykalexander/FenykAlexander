package first;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.*;

 class Note extends JFrame {
  JEditorPane textArea = new JEditorPane();//текстовый редактор

  JTextArea theText = new JTextArea();//многострочное поле текста
  JMenuBar jMenuBar = new JMenuBar();//общее меню

  JMenu file = new JMenu();//в меню добавляем опцию файл
  JMenuItem open = new JMenuItem();//добавляем опции открытия,сохранения и выхода
  JMenuItem save = new JMenuItem();
  JMenuItem exit = new JMenuItem();

  JMenu copytext = new JMenu();//опции работы с текстом
  JMenuItem copy = new JMenuItem();
  JMenuItem past = new JMenuItem();
  JMenuItem cut = new JMenuItem();

  JMenu textoption = new JMenu();//опции шрифта
  JMenuItem textj = new JMenuItem();//
  JMenuItem texti = new JMenuItem();
  JMenuItem textp = new JMenuItem();


  public Note() throws Exception {//конструктор с параметрами блокнота,размер,стан. шрифт и т.д
   this.setSize(500, 500);
   this.setTitle("Блокнот");
   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   this.textArea.setFont(new Font("", Font.PLAIN, 14));
   this.getContentPane().setLayout(new BorderLayout());
   this.getContentPane().add(textArea);//добавляем фун цию текстового редактора к рамке блокнота
   this.getContentPane().add(new JScrollPane(textArea));//добавляем вращение

   jMenuBar.add(file);//добаляем в меню все функции, сохрание,изменение шрифта и т.д
   jMenuBar.add(copytext);
   jMenuBar.add(textoption);

   setJMenuBar(jMenuBar);//установка меню со всеми добавленными опциями

   file.setText("Фаил");//титульник для работы с файлом
   open.setText("Открыть");//возможные операции с файлом
   file.add(open);//добавление операций к титульнику
   save.setText("Сохранить");
   exit.setText("Выход");
   file.add(exit);
   file.add(save);

   exit.addActionListener(new ActionListener() {//инициализация стандартных операций

    public void actionPerformed(ActionEvent e) {//вызов стандартного метода из библиотеки и добавление к нему фунций
     JOptionPane.showMessageDialog(exit, "Всего хорошего");
     System.exit(0);
    }
   });

   save.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
     JFileChooser save = new JFileChooser();//
     int option = save.showSaveDialog(save);//вызов диалога для сохранения(куда сохранять)
     if (option == JFileChooser.APPROVE_OPTION) {//выбор файла в диалоговом режиме
      try {
       BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));//
       out.write(textArea.getText());//выод текста из выбранного файла
       out.close();//закрытие окна после этого
      } catch (Exception ex) {
       System.out.println(ex.getMessage());//вывод на экран
      }
     }
    }
   });

   open.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
     JFileChooser open = new JFileChooser();
     int option = open.showOpenDialog(open);
     if (option == JFileChooser.APPROVE_OPTION) {
      theText.setText("");//
      try {
       Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));//
       while (scan.hasNext()) textArea.setText(scan.nextLine() + "\n");//
      } catch (Exception ex) {//
       System.out.println(ex.getMessage());
      }
     }
    }
   });

   copytext.setText("Копирование");//аналогично файлу и его опциям
   copy.setText("Копировать");
   past.setText("Вставить");
   copytext.add(past);
   cut.setText("Вырезать");
   copytext.add(cut);
   copytext.add(copy);

   copy.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
     textArea.copy();//стандартная реализация процедуры удаления
    }
   });
   past.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
     textArea.paste();
    }
   });
   cut.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
     textArea.cut();
    }
   });

   textoption.setText("Изменение шрифта");//работа со шрифтом аналогичная работе с файлом
   textj.setText("Жирный");
   textoption.add(textj);
   texti.setText("Курсивный");
   textoption.add(texti);
   textp.setText("Стандартный");
   textoption.add(textp);

   texti.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
     textArea.setFont(new Font("TAHOMA", Font.ITALIC, 14));
    }
   });
   textj.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent ae) {
     textArea.setFont(new Font("", Font.BOLD, 14));
    }
   });
   textp.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent ae) {
     textArea.setFont(new Font("", Font.PLAIN, 14));
    }
   });
  }

  public static void main (String args[]) throws Exception {//точка входа в программу
  Note app = new Note();
   app.setVisible(true);//видимость блокнота
  }
 }



