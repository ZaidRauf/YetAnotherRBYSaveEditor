package View;

import javax.swing.*;

public class StartingWindow {
    public static void main(String args[]){
        JFrame frame = new JFrame("Yet Another Red/Blue/Yellow Save Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
    }


}
