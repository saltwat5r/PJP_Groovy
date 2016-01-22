package cwicz6

import javax.swing.JOptionPane

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 * Zad. 4 (Regex) - 8 p.
 a) Napisać wyrażenie regularne, za pomoca którego mozna odnaleźć w tekście dowolne liczby rzeczywiste.
 b) zastosować je do przetwarzania tekstu zawierającego (posród innych) napisy w postaci liczba PLN, w taki sposób, aby zamienić te fragmenty na liczba EUR (po aktualnym kursie)

 */


def aMatch(String text) {
    def results = []
    text.eachMatch(/\d+/) {results << it}
    results
}

def bMatch(text) {
    // Pobieranie kursów
    def url = 'http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml'
    def rates = new XmlParser().parse(url)

    def map = [:]

    rates.Cube.Cube.Cube.each {
        map[it.@currency] = it.@rate
    }

    BigDecimal euroInPln = new BigDecimal(map['PLN'])
    text = text.replaceAll(/(\d+\.?\d+) PLN/) { all, kwota->
        BigDecimal euro = kwota.toBigDecimal()/euroInPln
        String.format("%.2f", euro) + ' EUR'
    }
    return  text
}

while (input = JOptionPane.showInputDialog('Podaj tekst z liczbami:')) {
    if (input) {
        println(aMatch(input))

        JOptionPane.showMessageDialog(null, bMatch(input))
    }
}