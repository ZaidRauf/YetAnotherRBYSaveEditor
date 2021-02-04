package View;

import Model.FileInput;
import Model.Player;
import Model.SaveEditor;
import Model.SaveReader;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import static Model.FileOutput.generateEditedSaveFile;

public class StartingWindow {

   private static Container contentPane = null;
   private static SpringLayout layout = null;
   private static JPanel infoPanel = null;
   private static JTextField nameField = null;
   private static JTextField rivalField = null;
   private static JTextField moneyField = null;
   private static JTextField coinsField = null;
   private static JTextField idField = null;
   private static JCheckBox[] checkArray = null;

   private static void createPlayerBadgesPanel(){
       JPanel panel = new JPanel();
       SpringLayout panelLayout = new SpringLayout();
       panel.setLayout(panelLayout);
       panel.setPreferredSize(new Dimension(150,200));
       Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
       raisedEtched = BorderFactory.createTitledBorder(raisedEtched, "Badges");
       panel.setBorder(raisedEtched);
       contentPane.add(panel);

       layout.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, contentPane);
       layout.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.SOUTH, infoPanel);

       JCheckBox boulderCheck = new JCheckBox();
       JCheckBox cascadeCheck = new JCheckBox();
       JCheckBox thunderCheck = new JCheckBox();
       JCheckBox rainbowCheck = new JCheckBox();
       JCheckBox soulCheck = new JCheckBox();
       JCheckBox marshCheck = new JCheckBox();
       JCheckBox volcanoCheck = new JCheckBox();
       JCheckBox earthCheck = new JCheckBox();

       boulderCheck.addActionListener(e -> {

           if(boulderCheck.isSelected()) {
               Player.gymBadges = Player.gymBadges | 0b10000000;
           }

           else{
               Player.gymBadges = Player.gymBadges & 0b01111111;
           }
           System.out.print("Badge Check: ");
           System.out.printf("0x%X", Player.gymBadges);
           System.out.println();

       });

       cascadeCheck.addActionListener(e -> {
           if(cascadeCheck.isSelected()) {
               Player.gymBadges = Player.gymBadges | 0b01000000;
           }

           else{
               Player.gymBadges = Player.gymBadges & 0b10111111;
           }
           System.out.print("Badge Check: ");
           System.out.printf("0x%X", Player.gymBadges);
           System.out.println();

       });

       thunderCheck.addActionListener(e -> {
           if(thunderCheck.isSelected()) {
               Player.gymBadges = Player.gymBadges | 0b00100000;
           }

           else{
               Player.gymBadges = Player.gymBadges & 0b11011111;
           }
           System.out.print("Badge Check: ");
           System.out.printf("0x%X", Player.gymBadges);
           System.out.println();
       });

       rainbowCheck.addActionListener(e -> {
           if(rainbowCheck.isSelected()) {
               Player.gymBadges = Player.gymBadges | 0b00010000;
           }

           else{
               Player.gymBadges = Player.gymBadges & 0b11101111;
           }
           System.out.print("Badge Check: ");
           System.out.printf("0x%X", Player.gymBadges);
           System.out.println();
       });


       soulCheck.addActionListener(e -> {
           if(soulCheck.isSelected()) {
               Player.gymBadges = Player.gymBadges | 0b00001000;
           }

           else{
               Player.gymBadges = Player.gymBadges & 0b11110111;
           }
           System.out.print("Badge Check: ");
           System.out.printf("0x%X", Player.gymBadges);
           System.out.println();
       });

       marshCheck.addActionListener(e -> {
           if(marshCheck.isSelected()) {
               Player.gymBadges = Player.gymBadges | 0b00000100;
           }

           else{
               Player.gymBadges = Player.gymBadges & 0b11111011;
           }
           System.out.print("Badge Check: ");
           System.out.printf("0x%X", Player.gymBadges);
           System.out.println();          });

       volcanoCheck.addActionListener(e -> {
           if(volcanoCheck.isSelected()) {
               Player.gymBadges = Player.gymBadges | 0b00000010;
           }

           else{
               Player.gymBadges = Player.gymBadges & 0b11111101;
           }
           System.out.print("Badge Check: ");
           System.out.printf("0x%X", Player.gymBadges);
           System.out.println();
       });

       earthCheck.addActionListener(e -> {
           if(earthCheck.isSelected()) {
               Player.gymBadges = Player.gymBadges | 0b00000001;
           }

           else{
               Player.gymBadges = Player.gymBadges & 0b11111110;
           }
           System.out.print("Badge Check: ");
           System.out.printf("0x%X", Player.gymBadges);
           System.out.println();
       });



       panel.add(boulderCheck);
       panel.add(cascadeCheck);
       panel.add(thunderCheck);
       panel.add(rainbowCheck);
       panel.add(soulCheck);
       panel.add(marshCheck);
       panel.add(volcanoCheck);
       panel.add(earthCheck);

       JLabel boulderCheckLabel = new JLabel("Boulder Badge");
       JLabel cascadeCheckLabel = new JLabel("Cascade Badge");
       JLabel thunderCheckLabel = new JLabel("Thunder Badge");
       JLabel rainbowCheckLabel = new JLabel("Rainbow Badge");
       JLabel soulCheckLabel = new JLabel("Soul Badge");
       JLabel marshCheckLabel = new JLabel("Marsh Badge");
       JLabel volcanoCheckLabel = new JLabel("Volcano Badge");
       JLabel earthCheckLabel = new JLabel("Earth Badge");

       checkArray = new JCheckBox[8];

       checkArray[0] = boulderCheck;
       checkArray[1] = cascadeCheck;
       checkArray[2] = thunderCheck;
       checkArray[3] = rainbowCheck;
       checkArray[4] = soulCheck;
       checkArray[5] = marshCheck;
       checkArray[6]= volcanoCheck;
       checkArray[7] = earthCheck;

       panel.add(boulderCheckLabel);
       panel.add(cascadeCheckLabel);
       panel.add(thunderCheckLabel);
       panel.add(rainbowCheckLabel);
       panel.add(soulCheckLabel);
       panel.add(marshCheckLabel);
       panel.add(volcanoCheckLabel);
       panel.add(earthCheckLabel);

       panelLayout.putConstraint(SpringLayout.WEST, volcanoCheck, 8, SpringLayout.EAST, volcanoCheckLabel);

       for(JCheckBox badgeCheck: checkArray){
           if (badgeCheck == checkArray[6]){
               continue;
           }

           panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, badgeCheck, 0, SpringLayout.HORIZONTAL_CENTER, volcanoCheck);
       }

       panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, volcanoCheck, 0, SpringLayout.VERTICAL_CENTER, volcanoCheckLabel);
       panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, boulderCheck, 0, SpringLayout.VERTICAL_CENTER, boulderCheckLabel);
       panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, cascadeCheck, 0, SpringLayout.VERTICAL_CENTER, cascadeCheckLabel);
       panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, thunderCheck, 0, SpringLayout.VERTICAL_CENTER, thunderCheckLabel);
       panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, rainbowCheck, 0, SpringLayout.VERTICAL_CENTER, rainbowCheckLabel);
       panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, soulCheck, 0, SpringLayout.VERTICAL_CENTER, soulCheckLabel);
       panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, marshCheck, 0, SpringLayout.VERTICAL_CENTER, marshCheckLabel);
       panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, marshCheck, 0, SpringLayout.VERTICAL_CENTER, marshCheckLabel);
       panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, earthCheck, 0, SpringLayout.VERTICAL_CENTER, earthCheckLabel);


       panelLayout.putConstraint(SpringLayout.WEST, boulderCheckLabel, 5, SpringLayout.WEST, panel);
       panelLayout.putConstraint(SpringLayout.WEST, cascadeCheckLabel, 0, SpringLayout.WEST, boulderCheckLabel);
       panelLayout.putConstraint(SpringLayout.WEST, thunderCheckLabel, 0, SpringLayout.WEST, cascadeCheckLabel);
       panelLayout.putConstraint(SpringLayout.WEST, rainbowCheckLabel, 0, SpringLayout.WEST, thunderCheckLabel);
       panelLayout.putConstraint(SpringLayout.WEST, soulCheckLabel, 0, SpringLayout.WEST, rainbowCheckLabel);
       panelLayout.putConstraint(SpringLayout.WEST, marshCheckLabel, 0, SpringLayout.WEST, soulCheckLabel);
       panelLayout.putConstraint(SpringLayout.WEST, volcanoCheckLabel, 0, SpringLayout.WEST, marshCheckLabel);
       panelLayout.putConstraint(SpringLayout.WEST, earthCheckLabel, 0, SpringLayout.WEST, volcanoCheckLabel);


       panelLayout.putConstraint(SpringLayout.NORTH, boulderCheckLabel, 5, SpringLayout.NORTH, panel);
       panelLayout.putConstraint(SpringLayout.NORTH, cascadeCheckLabel, 5, SpringLayout.SOUTH, boulderCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, thunderCheckLabel, 5, SpringLayout.SOUTH, cascadeCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, rainbowCheckLabel, 5, SpringLayout.SOUTH, thunderCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, soulCheckLabel, 5, SpringLayout.SOUTH, rainbowCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, marshCheckLabel, 5, SpringLayout.SOUTH, soulCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, volcanoCheckLabel, 5, SpringLayout.SOUTH, marshCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, earthCheckLabel, 5, SpringLayout.SOUTH, volcanoCheckLabel);

   }

    private static void createPlayerInfoPanel(){
        JPanel panel = new JPanel();
        SpringLayout panelLayout = new SpringLayout();
        panel.setLayout(panelLayout);
        panel.setPreferredSize(new Dimension(225,140));
        Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        raisedEtched = BorderFactory.createTitledBorder(raisedEtched, "Player Info");
        panel.setBorder(raisedEtched);
        contentPane.add(panel);

        layout.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, contentPane);

        JLabel nameLabel = new JLabel("Name: ");
        panel.add(nameLabel);

        JTextField nameInput = new JTextField(12);
        nameField = nameInput;
        panel.add(nameInput);

        JLabel moneyLabel = new JLabel("Money: ");
        panel.add(moneyLabel);

        JTextField moneyInput = new JTextField(12);
        moneyField = moneyInput;
        panel.add(moneyInput);

        JLabel coinsLabel = new JLabel("Coins: ");
        panel.add(coinsLabel);

        JTextField coinsInput = new JTextField(12);
        coinsField = coinsInput;
        panel.add(coinsInput);

        JLabel idLabel = new JLabel("ID: ");
        panel.add(idLabel);

        JTextField idInput = new JTextField(12);
        idField = idInput;
        panel.add(idInput);

        JLabel rivalLabel = new JLabel("Rival: ");
        panel.add(rivalLabel);

        JTextField rivalInput = new JTextField(12);
        rivalField = rivalInput;
        panel.add(rivalInput);

        nameInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                Player.playerName = nameInput.getText();
            }
        });

        rivalInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                Player.rivalName = rivalInput.getText();
            }
        });

        moneyInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                Player.money = Integer.parseInt(moneyInput.getText());
            }
        });

        coinsInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                Player.coins = Integer.parseInt(coinsInput.getText());
            }
        });

        idInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                Player.trainerID = Integer.parseInt(idInput.getText());
            }
        });



        panelLayout.putConstraint(SpringLayout.NORTH, nameLabel,3,SpringLayout.NORTH, panel);
        panelLayout.putConstraint(SpringLayout.WEST, nameLabel,3,SpringLayout.NORTH, panel);

        panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, nameInput,0,SpringLayout.VERTICAL_CENTER, nameLabel);
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

        panelLayout.putConstraint(SpringLayout.WEST, idLabel, 0, SpringLayout.WEST, coinsLabel);
        panelLayout.putConstraint(SpringLayout.NORTH, idLabel, 7, SpringLayout.SOUTH, coinsLabel);

        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, idInput, 0, SpringLayout.HORIZONTAL_CENTER, moneyInput);
        panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, idInput, 0, SpringLayout.VERTICAL_CENTER, idLabel);

        panelLayout.putConstraint(SpringLayout.WEST, rivalLabel, 0, SpringLayout.WEST, idLabel);
        panelLayout.putConstraint(SpringLayout.NORTH, rivalLabel, 7, SpringLayout.SOUTH, idLabel);

        panelLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, rivalInput, 0, SpringLayout.HORIZONTAL_CENTER, moneyInput);
        panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, rivalInput, 0, SpringLayout.VERTICAL_CENTER, rivalLabel);


        infoPanel = panel;

    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Yet Another RBY Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(750,512));

        contentPane = frame.getContentPane();
        layout = new SpringLayout();
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

        browseButton.addActionListener(e -> {
            filedialog.setVisible(true);

            File f = new File(filedialog.getDirectory() + filedialog.getFile()); //TODO: Check if it is a valid save file
            if(f.exists() && !f.isDirectory()) {

                try {
                    fileInput.loadSaveFile(filedialog.getDirectory() + filedialog.getFile());
                    SaveEditor.setSaveGameData(fileInput.getSaveFileData());
                    SaveReader.setSaveGameData(SaveEditor.getSaveGameData());

                    Player.playerName = SaveReader.readPlayerName();
                    nameField.setText(Player.playerName);

                    Player.rivalName = SaveReader.readRivalName();
                    rivalField.setText(Player.rivalName);

                    Player.gymBadges = SaveReader.readBadges();

                    int bitCheck =  0b10000000;

                    for (int i = 0; i < 8; i++){
                        int result = bitCheck & Player.gymBadges;
                        result = result >> 7 - i;

                        checkArray[i].setSelected(result == 0x1);

                        System.out.printf("0x%X", result);
                        System.out.println();
                        bitCheck = bitCheck >> 1;

                    }

                    Player.money = SaveReader.readPlayerMoney();
                    moneyField.setText(Integer.toString(Player.money));

                    Player.coins = SaveReader.readPlayerCoins();
                    coinsField.setText(Integer.toString(Player.coins));

                    Player.trainerID = SaveReader.readPlayerID();
                    idField.setText(SaveReader.readPlayerIDStr());


                }

                catch (IOException ioe){
                    JOptionPane.showMessageDialog(frame, "Invalid File: Could not be loaded");
                }
            }
        });

        saveButton.addActionListener(e -> {

            if(fileInput.getSaveFileData() == null){
                JOptionPane.showMessageDialog(frame, "No file currently loaded!");
                return;
            }

            saveDialog.setVisible(true);

            if (saveDialog.getDirectory() != null && saveDialog.getFile() != null) {

                System.out.println(saveDialog.getDirectory() + saveDialog.getFile());

                try {
                    SaveEditor.changePlayerName(Player.playerName);
                    SaveEditor.changePlayerRivalName(Player.rivalName);
                    SaveEditor.changePlayerBadges((byte) Player.gymBadges);
                    SaveEditor.changePlayerMoney(Player.money);
                    SaveEditor.changePlayerMoney(Player.money);
                    SaveEditor.changePlayerGameCornerCoins(Player.coins);
                    SaveEditor.changePlayerID(Player.trainerID);
                    SaveEditor.updateMainDataChecksum();

                    generateEditedSaveFile(saveDialog.getDirectory(), saveDialog.getFile(), SaveEditor.getSaveGameData());
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(frame, "Invalid File: Could not be saved");
                }
            }
        });

        createPlayerInfoPanel();
        createPlayerBadgesPanel();

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }
}