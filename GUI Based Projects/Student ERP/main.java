import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("SNULinks");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel navBarPanel = new JPanel(new BorderLayout());
        navBarPanel.setBackground(new Color(6, 85, 148));
        navBarPanel.setPreferredSize(new Dimension(getWidth(), 110));


        ImageIcon snuLogo = new ImageIcon("images/snuLogo-OPSE-logo-white.png");
        JLabel logoLabel = new JLabel(snuLogo);
        logoLabel.setPreferredSize(new Dimension(250, 100)); 
        navBarPanel.add(logoLabel, BorderLayout.WEST);


        JPanel iconsPanel = new JPanel();
        iconsPanel.setBackground(new Color(6, 85, 148));
        iconsPanel.setBorder(new EmptyBorder(25, 5, 10, 10));


        ImageIcon searchIcon = new ImageIcon("images/search_icon.png");
        Image searchImage = searchIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        searchIcon = new ImageIcon(searchImage);
        JButton searchButton = new JButton(searchIcon);
        searchButton.setPreferredSize(new Dimension(50, 50));
        searchButton.setBackground(new Color(6, 85, 148));


        ImageIcon menuIcon = new ImageIcon("images/menu_icon.png");
        Image menuImage = menuIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        menuIcon = new ImageIcon(menuImage);
        JButton menuButton = new JButton(menuIcon);
        menuButton.setPreferredSize(new Dimension(50, 50));
        menuButton.setBackground(new Color(6, 85, 148));

        JPopupMenu searchMenu = new JPopupMenu();
        JTextField searchInput = new JTextField(20);
        searchMenu.add(searchInput);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchMenu.show(searchButton, 0, searchButton.getHeight());
            }
        });


        JPopupMenu dropdownMenu = new JPopupMenu();
        String[] options = {"Logout", "Forgot Password", "Change/Reset Password", "IT HelpDesk", "How to Login"};
        for (String option : options) {
            JMenuItem menuItem = new JMenuItem(option);
            dropdownMenu.add(menuItem);

            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    System.out.println(option + " clicked");
                }
            });
        }


        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dropdownMenu.show(menuButton, 0, menuButton.getHeight());
            }
        });


        iconsPanel.add(searchButton);
        iconsPanel.add(menuButton);


        navBarPanel.add(iconsPanel, BorderLayout.EAST);


        JPanel buttonsPanel = new JPanel(new GridLayout(3, 6, 5, 5));
        buttonsPanel.setBackground(Color.white);

        String[] appNames = {
                "University ERP", "Assistantship", "Blackboard", "CCT",
                "Certificate Issuance", "Course Evaluation Survey", "Doctoral Portal", "Fastrack",
                "Hostel Management", "ID Card Management", "Mobile App CMS",
                "On Campus Job", "Student Outbound Mobility",
                "Student Attendance Recording", "Student Attendance Management",
                "Student Clearance", "Student Payment Center"
        };

        for (String appName : appNames) {
            JButton appButton = createApplicationButton(appName);
            buttonsPanel.add(appButton);
        }


        JPanel appButtonsPanel = new JPanel(new BorderLayout());
        appButtonsPanel.add(buttonsPanel, BorderLayout.CENTER);
        appButtonsPanel.setBorder(new EmptyBorder(10, 10, 10, 10));


        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(19, 19, 27));
        footerPanel.setPreferredSize(new Dimension(getWidth(), 110));


        String[] footerLabels = {
                "Student Policy", "Student Handbook", "Academic Research", "University Library", "Mess Menu", "NetID Help"
        };

        for (String label : footerLabels) {
            JButton footerButton = new JButton(label);

            ImageIcon icon = new ImageIcon("images/" + label + ".png");
            Image image = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);

            footerButton.setIcon(icon);
            footerButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            footerButton.setVerticalTextPosition(SwingConstants.CENTER);
            footerButton.setForeground(Color.white);
            footerButton.setBackground(new Color(19, 19, 27));

            footerPanel.add(footerButton);
        }


        footerPanel.add(Box.createVerticalStrut(10));


        JPanel copyrightPanel = new JPanel();
        copyrightPanel.setBackground(new Color(19, 19, 27));
        copyrightPanel.setPreferredSize(new Dimension(getWidth(), 50));


        JLabel copyrightLabel = new JLabel("\u00A9 2023 - Shiv Nadar (Institution of Eminence Deemed to be University).");
        copyrightLabel.setForeground(Color.white);
        copyrightLabel.setFont(new Font("Arial", Font.BOLD, 16));
        copyrightPanel.add(copyrightLabel);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(footerPanel, BorderLayout.CENTER);
        bottomPanel.add(copyrightPanel, BorderLayout.SOUTH);


        getContentPane().add(navBarPanel, BorderLayout.NORTH);
        getContentPane().add(appButtonsPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);


        setVisible(true);
    }

    private JButton createApplicationButton(String appName) {
        JButton button = new JButton(appName);

        if (appName.equals("University ERP")) {
            button.setBackground(new Color(6, 85, 148));
            button.setForeground(Color.white);
        } else {
            button.setBackground(Color.white);
            button.setForeground(Color.black);
        }

        ImageIcon icon = new ImageIcon("images/" + appName + ".png");
        Image image = icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        icon = new ImageIcon(image);

        button.setIcon(icon);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);

        return button;
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}

