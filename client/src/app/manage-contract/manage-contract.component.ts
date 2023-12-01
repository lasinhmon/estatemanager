import { Component, ElementRef, OnInit , ViewChild } from '@angular/core';
import { Contract } from '../contract';
import { ContractService } from '../contract.service';
import { User } from '../user';
import { UserService } from '../user.service';
import { FormBuilder, FormGroup } from '@angular/forms';
import { formatDate } from '@angular/common';  
@Component({
  selector: 'app-manage-contract',
  templateUrl: './manage-contract.component.html',
  styleUrls: ['./manage-contract.component.css']
})
export class ManageContractComponent implements OnInit{
  objContract: Contract=new Contract();
  contracts:Contract[];
  currentDate = new Date();
  formattedDate;

  findForm: FormGroup;
  

  page: number = 1;
  count: number = 0;
  tableSize: number = 10;
  tableSizes: any = [10, 20, 30, 40, 50, 60, 70];

  @ViewChild('closeButton') closeButton: ElementRef<any>;
  public errorMessage: string = '';
  public lblModalHeader: string = 'Update Contract';
  public lblBtn: string = 'Update';
  editForm: FormGroup;
  constructor(
    private fb:FormBuilder,
    private contractService: ContractService,
    private userService: UserService){}
  
  ngOnInit(): void {
    this.findForm=this.fb.group({
      userName: [''],
  
    });
    this.getContracts();
  }
  private getContracts(){
    this.contractService.getContractsList().subscribe(data=>{
      console.log(data);
      this.contracts = data
    })
  }
  public getContractById(contractId: number){
    console.log(contractId);
    this.contractService.getContractById(contractId).subscribe((respData: any) => {
      if(respData){
        this.objContract = respData;
      }
    });
    
  }
  public onSubmit():void{
    this.contractService.updateContractById(this.objContract.contractId,this.objContract).subscribe(data=>{
      this.getContracts();
    })
   // this.clearForm();
    
    this.closeButton.nativeElement.click();
  }
  public edit(contractId: number){
    this.contractService.getContractById(contractId).subscribe((respData: any) => {
      if(respData){
        this.objContract = respData;
      }
    });

  }
  public Statistic(){
    this.formattedDate = formatDate(this.currentDate, 'yyyy-MM-dd', 'en-US');  
    this.contractService.statistic(this.formattedDate).subscribe(data => {
        this.contracts = data;
    });
  }
  public NewContract(){
    this.contractService.statisticNewContract().subscribe(data => {
      this.contracts = data;
      console.log(data);
    });
  }
  onDataChange(event: any){
    this.page=event;
    this.getContracts();
  }

  onFind():void{
    console.log(this.findForm.value.userName);
    this.contractService.getContractByName(this.findForm.value.userName).subscribe(data=>{
      this.contracts = data;
    });
  }

}
