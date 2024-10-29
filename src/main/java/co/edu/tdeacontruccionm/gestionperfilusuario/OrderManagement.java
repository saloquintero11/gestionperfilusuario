
package co.edu.tdeacontruccionm.gestionperfilusuario;

import javax.swing.*;

public class OrderManagement extends JFrame {

    private final JTextField productField;
    private final JTextField quantityField;
    private final JTextField priceField;
    private final JTextArea ordersArea;
    private final Order[] orders;
    private int orderCount;

    public OrderManagement() {
        setTitle("Order Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        orders = new Order[100];
        orderCount = 0;

        add(new JLabel("Product:"));
        productField = new JTextField();
        add(productField);

        add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        add(quantityField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        JButton createOrderButton = new JButton("Create Order");
        createOrderButton.addActionListener(e -> createOrder());
        add(createOrderButton);

        ordersArea = new JTextArea();
        ordersArea.setEditable(false);
        add(new JScrollPane(ordersArea));

        JButton manageOrdersButton = new JButton("Manage Orders");
        manageOrdersButton.addActionListener(e -> manageOrders());
        add(manageOrdersButton);
    }

    private void createOrder() {
        String product = productField.getText();
        String quantity = quantityField.getText();
        String price = priceField.getText();

        if (orderCount < orders.length) {
            Order order = new Order(product, quantity, price);
            orders[orderCount++] = order;

            ordersArea.append("Order created: " + order + "");

            productField.setText("");
            quantityField.setText("");
            priceField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Cannot create more orders. Maximum capacity reached.");
        }
    }

    private void manageOrders() {
        StringBuilder management = new StringBuilder("Order Management:");
        for (int i = 0; i < orderCount; i++) {
            management.append(orders[i]).append("");
        }
        JOptionPane.showMessageDialog(this, management.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OrderManagement().setVisible(true));
    }

    static class Order {
        private final String product;
        private final String quantity;
        private final String price;

        public Order(String product, String quantity, String price) {
            this.product = product;
            this.quantity = quantity;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product: " + product + ", Quantity: " + quantity + ", Price: " + price;
        }
    }
}
