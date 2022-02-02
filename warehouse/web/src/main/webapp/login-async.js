$("#login-async").click(function () {
    $.ajax({
        method: "POST",
        url: "loginAsync",
        data: {
            username: $("#username").val(),
            password: $("#password").val()
        }
    })
        .done(function (loginInfo) {
            if (loginInfo["result"]) {
                // https://stackoverflow.com/questions/503093/how-do-i-redirect-to-another-webpage
                window.location.replace("secured/profile.html");
                //window.location.href = "secured/profile.html";
                return;
            }
            $("#loginMsg").text("Érvénytelen belépési adatok!");
        });
});
