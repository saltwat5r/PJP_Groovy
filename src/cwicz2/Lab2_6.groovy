package cwicz2

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 * Zad. 6 - badawcze trochę - 5p.

 Przedstawić ciekawe i praktycznie użyteczne zastosowania trampoline() i memoize().
 */

// Trampoline
/*
def factorial1
def factorial2

factorial1 = { int n, def accu = 1G ->
    if (n < 2) return accu
    factorial1(n - 1, n * accu)
}


factorial2 = { int n, def accu = 1G ->
    if (n < 2) return accu
    factorial2.trampoline(n - 1, n * accu)  // działa jak curry
}                                           // zwraca TrampolinedClos
factorial2 = factorial2.trampoline()

println factorial2(1000)
println factorial1(1000)
*/

// Memoize
long start
long count = 0
def startTimer = { -> start = System.currentTimeMillis() }
def elapsed = { -> System.currentTimeMillis() - start }

def fib

fib = { n ->
    count++
    if (n < 2) n
    else  fib(n - 1) + fib(n - 2)
}

startTimer()
println fib(34)
println 'Czas = ' + elapsed()/1000 + ' sek. Wolań: ' + count

fib = fib.memoize()
count = 0
startTimer()
println fib(34)
println 'Czas = ' + elapsed()/1000 + ' sek. Wolań: ' + count
