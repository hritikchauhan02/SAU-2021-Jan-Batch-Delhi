import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { UserService } from "../user.service";
import {ActivatedRoute, Router} from "@angular/router"

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.scss']
})
export class EditUserComponent implements OnInit {

  userForm : FormGroup;
  data = this.activatedRoute.snapshot;

  constructor(private fb: FormBuilder, private userService: UserService, private router: Router, private activatedRoute : ActivatedRoute) { }

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
      id : [this.data.params['id'], [Validators.required]],
      name : [this.data.params['name'], [Validators.required, Validators.minLength(3), Validators.pattern(this.namePattern)]],
      email : [this.data.params['email'], [Validators.required]],
      age : [this.data.params['age'], Validators.required],
      dob : [this.data.params['dob'], [Validators.required, Validators.pattern(this.dobValidator)]],
      address : this.fb.group({
        street : [this.data.params['street'], [Validators.required, Validators.minLength(3), Validators.maxLength(20)]],
        city : [this.data.params['city'], [Validators.required, Validators.minLength(3), Validators.maxLength(20), Validators.pattern(this.namePattern)]],
        zipcode : [this.data.params['zipcode'], [Validators.required, Validators.pattern(this.zipCodeValidator)]]
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
    this.userService.update(this.userObj);
    this.router.navigate(['/show']);
  }

}
