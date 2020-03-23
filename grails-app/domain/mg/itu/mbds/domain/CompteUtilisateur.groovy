package mg.itu.mbds.domain

class CompteUtilisateur {
    String firstName
    String lastName
    String emailAddress
    String password
    String repeatPassword
    boolean isValidated = false
    static hasMany = [mouvements: Mouvement]

    static constraints = {
        firstName blank: false
        lastName nullable: true
        emailAddress email: true, blank: false, unique: true
        /*password validator: {
            Validator.isStrengthPassword(it)
        }
        repeatPassword validator: { val, obj -> val.compareTo(obj.password) == 0 }*/
    }
}
