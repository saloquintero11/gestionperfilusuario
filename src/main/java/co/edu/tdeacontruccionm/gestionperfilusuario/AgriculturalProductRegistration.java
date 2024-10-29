package co.edu.tdeacontruccionm.gestionperfilusuario;

import javax.swing.*;

public class AgriculturalProductRegistration extends JFrame {

    private final JTextField nameField;
    private final JTextArea descriptionArea;
    private final JTextField quantityField;
    private final JTextField priceField;

    public AgriculturalProductRegistration() {
        setTitle("Agricultural Product Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Description:"));
        descriptionArea = new JTextArea();
        add(new JScrollPane(descriptionArea));

        add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        add(quantityField);

        add(new JLabel("Price:"));
        priceField = new JTextField();
        add(priceField);

        JButton registerButton = new JButton("Register Product");
        registerButton.addActionListener(e -> registerProduct());
        add(registerButton);
    }

    private void registerProduct() {
        String name = nameField.getText();
        String description = descriptionArea.getText();
        String quantity = quantityField.getText();
        String price = priceField.getText();

        JOptionPane.showMessageDialog(this, "Product successfully registered:" +
                "Name: " + name + "" +
                "Description: " + description + "" +
                "Quantity: " + quantity + "" +
                "Price: " + price);
    }

    
}
