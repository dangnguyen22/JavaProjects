package MatrixLab;

/** The Control class of this basic MVC
 * @author Michael Nguyen Fall 2022
 */ 

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Control1 extends View1 implements ActionListener {
    Model1 m;
    JFrame vectorZ = new JFrame();

    public static void main(String[] args) {
        new Control1();
    }

    public Control1() {
        m = new Model1(this);
        setButtons();
    }

    public void setButtons() {
        create.addActionListener(this);
        execute.addActionListener(this);
        quit.addActionListener(this);
        reset.addActionListener(this);
        box1.addActionListener(this);

        saveX.addActionListener(this);
        openX.addActionListener(this);
        clearX.addActionListener(this);
        saveY.addActionListener(this);
        openY.addActionListener(this);
        clearY.addActionListener(this);
        readX.addActionListener(this);
        readY.addActionListener(this);

        saveZ.addActionListener(this);
        openZ.addActionListener(this);
        clearZ.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
		   { String whichWidget = e.getActionCommand();
            String b = (String) box1.getSelectedItem();
		      System.out.println("calling action perform" + whichWidget );
              if (whichWidget.equals("Create"))addPanel();
              if (whichWidget.equals("Execute") && b.equals("Add"))m.procOper(1);
        if (whichWidget.equals("Execute") && b.equals("Subtract"))m.procOper(2);
        if (whichWidget.equals("Execute") && b.equals("Multiplication"))m.procOper(3);
        
        if(e.getSource() == readX)m.readX();
        if(e.getSource() == readY)m.readY();
        if(e.getSource() == readZ)m.readZ();
        
        if (e.getSource() == saveX) {m.saveFile(fileX.getText(),dataX);}
        if (e.getSource() == saveY){m.saveFile(fileY.getText(), dataY);}
        if (e.getSource() == saveZ){m.saveFile(fileZ.getText(), dataZ);}

        if(e.getSource() == openX) {
            numPanelX.removeAll();
            numPanelX.revalidate();
            m.openX(fileX.getText());
        }
        
        if(e.getSource() == openY) {
            numPanelY.removeAll();
            numPanelY.revalidate();
            m.openY(fileY.getText());
        }

        if(e.getSource() == openZ) {
            numPanelZ.removeAll();
            numPanelZ.revalidate();
            m.openZ(fileZ.getText());
        }
           }

    public void addPanel() {
        if (validateInteger(col1) && validateInteger(col2) && validateInteger(row1) && validateInteger(row2)) {
            collumnX = Integer.parseInt(col1.getText());
            collumnY = Integer.parseInt(col2.getText());
            rowX = Integer.parseInt(row1.getText());
            rowY = Integer.parseInt(row2.getText());

            vectorX = new JFrame("X Vector");
            vectorX.setLayout(new BorderLayout());
            vectorY = new JFrame("Y Vector");
            vectorY.setLayout(new BorderLayout());
            numPanelX = new JPanel();
            numPanelX.setLayout(new GridLayout(rowX, collumnX, 2, 2));
            numPanelY = new JPanel();
            numPanelY.setLayout(new GridLayout(rowY, collumnY, 2, 2));
            disFieldsX = new JTextField[rowX][collumnX];
            disFieldsY = new JTextField[rowY][collumnY];

            numPanelX.setBackground(TCUColor);
            numPanelY.setBackground(TCUColor);

            xPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            xPanel1.setPreferredSize(new Dimension(200, 40));
            xPanel1.setBackground(Color.white);
            xPanel1.add(clearX);
            xPanel1.add(readX);
            xPanel1.add(fileX);
            xPanel1.add(saveX);
            xPanel1.add(openX);

            yPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            yPanel1.setPreferredSize(new Dimension(200, 40));
            yPanel1.setBackground(Color.white);
            yPanel1.add(clearY);
            yPanel1.add(readY);
            yPanel1.add(fileY);
            yPanel1.add(saveY);
            yPanel1.add(openY);

            zPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
            zPanel1.setPreferredSize(new Dimension(200, 40));
            zPanel1.setBackground(Color.white);
            zPanel1.add(clearZ);
            zPanel1.add(readZ);
            zPanel1.add(fileZ);
            zPanel1.add(saveZ);
            zPanel1.add(openZ);

            vectorX.add(numPanelX, BorderLayout.CENTER);
            vectorY.add(numPanelY, BorderLayout.CENTER);
            vectorX.add(xPanel1, BorderLayout.SOUTH);
            vectorY.add(yPanel1, BorderLayout.SOUTH);

            for (int i = 0; i < rowX; i++) {
                for (int j = 0; j < collumnX; j++) {
                    disFieldsX[i][j] = new JTextField(10);
                    numPanelX.add(disFieldsX[i][j]);
                }
            }
            for (int i = 0; i < rowY; i++) {
                for (int j = 0; j < collumnY; j++) {
                    disFieldsY[i][j] = new JTextField(10);
                    numPanelY.add(disFieldsY[i][j]);
                }
            }
            vectorX.setBounds(500, 350, 500, 200);
            vectorY.setBounds(500, 100, 500, 200);
            vectorX.setVisible(true);
            vectorY.setVisible(true);
        }
    }

    public boolean validateInteger(JTextField datum) {
        try {
            int d = Integer.parseInt(datum.getText());
            return true;
        } catch (NumberFormatException e) {
            System.out.println("invalid Integer ");
            return false;
        }
    }
}
