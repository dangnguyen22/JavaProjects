package MatrixLab;

/** The View class of this basic MVC
 * @author Michael Nguyen Fall 2022
 * Some parts of this code was taken from Dr. Antonio Sanchez.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View1 extends JFrame {
    public Color TCUColor = new Color(123, 50, 250);

    JFrame home = new JFrame();
    JFrame vectorResult = new JFrame();
    JFrame vectorX;
    JFrame vectorY;
    JFrame vectorZ;

    double[][]   dataX; 
	double[][]   dataY; 
    double[][] dataZ;
	JTextField[][] disFieldsX;
	JTextField[][] disFieldsY;
    JTextField[][] disFieldsZ;

    int collumnX;
    int rowX;
    int collumnY;
    int rowY;
    int collumnZ;
    int rowZ;

    JTextField col1 = new JTextField(15);
    JTextField row1 = new JTextField(15);
    JTextField col2 = new JTextField(15);
    JTextField row2 = new JTextField(15);

    public JButton create = new JButton("Create");
    public JButton execute = new JButton("Execute");
    public JButton quit = new JButton("Quit");
    public JButton reset = new JButton("Reset");
    String[] s1 = { "Select", "Add", "Subtract","Multiplication" };
    JComboBox box1 = new JComboBox(s1);
    
    public JPanel xPanel1 = new JPanel();
    public JButton saveX = new JButton("Save");
    public JButton clearX = new JButton("Clear");
    public JButton openX = new JButton("Open");
    public JTextField fileX = new JTextField(15);
    public JButton readX = new JButton("Read");
    
    public JPanel yPanel1 = new JPanel();
    public JButton saveY = new JButton("Save");
    public JButton clearY = new JButton("Clear");
    public JButton openY = new JButton("Open");
    public JTextField fileY = new JTextField(15);
    public JButton readY = new JButton("Read");

    public JPanel zPanel1 = new JPanel();
    public JButton saveZ = new JButton("Save");
    public JButton clearZ = new JButton("Clear");
    public JButton readZ = new JButton("Read");
    public JButton openZ = new JButton("Open");
    public JTextField fileZ = new JTextField(15);

    JLabel label1 = new JLabel("First Matrix rows/cols", JLabel.CENTER);
    JLabel label2 = new JLabel("Second Matrix rows/cols", JLabel.CENTER);

    JPanel home1 = new JPanel();
    JPanel homeButtons = new JPanel();
    JPanel resPanel = new JPanel();
    JPanel numPanelX;
    JPanel numPanelY;
    JPanel numPanelZ;



    public static void main(String[] args) {
        new View1();
    }

    View1() {
        label1.setForeground(Color.white);
        label1.setFont(new Font("Helvetica", Font.PLAIN, 20));
        label2.setForeground(Color.white);
        label2.setFont(new Font("Helvetica", Font.PLAIN, 20));

        home.setLayout(new GridLayout(6, 2, 20, 20));
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setSize(500, 300);
        home.getContentPane().setBackground(TCUColor);

        home.add(label1);
        home.add(label2);
        home.add(row1);
        home.add(row2);
        home.add(col1);
        home.add(col2);
        home.add(create);
        home.add(box1);
        home.add(execute);
        home.add(reset);
        home.add(quit);

        home.setTitle("Control");
        home.setVisible(true);

    }
}
