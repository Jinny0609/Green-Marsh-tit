function validateLogin() {
  var user = document.getElementById("user").value;
  var pass = document.getElementById("pass").value;

  //아이디 확인
  if(user == "") {
    alert("아이디(이메일)를 입력하세요.");
    return false;
  }
  if(pass == "") {
    alert("비밀번호를 입력하세요.");
    return false;
  }
  return true;
}

function validateForm() {
	//이메일 형식
	var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	//특수문자 1개이상, 대문자1개이상, 4글자이상
	var expnum =  /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,}$/;
	//닉네임 형식
	var expname = /^[a-zA-Z가-힣0-9-_.]{2,12}$/;
	
	var email = document.getElementById("email").value;
	var pw = document.getElementById("pw").value;
	var name = document.getElementById("name").value;

	  if (email == "" || exptext.test(email) == false) {
	    alert("이메일형식이 올바르지 않습니다.");
	    return false;
	  }

	  if (pw == "" || expnum.test(pw) == false) {
	    alert("패스워드를 입력해주세요.");
	    return false;
	  }

	  if (name == "" || expname.test(name) == false) {
	    alert("닉네임을 입력해주세요.");
	    return false;
	  }

	  return true;
	}