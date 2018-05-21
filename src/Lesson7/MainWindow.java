package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    JLabel nameLable;
    JLabel lastnameLable;
    JLabel patronymicLable;


    public MainWindow(int x, int y) {

        JButton mainButton = new JButton("Добавить ФИО");
        JPanel panelInfo = new JPanel(new GridLayout(3, 1));
        nameLable = new JLabel();
        lastnameLable = new JLabel();
        patronymicLable = new JLabel();

        panelInfo.add(nameLable);
        panelInfo.add(lastnameLable);
        panelInfo.add(patronymicLable);
        //panelInfo.add(mainButton);
        add(panelInfo, BorderLayout.CENTER);
        add(mainButton, BorderLayout.SOUTH);
        setTitle("Главное окно");
        setBounds(50, 100, x, y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateNewWindow(500, 500);
            }
        });


    }

    void CreateNewWindow(int x, int y) {

        JFrame frame = new JFrame();
        JButton button = new JButton("Ok");
        JTextField textName = new JTextField();
        JTextField textLastname = new JTextField();
        JTextField textPatronymic = new JTextField();

        frame.setTitle("Вводи информации");
        frame.setBounds(x, y, x, y);

        JPanel panelInfo = new JPanel(new GridLayout(4, 1));
        panelInfo.add(textName);
        panelInfo.add(textLastname);
        panelInfo.add(textPatronymic);
        panelInfo.add(button);
        frame.add(panelInfo, BorderLayout.CENTER);

        frame.setResizable(false);
        frame.setLocation(100,100);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                setupName(textName.getText(), textLastname.getText(), textPatronymic.getText());
//                frame = null;
                frame.dispose();
            }
        });

    }

    void setupName(String name, String lastname, String patronymic) {

        nameLable.setText(name);
        lastnameLable.setText(lastname);
        patronymicLable.setText(patronymic);

    }
}

