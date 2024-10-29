package co.edu.tdeacontruccionm.gestionperfilusuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalesReport extends JFrame {
    private final JTextField startDateField;
    private final JTextField endDateField;
    private final JTextArea reportArea;

    public SalesReport() {
        setTitle("Sales Report Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Start Date (YYYY-MM-DD):"));
        startDateField = new JTextField();
        panel.add(startDateField);

        panel.add(new JLabel("End Date (YYYY-MM-DD):"));
        endDateField = new JTextField();
        panel.add(endDateField);

        JButton generateButton = new JButton("Generate Report");
        panel.add(generateButton);

        reportArea = new JTextArea();
        reportArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reportArea);
        panel.add(scrollPane);

        generateButton.addActionListener(e -> generateReport());

        add(panel);
    }

    private void generateReport() {
        String startDate = startDateField.getText();
        String endDate = endDateField.getText();

        
        if (startDate.isEmpty() || endDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both dates.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate start;
        LocalDate end;
        try {
            start = LocalDate.parse(startDate, DateTimeFormatter.ISO_LOCAL_DATE);
            end = LocalDate.parse(endDate, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Incorrect date format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        List<String> sales = getSales(start, end);
        StringBuilder report = new StringBuilder();
        report.append("Sales Report from ").append(startDate).append(" to ").append(endDate).append(":");
        for (String sale : sales) {
            report.append(sale).append("");
        }

        reportArea.setText(report.toString());
    }

    private List<String> getSales(LocalDate start, LocalDate end) {
       
        List<String> sales = new ArrayList<>();
        sales.add("Sale 1: $100 - " + start.plusDays(1));
        sales.add("Sale 2: $200 - " + start.plusDays(2));
        sales.add("Sale 3: $150 - " + end.minusDays(1));
        return sales;
    }
}
