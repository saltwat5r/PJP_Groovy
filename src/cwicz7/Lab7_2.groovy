package cwicz7

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 * Zad. 2

 Plik MenuPl.txt zawiera menu w postaci:
 nazwa_dania cena

 Ceny sa w PLN.
 Na podstawie pliku wejsciowego stworzyc plik MenuEur.txt majacy te sama postac, ale z cenami w EUR.
 */

def BigDecimal getEuroCourseInPLN() {
    // Pobieranie kursów
    def url = 'http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml'
    def rates = new XmlParser().parse(url)

    def map = [:]

    rates.Cube.Cube.Cube.each {
        map[it.@currency] = it.@rate
    }

    return new BigDecimal(map['PLN'])
}

def plFile = new File('MenuPl.txt')
def plFileContent = plFile.getText('UTF-8')

def eurFile = new File('MenuEur.txt')
if (eurFile.exists()) eurFile.delete()

plFileContent.eachLine { text ->

    BigDecimal euroInPLN = getEuroCourseInPLN()

    text = text.replaceAll(/(\d*?\.?\d+)$/) { all, kwota->
        BigDecimal euro = kwota.toBigDecimal()/euroInPLN
        String.format("%.2f \n", euro)
    }
    eurFile.append(text, 'UTF-8')
}