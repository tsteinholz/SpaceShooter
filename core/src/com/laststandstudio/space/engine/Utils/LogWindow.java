/******************************************************************************
 * Space Shooter Software License
 * Version 0.0.2-alpha
 *
 * Copyright (C) 2015 Last Stand Studio
 *
 *  SpaceShooter is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  SpaceShooter is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with SpaceShooter.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

package com.laststandstudio.space.engine.Utils;

import com.laststandstudio.space.SpaceShooter;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class LogWindow extends JFrame {

    public JTextPane jTextPane;
    public JScrollPane jScrollPane;
    StyledDocument styledDocument;

    public LogWindow() {
        super("Logger");
        System.out.println("\n\nMAKING WINDOW\n\n");
        setLayout(new GridLayout(1, 1));
        jTextPane = new JTextPane();
        jTextPane.setText("");
        styledDocument = jTextPane.getStyledDocument();
        jTextPane.setBackground(Color.black);
        jTextPane.setForeground(Color.white);
        jTextPane.setFont(new Font("Times New Roman", Font.PLAIN, 16));//font("Times New Roman", 16));
        jScrollPane = new JScrollPane(jTextPane);
        jScrollPane.setAutoscrolls(true);
        add(jScrollPane);


        setSize(1040, 310);
        if (SpaceShooter.debug) setVisible(true);

        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println(getWidth() + " : " + getHeight());
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }

    SimpleAttributeSet temp = new SimpleAttributeSet();

    public void appendString(String message, Color color) {
        StyleConstants.setForeground(temp, color != null ? color : Color.WHITE);
        try {
            styledDocument.insertString(styledDocument.getLength(), message, temp);
            JScrollBar vertical = jScrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}
