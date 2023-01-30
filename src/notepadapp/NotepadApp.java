
package notepadapp;

import javax.swing.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;


public class NotepadApp extends JFrame implements ActionListener{
    JMenuBar menubar= new JMenuBar();
    JMenu file=new JMenu("File");
    JMenu edit=new JMenu("Edit");
    JMenu help=new JMenu("Help");
    
    JMenuItem newFile=new JMenuItem("New");
    JMenuItem openFile=new JMenuItem("Open");
    JMenuItem saveFile=new JMenuItem("Save");
    JMenuItem printFile=new JMenuItem("Print");
    JMenuItem exitFile=new JMenuItem("Exit");
    
    
    JMenuItem cutFile=new JMenuItem("Cut");
    JMenuItem copyFile=new JMenuItem("Copy");
    JMenuItem pasteFile=new JMenuItem("Paste");
    JMenuItem selectallFile=new JMenuItem("Select all");
    
    JMenuItem aboutFile=new JMenuItem("about");
    
    JTextArea textArea=new JTextArea();



    NotepadApp(){
        setTitle("Notepad Application");
        setBounds(600,100,600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon(getClass().getResource("image1.png"));
        setIconImage(icon.getImage());
        
        setJMenuBar(menubar);
        
                menubar.add(file);
                menubar.add(edit);
                menubar.add(help);
                
                
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(printFile);
        file.add(exitFile);
        
        edit.add(cutFile);
        edit.add(copyFile);
        edit.add(pasteFile);
        edit.add(selectallFile);
        
        help.add(aboutFile);
        
        JScrollPane scrollpane=new JScrollPane(textArea);
        add(scrollpane);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

       
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        printFile.addActionListener(this);
        exitFile.addActionListener(this);
        cutFile.addActionListener(this);
        copyFile.addActionListener(this);
        pasteFile.addActionListener(this);
        selectallFile.addActionListener(this);
        aboutFile.addActionListener(this);
    }
    public static void main(String[] args) {
       new NotepadApp().setVisible(true);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("New")){
            textArea.setText(null);
            
            
            
    }else if(e.getActionCommand().equalsIgnoreCase("Open")){
         JFileChooser fileChooser=new JFileChooser();
        FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(textFilter);
        
        int action=fileChooser.showOpenDialog(null);
        if(action!=JFileChooser.APPROVE_OPTION){
            return;
        }else{
             try{
            BufferedReader reader=new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
            textArea.read(reader,null);
            }catch(IOException ex){
                ex.printStackTrace();
            }
            
        }

         
        
    }else if(e.getActionCommand().equalsIgnoreCase("Save")){
        JFileChooser fileChooser=new JFileChooser();
        FileNameExtensionFilter textFilter=new FileNameExtensionFilter("Only Text Files(.txt)","txt");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(textFilter);
        
        int action=fileChooser.showSaveDialog(null);
        if(action!=JFileChooser.APPROVE_OPTION){
            return;
        }else{
            String fileName=fileChooser.getSelectedFile().getAbsolutePath().toString();
            if(!fileName.contains(".txt"))
                fileName=fileName+".txt";
            try{
            BufferedWriter writer=new BufferedWriter(new FileWriter(fileName));
            textArea.write(writer);
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
        
        
        
        
    }else if(e.getActionCommand().equalsIgnoreCase("Print")){
        
            try {
                textArea.print();
            } catch (PrinterException ex) {
                Logger.getLogger(NotepadApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
            
    }else if(e.getActionCommand().equalsIgnoreCase("Exit")){
        
        System.exit(0);
        
        
    }else if(e.getActionCommand().equalsIgnoreCase("Cut")){
        
        textArea.cut();
        
    }else if(e.getActionCommand().equalsIgnoreCase("Copy")){
        textArea.copy();
        
        
    }else if(e.getActionCommand().equalsIgnoreCase("Paste")){
        textArea.paste();
        
        
    }else if(e.getActionCommand().equalsIgnoreCase("Selectall")){
        textArea.selectAll();
        
        
    }
    else if(e.getActionCommand().equalsIgnoreCase("about")){
         new about().setVisible(true);
    }
        
  }
    
}
