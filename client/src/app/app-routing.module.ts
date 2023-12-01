import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { DangNhapComponent } from './dang-nhap/dang-nhap.component';
import { DangKyComponent } from './dang-ky/dang-ky.component';
import { DoiPassComponent } from './doi-pass/doi-pass.component';
import { baoveGuard } from './baove.guard';
import { EstateDetailComponent } from './estate-detail/estate-detail.component';
import { ManageComponent } from './manage/manage.component';
import { ContractComponent } from './contract/contract.component';
import { ManageContractComponent } from './manage-contract/manage-contract.component';
import { ManageProjectComponent } from './manage-project/manage-project.component';
import { ManageUserComponent } from './manage-user/manage-user.component';
const routes: Routes = [
  { path:'', component:HomeComponent},
  { path:'estate-detail/:id', component:EstateDetailComponent},
  { path:'manage', component:ManageComponent,canActivate:[baoveGuard],},
  { path:'manage-contract', component:ManageContractComponent,canActivate:[baoveGuard]},
  { path:'manage-project', component:ManageProjectComponent,canActivate:[baoveGuard]},
  { path:'manage-user', component:ManageUserComponent,canActivate:[baoveGuard]},
  { path:'contract/:id',component:ContractComponent,canActivate:[baoveGuard],},
  { path:'dangnhap', component:DangNhapComponent},
  { path:'dangky', component:DangKyComponent},
  { path:'doipass',
    component:DoiPassComponent,
    canActivate:[baoveGuard], },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
