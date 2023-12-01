import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';import { Router } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-manage-user',
  templateUrl: './manage-user.component.html',
  styleUrls: ['./manage-user.component.css']
})
export class ManageUserComponent implements OnInit{
  userForm: FormGroup;
  users:User[];
  userId:string = null;
  objUser: User = new User();

  page: number = 1;
  count: number = 0;
  tableSize: number = 4;
  tableSizes: any = [4, 8, 12, 16, 20];


  @ViewChild('closeButton') closeButton: ElementRef<any>;
  public errorMessage: string = '';
  public lblModalHeader: string = 'Create User';
  public lblBtn: string = 'Submit';

  constructor(private fb: FormBuilder,
    private userService:UserService,
    private router: Router
   ){}
   ngOnInit(): void{
    this.userForm = this.fb.group({
      userName: [''],
      userPassword: [''],
      rolId: [''],
      phoneNum: [''],
    });
    this.getUsers();
   }
   private getUsers(){
    this.userService.getUserList().subscribe(data=>{
      console.log(data);

        this.users=data;

    });
  }
  public getUserByUserName(userName: string){
    this.userService.getUserByUserName(userName).subscribe((respData: any) => {
      if(respData){
        this.objUser = respData;
      }
    });
  }
  onSubmit():void{
    this.objUser.userName=this.userForm.value.userName;
    this.objUser.userPassword=this.userForm.value.userPassword;
    this.objUser.rolId=this.userForm.value.rolId;
    this.objUser.phoneNum=this.userForm.value.phoneNum;
    //ham mo form
    if(this.userId==null){
      console.log(this.objUser);
      this.userService.postUser(this.objUser).subscribe(data => {
        if(data===''){
          this.errorMessage = 'Something went wrong!';
        } else {
          this.clearForm();
          this.getUsers();
          this.closeButton.nativeElement.click();
        }
      });
    }else {
      console.log(this.objUser);
      this.userService.updateUser(this.userId,this.objUser).subscribe(data=>{
        if(data===''){
          this.errorMessage = 'Something went wrong!';
        }else{
          this.clearForm();
          this.getUsers();
          this.closeButton.nativeElement.click();
        }
      });
    }

  }
  public edit(userName: string){
    this.lblModalHeader = 'Update User';
    this.lblBtn = 'Update';
    this.userService.getUserByUserName(userName).subscribe((data: any) => {
      if(data){
        this.userId = data.userName;
        this.userForm.setValue({
          userName: data.userName,
          userPassword: data.userPassword,
          rolId: data.rolId,
          phoneNum: data.phoneNum,
        });
      }
    });
  }
  public deleteUser(userName: string){
    if(confirm("Bạn có chắc là muốn quên cô ấy không?")){
      this.userService.deleteUser(userName).subscribe(respData => {
        this.getUsers();
      });
    }

  }
  clearForm() {
    this.userForm.reset();
  }
  btnNew(){
    this.lblBtn = 'Submit';
    this.lblModalHeader = 'Create User';
    this.userId = null;

  }
  onDataChange(event: any){
    this.page=event;
    this.getUsers();
  }
}
