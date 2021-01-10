package View;

import Model.FileInput;
import Model.SaveEditor;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import static Model.FileOutput.generateEditedSaveFile;

public class StartingWindow {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Yet Another RBY Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(750,512));

        Container contentPane = frame.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        JPanel panel = new JPanel();
        SpringLayout panelLayout = new SpringLayout();
        panel.setLayout(panelLayout);
        panel.setPreferredSize(new Dimension(225,80));
        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        panel.setBorder(raisedetched);
        contentPane.add(panel);

        layout.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, contentPane);

        JButton browseButton = new JButton("Load Save File");
        contentPane.add(browseButton);

        JButton saveButton = new JButton("Save");
        contentPane.add(saveButton);

        JLabel nameLabel = new JLabel("Name: ");
        panel.add(nameLabel);

        JTextField nameInput = new JTextField(12);
        panel.add(nameInput);

        JLabel moneyLabel = new JLabel("Money: ");
        panel.add(moneyLabel);

        JTextField moneyInput = new JTextField(12);
        panel.add(moneyInput);

        JLabel coinsLabel = new JLabel("Coins: ");
        panel.add(coinsLabel);

        JTextField coinsInput = new JTextField(12);
        panel.add(coinsInput);

        final FileDialog filedialog = new java.awt.FileDialog((java.awt.Frame) null);
        final FileDialog saveDialog = new java.awt.FileDialog((java.awt.Frame) null, "Save", FileDialog.SAVE);


        layout.putConstraint(SpringLayout.WEST, browseButton,3,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, browseButton,0,SpringLayout.SOUTH, contentPane);

        layout.putConstraint(SpringLayout.EAST, saveButton,3,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, saveButton,0,SpringLayout.SOUTH, contentPane);

        panelLayout.putConstraint(SpringLayout.NORTH, nameLabel,3,SpringLayout.NORTH, panel);
        panelLayout.putConstraint(SpringLayout.WEST, nameLabel,3,SpringLayout.NORTH, panel);

        panelLayout.putConstraint(SpringLayout.WEST, nameInput,5,SpringLayout.EAST, nameLabel);

        panelLayout.putConstraint(SpringLayout.WEST, moneyLabel,3,SpringLayout.NORTH, panel);
        panelLayout.putConstraint(SpringLayout.NORTH, moneyLabel,7,SpringLayout.SOUTH, nameLabel);

        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, moneyInput,0,SpringLayout.WEST, moneyLabel);
        panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, moneyInput,0,SpringLayout.VERTICAL_CENTER, moneyLabel);
        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, moneyInput,0,SpringLayout.HORIZONTAL_CENTER, nameInput);

        panelLayout.putConstraint(SpringLayout.WEST, coinsLabel,3,SpringLayout.NORTH, panel);
        panelLayout.putConstraint(SpringLayout.NORTH, coinsLabel,7,SpringLayout.SOUTH, moneyLabel);

        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, coinsInput, 0, SpringLayout.HORIZONTAL_CENTER, moneyInput);
        panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, coinsInput, 0, SpringLayout.VERTICAL_CENTER, coinsLabel);

        FileInput fileInput = new FileInput();
        SaveEditor saveEditor = new SaveEditor();

        browseButton.addActionListener(e -> {
            filedialog.setVisible(true);

            File f = new File(filedialog.getDirectory() + filedialog.getFile()); //TODO: Check if it is a valid save file
            if(f.exists() && !f.isDirectory()) {

                try {
                    fileInput.loadSaveFile(filedialog.getDirectory() + filedialog.getFile());
                    saveEditor.setSaveGameData(fileInput.getSaveFileData());
                }

                catch (IOException ioe){
                    JOptionPane.showMessageDialog(frame, "Invalid File: Could not be loaded");
                }
            }
        });

        saveButton.addActionListener(e -> {

            saveDialog.setVisible(true);

            if (saveDialog.getDirectory() != null && saveDialog.getFile() != null) {
                if(fileInput.getSaveFileData() == null){
                    JOptionPane.showMessageDialog(frame, "No file currently loaded!");
                    return;
                }

                System.out.println(saveDialog.getDirectory() + saveDialog.getFile());

                try {
                    generateEditedSaveFile(saveDialog.getDirectory(), saveDialog.getFile(), saveEditor.getSaveGameData());
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(frame, "Invalid File: Could not be saved");
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
                createAndShowGUI();
    }
}