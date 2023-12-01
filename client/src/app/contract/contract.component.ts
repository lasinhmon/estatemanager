import { Component } from '@angular/core';
import { EstateService } from '../estate.service';
import { ContractService } from '../contract.service';
import { Estate } from '../estate';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Contract } from '../contract';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-contract',
  templateUrl: './contract.component.html',
  styleUrls: ['./contract.component.css']
})
export class ContractComponent {
  id:number
  estate:Estate
  username:string
  currentDate = new Date();
  objContract:Contract=new Contract();
  constructor(
    public DatePipe: DatePipe,
    private router: Router,
    private route: ActivatedRoute,
    private estateService: EstateService,
    private contractService:ContractService
  ) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.estate=new Estate();
    this.estateService.getEstateById(this.id).subscribe(data=>{
      this.estate=data;
    })
    this.objContract.userName=localStorage.getItem('userName');
    this.objContract.estateId=this.id;
    this.objContract.urlContract="tamm";
    this.objContract.statusContract="sold";
    this.objContract.dateContract=this.DatePipe.transform(this.currentDate,'yyyy-MM-dd');
    const date = new Date ();
    this.objContract.deadlineContract= this.DatePipe.transform(new Date(date.setDate( date.getDate() + 1 )),'yyyy-MM-dd');
  }

  saveContract(){
    // this.contractService.postContract(this.objContract).subscribe(data=>{

    // },
    // error => console.log(error))//GET
    window.location.href="http://localhost:8080/batdongsan/ContractController/"+this.objContract.userName+"/"+this.objContract.estateId+"/"+this.objContract.urlContract+"/"+this.objContract.statusContract+"/"+this.objContract.dateContract+"/"+this.objContract.deadlineContract;
  }
  onSubmit(){

    console.log(this.objContract.estateId);
    this.saveContract();
  }
}
