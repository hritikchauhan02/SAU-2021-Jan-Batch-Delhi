import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-user',
  templateUrl: './show-user.component.html',
  styleUrls: ['./show-user.component.scss']
})

export class ShowUserComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }

  userData = [];

  ngOnInit(): void {
    this.userData = this.userService.getEmployees();
  }

  edit(user) {
    this.router.navigate(['/edit', user.id, user.name, user.email, user.dob, user.age, user.address.street, user.address.city, user.address.zipcode]);
  }

  delete(user) {
    this.userService.deleteEmployee(user);
    this.updateData();
  }

  updateData() {
    this.userData = this.userService.getEmployees();
  }

}
