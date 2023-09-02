/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author fuada
 */
public class WhiteBox extends JFrame {
    
    public WhiteBox() {
        // set the size and color of the panel
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(247, 313));
        panel.setBackground(Color.decode("#ffffff"));
        
        // add the panel to the frame
        this.add(panel);
        
        // set the frame properties
        this.setTitle("White Box");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
}