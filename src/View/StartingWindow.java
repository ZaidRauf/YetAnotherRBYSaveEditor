package View;

import Controller.FileInput;
import Data.ItemKeys;
import Model.Item;
import Model.Player;
import Controller.SaveEditor;
import Controller.SaveReader;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;

import static Controller.FileOutput.generateEditedSaveFile;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

public class StartingWindow {

   private static Container contentPane = null;
   private static SpringLayout layout = null;
   private static JPanel infoPanel = null;
   private static JPanel pokeEditorPanel = null;
    private static JPanel itemEditorPanel = null;
    private static JPanel browserPanel = null;
   private static JPanel badgesPanel = null;
   private static JTextField nameField = null;
   private static JTextField rivalField = null;
   private static JTextField moneyField = null;
   private static JTextField coinsField = null;
   private static JTextField idField = null;
   private static JCheckBox[] checkArray = null;
   private static DefaultListModel<String> itemModel = null;
   private static JFormattedTextField itemAmountField = null;

   private static void createPlayerBadgesPanel(){
       JPanel panel = new JPanel();
       badgesPanel = panel;
       SpringLayout panelLayout = new SpringLayout();
       panel.setLayout(panelLayout);
       panel.setPreferredSize(new Dimension(160,210));
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

           updateBadgeValue(boulderCheck, 0);

       });

       cascadeCheck.addActionListener(e -> {
           updateBadgeValue(cascadeCheck, 1);
       });

       thunderCheck.addActionListener(e -> {
           updateBadgeValue(thunderCheck, 2);
       });

       rainbowCheck.addActionListener(e -> {
           updateBadgeValue(rainbowCheck, 3);

       });


       soulCheck.addActionListener(e -> {
           updateBadgeValue(soulCheck, 4);
       });

       marshCheck.addActionListener(e -> {
           updateBadgeValue(marshCheck, 5);
       });

       volcanoCheck.addActionListener(e -> {
           updateBadgeValue(volcanoCheck, 6);
       });

       earthCheck.addActionListener(e -> {
           updateBadgeValue(earthCheck, 7);
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

       panelLayout.putConstraint(SpringLayout.WEST, volcanoCheck, 23, SpringLayout.EAST, volcanoCheckLabel);

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
       panelLayout.putConstraint(SpringLayout.NORTH, cascadeCheckLabel, 7, SpringLayout.SOUTH, boulderCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, thunderCheckLabel, 7, SpringLayout.SOUTH, cascadeCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, rainbowCheckLabel, 7, SpringLayout.SOUTH, thunderCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, soulCheckLabel, 7, SpringLayout.SOUTH, rainbowCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, marshCheckLabel, 7, SpringLayout.SOUTH, soulCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, volcanoCheckLabel, 7, SpringLayout.SOUTH, marshCheckLabel);
       panelLayout.putConstraint(SpringLayout.NORTH, earthCheckLabel, 7, SpringLayout.SOUTH, volcanoCheckLabel);

   }

   private static void pokemonEditorPanel(){
       JPanel panel = new JPanel();
       pokeEditorPanel = panel;
       SpringLayout panelLayout = new SpringLayout();
       panel.setLayout(panelLayout);
       panel.setPreferredSize(new Dimension(330,210));
       Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
       raisedEtched = BorderFactory.createTitledBorder(raisedEtched, "PokéEditor");
       panel.setBorder(raisedEtched);
       contentPane.add(panel);

       layout.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.EAST, badgesPanel);
       layout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, badgesPanel);
   }

    private static void pokemonBrowserPanel(){
        JPanel panel = new JPanel();
        browserPanel = panel;
        SpringLayout panelLayout = new SpringLayout();
        panel.setLayout(panelLayout);
        panel.setPreferredSize(new Dimension(255,75));
        Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        raisedEtched = BorderFactory.createTitledBorder(raisedEtched, "PokéBrowser");
        panel.setBorder(raisedEtched);
        contentPane.add(panel);

        layout.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.EAST, badgesPanel);
        layout.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.SOUTH, itemEditorPanel);
    }

    private static void itemEditorPanel(){
        JPanel panel = new JPanel();
        itemEditorPanel = itemEditorPanel;
        SpringLayout panelLayout = new SpringLayout();
        panel.setLayout(panelLayout);
        panel.setPreferredSize(new Dimension(330,140));
        Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        raisedEtched = BorderFactory.createTitledBorder(raisedEtched, "Item Editor");
        panel.setBorder(raisedEtched);
        contentPane.add(panel);

        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> itemList = new JList<>( model );
        itemList.setSelectionMode(SINGLE_SELECTION);
        itemList.setLayoutOrientation(JList.VERTICAL);

        JScrollPane scroller = new JScrollPane(itemList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroller.setPreferredSize(new Dimension(90,80));
        panel.add(scroller);
        itemModel = model;

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        JComboBox<String> dropdownItemList = new JComboBox<>(comboBoxModel);
        dropdownItemList.setPreferredSize(new Dimension(138, 25));

        JLabel itemLabel = new JLabel("Item: ");
        panel.add(itemLabel);
        panelLayout.putConstraint(SpringLayout.EAST, itemLabel, 2, SpringLayout.WEST, dropdownItemList);
        panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, itemLabel, -2, SpringLayout.VERTICAL_CENTER, dropdownItemList);

        for(int key = 0; key < ItemKeys.numItems(); key++){
            String str = ItemKeys.getItemString(key);

            if (str == null){
                continue;
            }

            comboBoxModel.addElement(str);
        }

        panel.add(dropdownItemList);
        panelLayout.putConstraint(SpringLayout.EAST, dropdownItemList, 0, SpringLayout.EAST, panel);
        panelLayout.putConstraint(SpringLayout.NORTH, dropdownItemList, 20, SpringLayout.NORTH, panel);

        JLabel amountLabel = new JLabel("Amount:");
        panel.add(amountLabel);
        panelLayout.putConstraint(SpringLayout.NORTH, amountLabel, 10, SpringLayout.SOUTH, itemLabel);
        panelLayout.putConstraint(SpringLayout.WEST, amountLabel, 0, SpringLayout.WEST, itemLabel);

        NumberFormatter amountFormat = new NumberFormatter(NumberFormat.getIntegerInstance());
        amountFormat.setMinimum(1);
        amountFormat.setMaximum(99);
//        amountFormat.setAllowsInvalid(false);
        JFormattedTextField itemAmountInput = new JFormattedTextField(amountFormat);
        itemAmountInput.setColumns(2);
        panel.add(itemAmountInput);
        panelLayout.putConstraint(SpringLayout.WEST, itemAmountInput, 5, SpringLayout.EAST, amountLabel);
        panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, itemAmountInput, 2, SpringLayout.VERTICAL_CENTER, amountLabel);
        itemAmountField = itemAmountInput;

        itemAmountInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    if (itemList.getSelectedIndex() != -1 && !itemAmountInput.getText().equals("") && Integer.parseInt(itemAmountInput.getText()) > 0) {
                        SaveEditor.changeBagAmount(itemList.getSelectedIndex(), Integer.parseInt(itemAmountInput.getText()));
                    }
                }
                catch (NumberFormatException nfe){

                    //don't change value

                }
            }
        });

        JLabel countLabel = new JLabel("Capacity: ");
        panel.add(countLabel);
        panelLayout.putConstraint(SpringLayout.NORTH, countLabel, 10, SpringLayout.SOUTH, amountLabel);
        panelLayout.putConstraint(SpringLayout.WEST, countLabel, 0, SpringLayout.WEST, itemLabel);

        JButton addButton = new JButton("+");
        panel.add(addButton);
        addButton.setPreferredSize(new Dimension(40, 23));
        addButton.setToolTipText("Add a new item");
        panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, addButton, -12, SpringLayout.VERTICAL_CENTER, scroller);
        panelLayout.putConstraint(SpringLayout.WEST, addButton, 0, SpringLayout.EAST, scroller);

        JButton removeButton = new JButton("-");
        panel.add(removeButton);
        removeButton.setPreferredSize(new Dimension(40, 23));
        removeButton.setToolTipText("Remove the highlighted item");
        panelLayout.putConstraint(SpringLayout.NORTH, removeButton, 5, SpringLayout.SOUTH, addButton);
        panelLayout.putConstraint(SpringLayout.WEST, removeButton, 0, SpringLayout.EAST, scroller);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(itemList.getSelectedIndex() != -1) {
                    int currIdx = itemList.getSelectedIndex();

                    SaveEditor.removeBagItem(itemList.getSelectedIndex());
                    model.removeElementAt(itemList.getSelectedIndex());
                    itemAmountInput.setText("");

                    if(model.size() != 0 && currIdx != 0){
                        itemList.setSelectedIndex(currIdx-1);
                        itemAmountInput.setText("" + SaveReader.readBagItemAmount(itemList.getSelectedIndex()));
                    }
                }

                else if(model.size() > 0 && itemList.getSelectedIndex() == -1){
                    SaveEditor.removeBagItem(model.size() - 1);
                    model.removeElementAt(model.size() - 1);
                    itemAmountInput.setText("");
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveEditor.addBagItem((String) dropdownItemList.getSelectedItem(), 1);
                model.add(model.size(), (String) dropdownItemList.getSelectedItem());

                itemList.setSelectedIndex(model.size() - 1);
                itemAmountInput.setText("" + SaveReader.readBagItemAmount(model.size() - 1));

            }
        });

        panelLayout.putConstraint(SpringLayout.VERTICAL_CENTER, scroller, 0, SpringLayout.VERTICAL_CENTER, panel);
        panelLayout.putConstraint(SpringLayout.WEST, scroller, 10, SpringLayout.WEST, panel);

        layout.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.EAST, infoPanel);
        layout.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, contentPane);

        itemList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {//This line prevents double events
                    System.out.println(itemList.getSelectedIndex());

                    if(itemList.getSelectedIndex() != -1) {
                        itemAmountInput.setText("" + SaveReader.readBagItemAmount(itemList.getSelectedIndex()));

                        dropdownItemList.setSelectedItem(itemList.getSelectedValue());

                    }

                }
            }

        });

        dropdownItemList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(itemList.getSelectedIndex() != -1) {

                    SaveEditor.changeBagItem(itemList.getSelectedIndex(), (String) dropdownItemList.getSelectedItem());
                    model.setElementAt((String) dropdownItemList.getSelectedItem(), itemList.getSelectedIndex());

                }
            }
        });

    }

    private static void createPlayerInfoPanel(){
        JPanel panel = new JPanel();
        SpringLayout panelLayout = new SpringLayout();
        panel.setLayout(panelLayout);
        panel.setPreferredSize(new Dimension(160,140));
        Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        raisedEtched = BorderFactory.createTitledBorder(raisedEtched, "Player Info");
        panel.setBorder(raisedEtched);
        contentPane.add(panel);

        layout.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, panel, 5, SpringLayout.NORTH, contentPane);

        JLabel nameLabel = new JLabel("Name: ");
        panel.add(nameLabel);

        JTextField nameInput = new  JTextField(7);
        nameField = nameInput;
        panel.add(nameInput);

        JLabel moneyLabel = new JLabel("Money: ");
        panel.add(moneyLabel);

        JTextField moneyInput = new JTextField(7);
        moneyField = moneyInput;
        panel.add(moneyInput);

        JLabel coinsLabel = new JLabel("Coins: ");
        panel.add(coinsLabel);

        JTextField coinsInput = new JTextField(7);
        coinsField = coinsInput;
        panel.add(coinsInput);

        JLabel idLabel = new JLabel("ID: ");
        panel.add(idLabel);

        JTextField idInput = new JTextField(7);
        idField = idInput;
        panel.add(idInput);

        JLabel rivalLabel = new JLabel("Rival: ");
        panel.add(rivalLabel);

        JTextField rivalInput = new JTextField(7);
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
        frame.setPreferredSize(new Dimension(515,430));

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

                    SaveReader.readBagItemList();

                    itemModel.clear();
                    for(Item item : Player.bagItemList){
                        itemModel.addElement(item.getItemName());
                    }

                    int bitCheck =  0b00000001;

                    for (int i = 0; i < 8; i++){
                        int result = bitCheck & Player.gymBadges;
                        result = result >> i;

                        checkArray[i].setSelected(result == 0x1);

                        System.out.printf("0x%X", result);
                        System.out.println();
                        bitCheck = bitCheck << 1;

                    }

                    Player.money = SaveReader.readPlayerMoney();
                    moneyField.setText(Integer.toString(Player.money));

                    Player.coins = SaveReader.readPlayerCoins();
                    coinsField.setText(Integer.toString(Player.coins));

                    Player.trainerID = SaveReader.readPlayerID();
                    idField.setText(SaveReader.readPlayerIDStr());

                    itemAmountField.setText("");


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
                    SaveEditor.writeBagItems();
                    SaveEditor.updateMainDataChecksum();

                    generateEditedSaveFile(saveDialog.getDirectory(), saveDialog.getFile(), SaveEditor.getSaveGameData());
                } catch (IOException ioe) {
                    JOptionPane.showMessageDialog(frame, "Invalid File: Could not be saved");
                }
            }
        });

        createPlayerInfoPanel();
        createPlayerBadgesPanel();
        pokemonEditorPanel();
        itemEditorPanel();

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            System.exit(1);
        }

        createAndShowGUI();
    }

    private static void updateBadgeValue(JCheckBox badgeCheck, int badgeNum ){
       int checkMask = 0b00000001 << badgeNum;
       int uncheckMask = ~checkMask;

        if(badgeCheck.isSelected()) {
            Player.gymBadges = Player.gymBadges | checkMask;
        }

        else{
            Player.gymBadges = Player.gymBadges & uncheckMask;
        }
        System.out.print("Badge Check: ");
        System.out.printf("0x%X", Player.gymBadges);
        System.out.println();
    }


}