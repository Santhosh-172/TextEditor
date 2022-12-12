import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor implements ActionListener {

    JFrame frame;

    JMenuBar menuBar;

    JMenu file, edit , close;

    JMenuItem newFile, openFile,saveFile;

    JMenuItem cut, copy, paste, selectAll, Close;

    JTextArea textArea;



    TextEditor(){

        frame = new JFrame();

        menuBar = new JMenuBar();

        textArea = new JTextArea();

        file = new JMenu("File");
        edit = new JMenu("Edit");
        close = new JMenu("Close");

        close.addActionListener(this);

        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectAll = new JMenuItem("Select All");
        Close = new JMenuItem("Close");

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        Close.addActionListener(this);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        edit.add(Close);

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(close);

        frame.setJMenuBar(menuBar);

        frame.add(textArea);

        frame.setBounds(100,100, 800,500);

        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == cut){
            textArea.cut();
        }

        if(e.getSource() == paste){
            textArea.paste();
        }

        if(e.getSource() == copy)
            textArea.copy();

        if(e.getSource() == paste)
            textArea.paste();

        if(e.getSource() == selectAll)
            textArea.selectAll();

        if(e.getSource() == close){
            System.exit(0);
        }
        if(e.getSource() == Close){
            System.exit(0);
        }

        if(e.getSource() == newFile){
            TextEditor textEditor = new TextEditor();
        }

        if(e.getSource() == openFile) {

            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showOpenDialog(null);

            if (chooseOption == JFileChooser.APPROVE_OPTION) {

                File file = fileChooser.getSelectedFile();

                String filePath = file.getPath();

                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                    String intermediate = "", output = "";

                    while ((intermediate = bufferedReader.readLine()) != null) {
                        output += intermediate + "\n";
                    }

                    textArea.setText(output);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }

            if(e.getSource() == saveFile){
                JFileChooser fileChooser = new JFileChooser("C:");

                int chooseOption = fileChooser.showSaveDialog(null);

                if(chooseOption == JFileChooser.APPROVE_OPTION){

                    File file = new File(fileChooser.getSelectedFile().getAbsoluteFile()+".txt");

                    try{
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                        textArea.write(bufferedWriter);
                        bufferedWriter.close();
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }
                }

            }
        }
        




    public static void main(String[] args) {

         new TextEditor();
    }



}