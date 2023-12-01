import { Component } from '@angular/core';
import { AuthService } from './auth.service';
import { User } from './user';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  username='';
  constructor( private auth:AuthService){}
  thoat(){
    this.auth.thoat();
  }
  daDangNhap() {
    this.username=localStorage.getItem('userName');

    return this.auth.daDangNhap()

  }

  title = 'client';
}
