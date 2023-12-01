import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';import { Router } from '@angular/router';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-manage-project',
  templateUrl: './manage-project.component.html',
  styleUrls: ['./manage-project.component.css']
})
export class ManageProjectComponent implements OnInit{
  projectForm: FormGroup;
  projects:Project[];
  projectId:number = 0;
  objProject: Project = new Project();

  page: number = 1;
  count: number = 0;
  tableSize: number = 4;
  tableSizes: any = [4, 8, 12, 16, 20];

  @ViewChild('closeButton') closeButton: ElementRef<any>;
  public errorMessage: string = '';
  public lblModalHeader: string = 'Create Project';
  public lblBtn: string = 'Submit';

  constructor(private fb: FormBuilder,
    private projectService:ProjectService,
    private router: Router
   ){}
   ngOnInit(): void{
    this.projectForm = this.fb.group({
      projectName: [''],
    });
    this.getProjects();
   }
   private getProjects(){
    this.projectService.getProjectList().subscribe(data=>{
      console.log(data);

        this.projects=data;

    });
  }
  public getProjectById(projectId: number){
    this.projectService.getProjectById(projectId).subscribe((respData: any) => {
      if(respData){
        this.objProject = respData;
      }
    });
  }
  onSubmit():void{
    this.objProject.projectId=this.projectForm.value.projectId;
    this.objProject.projectName=this.projectForm.value.projectName;

    //ham mo form
    if(this.projectId>0){
      console.log(this.objProject);
      this.projectService.updateProject(this.projectId,this.objProject).subscribe(data=>{
        if(data===''){
          this.errorMessage = 'Something went wrong!';
        }else{
          this.clearForm();
          this.getProjects();
          this.closeButton.nativeElement.click();
        }
      });
    }else {
      console.log(this.objProject);
      this.projectService.postProject(this.objProject).subscribe(data => {
        if(data===''){
          this.errorMessage = 'Something went wrong!';
        } else {
          this.clearForm();
          this.getProjects();
          this.closeButton.nativeElement.click();
        }
      });
    }

  }
  public edit(projectId: number){
    this.lblModalHeader = 'Update Project';
    this.lblBtn = 'Update';
    this.projectService.getProjectById(projectId).subscribe((data: any) => {
      if(data){
        this.projectId = data.projectId;
        this.projectForm.setValue({
          projectName : data.projectName,
        });
      }
    });
  }
  public deleteProject(projectId: number){
    if(confirm("Bạn có chắc là muốn quên cô ấy không?")){
      this.projectService.deleteProject(projectId).subscribe(respData => {
        this.getProjects();
      });
    }

  }
  clearForm() {
    this.projectForm.reset();
  }
  btnNew(){
    this.lblBtn = 'Submit';
    this.lblModalHeader = 'Create Project';
    this.projectId = 0;

  }
  onDataChange(event: any){
    this.page=event;
    this.getProjects();
  }
}
