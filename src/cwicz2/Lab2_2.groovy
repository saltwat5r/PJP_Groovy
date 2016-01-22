package cwicz2

import static javax.swing.JOptionPane.*

/**
 * Created by msoliwoda on 16.01.2016.
 */

/**
 * Zad. 2 (bardzo łatwe - 2 p.)
 Napisać funkcję List getInts(), która prosi o podanie szeregu liczb całkowitych w dialogu wejściowym i zwraca listę
 wprowadzonych liczb (jako obiektów typu Integer). Nie dopuścić do wprowadzenia wadliwych danych (ponowienie dialogu do poprawki).

 Pomoc (ew. pokazanie wadliwych danych w dialogu do poprawki):
 public static String showInputDialog(Component parentComponent,
 Object message,
 Object initialSelectionValue)
 Shows a question-message dialog requesting input from the user and parented to parentComponent.
 The input value will be initialized to initialSelectionValue. The dialog is displayed on top of the Component's frame,
 and is usually positioned below the Component.

 Parameters:
 parentComponent - the parent Component for the dialog (podamy null)
 message - the Object to display (komunikat)
 initialSelectionValue - the value used to initialize the input field (co się pokazuje w polu tekstowym dialogu)
 */

def showIntInput(param) {
    return param ? showInputDialog("Nieakceptowalne znaki: $param \nSpróbuj ponownie.") : showInputDialog('Podaj szereg liczb całkowitych.')
}

def List getInts(param = null) {


    input = showIntInput(param)

    if (input) {
        def regexp = /^[0-9 ]+$/  // Only numbers and spaces
        if (input =~ regexp) {
            array = input.tokenize(' ')
            if (array) {
                println('Good')
                array.eachWithIndex{ entry, i ->
                    array[i] = entry.toInteger()
                }
                return array
            }
        } else {
            a = [] //input.findAll(regexp) //(/^(?:(?!ab).)+$/)
            input.each {
                if (!(it =~ /[0-9 ]/)) {
                    a << it
                }
            }
            getInts(a)
        }
    } else {
        showMessageDialog(null, 'Brak danych!', '', 0)
    }
}

ints = getInts()
if (ints) {
    showMessageDialog(null, "Lista Integerów:\n $ints", '' , 1)
}
