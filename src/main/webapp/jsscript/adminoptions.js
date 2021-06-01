function redirectadministratorpage()
{
    swal("Admin!","Redirecting To Admin Actions Page!","success").then(value=>{
        window.location="adminActions.jsp";
    });
}
function redirectvotingpage()
{
    swal("Admin!","Redirecting To Voting Controller Page!","success").then(value=>{
        window.location="VotingControllerServlet";
    });
}
function manageuser()
{
    swal("Admin!","Redirecting To User Management Page!","success").then(value=>{
        window.location="manageuser.jsp";
    });
}
function managecandidate()
{
    swal("Admin!","Redirecting To Candidate Management Page!","success").then(value=>{
        window.location="managecandidate.jsp";
    });
}

function getdetails(e){
    if (e.keyCode === 13){
        data = (uid:$("#uid").val());
        $.post("AddCandidateControllerServlet", data, function(responseText){
            let details = JSON.parse(responseText);
            let city = details.city;
            let uname = details.username;
            if (uname === "wrong"){
                swal("Wrong Adhaar No!", "Adhaar no is invalid", "error");
            }
            else{
                $("#cname").val(uname);
                $("#city").empty();
                $("#city").append(city);
                $("#cname").prop("disabled", true);
            }
        });
    }
}