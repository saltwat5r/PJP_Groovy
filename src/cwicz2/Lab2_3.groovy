package cwicz2

/**
 * Created by msoliwoda on 17.01.2016.
 */

/**
 * Zad. 3 (łatwe - 2 p.)
 Napisać funkcję List apply(List l, Closure c), która każdy element listy l transformuje za pomocą domknięcie c i zwraca
 listę transformowanych wartości. Przetestować dla różnych list i różnych domknięć
 */

def inputList1 = ['a', 'b', 'c']
def inputList2 = [',', '.', '=']

def convertToInt = { int i = it }

def increment = { ++it }

def List apply(List l, Closure c) {
    def result = []
    l.each { result << c(it) }
    return result
}

println("convertToInt closure on $inputList1:\n" + apply(inputList1, convertToInt))
println("convertToInt closure on $inputList2:\n" + apply(inputList2, convertToInt))

println("increment closure on $inputList1:\n" + apply(inputList1, increment))
println("increment closure on $inputList2:\n" + apply(inputList2, increment))