$.validator.setDefaults({
	submitHandler: function() { document.loginform.submit(); }
});

$().ready(function() {
            $("#loginform").validate({
		rules: {
			email: {
				required: true,
				email: true
			},
                        pass: {
				required: true,
				minlength: 5
			}
			
		},
		messages: {
                        email: "Please enter a valid user name (your email address)",     
			pass: {
				required: "Please enter a password",
				rangelength: jQuery.format("Please enter at least {0} characters")
			}		        
		}
	});
});