function validation () {
    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    var inputNumber = document.getElementById('inputNumber').value;
    var company = document.getElementById('company').value;
    var gender = null;
    var inputState = document.getElementById('inputState').value;
    var formList = document.querySelectorAll('li');

    var form = document.getElementById("myForm");
    function handleForm(event) { event.preventDefault(); } 
    form.addEventListener('submit', handleForm);

    var isNum1 = false;
    var isNum2 = false;
    var span = document.getElementsByTagName('span');
    var isCapital = false;
    var isPassNum = false;

    var error = false;

    for(let i=0;i<span.length;i++)
    {
        span[i].innerHTML = '';
    }

    if (document.getElementById('male').checked) {
        gender = document.getElementById('male').value;
      } else if (document.getElementById('female').checked) {
        gender = document.getElementById('female').value;
      } else if (document.getElementById('transgender').checked) {
        gender = document.getElementById('transgender').value;
      }
    
// Validating First Name   

    if(firstName.length < 3 || firstName.length > 10)
    {
        document.getElementById('wrongFirstName').innerHTML = "* First Name should be between 2 to 8 characters long";
        var error = true;
    }
    
    for(let i=0;i<firstName.length;i++)
    {
        if(!((firstName.charCodeAt(i) >= 65 && firstName.charCodeAt(i) <= 90) || (firstName.charCodeAt(i) >= 97 && firstName.charCodeAt(i) <= 122)))
        {
            isNum1 = true;
        }
    }

    if(isNum1)
    {
        document.getElementById('wrongFirstName').innerHTML = "* Only alphabets are allowed";

        var error = true;
    }

// Validating Last Name

    if(lastName.length < 3 || lastName.length > 10)
    {
        document.getElementById('wrongLastName').innerHTML = "* First Name length should be more than 2 and less than 8";

        var error = true;
    }
    
    for(let i=0;i<lastName.length;i++)
    {
        if(!((lastName.charCodeAt(i) >= 65 && lastName.charCodeAt(i) <= 90) || (lastName.charCodeAt(i) >= 97 && lastName.charCodeAt(i) <= 122)))
        {
            isNum2 = true;
        }
    }

    if(isNum2)
    {
        document.getElementById('wrongLastName').innerHTML = "* Only alphabets are allowed";

        var error = true;
    }


    if(email.indexOf('@') == 1 || email.indexOf('@') == -1 || email.indexOf('@') == 0 || email.indexOf('.') == -1 || email.indexOf('.') == email.length - 1 || email.indexOf('.') == email.length - 2)
    {
        document.getElementById('wrongEmail').innerHTML = "* Please enter a valid email";

        var error = true;
    }

    if(password.length < 5 || password.length > 16)
    {
        document.getElementById('wrongPassword').innerHTML = "* Password length should be between 5 and 16";

        var error = true;
    }

    for(let i=0;i<password.length;i++)
    {
        if((password.charCodeAt(i) >= 65 && password.charCodeAt(i) <= 90))
        {
            isCapital = true;
        }
        if(password.charCodeAt(i) >= 48 && password.charCodeAt(i) <= 57)
        {
            isPassNum = true;
        }
    }

    if(password.toUpperCase() === 'PASSWORD')
    {
        document.getElementById('wrongPassword').innerHTML = "* Your Password cannot be password";

        var error = true;
    }

    if(!isCapital)
    {
        document.getElementById('wrongPassword').innerHTML = "* Password should have atleast one uppercase character";

        var error = true;
    }

    if(!isPassNum)
    {
        document.getElementById('wrongPassword').innerHTML = "* Password should include atleast one number";

        var error = true;
    }

    // Mobile Number Validation

    if(inputNumber.length != 10)
    {
        document.getElementById('wrongNumber').innerHTML = "* Please enter a valid Number";
        var error = true;
    }

    if(parseInt(inputNumber) != inputNumber)
    {
        document.getElementById('wrongNumber').innerHTML = "* Please enter a valid Number";

        var error = true;
    }

    // Validating Gender Radio Button

    if(gender == null)
    {
        document.getElementById('wrongGender').innerHTML = "* Please select a Value From the Radio Button";

        var error = true;
    }

    // Validating State Select Box

    if(inputState === '')
    {
        document.getElementById('wrongState').innerHTML = "* Please select a State from Drop Box";

        var error = true;
    }

    if(error)
    {
        return false;
    }

    console.log(password);

    for(let i=0;i<formList.length;i++)
    {
        formList[i].classList.remove('hide');
    }
    formList[0].textContent = "User Details";
    formList[0].style.fontSize = '24px';
    formList[1].textContent = 'Name : ' + firstName + ' ' + lastName;
    formList[2].textContent = 'Email : ' + email;
    formList[3].textContent = 'Mobile Number : ' + inputNumber;
    formList[4].textContent = 'Company : ' + company;
    formList[5].textContent = 'Gender : ' + gender;
    formList[6].textContent = 'State : ' + inputState;

    myForm.reset();
}