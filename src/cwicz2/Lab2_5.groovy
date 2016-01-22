package cwicz2

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 Zad. 5 - wlasne konstrukcje iteracyjne (badawcze trochę) - 5 p.

 Zapewnić iterowanie na Iterable za pomocą metody eachTuple, umożliwiającej działanie podanego domknięcia na kolejnych
 n-kach elemntow. Liczba n wynikać ma z liczby argumentów domknięcia.
 W "płaskiej" definicji skryptowej można by jej uzywać np. tak

 def list = (1..40)

 eachTuple(list) { e1, e2, e3, e4 ->
 println "$e1 $e2 $e3 $e4"
 }

 def s = 'asia ma kota i psa'

 def out = new StringBuffer()
 eachTuple(s) { a,b ->
 out << b << a
 }
 println out

 Wypisze:
 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 16
 17 18 19 20
 21 22 23 24
 25 26 27 28
 29 30 31 32
 33 34 35 36
 37 38 39 40
 saaim  aokati p as
 */