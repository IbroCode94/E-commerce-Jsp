$(function(){
    $("#login_user").on("click",()=>{
        $("#signup").hide(100)
        $("#login").show(100)
    })
    $("#signin_user").on("click",()=>{
        $("#login").hide(100)
        $("#signup").show(100)
    })



});