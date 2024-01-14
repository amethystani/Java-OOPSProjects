import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;

class TextEditor extends JFrame implements ActionListener {

    JTextArea textArea;
    JFrame frame;
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, reviewMenu;
    JMenuItem newFile, openFile, saveFile, printFile, cut, copy, paste, close, fontSize;
    JComboBox<String> fontTypeComboBox;
    JComboBox<Integer> fontSizeComboBox;
    JComboBox<String> alignmentComboBox;
    JPanel sketchPadPanel;
    JButton clearButton;
    JButton findAllButton, findNextButton, replaceButton, replaceAllButton;

    TextEditor() {
        frame = new JFrame("Text Editor");

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        } catch (Exception e) {
            e.printStackTrace();
        }

        textArea = new JTextArea();

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        reviewMenu = new JMenu("Review");

        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        printFile = new JMenuItem("Print");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        close = new JMenuItem("Close");
        fontSize = new JMenuItem("Font Size");

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        printFile.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        close.addActionListener(this);
        fontSize.addActionListener(this);

        fileMenu.add(newFile);
        fileMenu.add(openFile);
        fileMenu.add(saveFile);
        fileMenu.add(printFile);

        editMenu.add(cut);
        editMenu.add(copy);
        editMenu.add(paste);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(reviewMenu);

        fontTypeComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        fontTypeComboBox.addActionListener(this);

        fontSizeComboBox = new JComboBox<>(new Integer[] {8, 10, 12, 14, 16, 18, 20, 22, 24, 28, 32, 36, 40, 48, 56, 72});
        fontSizeComboBox.addActionListener(this);

        String[] alignments = { "Left", "Center", "Right" };
        alignmentComboBox = new JComboBox<>(alignments);
        alignmentComboBox.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Font Type:"));
        panel.add(fontTypeComboBox);
        panel.add(new JLabel("Font Size:"));
        panel.add(fontSizeComboBox);
        panel.add(new JLabel("Alignment:"));
        panel.add(alignmentComboBox);

        sketchPadPanel = new JPanel();
        sketchPadPanel.setPreferredSize(new Dimension(200, 200));
        sketchPadPanel.setBackground(Color.WHITE);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        findAllButton = new JButton("Find All");
        findAllButton.addActionListener(this);
        findNextButton = new JButton("Find Next");
        findNextButton.addActionListener(this);
        replaceButton = new JButton("Replace");
        replaceButton.addActionListener(this);
        replaceAllButton = new JButton("Replace All");
        replaceAllButton.addActionListener(this);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(menuBar, BorderLayout.NORTH);
        topPanel.add(panel, BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(sketchPadPanel, BorderLayout.CENTER);
        rightPanel.add(clearButton, BorderLayout.SOUTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(findAllButton);
        bottomPanel.add(findNextButton);
        bottomPanel.add(replaceButton);
        bottomPanel.add(replaceAllButton);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(textArea), rightPanel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(splitPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Cut")) {
            textArea.cut();
        } else if (s.equals("Copy")) {
            textArea.copy();
        } else if (s.equals("Paste")) {
            textArea.paste();
        } else if (s.equals("Save")) {
 
        } else if (s.equals("Open")) {

        } else if (s.equals("New")) {
            textArea.setText("");
        } else if (s.equals("Close")) {
            frame.setVisible(false);
        } else if (s.equals("Font Size")) {

        } else if (s.equals("Clear")) {
            sketchPadPanel.repaint();
        } else if (s.equals("Find All")) {
        } else if (s.equals("Find Next")) {

        } else if (s.equals("Replace")) {

        } else if (s.equals("Replace All")) {

        }
    }

    public static void main(String args[]) {
        TextEditor editor = new TextEditor();
    }
}
