package cwicz1
/* 
 * Napisać pogram przekształcający liczby na ich słowne odpowiedniki. 
       Np. po wprowadzeniu liczby 147 winniśmy uzyskać jeden - cztery - siedem. (5)
*/

import static javax.swing.JOptionPane.*

numbersMap = ['0': 'zero',
	'1': 'jeden',
	'2': 'dwa',
	'3': 'trzy',
	'4': 'cztery',
	'5': 'pięć',
	'6': 'sześć',
	'7': 'siedem',
	'8': 'osiem',
	'9': 'dziewięć']

input = showInputDialog('Podaj liczbę')

resultString = ''

data = input.toCharArray()

data.eachWithIndex { item, index ->
	resultString += numbersMap["$item"] + ' '
}
resultString = resultString.tokenize().join(' - ')
println resultString