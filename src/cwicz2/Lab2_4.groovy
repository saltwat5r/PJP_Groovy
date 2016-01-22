package cwicz2

import javax.swing.JOptionPane

/**
 * Created by msoliwoda on 17.01.2016.
 */

/**
 * Zad. 4 (trudniejsze - 5 p.)
 Uogólnić funkcję z zadania 4, tak by wprowadzane mogły być dowolne liczby i słowa (napisy rozdzielone białymi znakami),
 a ich poprawność weryfikowana za pomocą przekazanego funkcji domknięcia.
 Niech funkcja nazywa sie getData.
 Przykładowe wywołania:

 getData(Integer) { it > 0 }            // liczby całkowite większe od 0
 println getData() { it.size() > 3 }   // słowa o długości większej od 3 (domyślny typ: String)
 println getData()                          // dowolne napisy (słowa)
 println getData(BigDecimal)         // dowolne liczby
 */

//def convertToInt = { int i = it }
//def type = { it.class }
//def increment = { ++it }

def customClosure = { input ->
    def result
    switch(input) {
        case { it > 0 }: input > 0 ? result = 'Integer > 0' : null
            break
        case { it instanceof String && it.size() > 3}: result = 'String > 3'
            break
        case { it instanceof String }: result = 'String'
            break
        case { it instanceof BigDecimal }: result = 'Big Decimal'
            break
        default: false
    }
    result
}

def getData(param, Closure closure) {
    return closure(param)
}

while (input = JOptionPane.showInputDialog('Podaj liczby lub słowa:', '')) {
    //println getData(input, type)
    println(getData(input, customClosure))
}


/*
def defaultBonus = 100
def f = new File('bonus.txt')
println f.text
def bonus = f.readLines().collect {
    if (it.tokenize().size() < 2) "$it $defaultBonus"
    else it
}
println 'Default bonus assigned'
bonus.each { println it }
 */