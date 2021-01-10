package View;

import Model.FileInput;
import Model.SaveEditor;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

import static Model.FileOutput.generateEditedSaveFile;

public class StartingWindow {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Yet Another RBY Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(256,128));

        Container contentPane = frame.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        JButton browseButton = new JButton("Load Save File");
        contentPane.add(browseButton);

        JButton saveButton = new JButton("Save");
        contentPane.add(saveButton);

        final FileDialog filedialog = new java.awt.FileDialog((java.awt.Frame) null);
        final FileDialog saveDialog = new java.awt.FileDialog((java.awt.Frame) null, "Save", FileDialog.SAVE);


        layout.putConstraint(SpringLayout.WEST, browseButton,3,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, browseButton,0,SpringLayout.SOUTH, contentPane);

        layout.putConstraint(SpringLayout.EAST, saveButton,3,SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.SOUTH, saveButton,0,SpringLayout.SOUTH, contentPane);

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