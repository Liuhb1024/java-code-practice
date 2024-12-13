import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class AccountBook implements ActionListener {
    private JFrame frame;
    private JButton addButton, saveButton, deleteButton;
    private JTextField nameField, amountField;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private double total;
    private File file;

    public AccountBook() {
        frame = new JFrame("记账本");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("时间及用处"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("金额"));
        amountField = new JTextField();
        inputPanel.add(amountField);
        addButton = new JButton("添加");
        addButton.addActionListener(this);
        inputPanel.add(addButton);
        saveButton = new JButton("保存");
        saveButton.addActionListener(this);
        inputPanel.add(saveButton);
        deleteButton = new JButton("删除");
        deleteButton.addActionListener(this);
        inputPanel.add(deleteButton);
        frame.add(inputPanel, BorderLayout.PAGE_START);

        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel totalPanel = new JPanel(new BorderLayout());
        totalPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        totalPanel.add(new JLabel("总计"), BorderLayout.LINE_START);
        JLabel totalLabel = new JLabel("$0.00");
        totalPanel.add(totalLabel, BorderLayout.LINE_END);
        frame.add(totalPanel, BorderLayout.PAGE_END);
        file = new File("accountbook.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {listModel.addElement(line);
                    total += Double.parseDouble(line.substring(line.indexOf("$") + 1, line.length() - 1));
                }
                totalLabel.setText(String.format("$%.2f", total));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        frame.pack();
        frame.setVisible(true);
    }

    @SuppressWarnings("null")
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText().trim();
            double amount = Double.parseDouble(amountField.getText().trim());
            listModel.addElement(name + " ($" + amount + ")");
            total += amount;
            AbstractButton totalLabel = null;
            totalLabel.setText(String.format("$%.2f", total));
            nameField.setText("");
            amountField.setText("");
            addButton.setEnabled(false);
            JOptionPane.showMessageDialog(frame, "已添加记录！", "提示", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == saveButton) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (int i = 0; i < listModel.size(); i++) {
                    writer.write(listModel.get(i));
                    writer.newLine();
                }
                JOptionPane.showMessageDialog(frame, "已保存记录！", "提示", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else if (e.getSource() == deleteButton) {
            AbstractButton totalLabel = null;
            ArrayList<String> selectedItems = new ArrayList<String>(list.getSelectedValuesList());
            int size = selectedItems.size();
            for (int i = size - 1; i >= 0; i--) {
                String item = selectedItems.get(i);
                int index = listModel.indexOf(item);
                listModel.remove(index);
                double amount = Double.parseDouble(item.substring(item.indexOf("$") + 1, item.length()));
                total -= amount;
            }
            deleteButton.setEnabled(!listModel.isEmpty());
            totalLabel.setText(String.format("$%.2f", total));
        }
    }

    public static void main(String[] args) {
        new AccountBook();
    }
}