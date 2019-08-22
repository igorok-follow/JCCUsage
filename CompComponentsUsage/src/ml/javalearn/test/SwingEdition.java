package ml.javalearn.test;

import ml.javalearn.back.app.RAMUsage;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class SwingEdition extends JFrame {

    private JLabel label;
    private JPanel panel;

    SwingEdition() {
        initFrame();
        setPanel();
        setLabel();
        setTimer();
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("test");
        setBounds(100, 100, 300, 300);
        setVisible(true);
    }

    private void setLabel() {
        label = new JLabel("first text");
        panel.add(label);
    }

    private void setPanel() {
        panel = new JPanel();
        getContentPane().add(panel);
    }

    private void setTimer() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                label.setText(new RAMUsage().getInfoRam());
            }
        };

        timer.schedule(timerTask, 10, 1000);
    }

    public static void main(String[] args) {
        new SwingEdition();
    }

}
