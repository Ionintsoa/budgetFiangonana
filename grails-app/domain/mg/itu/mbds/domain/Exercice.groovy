package mg.itu.mbds.domain

class Exercice {
    int beginYear
    int endYear
    static hasMany = [caisses: Caisse]
    static constraints = {
    }
}
