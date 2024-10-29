package co.edu.tdeacontruccionm.gestionperfilusuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReporteVentas extends JFrame {
    private final JTextField campoFechaInicio;
    private final JTextField campoFechaFin;
    private final JTextArea areaReporte;

    public ReporteVentas() {
        setTitle("Generación de Reportes de Ventas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Fecha Inicio (YYYY-MM-DD):"));
        campoFechaInicio = new JTextField();
        panel.add(campoFechaInicio);

        panel.add(new JLabel("Fecha Fin (YYYY-MM-DD):"));
        campoFechaFin = new JTextField();
        panel.add(campoFechaFin);

        JButton botonGenerar = new JButton("Generar Reporte");
        panel.add(botonGenerar);

        areaReporte = new JTextArea();
        areaReporte.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaReporte);
        panel.add(scrollPane);

        botonGenerar.addActionListener(e -> generarReporte());

        add(panel);
    }

    private void generarReporte() {
        String fechaInicio = campoFechaInicio.getText();
        String fechaFin = campoFechaFin.getText();

        // Validar fechas
        if (fechaInicio.isEmpty() || fechaFin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese ambas fechas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate inicio;
        LocalDate fin;
        try {
            inicio = LocalDate.parse(fechaInicio, DateTimeFormatter.ISO_LOCAL_DATE);
            fin = LocalDate.parse(fechaFin, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Generar reporte (simulado)
        List<String> ventas = obtenerVentas(inicio, fin);
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de Ventas desde ").append(fechaInicio).append(" hasta ").append(fechaFin).append(":\n\n");
        for (String venta : ventas) {
            reporte.append(venta).append("\n");
        }

        areaReporte.setText(reporte.toString());
    }

    private List<String> obtenerVentas(LocalDate inicio, LocalDate fin) {
        //* Simulación de obtención de datos de ventas
        List<String> ventas = new ArrayList<>();
        ventas.add("Venta 1: $100 - " + inicio.plusDays(1));
        ventas.add("Venta 2: $200 - " + inicio.plusDays(2));
        ventas.add("Venta 3: $150 - " + fin.minusDays(1));
        return ventas;
    }
}



