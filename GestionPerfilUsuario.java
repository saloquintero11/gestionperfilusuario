
package co.edu.tdeacontruccionm.gestionperfilusuario;
import javax.swing.*;

public class GestionPerfilUsuario extends JFrame {

    private final JTextField nombreField;
    private final JTextField emailField;
    private final JTextField telefonoField;
    private final JTextArea direccionArea;
    private final JPasswordField passwordField;
    private final JPasswordField confirmPasswordField;

    public GestionPerfilUsuario() {
        setTitle("Gestión de Perfil de Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        add(telefonoField);

        add(new JLabel("Dirección:"));
        direccionArea = new JTextArea();
        add(new JScrollPane(direccionArea));

        add(new JLabel("Nueva Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Confirmar Contraseña:"));
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);

        JButton actualizarButton = new JButton("Actualizar Perfil");
        actualizarButton.addActionListener(e -> actualizarPerfil());
        add(actualizarButton);
    }

    private void actualizarPerfil() {
        String nombre = nombreField.getText();
        String email = emailField.getText();
        String telefono = telefonoField.getText();
        String direccion = direccionArea.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
            return;
        }

        

        JOptionPane.showMessageDialog(this, "Perfil actualizado con éxito:" +
                "Nombre: " + nombre + "" +
                "Email: " + email + "" +
                "Teléfono: " + telefono + "" +
                "Dirección: " + direccion);
    }

    
}

