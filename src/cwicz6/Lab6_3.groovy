package cwicz6

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by msoliwoda on 15.01.2016.
 */

/**
 Zad. 3 (Regex) - 8 p.
 Daty w tekście maja postać YYYY-MM-DD (rok- miesiac- dzien). Wypisać wszystkie poprawne daty.
 czyli: po wyróznieniu wszytskicgh fragmentów, które mogą być datami sprawdizc ich poprawnośc (np. czy właściwa jest liczba dni w miesiącu)
*/

File datesFile = new File('dates.txt')
String datesContent = datesFile.getText('UTF-8')

def regexp = /\d{4}\-\d{2}\-\d{2}/
def matcher = datesContent =~ regexp

def foundedDates = []
matcher.each { foundedDates << it }
println "Founded dates: $foundedDates\n"

println "Valid dates:"
foundedDates.each {
    Date validatedDate
    SimpleDateFormat dateFormat = new SimpleDateFormat('yyyy-MM-dd')
    dateFormat.setLenient(false)
    try { validatedDate = dateFormat.parse("$it"); if(validatedDate) println(validatedDate)} catch (ParseException e) { /*println "Parse exception beacuse of: $e.cause"*/}
}