import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { AuthService } from '../auth.service';

import { Router } from '@angular/router';
@Component({
  selector: 'app-dang-ky',
  templateUrl: './dang-ky.component.html',
  styleUrls: ['./dang-ky.component.css']
})
export class DangKyComponent implements OnInit {
  user: User=new User();
  constructor(private auth:AuthService,
    private router: Router){}
  ngOnInit(): void {
    
  }
  xulyDK(){
    this.auth.register(this.user).subscribe(
      res=>{
        alert('Dang ky thanh cong');
        this.router.navigateByUrl('/');
      },
      error => {
        alert('Ten dang nhap da ton tai');
        this.router.navigateByUrl('/dangky');
      }
    )
  }

}
