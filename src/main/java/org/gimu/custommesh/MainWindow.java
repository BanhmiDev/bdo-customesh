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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainWindow extends JFrame {
    public JPanel mainPanel;
    private JButton mergeToTargetCustomizationButton;
    private JCheckBox voiceCheckBox;
    private JPanel filePanel;
    private JPanel dataPanel;
    private JTextField textField1;
    private JButton openButton;
    private JButton openButton1;
    private JTextField textField2;

    private String sourceFile = null;
    private String targetFile = null;

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
                    File selectedFile = fileChooser.getSelectedFile();
                    sourceFile = selectedFile.getAbsolutePath();
                    System.out.println("File: " + selectedFile.getAbsolutePath());
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
                    File selectedFile = fileChooser.getSelectedFile();
                    targetFile = selectedFile.getAbsolutePath();
                    System.out.println("File: " + selectedFile.getAbsolutePath());
                }
            }
        });

        // Merge action
        mergeToTargetCustomizationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                byte[] sourceData = null, targetData = null;
                Path path = Paths.get(sourceFile);
                try {
                    sourceData = Files.readAllBytes(path);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println(getClassFromData(sourceData));
            }
        });
    }

    private String getClassFromData(byte[] data) {
        return Constants.CLASS_MAP.get(BitConverter.toUInt64(data, Constants.CLASS_ID.getOffset()));
    }
}
