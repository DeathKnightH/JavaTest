package cn.dk.common.tools;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(JPanel panel) throws HeadlessException {
        super();
        init(panel);
    }

    private void init(JPanel panel){
        this.setSize(1600,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
