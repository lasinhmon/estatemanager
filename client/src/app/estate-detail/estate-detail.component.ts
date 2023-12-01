import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { EstateService } from '../estate.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Estate } from '../estate';
@Component({
  selector: 'app-estate-detail',
  templateUrl: './estate-detail.component.html',
  styleUrls: ['./estate-detail.component.css']
})
export class EstateDetailComponent implements OnInit{
  id:number
  estate:Estate
  constructor(
    private auth:AuthService,
    private router: Router,
    private route: ActivatedRoute,
    private estateService: EstateService
  ) { }
  // getName(){
  //   this.username=localStorage.getItem('userName');
  // }
  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.estate=new Estate();
    this.estateService.getEstateById(this.id).subscribe(data=>{
      this.estate=data;
      console.log(this.estate.categoryId);
    })
  }
  daDangNhap(id:number) {

    if(this.auth.daDangNhap()==-1){
      this.router.navigateByUrl('/dangnhap');
    }
    else if(this.auth.daDangNhap()==1){
      this.router.navigate(['contract',id])
    }
  }
}
