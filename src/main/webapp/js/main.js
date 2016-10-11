
function check_signup(){

	var name = $('#name').val();
	var pass = $('#pass').val();
	var conf = $('#conf').val();
	
	if(name == '' || pass == '' || conf == ''){
		alert('账号密码不能为空');
		return false;
	}
	if(pass != conf){
		alert('两次输入密码不相同');
		return false;
	}
	return true;
}

function check_signin(){

	var name = $('#name').val();
	var pass = $('#pass').val();
	
	if(name == '' || pass == ''){
		alert('账号密码不能为空');
		return false;
	}
	return true;
}