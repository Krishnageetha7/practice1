import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class StudentManagement {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        
        String[] columns = {"Name", "Grade"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

       
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField(15);
        JLabel gradeLabel = new JLabel("Grade:");
        JTextField gradeField = new JTextField(5);
        JButton addButton = new JButton("Add Student");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(gradeLabel);
        inputPanel.add(gradeField);
        inputPanel.add(new JLabel()); 
        inputPanel.add(addButton);

       
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String grade = gradeField.getText();
                if (name.isEmpty() || grade.isEmpty()) {
       JOptionPane.showMessageDialog(frame, "Please enter name and grade!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    tableModel.addRow(new Object[]{name, grade});
                    nameField.setText("");
                    gradeField.setText("");
                }
            }
        });

        
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.NORTH);

       
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
 
}