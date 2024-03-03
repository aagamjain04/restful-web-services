package com.project.rest.webservices.restfulwebservices.versioning;

public class PersonV2 {

    private String firstname;
    private String lastName;
    public PersonV2(String firstname, String lastName) {
        this.firstname = firstname;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "firstname='" + firstname + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
