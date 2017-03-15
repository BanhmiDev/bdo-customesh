/*
 *  Copyright 2017 Son Nguyen <mail@gimu.org>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package main.java.org.gimu.custommesh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class MainWindow extends JFrame {
    public JPanel mainPanel;
    private JButton mergeToTargetCustomizationButton;
    private JCheckBox faceShapeCheckBox;
    private JPanel filePanel;
    private JPanel dataPanel;
    private JTextField sourceField;
    private JButton openButton;
    private JButton openButton1;
    private JTextField targetField;
    private JLabel errorLabel;
    private JPanel informationPanel;
    private JLabel sourceClassLabel;
    private JLabel targetClassLabel;
    private JCheckBox hairAndFaceCheckBox;
    private JCheckBox hairColorCheckBox;
    private JCheckBox skinCheckBox;
    private JCheckBox eyeMakeupCheckBox;
    private JCheckBox eyeLineCheckBox;
    private JCheckBox eyesCheckBox;
    private JCheckBox bodyShapeCheckBox;
    private JCheckBox standbyExpressionCheckBox;
    private JCheckBox voiceCheckBox;

    private byte[] sourceData = null;
    private byte[] targetData = null;

    public MainWindow() {
        mergeToTargetCustomizationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e);
            }
        });

        // Opens input file chooser
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(openButton);
                if (result == JFileChooser.APPROVE_OPTION) {
                    sourceField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    loadSourceData(sourceField.getText());
                }
            }
        });

        // Open target file chooser
        openButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(openButton1);
                if (result == JFileChooser.APPROVE_OPTION) {
                    targetField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                    loadTargetData(targetField.getText());
                }
            }
        });

        // Merge action
        mergeToTargetCustomizationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sourceField.getText().isEmpty() || targetField.getText().isEmpty()) {
                    errorLabel.setText("Missing source or target file!");
                    return;
                }

                if (sourceField.getText() == "unknown" || targetField.getText() == "unknown") {
                    errorLabel.setText("Source or target file invalid!");
                    return;
                }

                // Get selected options
                List<DataBlock> sections = new LinkedList<DataBlock>();
                for (Component c : dataPanel.getComponents()) {
                    if (c instanceof JCheckBox) {
                        if (((JCheckBox)c).isSelected()) {
                            sections.add(Constants.APPEARANCE_MAP.get(((JCheckBox)c).getText()));
                        }
                    }
                }
                // Finally merge to target file
                mergeBySections(sections);
            }
        });
    }

    private void mergeBySections(List<DataBlock> sections) {
        for (DataBlock section : sections) {
            System.arraycopy(sourceData, section.getOffset(), targetData, section.getOffset(), section.getLength());
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(targetField.getText());
            fos.write(targetData);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Successfully merged to target customization file.", "Success", JOptionPane.PLAIN_MESSAGE);
    }

    private void loadSourceData(String path) {
        Path sourcePath = Paths.get(path);
        try {
            sourceData = Files.readAllBytes(sourcePath);
            sourceClassLabel.setText(getClassFromData(sourceData));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private void loadTargetData(String path) {
        Path targetPath = Paths.get(path);
        try {
            targetData = Files.readAllBytes(targetPath);
            targetClassLabel.setText(getClassFromData(targetData));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private String getClassFromData(byte[] data) {
        return Constants.CLASS_MAP.get(BitConverter.toUInt64(data, Constants.CLASS_ID.getOffset()));
    }
}
