package cwicz5

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 * Zad. 2 (2 p.)

 Napisać funkcję String reverseWords(String s) zwracającą napis, składający się ze słów napisu s w odwrotnej kolejności.
 Np.  reverseWords("ala ma kota") zwróci "kota ma ala"
 */

def String reverseWords(String s) {
    return s.split().reverse().join(' ')
}

println(reverseWords("ala ma kota"))