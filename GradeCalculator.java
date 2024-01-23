import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculator extends JFrame {

    private JTextField[] txtSubjects;
    private JButton btnSubmitMarks;
    private JLabel lblTotalMarks, lblAveragePercentage, lblGrade;

    public GradeCalculator() {
        // Set up the JFrame
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create components
        int numSubjects = 5; // You can adjust this based on the number of subjects
        txtSubjects = new JTextField[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            JLabel lblSubject = new JLabel("Subject " + (i + 1) + " Marks:");
            lblSubject.setBounds(10, 10 + i * 30, 120, 20);
            add(lblSubject);

            txtSubjects[i] = new JTextField();
            txtSubjects[i].setBounds(140, 10 + i * 30, 120, 20);
            add(txtSubjects[i]);
        }

        btnSubmitMarks = new JButton("Submit Marks");
        btnSubmitMarks.setBounds(80, 10 + numSubjects * 30, 200, 30);
        add(btnSubmitMarks);

        lblTotalMarks = new JLabel("Total Marks: ");
        lblTotalMarks.setBounds(10, 50 + numSubjects * 30, 300, 20);
        add(lblTotalMarks);

        lblAveragePercentage = new JLabel("Average Percentage: ");
        lblAveragePercentage.setBounds(10, 80 + numSubjects * 30, 300, 20);
        add(lblAveragePercentage);

        lblGrade = new JLabel("Grade: ");
        lblGrade.setBounds(10, 110 + numSubjects * 30, 300, 20);
        add(lblGrade);

        // Add action listener to the button
        btnSubmitMarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResults();
            }
        });
    }

    private void calculateResults() {
        try {
            int totalMarks = 0;
            int numSubjects = txtSubjects.length;

            for (int i = 0; i < numSubjects; i++) {
                int marks = Integer.parseInt(txtSubjects[i].getText());
                totalMarks += marks;
            }

            double averagePercentage = (double) totalMarks / numSubjects;

            String grade;
            if (averagePercentage >= 90) {
                grade = "A";
            } else if (averagePercentage >= 80) {
                grade = "B";
            } else if (averagePercentage >= 70) {
                grade = "C";
            } else if (averagePercentage >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Display the results
            lblTotalMarks.setText("Total Marks: " + totalMarks);
            lblAveragePercentage.setText("Average Percentage: " + averagePercentage + "%");
            lblGrade.setText("Grade: " + grade);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GradeCalculator().setVisible(true);
            }
        });
    }
}

