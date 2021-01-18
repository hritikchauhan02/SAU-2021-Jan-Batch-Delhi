import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  userData = [
    {"id": 1, "name": "Leanne Graham", "email": "Sincere@april.biz", "address": { "street": "Kulas Light", "city": "Gwenborough", "zipcode": "92998-3874"}, "dob": "26/08/1987", "age" : "34"},
    {"id": 2, "name": "Ervin Howell","email": "Shanna@melissa.tv","address": {"street": "Victor Plains","city": "Wisokyburgh","zipcode": "90566-7771", },"dob": "12/02/1992" , "age" : "29"},
    {"id": 3,"name": "Clementine Bauch","email": "Nathan@yesenia.net","address": {"street": "Douglas Extension","city": "McKenziehaven","zipcode": "59590-4157"},"dob":"15/01/1988" , "age" : "33"},
    {"id": 4,"name": "Patricia Lebsack","email": "Julianne.OConner@kory.org","address": {"street": "Hoeger Mall","city": "South Elvis","zipcode": "53919-4257",},"dob":"21/09/1991", "age" : "30"},
    {"id": 5,"name": "Chelsey Dietrich","email": "Lucio_Hettinger@annie.ca","address": {"street": "Skiles Walks","city": "Roscoeview","zipcode": "33263",},"dob": "22/10/1992", "age" : "29"},
    {"id": 6,"name": "Mrs. Dennis Schulist","email": "Karley_Dach@jasper.info","address": {"street": "Norberto Crossing","city": "South Christy","zipcode": "23505-1337"},"dob":"25/06/1996", "age" : "25"},
    {"id": 7,"name": "Kurtis Weissnat","email": "Telly.Hoeger@billy.biz","address": {"street": "Rex Trail","city": "Howemouth","zipcode": "58804-1099"},"dob":"28/02/1985", "age" : "36"},
    {"id": 8,"name": "Nicholas Runolfsdottir V","email": "Sherwood@rosamond.me","address": {"street": "Ellsworth Summit","city": "Aliyaview","zipcode": "45169"},"dob":"15/02/1986", "age" : "35"},
  ]

  constructor() {
   }

  getEmployees() {
    return this.userData;
  }

  deleteEmployee(employee) {
    this.userData = this.userData.filter(u => u.id !== employee.id);
  }

  addUser(userObj) {
    this.userData.push(userObj)
  }

  update(userObj) {
    for(let i=0;i< this.userData.length;i++)
    {
      if(this.userData[i].id == userObj.id)
      {
        this.userData[i] = userObj;
      }
    }
  }
}
