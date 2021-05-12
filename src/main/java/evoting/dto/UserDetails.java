/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.dto;

/**
 *
 * @author adarshkumar
 */
public class UserDetails {

    @Override
    public String toString() {
        return "UserDetails{" + "userName=" + userName + ", userID=" + userID + ", email=" + email + ", address=" + address + ", mobile=" + mobile + ", city=" + city + ", password=" + password + '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails(String userName, String userID, String email, String address, String mobile, String city, String password) {
        this.userName = userName;
        this.userID = userID;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
        this.city = city;
        this.password = password;
    }

    public UserDetails(){
        
    }
    private String userName;
    private String userID;
    private String email;
    private String address;
    private String mobile;
    private String city;
    private String password;
}
