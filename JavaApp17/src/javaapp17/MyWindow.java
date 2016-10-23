package javaapp17;

import javax.swing.*;
import javax.swing.text.FlowView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    public MyWindow() {
        //завершать работу приложения при закрытии окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //утановка первоначального размера и положения  окна на рабочем столе
        this.setBounds(500, 400, 300, 200);
        //установка заголовка для окна
        this.setTitle("Заголовок формы");

        //Объект кнопки
        JButton button = new JButton("Click me!!!");

        //Добавление кнопопки в окно
        this.getContentPane().add(button);

        //Добавление обработчика нажатия на кнопку
        button.addActionListener(new HelloButtonListener());

        //Объект текстового поля
        nameField = new JTextField();
        nameField.setSize(100, 35);

        //табличное размещение объектов (2 строки, 1-столбец)
        GridLayout gridLayout = new GridLayout(2, 1);

        JPanel panel = new JPanel();
        panel.setLayout(gridLayout);
        panel.add(nameField);
        panel.add(button);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel, BorderLayout.WEST);
        mainPanel.add(new SpritePanel(),BorderLayout.CENTER);

        this.getContentPane().add(mainPanel);

    }

    //внутренний класс
    //класс обработчик событий типа ActionListener
    class HelloButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String name = nameField.getText();
            if (name.equals(""))
                JOptionPane.showMessageDialog(null, "Введите имя");
            else
                JOptionPane.showMessageDialog(null, "Привет, " + name);
        }
    }

    private JTextField nameField;

}
