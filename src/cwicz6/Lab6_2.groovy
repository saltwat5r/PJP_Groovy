package cwicz6

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 * Zad. 2

 Firma software'owa prowadzi projekty w:
 Groovy, Grails, Java, JEE
 Do każdego projektu przypisani są programiści, co pokazuje poniższa mapa:

 def pmap = [ Groovy: [ 'Asia', 'Jan' ],
 Grails: [ 'Asia', 'Jan', 'Stefan', 'Mirek' ],
 Java: [ 'Asia', 'Stefan', 'Mirek' ],
 JEE: [ 'Slawek', 'Stefan', 'Janusz' ]
 ]
 Wypisać:
 a) ile osób pracuje w każdym z projektów  (3 p)
 b) projekty, które mają więcej niż dwóch programistów (3p )
 c)  w jakich projektach biorą udzial poszczególni programisci (6 p.)

 */

def pmap = [ Groovy: [ 'Asia', 'Jan' ],
             Grails: [ 'Asia', 'Jan', 'Stefan', 'Mirek' ],
             Java: [ 'Asia', 'Stefan', 'Mirek' ],
             JEE: [ 'Slawek', 'Stefan', 'Janusz' ]
]

// Wypisać:
// a) ile osób pracuje w każdym z projektów  (3 p)

println('Liczba pracowników w poszczególnych projektach:')
pmap.each { String project, List employees ->
    println("$project: $employees.size")
}

println('Collect:')
pmap.collect { println("$it.key: $it.value.size") }


// b) projekty, które mają więcej niż dwóch programistów (3p )
println('Projekty, które mają więcej niż dwóch programistów:')
pmap.each { String project, List employees ->
    employees.size() > 2 ? println("$project: $employees.size") : null
}

// c)  w jakich projektach biorą udzial poszczególni programisci (6 p.)

def developersProjects = { map ->
    println("$map.key: " + map.value.join(', '))
}

println("\nProjekty poszczególnych programistów:\n")
def devs = [:]
pmap.each { project, developers ->
    developers.each { dev ->
        if (devs["$dev"]) {
            devs["$dev"] << "$project"
        } else {
            devs["$dev"] = ["$project"]
        }
    }
}
devs.each { developersProjects(it)}