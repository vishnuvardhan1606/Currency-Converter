import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverterGUI extends JFrame implements ActionListener {
    private JLabel amountLabel, fromCurrencyLabel, toCurrencyLabel, resultLabel;
    private JTextField amountField;
    private JComboBox<String> fromCurrencyBox, toCurrencyBox;
    private JButton convertButton;
    private Map<String, Double> exchangeRates;

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        amountLabel = new JLabel("Amount: ");
        add(amountLabel);

        amountField = new JTextField();
        add(amountField);

        fromCurrencyLabel = new JLabel("From Currency: ");
        add(fromCurrencyLabel);

        fromCurrencyBox = new JComboBox<>();
        fromCurrencyBox.addItem("USD");
        fromCurrencyBox.addItem("EUR");
        fromCurrencyBox.addItem("GBP");
        fromCurrencyBox.addItem("YEN");
        add(fromCurrencyBox);

        toCurrencyLabel = new JLabel("To Currency: ");
        add(toCurrencyLabel);

        toCurrencyBox = new JComboBox<>();
        toCurrencyBox.addItem("USD");
        toCurrencyBox.addItem("EUR");
        toCurrencyBox.addItem("GBP");
        toCurrencyBox.addItem("YEN");
        add(toCurrencyBox);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        add(convertButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.2061);
        exchangeRates.put("EUR", 1.000);
        exchangeRates.put("GBP", 0.8626);
        exchangeRates.put("YEN", 132.2300);
        exchangeRates.put("INR", 0.012);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConverterGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            double amount = Double.parseDouble(amountField.getText());
            String fromCurrency = fromCurrencyBox.getSelectedItem().toString();
            String toCurrency = toCurrencyBox.getSelectedItem().toString();
            double fromRate = exchangeRates.get(fromCurrency);
            double toRate = exchangeRates.get(toCurrency);
            double result = amount * (toRate / fromRate);
            DecimalFormat df = new DecimalFormat("#.##");
            resultLabel.setText(df.format(amount) + " " + fromCurrency + " is equal to " + df.format(result) + " " + toCurrency);
        }
    }
}
