package histogram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class provides methods to calculate statistics from .csv file
 *
 * @author Anna Antończak
 * @since 23.02.2018
 */
public class csvDataCalculation {

    /**
     * array of student's points - each position stores one student's number of points
     */
    private double[] results;
    /**
     * array of grades distribution - each position stores number of students that received the same grade
     */
    private double[] gradesDistribution;

    /**
     * Gets data from .csv file
     *
     * @param fileName Name of loaded .csv file
     * @return ArrayList of String[] representing each line from file
     */
    public ArrayList<String[]> readFile(String fileName) {

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            ArrayList<String[]> answersList = new ArrayList<>();
            while ((line = br.readLine()) != null) {

                String[] answer = line.split(cvsSplitBy);

                answersList.add(answer);
            }
            return answersList;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Checks how many points gains each student and return array of points
     *
     * @param answersList ArrayList of String[] that contains student's answers - each position in ArrayList stores one student's answers
     * @param answerKey   ArrayList of String[] that contains answer key
     * @return array of student's points - each position stores one student's number of points
     */
    public double[] checkAnswers(ArrayList<String[]> answersList, ArrayList<String[]> answerKey) {

        results = new double[answersList.size()];

        for (int i = 0; i < answersList.size(); i++) {
            for (int j = 0; j < answersList.get(j).length; j++) {

                if (answersList.get(i).length != answerKey.get(0).length)
                    return null;

                if (answersList.get(i)[j].equals(answerKey.get(0)[j]))
                    results[i]++;
            }
        }
        return results;
    }


    /**
     * Returns distribution of grades from students points
     * <ul>
     *     <li>gradesDistribution[0] - 2.0</li>
     *     <li>gradesDistribution[1] - 3.0</li>
     *     <li>gradesDistribution[2] - 3.5</li>
     *     <li>gradesDistribution[3] - 4.0</li>
     *     <li>gradesDistribution[4] - 4.5</li>
     *     <li>gradesDistribution[5] - 5.0</li>
     * </ul>
     *
     * @param results          array of student's points
     * @param totalQuestionsNo number of questions in answers key
     * @return array of grades distribution
     * @see csvDataCalculation#checkAnswers(ArrayList, ArrayList)
     */
    public double[] calculateGrades(double[] results, int totalQuestionsNo) {

        if (totalQuestionsNo < 1) {
            return null;
        }
        gradesDistribution = new double[6];

        for (int i = 0; i < results.length; i++) {
            if (results[i] / totalQuestionsNo > 0.9) {
                gradesDistribution[5] += 1;
            } else if (results[i] / totalQuestionsNo >= 0.8) {
                gradesDistribution[4] += 1;

            } else if (results[i] / totalQuestionsNo >= 0.7) {
                gradesDistribution[3] += 1;
            } else if (results[i] / totalQuestionsNo >= 0.6) {
                gradesDistribution[2] += 1;

            } else if (results[i] / totalQuestionsNo >= 0.4) {
                gradesDistribution[1] += 1;
            } else {
                gradesDistribution[0] += 1;
            }
        }
        return gradesDistribution;

    }
}
