package cwicz7

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 * Zad. 1

 Firma software'owa prowadzi projekty w:
 Groovy, Grails, Java, JEE
 Plik Projekty.txt zawiera informacje o składzie osobowym każdego z projektów w postaci:
 nazwaprojektu<TAB>Nazwisko imie(1)<TAB>Nazwiskoimie(2)<TAB> itd

 Utworzyc pliki:
 ProjektyDuze.txt - zawierający spis projektów w którym pracuje > niż 3 osoby

 Programisci.txt - zawierajacy spis programistow w postaci:
 nazwisko imie<tab>proj1<tab>proj2<tab> itd.
 */

def projectsFile = new File('Projekty.txt')
def hugeProjectsFile = new File('ProjektyDuze.txt')
def developersFile = new File('Programisci.txt')

def checkIsHugeTeam = { map ->
    !(map.value.size > 3) ?: hugeProjectsFile.append(map.key + '\n', 'UTF-8')
}
def developersWithProjects = { map ->
    fullname = map.key.tokenize()
    name = fullname[0]
    surname = fullname[1]
    developersFile.append("$surname $name" + '\t' + map.value.join('\t') + '\n' ,'UTF-8')
}
def pmap = [:]

projectsFile.splitEachLine('\t') { tokens ->
    def project = tokens[0]
    def developers = tokens[1..-1]
    pmap["$project"] = developers
}

println('Wszystkie projekty:')
pmap.each {println(it)}

// Projekty duże
// Clear if file exists
!hugeProjectsFile.exists() ?: hugeProjectsFile.write('')
pmap.each { checkIsHugeTeam(it) }

// Programiści
!developersFile.exists() ?: developersFile.write('')
println("\nDevelopers: ")
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

println(devs)
// Clear if file exists
!developersFile.exists() ?: developersFile.write('')
devs.each { developersWithProjects(it)}

/*
// Programiści
!developersFile.exists() ?: developersFile.write('')
println("Developers: ")
def devs = [:]
pmap.each { key, value ->
    value.each {
        devs["$it"] = "$key"
    }
}

println(devs)
 */