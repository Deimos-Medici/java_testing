package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

    private int id = Integer.MAX_VALUE;
    private  String name;
    private  String lastname;
    private  String address;
    private  String phone;
    private  String mail;
    private  String homePhone;
    private  String mobilePhone;

    public String getHomePhone() {
        return homePhone;
    }

    public ContactData withHomePhone(String homePhone){
        this.homePhone = homePhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public ContactData withMobilePhone(String mobilePhone){
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }
    public ContactData withWorkPhone(String workPhone){
        this.workPhone = workPhone;
        return this;
    }

    private  String workPhone;



    public String getName(){
        return name;
    }

    public String getLastname(){
        return lastname;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public String getMail(){
        return mail;
    }

    public int getId(){
        return id;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactData withMail(String mail) {
        this.mail = mail;
        return this;
    }

    @Override
    public String toString() {
        return "NewContactInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname);
    }

}