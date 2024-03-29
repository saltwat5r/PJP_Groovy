package cwicz7

/**
 * Created by msoliwoda on 18.01.2016.
 */

/**
 * Zad. 3
 Wylistować pełne nazwy wszystkich plików html z podanego katalogu i wzystkich jego podkatalogów w postaci:
 1 nazwa
 2 nazwa

 Np.
 1 D:\docs\api\allclasses-frame.html
 2 D:\docs\api\allclasses-noframe.html
 3 D:\docs\api\constant-values.html
 4 D:\docs\api\deprecated-list.html
 5 D:\docs\api\help-doc.html
 6 D:\docs\api\index-files\index-1.html
 7 D:\docs\api\index-files\index-10.html
 8 D:\docs\api\index-files\index-11.html
 9 D:\docs\api\index-files\index-12.html
 10 D:\docs\api\index-files\index-13.html
 ...
 ....

 */

def filePath = new File('htmls_catalog').absolutePath
def fileDir = new File(filePath)
println("Files dir: $fileDir\n")

def index = 1
fileDir.eachFileRecurse {
    def regex = /\w+.{1}html$/
    if (it =~ regex) { println("$index $it"); index++ }
}