package GUI;

import Comp_Decomp.Compressor;
import Comp_Decomp.DeCompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AppFrame extends JFrame implements ActionListener {
    JButton CompressorButton;
    JButton DeCompressorButton;

    AppFrame(){
        this.setLayout(null);
        this.setTitle("Compress and Decompress");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CompressorButton=new JButton("Compress File");
        CompressorButton.setBounds(20,100,200,30);
        CompressorButton.addActionListener(this::actionPerformed);
        DeCompressorButton=new JButton("Decompress File");
        DeCompressorButton.setBounds(300,100,200,30);
        DeCompressorButton.addActionListener(this::actionPerformed);
        this.add(CompressorButton);
        this.add(DeCompressorButton);
        this.setSize(1000,700);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==CompressorButton){
            JFileChooser jfile=new JFileChooser();
            int response=jfile.showSaveDialog(null);
            if(response==jfile.APPROVE_OPTION){
                File file=new File(jfile.getSelectedFile().getAbsolutePath());
                try {
                    Compressor.method(file);
                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null,ex.toString());
                }

            }
        }
        if(e.getSource()==DeCompressorButton){
            JFileChooser jfile=new JFileChooser();
            int response=jfile.showSaveDialog(null);
            if(response==jfile.APPROVE_OPTION){
                File file=new File(jfile.getSelectedFile().getAbsolutePath());
                try {
                    DeCompressor.method(file);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.toString());
                }

            }
        }

    }
}
