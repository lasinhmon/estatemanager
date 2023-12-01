import { Component,   OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from '../user';
import * as moment from 'moment';
@Component({
  selector: 'app-dang-nhap',
  templateUrl: './dang-nhap.component.html',
  styleUrls: ['./dang-nhap.component.css']
})
export class DangNhapComponent implements OnInit{
  user: User=new User();
  constructor(
    private auth:AuthService,
    private router: Router
  ) { }
  ngOnInit(): void { }
  xulyDN(){

    this.auth.login(this.user).subscribe(
      res=>{
        var user=res.userName;
        var password=res.userPassword;
        var rolId=res.rolId;
        console.log("dang nhap thanh cong",user,password);
        const expiresAt = moment().add(120,'second');
        localStorage.setItem("expires_at", JSON.stringify(expiresAt.valueOf()) );
        localStorage.setItem('userName', user);
        localStorage.setItem('userPassword', password);
        localStorage.setItem('rolId', rolId);
        this.router.navigateByUrl('/');
      },
      error => {
        alert('Sai mat khau');
        this.router.navigateByUrl('/dangnhap');
      }
    )
  }
}
