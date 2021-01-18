import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { UserService } from "../user.service";
import {Router} from "@angular/router"

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {

  isUserPresentWithId = false;
  isUserPresentWithEmail = false;

  userForm : FormGroup;

  constructor(private fb: FormBuilder, private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.initializeForm();
    this.userData = this.userService.getEmployees();
  }

  namePattern = /^([a-zA-Z]+\s)*[a-zA-Z]+$/
  emailValidationPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";
  zipCodeValidator = /^[0-9]{5}(?:-[0-9]{4})?$/;
  dobValidator = /^\d{2}[/]\d{2}[/]\d{4}$/

  initializeForm() {
    this.userForm = this.fb.group({
      id : ['', [Validators.required]],
      name : ['', [Validators.required, Validators.minLength(3), Validators.pattern(this.namePattern)]],
      email : ['', [Validators.required, Validators.pattern(this.emailValidationPattern)]],
      age : ['', Validators.required],
      dob : ['', [Validators.required, Validators.pattern(this.dobValidator)]],
      address : this.fb.group({
        street : ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
        city : ['', [Validators.required, Validators.minLength(3), Validators.maxLength(20), Validators.pattern(this.namePattern)]],
        zipcode : ['', [Validators.required, Validators.pattern(this.zipCodeValidator)]]
      })
    })
  }

  userData;
  userObj;

  get name() {
    return this.userForm.get('name');
  }

  get id() {
    return this.userForm.get('id');
  }

  get email() {
    return this.userForm.get('email');
  }

  get street() {
    return this.userForm.get('address.street');
  }

  get city() {
    return this.userForm.get('address.city');
  }

  get zipcode() {
    return this.userForm.get('address.zipcode');
  }

  get dob() {
    return this.userForm.get('dob');
  }

  get age() {
    return this.userForm.get('age');
  }

  onSubmit(data) {
    this.userObj = {
      id : data.id,
      name: data.name,
      email: data.email,
      dob: data.dob,
      age: data.age,
      address : {
        street: data.address.street,
        city: data.address.city,
        zipcode: data.address.zipcode
      }
    }
    //console.log(this.userData)
      this.isUserPresentWithId = false;
    this.isUserPresentWithEmail = false;

    this.userData.forEach(element => {
      //console.log(element.id, ' ', this.userObj.id)
      if(parseInt(element.id) === parseInt(this.userObj.id)) {
        this.isUserPresentWithId = true;
      }
      if(element.email === this.userObj.email) {
        this.isUserPresentWithEmail = true;
      }
    });

    if(!(this.isUserPresentWithEmail || this.isUserPresentWithId))
    {
      this.userService.addUser(this.userObj);
      this.router.navigate(['/show'])
    }

  }
}
