package histogram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * This class is a frame. It displays histogram using JFreeChart.
 *
 * @author Anna Antończak
 * @since 25.02.2018
 *
 * @see JFrame
 * @see JFreeChart
 */

public class HistogramWindow {

    /**
     * Creates and returns histogram using JFreeChart.
     *
     * @param xaxisData data to create a histogram;
     * @param binsNumber number of bins in histogram;
     * @param xaxisTitle title of x axis;
     * @param yaxisTitle title of y axis;;
     * @param minVal min value in histogram on x axis;
     * @param maxVal max value in histogram on x axis;;
     */
    HistogramWindow(double[] xaxisData, int binsNumber, String xaxisTitle, String yaxisTitle, double minVal, double maxVal){
        JFreeChart histogram = createHistogram(xaxisData, binsNumber, xaxisTitle, yaxisTitle,minVal, maxVal);
        JFrame frame = new JFrame();
        JPanel panelHist = new JPanel();

        BufferedImage image = histogram.createBufferedImage(600, 400);
        JLabel labelImage = new JLabel(new ImageIcon(image));
        panelHist.add(labelImage);
        frame.add(panelHist);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Creates and returns histogram using JFreeChart.
     *
     * @param xaxisData data to create a histogram;
     * @param binsNumber number of bins in histogram;
     * @param xaxisTitle title of x axis;
     * @param yaxisTitle title of y axis;;
     * @param minVal min value in histogram on x axis;
     * @param maxVal max value in histogram on x axis;;
     * @return histogram with specified parameters
     *
     * @see HistogramDataset
     */
    private JFreeChart createHistogram(double[] xaxisData, int binsNumber, String xaxisTitle, String yaxisTitle, double minVal, double maxVal) {
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.FREQUENCY);
        dataset.addSeries("Histogram", xaxisData, binsNumber, minVal, maxVal);
        //dataset.addSeries("Histogram", xaxisData, binsNumber);
        String plotTitle = "Histogram";
        PlotOrientation orientation = PlotOrientation.VERTICAL;
        boolean show = false;
        boolean toolTips = false;
        boolean urls = false;
        JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxisTitle, yaxisTitle,
                dataset, orientation, show, toolTips, urls);

        return chart;

    }
}
