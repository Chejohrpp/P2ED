/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.p2ed;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author sergi
 */
public class CargaDatos {
    
    private JFrame frame;
    public CargaDatos() {
        frame = new JFrame();
        frame.setVisible(true);
        BringToFront();
    }
    public File getFile() {
        JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(false);
        if(JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null)){
            //frame.setVisible(false);
            frame.dispose();
            return fc.getSelectedFile();
        }else {
            frame.dispose();
        }
        return null;
    }

    private void BringToFront() {                  
        frame.setExtendedState(JFrame.ICONIFIED);
        frame.setExtendedState(JFrame.NORMAL);
    }
}
