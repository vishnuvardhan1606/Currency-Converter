# Currency-Converter

A currency converter is an application that allows users to convert amounts from one currency to another. It typically includes a graphical user interface (GUI) with input fields for the source currency and amount, and output fields for the converted amount in the target currency.
To create a currency converter in Java, you can use the Swing library to build the GUI. This involves creating a JFrame to hold the application window, and adding components like JLabels for currency names, JTextFields for user input, and JButtons for conversion actions and closing the app.
The conversion logic is implemented in Java code. When the user enters an amount in the source currency and clicks the convert button, the program retrieves the input value, performs the conversion calculation based on exchange rates, and displays the result in the target currency field.

The conversion calculation can be done using simple multiplication, for example:
java
double dollarAmount = rupeeAmount / 65.25;
Where 65.25 is the assumed exchange rate from rupees to dollars.

More advanced currency converters may fetch live exchange rates from an API to provide accurate, up-to-date conversions.
The key steps in creating a currency converter in Java are:
Set up the Swing GUI with input/output fields and buttons
Add action listeners to the buttons to handle user input
Retrieve the input amount from the source currency field
Perform the conversion calculation based on exchange rates
Display the converted amount in the target currency field
With some Java coding and Swing GUI components, you can create a simple but functional currency converter application. More complex features like fetching live exchange rates can be added to enhance the application.

![image](https://github.com/vishnuvardhan1606/Currency-Converter/assets/149487193/0b64c9f5-1501-4558-bd44-3a45caa6a20b)
![image](https://github.com/vishnuvardhan1606/Currency-Converter/assets/149487193/5a9ac05c-c599-4209-ac25-d950f3c753d1)
