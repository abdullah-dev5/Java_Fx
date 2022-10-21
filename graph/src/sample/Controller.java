package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TextField;

public class Controller {
    public TextField java;
    public TextField cpp;
    public TextField python;
    public TextField figma;
    public TextField html;
    public PieChart graph;

    public void loadGraph() {
        int j = Integer.parseInt(java.getText());
        int c = Integer.parseInt(cpp.getText());
        int p = Integer.parseInt(python.getText());
        int f = Integer.parseInt(figma.getText());
        int h = Integer.parseInt(html.getText());
        double total = j + c + p + f + h;

        ObservableList<PieChart.Data> data;
        data = FXCollections.observableArrayList(
                new PieChart.Data("Java", j / total),
                new PieChart.Data("HTML", h / total),

                new PieChart.Data("Figma", f / total),
                new PieChart.Data("Cpp", c / total),
                new PieChart.Data("Python", p / total)


        );
        graph.setData(data);
    }
}
