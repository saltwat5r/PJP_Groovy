package cwicz1
names = ['AWA Warszawa', 'AKR Kraków', 'AWR Wrocław', 'xxx Warszawa']
loc = 'Warszawa'
waw = names.findAll {it.endsWith loc}
println "Znalezione dla $loc: " + waw.size()
waw.each { println it.tokenize()[0]}
