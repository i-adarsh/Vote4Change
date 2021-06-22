/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addVote(){
    
    var id = $('input[type=radio][name=flat]:checked').attr('id');
    data = {candidate:id};
    $.post("AddVoteControllerServlet", data, processResponse);
}
function processResponse(responseText){
    responseText = responseText.trim();
    if (responseText === "success"){
        swal("Success", "Voting done", "success").then((value) => {
            window.location="votingResponse.jsp";
        })
        
    }
    else{
        swal("Failure", "Voting failed", "error").then((value)=>{
            window.location="votingResponse.jsp";
        });
    }
}
