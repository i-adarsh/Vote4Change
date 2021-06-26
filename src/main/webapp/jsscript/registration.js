/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let userName, password, cpassword, city, address, aadhar, email, mobile, gender;

function addUser() {
    userName = $("#username").val();
    password = $("#password").val();
    cpassword = $("#cpassword").val();
    city = $("#city").val();
    address = $("#address").val();
    aadhar = $("#adhar").val();
    email = $("#email").val();
    mobile = $("#mobile").val();
    gender = $("input[name='gender']:checked").val();

    if (validateUser) {
        if (password !== cpassword) {
            swal("Error!", "Passwords do not match !!", "Error");
            return;
        } else {
            if (checkEmail() === false) {
                return;
            }
            let data = {
                username: userName,
                password: password,
                city: city,
                address: address,
                userID: aadhar,
                email: email,
                mobile: mobile,
                gender: gender
            };
            let xhr = $.post("RegistrationControllerServlet", data, processResponse);
            xhr.fail(handleError);
        }
    }
}

function processResponse(responseText, textStatus, xhr) {
    let str = responseText.trim();
    if (str == "success") {
        swal("Success !", "Registration Done Successfully! You can now Login", "success");
        setTimeout(redirectUser, 3000);
    }
    else if (str == "uap") {
        swal("Error!", "Sorry the UserID is already Present !!", "error");
    }
    else {
        swal("Error!", "Registration Failed !! , Try Again", "error");
    }

}

function handleError() {
    swal("Error", "Problem in Server Communication" + xhr.statusText, "error");
}

function validateUser() {
    if (userName === "" || password === "" || cpassword === "" || city === "" ||
        address === "" || aadhar === "" || email === "" || mobile === "") {
        swal("Error!", "All Field's are Mandatory", "Error");;
        return false;
    }
    return true;
}

function checkEmail() {
    let atTheRatePos = email.indexOf("@");
    let dotPos = email.indexOf(".");
    if (atTheRatePos < 1 || dotPos < atTheRatePos + 2 || dotPos + 2 >= email.length) {
        swal("Error!", "Please Enter a Valid Email", "Error");;
        return false;
    }
    return true;
}

function redirectUser() {
    window.location = "login.html";
}