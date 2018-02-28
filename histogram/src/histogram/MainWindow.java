package histogram;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * This class is a frame. It is a main menu of the application. It contains two buttos to load answer key and
 * students's answers from file and two buttons to display loaded data on charts.
 *
 *
 * @see JFrame;
 * @see JButton;
 */
public class MainWindow extends JPanel {
    private JPanel panel1;
    private JButton loadAnswerKeyButton;
    private JButton histogramButton;
    private JButton showGradesHistogramButton;
    private JButton loadAnswerButton;


    private JLabel keyFileLabel;
    private JLabel answersLabel;
    private LoaderFileWindow loaderAnswers;
    private LoaderFileWindow loaderKey;

    private ArrayList<String[]> answersList;
    private ArrayList<String[]> answerKey;

    public JPanel getPanel1() {
        return panel1;
    }

    public JLabel getAnswersLabel() {
        return answersLabel;
    }

    public JLabel getKeyFileLabel() {
        return keyFileLabel;
    }

    /**
     * Assigns loaded data from file to answersList and answerKey. If data is not loaded, displays MessageDialog.
     *
     * @see LoaderFileWindow;
     */
    public boolean loadData() {
            if (loaderAnswers == null || loaderKey == null || loaderAnswers.getDataList() == null || loaderKey.getDataList() == null) {
                JOptionPane.showMessageDialog(new Frame(), "You should load data first.");
                return false;
            } else {
                answersList = loaderAnswers.getDataList();
                answerKey = loaderKey.getDataList();
                return true;
            }

    }


    public MainWindow() {
        panel1 = this;
        MainWindow mainWindow = this;
        loadAnswerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loaderAnswers = new LoaderFileWindow(mainWindow, false);
            }
        });
        loadAnswerKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loaderKey = new LoaderFileWindow(mainWindow, true);
            }
        });
        histogramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loadData()) {
                    csvDataCalculation statistics = new csvDataCalculation();
                    double numberOfPoints[] = statistics.checkAnswers(answersList, answerKey);
                    int maxValue = answerKey.get(0).length;
                    String xaxis = "Number of points";
                    String yaxis = "Number of students";
                    HistogramWindow histogram = new HistogramWindow(numberOfPoints, maxValue * 2 + 1, xaxis, yaxis, 0, maxValue);
                }
            }
        });
        showGradesHistogramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(loadData()) {
                    csvDataCalculation statistics = new csvDataCalculation();
                    double numberOfPoints[] = statistics.checkAnswers(answersList, answerKey);
                    double gradesDistribution[] = statistics.calculateGrades(numberOfPoints, answerKey.get(0).length);
                    String chartTitle = "Grades distribution";
                    PieChartWindow pieChart = new PieChartWindow(gradesDistribution, chartTitle);
                }
            }
        });
    }


    public static void main(String[] args) {
    }
}
