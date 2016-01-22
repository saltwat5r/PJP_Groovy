package cwicz5

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 * Zad. 1 (2 p.)

 Napisać funkcję String reverseChars(String s)  odwracającą napis s i zwracającą odwrócony napis.
 np. reverseChars("piesek") zwróci "keseip"
 */

def String reverseChars(String s) {
    return s[-1..0]
}

println(reverseChars("piesek"))