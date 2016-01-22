package cwicz5

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 * Zad. 3  (3 p)
 Napisać funkcję String join(List l, String sep) zwracająca napis zawierający elmenty listy l rozdzielone separatorami sep.
 */


def String join(List l, String sep) {
    str = ''
    l.each {
        str = l.join(sep)
    }

    str
}

println(join(['Mateusz', 'jest', 'studentem', 'PJA'], ' *!* '))