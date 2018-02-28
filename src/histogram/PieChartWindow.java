package histogram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * This class is a frame. It displays histogram using JFreeChart.
 *
 * @author Anna Antończak
 * @since 27.02.2018
 *
 * @see JFrame
 * @see JFreeChart
 */

public class PieChartWindow {

    /**
     *
     * @param data array of data to create a pie chart;
     * @param chartTitle title of the chart;
     */
        PieChartWindow(double data[], String chartTitle){
                JFreeChart pieChart = createPieChart(data, chartTitle);
                JFrame frame = new JFrame();
                JPanel panelPie = new JPanel();

                BufferedImage image = pieChart.createBufferedImage(600, 400);
                JLabel labelImage = new JLabel(new ImageIcon(image));
                panelPie.add(labelImage);
                frame.add(panelPie);
                frame.pack();
                frame.setVisible(true);
        }

    /**
     * Creates pie chart using JFreeChart.
     *
     * @param data array of data to create a pie chart;
     * @param chartTitle title of the chart;
     * @return simple pie chart
     *
     * @see DefaultPieDataset
     */
        public JFreeChart createPieChart(double data[], String chartTitle){

        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("2.0", data[0]);
        pieDataset.setValue("3.0", data[1]);
        pieDataset.setValue("3.5", data[2]);
        pieDataset.setValue("4.0", data[3]);
        pieDataset.setValue("4.5", data[4]);
        pieDataset.setValue("5.0", data[5]);
        JFreeChart chart = ChartFactory.createPieChart
                (chartTitle,
                        pieDataset,
                        true,
                        true,
                        false );

        return chart;
        }
}