package co.edu.tdeacontruccionm.gestionperfilusuario;

import javax.swing.*;

public class AgriculturalProductsSearch extends JFrame {
    private final JTextField searchField;
    private final JComboBox<String> categoriesCombo;
    private final JTextArea resultsArea;
    private final Product[] products;
    private final int MAX_PRODUCTS = 100;
    private int productCount;

    public AgriculturalProductsSearch() {
        products = new Product[MAX_PRODUCTS];
        productCount = 0;
        initializeProducts();

        setTitle("Agricultural Products Search");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        searchField = new JTextField(20);
        categoriesCombo = new JComboBox<>(new String[]{"All", "Fruits", "Vegetables", "Grains", "Others"});
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);
        
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
        searchPanel.add(new JLabel("Search by name:"));
        searchPanel.add(searchField);
        searchPanel.add(new JLabel("Category:"));
        searchPanel.add(categoriesCombo);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchProducts());
        searchPanel.add(searchButton);

        add(searchPanel);
        add(new JScrollPane(resultsArea));

        JButton clearButton = new JButton("Clear search");
        clearButton.addActionListener(e -> clearSearch());
        add(clearButton);

        pack();
        setLocationRelativeTo(null);
    }

    private void addProduct(String name, String category, String description, int quantity, double price) {
        if (productCount < MAX_PRODUCTS) {
            products[productCount++] = new Product(name, category, description, quantity, price);
        }
    }

    private void initializeProducts() {
        addProduct("Apples", "Fruits", "Fresh red apples", 100, 2500);
        addProduct("Potatoes", "Vegetables", "Pastusa potatoes", 50, 1800);
        addProduct("Beans", "Grains", "Red beans", 30, 4500);
        addProduct("Tomatoes", "Vegetables", "Chonto tomatoes", 80, 2000);
        addProduct("Rice", "Grains", "White rice", 200, 3000);
        addProduct("Bananas", "Fruits", "Organic bananas", 150, 1200);
        addProduct("Oranges", "Fruits", "Sweet oranges", 80, 1800);
        addProduct("Mangos", "Fruits", "Fresh mangos", 100, 3500);
        addProduct("Onions", "Vegetables", "Large onions", 60, 2500);
        addProduct("Carrots", "Vegetables", "Fresh carrots", 70, 2000);
        addProduct("Lettuce", "Vegetables", "Fresh lettuce", 40, 1500);
        addProduct("Avocados", "Fruits", "Hass avocados", 90, 5000);
        addProduct("Pineapples", "Fruits", "Sweet pineapples", 50, 4000);
        addProduct("Bell Peppers", "Vegetables", "Red bell peppers", 60, 3000);
    }

    private void searchProducts() {
        String searchTerm = searchField.getText().toLowerCase().trim();
        String selectedCategory = (String) categoriesCombo.getSelectedItem();
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < productCount; i++) {
            Product p = products[i];
            if ((selectedCategory.equals("All") || p.getCategory().equals(selectedCategory)) &&
                (p.getName().toLowerCase().contains(searchTerm) || searchTerm.isEmpty())) {
                result.append("Name: ").append(p.getName()).append("")
                        .append("Category: ").append(p.getCategory()).append("")
                        .append("Description: ").append(p.getDescription()).append("")
                        .append("Quantity: ").append(p.getQuantity()).append("")
                        .append("Price: $").append(p.getPrice()).append("");
            }
        }

        resultsArea.setText(result.length() > 0 ? result.toString() : "No products found.");
    }

    private void clearSearch() {
        searchField.setText("");
        categoriesCombo.setSelectedIndex(0);
        resultsArea.setText("");
    }

    private static class Product {
        private final String name, category, description;
        private final int quantity;
        private final double price;

        public Product(String name, String category, String description, int quantity, double price) {
            this.name = name;
            this.category = category;
            this.description = description;
            this.quantity = quantity;
            this.price = price;
        }

        public String getName() { return name; }
        public String getCategory() { return category; }
        public String getDescription() { return description; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }
    }
}

