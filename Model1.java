package MatrixLab;

/** The Model class of this basic MVC
 * @author Michael Nguyen Fall 2022
 * Some parts of this code was taken from Dr. Sanchez's examples.
 */

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Model1 {
    Control1 c;
    double[][] data = null;

    public Model1(Control1 fromC) {
        c = fromC;

    }

    public void procOper(int opt) {

        c.dataX = new double[c.rowX][c.collumnX];

        for (int i = 0; i < c.rowX; i++) {
            for (int j = 0; j < c.collumnX; j++) {

                c.dataX[i][j] = Double.parseDouble(c.disFieldsX[i][j].getText());
            }

        }
        c.dataY = new double[c.rowY][c.collumnY];

        for (int i = 0; i < c.rowY; i++) {
            for (int j = 0; j < c.collumnY; j++) {

                c.dataY[i][j] = Double.parseDouble(c.disFieldsY[i][j].getText());
            }

        }
        JPanel numPanelZ = new JPanel();
        numPanelZ.setLayout((new GridLayout(c.rowX, c.collumnX, 2, 2)));
        double[][] dataZ = new double[c.rowX][c.collumnX];
        c.disFieldsZ = new JTextField[c.rowX][c.collumnX];
        switch (opt) {
            case 1:

                for (int i = 0; i < c.rowX; i++) {
                    for (int j = 0; j < c.collumnX; j++) {
                        dataZ[i][j] = c.dataX[i][j] + c.dataY[i][j];
                        c.disFieldsZ[i][j] = new JTextField();
                        c.disFieldsZ[i][j].setText("" + dataZ[i][j]);
                        numPanelZ.add(c.disFieldsZ[i][j]);
                    }
                }
                c.rowZ = c.rowX;
                c.collumnZ = c.collumnX;
                c.vectorZ = new JFrame("Result Matrix");
                c.vectorZ.add(numPanelZ);
                c.vectorZ.add(c.zPanel1,BorderLayout.SOUTH);
                numPanelZ.setBackground(c.TCUColor);
                c.vectorZ.setBackground(c.TCUColor);
                c.vectorZ.setBounds(500, 600, 500, 200);
                c.vectorZ.setVisible(true);
                break;

            case 2:

                for (int i = 0; i < c.rowX; i++) {
                    for (int j = 0; j < c.collumnX; j++) {
                        dataZ[i][j] = c.dataX[i][j] - c.dataY[i][j];
                        c.disFieldsZ[i][j] = new JTextField();
                        c.disFieldsZ[i][j].setText("" + dataZ[i][j]);
                        numPanelZ.add(c.disFieldsZ[i][j]);
                    }
                }
                c.rowZ = c.rowX;
                c.collumnZ = c.collumnX;
                c.vectorZ = new JFrame("Result Matrix");
                c.vectorZ.add(numPanelZ);
                c.vectorZ.add(c.zPanel1,BorderLayout.SOUTH);
                numPanelZ.setBackground(c.TCUColor);
                c.vectorZ.setBackground(c.TCUColor);
                c.vectorZ.setBounds(500, 600, 300, 200);
                c.vectorZ.setVisible(true);
                break;

            case 3:
                c.disFieldsZ = new JTextField[c.rowX][c.collumnY];
                numPanelZ = new JPanel(new GridLayout(c.rowX, c.collumnY));
                dataZ = new double[c.rowX][c.collumnY];
                for (int i = 0; i < c.rowX; i++) {
                    for (int j = 0; j < c.collumnY; j++) {
                        for (int k = 0; k < c.rowY; k++) {
                            dataZ[i][j] += c.dataX[i][k] * c.dataY[k][j];

                        }
                        c.disFieldsZ[i][j] = new JTextField();
                        c.disFieldsZ[i][j].setText("" + dataZ[i][j]);
                        numPanelZ.add(c.disFieldsZ[i][j]);
                    }
                }
                c.rowZ = c.rowX;
                c.collumnZ = c.collumnY;
                c.vectorZ = new JFrame("Result Matrix");
                c.vectorZ.add(numPanelZ);
                c.vectorZ.add(c.zPanel1,BorderLayout.SOUTH);
                numPanelZ.setBackground(c.TCUColor);
                c.vectorZ.setBackground(c.TCUColor);
                c.vectorZ.setBounds(850, 600, 300, 200);
                c.vectorZ.setVisible(true);
                break;

        }
    }

    public void saveFile(String file, double[][] d) {
        try {
            // System.out.println(" file to write " + file);
            FileOutputStream fo = new FileOutputStream(file);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(d);
            oo.close();
            fo.close();
            System.out.println("file " + file + " saved as object");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        // for (int r = 0; r < d.length; r++) {
        // for (int c = 0; c < d[r].length; c++) {
        // System.out.println(d[r][c]);
        // this.c.disFieldsX[r][c].setText(d[r][c] + "");
    }

    public double[][] openX(String file) {
        try { // System.out.println(" file to read "+ file );

            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            double[][] data = (double[][]) oi.readObject();

            int row = data.length;
            int col = data[0].length;

            c.dataX = data;
            c.disFieldsX = new JTextField[row][col];
            c.numPanelX.setLayout(new GridLayout(row, col, 2, 2));
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    this.c.disFieldsX[r][c] = new JTextField("" + this.c.dataX[r][c]);
                    this.c.numPanelX.add(this.c.disFieldsX[r][c]);
                }
            }

            oi.close();
            fi.close();
            System.out.println("file " + file + " opened as an object");
            return data;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        return data;
    }

    public double[][] openY(String file) {
        try { // System.out.println(" file to read "+ file );

            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            double[][] data = (double[][]) oi.readObject();

            int row = data.length;
            int col = data[0].length;

            c.dataY = data;
            c.disFieldsY = new JTextField[row][col];
            c.numPanelY.setLayout(new GridLayout(row, col, 2, 2));
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    this.c.disFieldsY[r][c] = new JTextField("" + this.c.dataY[r][c]);
                    this.c.numPanelY.add(this.c.disFieldsY[r][c]);
                }
            }

            oi.close();
            fi.close();
            System.out.println("file " + file + " opened as an object");
            return data;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        return data;
    }

    public double[][] openZ(String file) {
        try { // System.out.println(" file to read "+ file );

            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            double[][] data = (double[][]) oi.readObject();

            int row = data.length;
            int col = data[0].length;

            c.dataZ = data;
            c.disFieldsZ = new JTextField[row][col];
            c.numPanelZ.setLayout(new GridLayout(row, col, 2, 2));
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    this.c.disFieldsZ[r][c] = new JTextField("" + this.c.dataZ[r][c]);
                    this.c.numPanelZ.add(this.c.disFieldsZ[r][c]);
                }
            }

            oi.close();
            fi.close();
            System.out.println("file " + file + " opened as an object");
            return data;
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
        return data;
    }
    public void readX() {
        c.dataX = new double[c.rowX][c.collumnX];
        for (int i = 0; i < c.rowX; i++) {
            for (int j = 0; j < c.collumnX; j++) {
                c.dataX[i][j] = Double.parseDouble(c.disFieldsX[i][j].getText());
            }

        }
    }

    public void readY() {
        c.dataY = new double[c.rowY][c.collumnY];
        for (int i = 0; i < c.rowY; i++) {
            for (int j = 0; j < c.collumnY; j++) {
                c.dataY[i][j] = Double.parseDouble(c.disFieldsY[i][j].getText());
            }
        }
    }
    public void readZ() {
        c.dataZ = new double[c.rowZ][c.collumnZ];
        for (int i = 0; i < c.rowZ; i++) {
            for (int j = 0; j < c.collumnZ; j++) {
                c.dataZ[i][j] = Double.parseDouble(c.disFieldsZ[i][j].getText());
            }
        }
    }


}
