//Caleb Garcia

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
    //Panels
    JPanel containerPanel = new JPanel(new BorderLayout());
    JPanel inputPanel = new JPanel(null);
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 15));
    
    //Labels
    JLabel nameLbl = new JLabel("Name:");
    JLabel basePriceLbl = new JLabel("Base Price - ($31,000)");
    //Input group labels
    JLabel cabStyleLbl = new JLabel("Cab Style:");
    JLabel bedLbl = new JLabel("Bed:");
    JLabel engineLbl = new JLabel("Engine:");
    JLabel additionalLbl = new JLabel("Additional Features:");
    JLabel colorLbl = new JLabel("Color:");
    
    //Text fields
    JTextField nameTxt = new JTextField();
    
    //Radios
    //Cab style
    JRadioButton standardCabRadio = new JRadioButton("Standard - (-$2,800)");
    JRadioButton extendedRadio = new JRadioButton("Extended - (base)");
    JRadioButton crewRadio = new JRadioButton("Crew - (+$1,750)");
    
    //Bed style
    JRadioButton shortRadio = new JRadioButton("Short - (-$1,210)");
    JRadioButton standardBedRadio = new JRadioButton("Standard - (base)");
    JRadioButton fullRadio = new JRadioButton("Full - (+$1,460)");
    
    //Engine
    JRadioButton v6Radio = new JRadioButton("V-6 - (base)");
    JRadioButton v8Radio = new JRadioButton("V-8 - (+$2,730)");
    
    //Color
    JRadioButton whiteRadio = new JRadioButton("White");
    JRadioButton blueRadio = new JRadioButton("Blue");
    JRadioButton redRadio = new JRadioButton("Red");
    JRadioButton blackRadio = new JRadioButton("Black");
    JRadioButton charcoalRadio = new JRadioButton("Charcoal");
    
    //Radio groups
    ButtonGroup cabGrp = new ButtonGroup();
    ButtonGroup bedGrp = new ButtonGroup();
    ButtonGroup engineGrp = new ButtonGroup();
    ButtonGroup colorGrp = new ButtonGroup();
    
    //Check boxes
    JCheckBox fourWheelBox = new JCheckBox("4WD - (+$1,870)");
    JCheckBox runningBox = new JCheckBox("Running boards - (+$540)");
    JCheckBox alloyBox = new JCheckBox("Alloy wheels - (+$620)");
    JCheckBox atSuspBox = new JCheckBox("All-terrain suspension - (+$1,400)");
    
    //Util buttons
    JButton buildBtn = new JButton("Build");
    JButton overBtn = new JButton("Start Over");
    JButton exitBtn = new JButton("Exit");
    
    //Misc
    Double basePrice = 31000.00;
    
    //button and check lists
    ArrayList<JRadioButton> cabBtns = new ArrayList();
    ArrayList<JRadioButton> bedBtns = new ArrayList();
    ArrayList<JRadioButton> engineBtns = new ArrayList();
    ArrayList<JCheckBox> additionalChecks = new ArrayList();
    ArrayList<JRadioButton> colorBtns = new ArrayList();
    
    public Home() {
        // Frame and panel settings
        pack();
        setSize(Constants.HOME_WINDOW_WIDTH, Constants.HOME_WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Truck Builder");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().add(containerPanel);
        
        inputPanel.setPreferredSize(new Dimension(500, 450));
        buttonPanel.setPreferredSize(new Dimension(500, 50));
        
        containerPanel.add(inputPanel, BorderLayout.CENTER);
        containerPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        buildInputPanel();
        buildButtonPanel();
        
        containerPanel.revalidate();
    }
    
    private void buildInputPanel() {
        buildNameAndBasePrice();
        buildCabGroup();
        buildBedGroup();
        buildEngineGroup();
        buildAdditional();
        buildColorGroup();
    }
    
    private void buildNameAndBasePrice() {
        nameLbl.setBounds(30, 30, 50, 15);
        nameLbl.setFont(Constants.BOLD_FONT);
        nameTxt.setBounds(70, 30, 100, 20);
        basePriceLbl.setBounds(320, 30, 130, 15);
        basePriceLbl.setFont(Constants.BOLD_FONT);
        
        inputPanel.add(nameLbl);
        inputPanel.add(nameTxt);
        inputPanel.add(basePriceLbl);
    }
    
    private void buildCabGroup() {
        cabGrp.add(standardCabRadio);
        cabGrp.add(extendedRadio);
        cabGrp.add(crewRadio);
        
        cabStyleLbl.setBounds(30, 80, 80, 15);
        cabStyleLbl.setFont(Constants.BOLD_FONT);
        standardCabRadio.setBounds(30, 100, 170, 20);
        extendedRadio.setBounds(30, 130, 150, 20);
        crewRadio.setBounds(30, 160, 150, 20);
        
        inputPanel.add(cabStyleLbl);
        inputPanel.add(standardCabRadio);
        inputPanel.add(extendedRadio);
        inputPanel.add(crewRadio);
        
        addCabListeners();
        buildCabList();
    }
    
    private void buildCabList() {
        cabBtns.add(standardCabRadio);
        cabBtns.add(extendedRadio);
        cabBtns.add(crewRadio);
    }
    
    private void addCabListeners() {
        standardCabRadio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    basePrice -= 2800;
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    basePrice += 2800;
                }
            }
        });
        crewRadio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    basePrice += 1750;
                    fullRadio.setEnabled(false);
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    basePrice -= 1750;
                    fullRadio.setEnabled(true);
                }
            }
        });
    }
    
    private void buildBedGroup() {
        bedGrp.add(shortRadio);
        bedGrp.add(standardBedRadio);
        bedGrp.add(fullRadio);
        
        bedLbl.setBounds(230, 80, 80, 15);
        bedLbl.setFont(Constants.BOLD_FONT);
        shortRadio.setBounds(230, 100, 170, 20);
        standardBedRadio.setBounds(230, 130, 150, 20);
        fullRadio.setBounds(230, 160, 150, 20);
        
        inputPanel.add(bedLbl);
        inputPanel.add(shortRadio);
        inputPanel.add(standardBedRadio);
        inputPanel.add(fullRadio);
        
        addBedListeners();
        buildBedList();
    }
    
    private void buildBedList() {
        bedBtns.add(shortRadio);
        bedBtns.add(standardBedRadio);
        bedBtns.add(fullRadio);
    }
    
    private void addBedListeners() {
        shortRadio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    basePrice -= 1210;
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    basePrice += 1210;
                }
            }
        });
        fullRadio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    basePrice += 1460;
                    crewRadio.setEnabled(false);
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    basePrice -= 1460;
                    crewRadio.setEnabled(true);
                }
            }
        });
    }
    
    private void buildEngineGroup() {
        engineGrp.add(v6Radio);
        engineGrp.add(v8Radio);
        
        engineLbl.setBounds(30, 200, 80, 15);
        engineLbl.setFont(Constants.BOLD_FONT);
        v6Radio.setBounds(30, 220, 170, 20);
        v8Radio.setBounds(30, 250, 150, 20);
        
        inputPanel.add(engineLbl);
        inputPanel.add(v6Radio);
        inputPanel.add(v8Radio);
        
        addEngineListener();
        buildEngineList();
    }
    
    private void buildEngineList() {
        engineBtns.add(v6Radio);
        engineBtns.add(v8Radio);
    }
    
    private void addEngineListener() {
        v8Radio.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    basePrice += 2730;
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    basePrice -= 2730;
                }
            }
        });
    }
    
    private void buildAdditional() {
        additionalLbl.setBounds(230, 200, 130, 15);
        additionalLbl.setFont(Constants.BOLD_FONT);
        fourWheelBox.setBounds(230, 220, 200, 15);
        runningBox.setBounds(230, 250, 200, 15);
        alloyBox.setBounds(230, 280, 200, 15);
        atSuspBox.setBounds(230, 310, 270, 15);
        
        inputPanel.add(additionalLbl);
        inputPanel.add(fourWheelBox);
        inputPanel.add(runningBox);
        inputPanel.add(alloyBox);
        inputPanel.add(atSuspBox);
        
        addAdditionalListeners();
        buildAdditionalList();
    }
    
    private void buildAdditionalList() {
        additionalChecks.add(fourWheelBox);
        additionalChecks.add(runningBox);
        additionalChecks.add(alloyBox);
        additionalChecks.add(atSuspBox);
    }
    
    private void addAdditionalListeners() {
        fourWheelBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    basePrice += 1870;
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    basePrice -= 1870;
                }
            }
        });
        
        runningBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    basePrice += 540;
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    basePrice -= 540;
                }
            }
        });
        
        alloyBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    basePrice += 620;
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    basePrice -= 620;
                }
            }
        });
        
        atSuspBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    basePrice += 1400;
                } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
                    basePrice -= 1400;
                }
            }
        });
    }
    
    private void buildColorGroup() {
        colorGrp.add(whiteRadio);
        colorGrp.add(blueRadio);
        colorGrp.add(redRadio);
        colorGrp.add(blackRadio);
        colorGrp.add(charcoalRadio);
        
        colorLbl.setBounds(30, 280, 60, 15);
        colorLbl.setFont(Constants.BOLD_FONT);
        whiteRadio.setBounds(30, 300, 100, 20);
        blueRadio.setBounds(30, 330, 100, 20);
        redRadio.setBounds(30, 360, 100, 20);
        blackRadio.setBounds(30, 390, 100, 20);
        charcoalRadio.setBounds(30, 420, 100, 20);
        
        inputPanel.add(colorLbl);
        inputPanel.add(whiteRadio);
        inputPanel.add(blueRadio);
        inputPanel.add(redRadio);
        inputPanel.add(blackRadio);
        inputPanel.add(charcoalRadio);
        
        buildColorList();
    }
    
    private void buildButtonPanel() {
        buttonPanel.add(buildBtn);
        buttonPanel.add(overBtn);
        buttonPanel.add(exitBtn);
        addListeners();
    }
    
    private void addListeners() {
        buildBtn.addActionListener(this);
        overBtn.addActionListener(this);
        exitBtn.addActionListener(this);
    }
    
    private void buildColorList() {
        colorBtns.add(whiteRadio);
        colorBtns.add(blueRadio);
        colorBtns.add(redRadio);
        colorBtns.add(blackRadio);
        colorBtns.add(charcoalRadio);
    }
    
    private String getNameText() {
        return nameTxt.getText();
    }
    
    private String getCabStyle() {
        String cabStyle = "";
        
        for (JRadioButton btn : cabBtns) {
            if (btn.isSelected()) {
                cabStyle = btn.getText();
            }
        }
        
        return cabStyle;
    }
    
    private String getBedStyle() {
        String bedStyle = "";
        
        for (JRadioButton btn : bedBtns) {
            if (btn.isSelected()) {
                bedStyle = btn.getText();
            }
        }
        
        return bedStyle;
    }
    
    private String getEngine() {
        String engine = "";
        
        for (JRadioButton btn : engineBtns) {
            if (btn.isSelected()) {
                engine = btn.getText();
            }
        }
        
        return engine;
    }
    
    private String getAdditional() {
        String additional = "";
        
        for (JCheckBox box : additionalChecks) {
            if (box.isSelected()) {
                additional += box.getText() + "\n";
            }
        }
        
        return additional;
    }
    
    private String getColor() {
        String color = "";
        
        for (JRadioButton btn : colorBtns) {
            if (btn.isSelected()) {
                color = btn.getText();
            }
        }
        
        return color;
    }
    
    private Double calcTax(Double subtotal, Double salesTax) {
        return subtotal * salesTax;
    }
    
    private Double calcLicense(Double subtotal, Double licenseFee) {
        return subtotal * licenseFee;
    }
    
    private void printInvoice(String name, String cab, String bed, String engine,
            String additional, String color, Double subtotal, Double tax,
            Double dockFees, Double license, Double total) {
        JOptionPane.showMessageDialog(null, "Buyer: " + name
                + "\n\nRequested customizations:\n\nCab Style: " + cab
                + "\n\nBed style: " + bed + "\n\nEngine: " + engine
                + "\n\nAdditional features:\n" + additional + "\nColor: "
                + color + "\n\n\nSubtotal: $" + subtotal + "\nSales Tax: $"
                + String.format("%.2f", tax) + "\nDock fees: $"
                + String.format("%.2f", dockFees) + "\nLicense fee: $"
                + String.format("%.2f", license) + "\n\nTotal: $"
                + String.format("%.2f", total));
    }
    
    private void genInvoice() {
        boolean validTruck = true;
        //Calculation variables
        Double subtotal = 0.00;
        Double tax = 0.00;
        Double license = 0.00;
        Double total = 0.00;
        //Customization variables
        String name = getNameText();
        String cabStyle = getCabStyle();
        String bedStyle = getBedStyle();
        String engine = getEngine();
        String additional = getAdditional();
        String color = getColor();
        
        //Validation checks
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your name.");
            validTruck = false;
        }
        //Cab
        if (cabStyle.equals("")) {
            JOptionPane.showMessageDialog(null, "Please choose a cab style.");
            validTruck = false;
        }
        //Bed
        if (bedStyle.equals("")) {
            JOptionPane.showMessageDialog(null, "Please choose a bed style.");
            validTruck = false;
        }
        //Engine
        if (engine.equals("")) {
            JOptionPane.showMessageDialog(null, "Please choose an engine.");
            validTruck = false;
        }
        //Color
        if (color.equals("")) {
            JOptionPane.showMessageDialog(null, "Please choose a color.");
            validTruck = false;
        }
        
        if (additional.equals("")) {
            additional = "None\n";
        }
        
        if (validTruck) {
            subtotal = basePrice;
            tax = calcTax(subtotal, Constants.SALES_TAX);
            Double dockFees = Constants.DOCK_FEE;
            license = calcLicense(subtotal, Constants.LICENSE_FEE);
            total = subtotal + tax + dockFees + license;
            
            printInvoice(name, cabStyle, bedStyle, engine, additional, color,
                    subtotal, tax, dockFees, license, total);
            startOver();
        }
    }
    
    private void startOver() {
        nameTxt.setText(null);
        cabGrp.clearSelection();
        bedGrp.clearSelection();
        engineGrp.clearSelection();
        colorGrp.clearSelection();
        fourWheelBox.setSelected(false);
        runningBox.setSelected(false);
        alloyBox.setSelected(false);
        atSuspBox.setSelected(false);
        
        nameTxt.grabFocus();
    }
    
    private void exit() {
        JOptionPane.showMessageDialog(null, "Thank you for using the Truck Builder Program.");
        System.exit(0);
    }
    
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        
        if (buildBtn.equals(source)) {
            genInvoice();
        } else if (overBtn.equals(source)) {
            startOver();
        } else if (exitBtn.equals(source)) {
            exit();
        }
    }
}
