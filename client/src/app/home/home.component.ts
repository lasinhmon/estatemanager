import { Component, OnInit } from '@angular/core';
import { Estate } from '../estate';
import { EstateService } from '../estate.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Project } from '../project';
import { Category } from '../category';
import { ProjectService } from '../project.service';
import { CategoryService } from '../category.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
   
  findForm: FormGroup;

  estates:Estate[];
  projects:Project[];
  categories:Category[];

  objEstate: Estate = new Estate();

  page: number = 1;
  count: number = 0;
  tableSize: number = 4;
  tableSizes: any = [4, 8, 12, 16, 20, 24, 28];

  constructor(
    private fb:FormBuilder,
    private estateService:EstateService,
    private projectService:ProjectService,
    private categoryService:CategoryService,
    private router: Router){}

  ngOnInit(): void{
    this.findForm=this.fb.group({
      projectId: [''],
      categoryId: [''],
      price:[''],
    });
    this.projectService.getProjectList().subscribe(data=>{
      this.projects=data;
      console.log(data);
    });
    //lay du lieu project len
    this.categoryService.getCategoryList().subscribe(data=>{
      this.categories=data;
      console.log(data);
    });
    this.getEstates();
  }

  onFind():void{
    this.objEstate.projectId=this.findForm.value.projectId;
    this.objEstate.categoryId=this.findForm.value.categoryId;
    this.objEstate.price=this.findForm.value.price;
 //  console.log(this.objEstate.price)
   // this.objEstate.price=this.findForm.value.price;
    this.estateService.findEstate(this.objEstate.projectId, this.objEstate.categoryId,this.objEstate.price).subscribe(data=>{
      this.estates=data;
    })
  }

  private getEstates(){
    this.estateService.getEstatesList().subscribe(data=>{
      this.estates=data;
    });
  }
  onDataChange(event: any){
    this.page=event;
    this.getEstates();
  }
  onDataSizeChange(event:any){
    this.tableSize=event.target.value;
    this.page=1;
    this.getEstates();
  }
  estateDetail(id:number){
    this.router.navigate(['estate-detail',id])
  }
  ChangeProject(e){
    console.log(e.target.value);
  }
  ChangeCategory(e){
    console.log(e.target.value);
  }
}
