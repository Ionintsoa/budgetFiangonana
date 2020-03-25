package mg.itu.mbds.service

import grails.gorm.transactions.Transactional

import mg.itu.mbds.domain.CompteUtilisateur

@Transactional
class UserService {
  def serviceMethod() {

  }

  def save(CompteUtilisateur user) {
    user.save(failOnError: true)
  }

  def edit(String id, CompteUtilisateur user) {
    def loadedObj = getById(id)
    loadedObj.properties = user.properties
    save(loadedObj)
  }

  def getAll() {
    return CompteUtilisateur.list()
  }

  def getById(String id) {
    return CompteUtilisateur.get(Long.parseLong(id))
  }

  def delete(String id) {
    return CompteUtilisateur.get(Long.parseLong(id)).delete()
  }
}