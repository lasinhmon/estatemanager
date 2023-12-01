import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Estate } from '../estate';
import { EstateService } from '../estate.service';
import { Router } from '@angular/router';
import { Project } from '../project';
import { ProjectService } from '../project.service';
import { Category } from '../category';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.css']
})
export class ManageComponent implements OnInit{
  estateForm: FormGroup;
  objEstate: Estate = new Estate();
  estates:Estate[];
  estateId:number = 0;
  projects:Project[];
  categories:Category[];


  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  tableSizes: any = [10, 20, 30, 40, 50, 60, 70];

  @ViewChild('closeButton') closeButton: ElementRef<any>;
  public errorMessage: string = '';
  public lblModalHeader: string = 'Create Estate';
  public lblBtn: string = 'Submit';
  constructor(private fb: FormBuilder,
              private estateService:EstateService,
              private projectService:ProjectService,
              private categoryService:CategoryService,
              private router: Router
             ){}
  ngOnInit(): void{
    this.estateForm = this.fb.group({
      projectId: [''],
      categoryId: [''],
      price: [''],
      statusId: [''],
    });
     //lay du lieu project len
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
  private getEstates(){
    this.estateService.getEstatesList().subscribe(data=>{
      console.log(data);

        this.estates=data;

    });
  }
  onSubmit():void{
    this.objEstate.projectId=this.estateForm.value.projectId;
    this.objEstate.categoryId=this.estateForm.value.categoryId;
    this.objEstate.price=this.estateForm.value.price;
    this.objEstate.statusId=this.estateForm.value.statusId;

    //ham mo form
    if(this.estateId>0){
      console.log(this.objEstate);
      this.estateService.updateEstate(this.estateId,this.objEstate).subscribe(data=>{
        if(data===''){
          this.errorMessage = 'Something went wrong!';
        }else{
          this.clearForm();
          this.getEstates();
          this.closeButton.nativeElement.click();
        }
      });
    }else {
      console.log(this.objEstate);
      this.estateService.postEstate(this.objEstate).subscribe(data => {
        if(data===''){
          this.errorMessage = 'Something went wrong!';
        } else {
          this.clearForm();
          this.getEstates();
          this.closeButton.nativeElement.click();
        }
      });
    }

  }
  public getEstateById(estateId: number){
    this.estateService.getEstateById(estateId).subscribe((respData: any) => {
      if(respData){
        this.objEstate = respData;
      }
    });
  }
  public edit(estateId: number){
    this.lblModalHeader = 'Update Estate';
    this.lblBtn = 'Update';
    this.estateService.getEstateById(estateId).subscribe((data: any) => {
      if(data){
        this.estateId = data.estateId;
        this.estateForm.setValue({
          projectId : data.projectId,
          categoryId : data.categoryId,
          price: data.price,
          statusId : data.statusId,
        });
      }
    });
  }
  public deleteEstate(estateId: number){
    if(confirm("Bạn có chắc là muốn quên cô ấy không?")){
      this.estateService.deleteEstate(estateId).subscribe(respData => {
        this.getEstates();
      });
    }

  }
  clearForm() {
    this.estateForm.reset();
  }
  btnNew(){
    this.lblBtn = 'Submit';
    this.lblModalHeader = 'Create Estate';
    this.estateId = 0;

  }
  ChangeProject(e){
    console.log(e.target.value);
  }
  ChangeCategory(e){
    console.log(e.target.value);
  }
  onDataChange(event: any){
    this.page=event;
    this.getEstates();
  }
}
