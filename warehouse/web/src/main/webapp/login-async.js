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
                window.location.replace("secured/profile.html");
                return;
            }
            $("#loginMsg").text("Érvénytelen belépési adatok!");
        });
});
