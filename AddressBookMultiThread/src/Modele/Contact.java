/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

/**
 *it's a contact Class representing a contact with all the informatoin
 * @author Bakalian
 */
public  final class Contact {
    
    
private String FirstName;
private String LastName;
private String HomeAddress;
private String Notes;
private String PersonalPhone;
private String ProfessionalPhone;
private String HomePage;
private String Email;
private String Photo;
private String Age;
private String CompanyAddress;
private String idNumber;

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public void setCompanyAddress(String CompanyAddress) {
        this.CompanyAddress = CompanyAddress;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }





    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getHomeAddress() {
        return HomeAddress;
    }



    public String getPersonalPhone() {
        return PersonalPhone;
    }

    public String getProfessionalPhone() {
        return ProfessionalPhone;
    }

    public String getHomePage() {
        return HomePage;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoto() {
        return Photo;
    }

    public String getAge() {
        return Age;
    }
    

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setHomeAddress(String HomeAddress) {
        this.HomeAddress = HomeAddress;
    }

    

    public void setPersonalPhone(String PersonalPhone) {
        this.PersonalPhone = PersonalPhone;
    }

    public void setProfessionalPhone(String ProfessionalPhone) {
        this.ProfessionalPhone = ProfessionalPhone;
    }

    public void setHomePage(String HomePage) {
        this.HomePage = HomePage;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public void setAge(String Age) {
        this.Age=Age;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }
    
    
    
}
