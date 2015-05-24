package com.laststandstudio.space.engine.Utils;


import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

/**
 * Created by Freedman on 5/24/2015.
 */
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
        setVisible(true);

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
