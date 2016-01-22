package cwicz6

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 * Zad. 1

 Dla poniższych definicji list:
 def list1 = [ 'a', 'b', 'c']
 def list2 = [ 1, 8, 23 ]

 za pomocą metody each(Closure)
 a) wypisać wszystkie elementy (2 p.),
 b) stworzyć nowe listy list11 i list12 zawierające podwojone wartości list oryginalnych (3 p.).

 */

def list1 = [ 'a', 'b', 'c']
def list2 = [ 1, 8, 23 ]


def printList(List l) {
    l.each {
        println(it)
    }
}

def listElemsSquare(List l) {
    newL = []
    l.each {
        newL << it * 2
    }

    return newL
}


printList(list1)
printList(list2)

println(listElemsSquare(list1))
println(listElemsSquare(list2))