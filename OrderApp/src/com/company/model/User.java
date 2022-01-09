package com.company.model;

public class User {

    private int userid;
    private String name;
    private int phoneNumber;
    private String adressEmail;
    private String adress;

    public static final class Builder {

        private int userid;
        private String name;
        private int phoneNumber;
        private String adressEmail;
        private String adress;



        public Builder userid(int userid){

            this.userid = userid;
            return this;
        }

        public Builder name(String name){

            this.name = name;
            return this;
        }

        public Builder phoneNumber(int phoneNumber){

            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder adressEmail(String adressEmail){

            this.adressEmail = adressEmail;
            return this;
        }

        public Builder adress(String adress){

            this.adress = adress;
            return this;
        }


        public User build(){

            if(name.isEmpty()){
                throw new IllegalStateException("Name can not be empty!");
            }

            User user = new User();
            user.userid = this.userid;
            user.name = this.name;
            user.phoneNumber = this.phoneNumber;
            user.adressEmail = this.adressEmail;
            user.adress = this.adress;

            return user;

        }

    }

    public int getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdressEmail() {
        return adressEmail;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", adressEmail='" + adressEmail + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
