
package co.edu.tdeacontruccionm.gestionperfilusuario;
import javax.swing.*;

public class UserProfileManagement extends JFrame {

    private final JTextField nameField;
    private final JTextField emailField;
    private final JTextField phoneField;
    private final JTextArea addressArea;
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;

    public UserProfileManagement() {
        setTitle("User Profile Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Address:"));
        addressArea = new JTextArea();
        add(new JScrollPane(addressArea));

        add(new JLabel("New Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        JButton updateButton = new JButton("Update Profile");
        updateButton.addActionListener(e -> updateProfile());
        add(updateButton);
    }

    private void updateProfile() {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String address = addressArea.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match");
            return;
        }

        JOptionPane.showMessageDialog(this, "Profile updated successfully:" +
                "Name: " + name + "" +
                "Email: " + email + "" +
                "Phone: " + phone + "" +
                "Address: " + address);
    }

   
}
