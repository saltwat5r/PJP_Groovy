package cwicz5

/**
 * Created by msoliwoda on 18.01.2016.
 */
/*
Zad. 4 (5 p.)
Napisy wprowadzane w kolejnych dialogach mają formę:  pozycja = koszt. Zsumuj wszystkie koszty
dla tych samych pozycji (np. mleko, chleb) .
*/
// To samo zadanie jest w Lab1c.

import static javax.swing.JOptionPane.*

productsMap = [:]
while (input = showInputDialog('Wprowadź dane w formacie: pozycja = koszt')) {

    def regexp = /^[a-zA-Z ]+ \= +[0-9]+\.*[0-9]*$/  // Start with string + ' = ' + ends with decimal
    if (input =~ regexp) {
        inputParams = input.tokenize(' = ') //split(/ = /)
        pozycja = inputParams[0]
        koszt = inputParams[1].toBigDecimal()

        //pozycja = input.substring(0, input.indexOf(" = "))
        //koszt = input.substring(input.indexOf(" = "))
        //pozycja = input.tokenize()[0]
        //koszt = input.tokenize()[1]

        productsMap[pozycja] ? koszt += productsMap[pozycja] : null
        productsMap.put(pozycja, koszt)//[pozycja] = koszt
        println("nowa pozycja: " + pozycja)
        println("koszt: " + koszt)

        println("Products: " + productsMap)
    } else {
        showMessageDialog(null, "Błędnie wprowadzone dane!", "", 0)
    }
}
allProducts = "Produkt = koszt:\n"
productsMap.each { k, v -> allProducts += "${k} = ${v}\n" }
!productsMap.isEmpty() ? showMessageDialog(null, allProducts, "Wszystkie produkty", 1) : showMessageDialog(null, "Brak produktów!", "", 0)