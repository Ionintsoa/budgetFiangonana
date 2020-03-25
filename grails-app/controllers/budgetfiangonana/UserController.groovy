package budgetfiangonana

import mg.itu.mbds.service.UserService
import mg.itu.mbds.domain.CompteUtilisateur

class UserController {

    UserService userService

    def index() { }

    def create() { }

    def save() {
        CompteUtilisateur user = new CompteUtilisateur(params);
        userService.save(user);
        redirect(controller:"mouvement", action:"index");
    }
}
