package histogram;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class is a frame. User can enter file name and then push a button to load data from this file.
 *
 * @author Anna Antończak
 * @since 25.02.2018
 *
 * @see JFrame
 * @see JTextField
 * @see JButton
 */

public class LoaderFileWindow extends JFrame {
    private JTextField enterFileNameTextField;
    private JButton loadFileButton;
    private JPanel panel1;
    private csvDataCalculation reader;
    private String fileName;
    private ArrayList<String[]> dataList;

    /**
     * Loads data from file using csvDataCalculation class. When data is loaded sets text in labels in MainWindow as a file name.
     * In other cases sets text in text field as "Error".
     *
     * @param object Frame that contais main menu
     *
     * @see csvDataCalculation
     */
    public void loadDataList(MainWindow object, boolean keyField) {

        reader = new csvDataCalculation();
        fileName = "/Users/Ania/Documents/pwr/Rok3/semestr6/Zaawansowane_techniki_JAVA/templates/";
        fileName += enterFileNameTextField.getText();
//        if(!keyField)
//        fileName = "/tests.csv";
//        else
//            fileName = "/answers.csv";
        dataList = reader.readFile(fileName);

        if (dataList != null) {
            setVisible(false);

            if (!keyField) {
                object.getAnswersLabel().setText(enterFileNameTextField.getText());
            } else {
                object.getKeyFileLabel().setText(enterFileNameTextField.getText());
            }
        } else {

            enterFileNameTextField.setText("Error!");
        }
    }

    public ArrayList<String[]> getDataList() {
        return dataList;
    }


    public LoaderFileWindow(MainWindow object, boolean keyFile) {
        dataList = null;
        add(panel1);
        pack();
        setVisible(true);
        loadFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDataList(object, keyFile);
            }
        });

    }
}
