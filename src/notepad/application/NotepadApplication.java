package notepad.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.filechooser.*;
import java.io.*;

public class NotepadApplication extends JFrame implements ActionListener{
    
    JTextArea area;
    String text;
    
    NotepadApplication(){
        setTitle("Notepad");
        setExtendedState(JFrame.MAXIMIZED_BOTH );
        getContentPane().setBackground(Color.WHITE);
        
        
        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("notepad/application/icons/notepad.png"));
        Image icon = notepadIcon.getImage();
        setIconImage(icon);
        
        
//        ### Creating menu bar ###
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        setJMenuBar(menuBar);
        
//        ### Creating menu filed ######
        
        JMenu file = new JMenu("File");
        file.setFont(new Font("ARIAL" , Font.BOLD , 15));
        menuBar.add(file);
        
        
//        ###### Creating menu item #######
        JMenuItem newDoc = new JMenuItem("New");
        newDoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N , ActionEvent.CTRL_MASK));
        newDoc.addActionListener(this);
        file.add(newDoc); 
        
        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O , ActionEvent.CTRL_MASK));
        open.addActionListener(this);
        file.add(open); 
        
        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
        save.addActionListener(this);
        file.add(save); 
        
        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));
        print.addActionListener(this);
        file.add(print); 
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE  ,ActionEvent.CTRL_MASK));
        exit.addActionListener(this);
        file.add(exit); 
        
        
//        ##### Second Menu filed#####
        JMenu edit = new JMenu("Edit");
        edit.setFont(new Font("ARIAL" , Font.BOLD , 15));
        menuBar.add(edit);
        
//        ##### Second menu item ###
        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C , ActionEvent.CTRL_MASK));
        copy.addActionListener(this);
        edit.add(copy);
        
        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , ActionEvent.CTRL_MASK));
        paste.addActionListener(this);
        edit.add(paste);
        
        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X , ActionEvent.CTRL_MASK));
        cut.addActionListener(this);
        edit.add(cut);
        
        JMenuItem selectAll = new JMenuItem("Select All");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
        selectAll.addActionListener(this);
        edit.add(selectAll);
        
        
        
//        #### Third menu filed ######
        JMenu help = new JMenu("Help");
        help.setFont(new Font("ARIAL" , Font.BOLD , 15));
        menuBar.add(help);
        
        JMenuItem helpitem = new JMenuItem("About");
        helpitem.addActionListener(this);
        help.add(helpitem);
        
//        #### Adding text area ###
        area = new JTextArea();
        area.setFont(new Font("SAN_SARIF" , Font.PLAIN , 20));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
//        add(area);        
        
//        ### Adding Scroll Panel #####
        JScrollPane pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);
        



        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("New")){
            area.setText("");
        }
        else if(ae.getActionCommand().equals("Open")){
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files" , "txt");
            chooser.addChoosableFileFilter(restrict);
            
            int action = chooser.showOpenDialog(this);
            
            if(action != JFileChooser.APPROVE_OPTION){
                return ;
            }
            
            File file = chooser.getSelectedFile();
            try{
                BufferedReader reader = new BufferedReader(new FileReader(file));
                area.read(reader, null);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getActionCommand().equals("Save")){
            JFileChooser saveas = new JFileChooser();
            saveas.setApproveButtonText("Save");
            int action = saveas.showOpenDialog(this);
            
            if(action != JFileChooser.APPROVE_OPTION){
                return ;
            }
            
            File filename = new File(saveas.getSelectedFile() + ".txt");
            BufferedWriter outfile = null;
            
            try{
                outfile = new BufferedWriter(new FileWriter(filename));
                area.write(outfile);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getActionCommand().equals("Print")){
            try{
                area.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getActionCommand().equals("Exit")){
            System.exit(0);
        }
        else if(ae.getActionCommand().equals("Copy")){
            text = area.getSelectedText();
        }
        else if(ae.getActionCommand().equals("Paste")){
            area.insert(text, area.getCaretPosition());
        }
        else if(ae.getActionCommand().equals("Cut")){
            text = area.getSelectedText();
            area.replaceRange("", area.getSelectionStart()   , area.getSelectionEnd());
        }
        else if(ae.getActionCommand().equals("Select All")){
            area.selectAll();
        }else if(ae.getActionCommand().equals("About")){
//            setVisible(false);
            new About();
        }
    }
    
    
    public static void main(String[] args) {
        new NotepadApplication();
    }
    
}
