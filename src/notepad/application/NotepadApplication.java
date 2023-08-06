package notepad.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NotepadApplication extends JFrame{
    
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
        file.add(newDoc); 
        
        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O , ActionEvent.CTRL_MASK));
        file.add(open); 
        
        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S , ActionEvent.CTRL_MASK));
        file.add(save); 
        
        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P , ActionEvent.CTRL_MASK));
        file.add(print); 
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE  , ActionEvent.CTRL_MASK));
        file.add(exit); 
        
        
//        ##### Second Menu filed#####
        JMenu edit = new JMenu("Edit");
        edit.setFont(new Font("ARIAL" , Font.BOLD , 15));
        menuBar.add(edit);
        
//        ##### Second menu item ###
        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C , ActionEvent.CTRL_MASK));
        edit.add(copy);
        
        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V , ActionEvent.CTRL_MASK));
        edit.add(paste);
        
        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X , ActionEvent.CTRL_MASK));
        edit.add(cut);
        
        JMenuItem selectAll = new JMenuItem("Select All");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A , ActionEvent.CTRL_MASK));
        edit.add(selectAll);
        
        
        
//        #### Third menu filed ######
        JMenu help = new JMenu("Help");
        help.setFont(new Font("ARIAL" , Font.BOLD , 15));
        menuBar.add(help);
        
        JMenuItem helpitem = new JMenuItem("About Notepad");
        help.add(helpitem);
        
//        #### Adding text area ###
        JTextArea area = new JTextArea();
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

    public static void main(String[] args) {
        new NotepadApplication();
    }
    
}
