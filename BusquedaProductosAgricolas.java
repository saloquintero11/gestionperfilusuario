package co.edu.tdeacontruccionm.gestionperfilusuario;

import javax.swing.*;

public class BusquedaProductosAgricolas extends JFrame {
    private final JTextField busquedaField;
    private final JComboBox<String> categoriasCombo;
    private final JTextArea resultadosArea;
    private final Producto[] productos;
    private final int MAX_PRODUCTOS = 100;
    private int cantidadProductos;

    public BusquedaProductosAgricolas() {
        productos = new Producto[MAX_PRODUCTOS];
        cantidadProductos = 0;
        inicializarProductos();

        setTitle("Búsqueda de Productos Agrícolas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        busquedaField = new JTextField(20);
        categoriasCombo = new JComboBox<>(new String[]{"Todas", "Frutas", "Verduras", "Granos", "Otros"});
        resultadosArea = new JTextArea(10, 40);
        resultadosArea.setEditable(false);
        
        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel();
        panelBusqueda.setLayout(new BoxLayout(panelBusqueda, BoxLayout.Y_AXIS));
        panelBusqueda.add(new JLabel("Buscar por nombre:"));
        panelBusqueda.add(busquedaField);
        panelBusqueda.add(new JLabel("Categoría:"));
        panelBusqueda.add(categoriasCombo);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(e -> buscarProductos());
        panelBusqueda.add(buscarButton);

        add(panelBusqueda);
        add(new JScrollPane(resultadosArea));

        JButton limpiarButton = new JButton("Limpiar búsqueda");
        limpiarButton.addActionListener(e -> limpiarBusqueda());
        add(limpiarButton);

        pack();
        setLocationRelativeTo(null);
    }

    private void agregarProducto(String nombre, String categoria, String descripcion, int cantidad, double precio) {
        if (cantidadProductos < MAX_PRODUCTOS) {
            productos[cantidadProductos++] = new Producto(nombre, categoria, descripcion, cantidad, precio);
        }
    }

    private void inicializarProductos() {
        agregarProducto("Manzanas", "Frutas", "Manzanas rojas frescas", 100, 2500);
        agregarProducto("Papas", "Verduras", "Papas pastusas", 50, 1800);
        agregarProducto("Frijoles", "Granos", "Frijoles rojos", 30, 4500);
        agregarProducto("Tomates", "Verduras", "Tomates chonto", 80, 2000);
        agregarProducto("Arroz", "Granos", "Arroz blanco", 200, 3000);
        agregarProducto("Bananas", "Frutas", "Bananas orgánicas", 150, 1200);
        agregarProducto("Naranjas", "Frutas", "Naranjas dulces", 80, 1800);
        agregarProducto("Mangos", "Frutas", "Mangos frescos", 100, 3500);
        agregarProducto("Cebollas", "Verduras", "Cebollas cabezonas", 60, 2500);
        agregarProducto("Zanahorias", "Verduras", "Zanahorias frescas", 70, 2000);
        agregarProducto("Lechugas", "Verduras", "Lechugas frescas", 40, 1500);
        agregarProducto("Aguacates", "Frutas", "Aguacates Hass", 90, 5000);
        agregarProducto("Piñas", "Frutas", "Piñas dulces", 50, 4000);
        agregarProducto("Pimientos", "Verduras", "Pimientos rojos", 60, 3000);
    }

    private void buscarProductos() {
        String terminoBusqueda = busquedaField.getText().toLowerCase().trim();
        String categoriaSeleccionada = (String) categoriasCombo.getSelectedItem();
        
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < cantidadProductos; i++) {
            Producto p = productos[i];
            if ((categoriaSeleccionada.equals("Todas") || p.getCategoria().equals(categoriaSeleccionada)) &&
                (p.getNombre().toLowerCase().contains(terminoBusqueda) || terminoBusqueda.isEmpty())) {
                resultado.append("Nombre: ").append(p.getNombre()).append("\n")
                        .append("Categoría: ").append(p.getCategoria()).append("\n")
                        .append("Descripción: ").append(p.getDescripcion()).append("\n")
                        .append("Cantidad: ").append(p.getCantidad()).append("\n")
                        .append("Precio: $").append(p.getPrecio()).append("\n------------------------\n");
            }
        }

        resultadosArea.setText(resultado.length() > 0 ? resultado.toString() : "No se encontraron productos.");
    }

    private void limpiarBusqueda() {
        busquedaField.setText("");
        categoriasCombo.setSelectedIndex(0);
        resultadosArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BusquedaProductosAgricolas().setVisible(true));
    }

    private static class Producto {
        private final String nombre, categoria, descripcion;
        private final int cantidad;
        private final double precio;

        public Producto(String nombre, String categoria, String descripcion, int cantidad, double precio) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.descripcion = descripcion;
            this.cantidad = cantidad;
            this.precio = precio;
        }

        public String getNombre() { return nombre; }
        public String getCategoria() { return categoria; }
        public String getDescripcion() { return descripcion; }
        public int getCantidad() { return cantidad; }
        public double getPrecio() { return precio; }
    }
}

