package com.marijapavlovic.zadatak_1_2;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPanel extends JPanel {

    private JTextField height;
    private JTextField weight;

    private JRadioButton senior;
    private JRadioButton junior;

    private ButtonGroup buttonGroup;

    private JButton btnCalculate;

    private FormPanelListener formPanelListener;


    public FormPanel(){
        initComps();
        layoutComps();
        activatePanel();
    }

    private void initComps(){

        Dimension dim = getPreferredSize();
        dim.height = 200;
        setPreferredSize(dim);

        height = new JTextField(10);
        weight = new JTextField(10);

        senior = new JRadioButton("Senior");
        junior = new JRadioButton("Junior");

        senior.setActionCommand("Senior");
        junior.setActionCommand("Junior");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(senior);
        buttonGroup.add(junior);
        senior.setSelected(true);

        btnCalculate = new JButton("Calculate");

        Border innerBorder = BorderFactory.createTitledBorder("Calculate BMI");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
    }

    private void layoutComps(){
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;

        add(new JLabel("Height: "), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        add(height, gc);

        gc.gridx = 0;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Weight: "), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        add(weight, gc);

        gc.gridx++;
        gc.gridy = 0;

        add(Box.createHorizontalStrut(10), gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_END;
        add(new JLabel("Age category"), gc);

        gc.gridx++;
        gc.gridy++;
        gc.anchor = GridBagConstraints.LINE_START;

        add(senior, gc);
        gc.gridy++;
        add(junior, gc);

        gc.gridy++;

        add(Box.createVerticalStrut(10), gc);

        gc.gridy++;
        add(btnCalculate, gc);

    }

    public void setFormPanelListener(FormPanelListener formPanelListener){
        this.formPanelListener = formPanelListener;
    }


    private void activatePanel(){

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String heightStr = height.getText();
                String weightStr = weight.getText();
                String category = buttonGroup.getSelection().getActionCommand();

                if(isRealNumber(heightStr) && isRealNumber(weightStr) && isPositiveNumber(heightStr) && isPositiveNumber(weightStr)){
                    float height = Float.parseFloat(heightStr);
                    float weight = Float.parseFloat(weightStr);
                    float bmi = weight / (height * height);

                    // FormEvent formEvent = new FormEvent(this, height, weight, category);
                    Person person = new Person(height, weight, category, bmi);
                    FormEvent formEvent = new FormEvent(this, person);

                    if(formPanelListener != null){
                        formPanelListener.formEventOccurred(formEvent);
                        resetFields();
                    }
                }else{
                    JOptionPane.showMessageDialog(FormPanel.this, "Height and weight must be real and positive numbers", "Error", JOptionPane.ERROR_MESSAGE);
                    resetFields();
                }

            }
        });



    }

    private void resetFields(){
        height.setText("");
        weight.setText("");
        senior.setSelected(true);
        height.requestFocus();
    }

    private boolean isRealNumber(String str){
        try{
            // check if there is a 'd' or 'f' at the end of the string
            if(str.charAt(str.length() - 1) == 'd' || str.charAt(str.length() - 1) == 'f'){
                return false;
            }
            Float.parseFloat(str);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private boolean isPositiveNumber(String str){
        try{
            float num = Float.parseFloat(str);
            return num > 0;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public float getPersonHeight() {
        return Float.parseFloat(height.getText());
    }

    public float getWeight() {
        return Float.parseFloat(weight.getText());
    }

    public String getCategory() {
        return buttonGroup.getSelection().getActionCommand();
    }

    public float getBmi() {
        return getWeight() / (getHeight() * getHeight());
    }

    public Person getPerson() {
        return new Person(getPersonHeight(), getWeight(), getCategory(), getBmi());
    }
}
