import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './home/home.component';
import { DangKyComponent } from './dang-ky/dang-ky.component';
import { DangNhapComponent } from './dang-nhap/dang-nhap.component';
import { DoiPassComponent } from './doi-pass/doi-pass.component';
import { ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { Moment } from 'moment';
import { EstateDetailComponent } from './estate-detail/estate-detail.component';
import { ManageComponent } from './manage/manage.component';
import { ContractComponent } from './contract/contract.component';
import { ManageContractComponent } from './manage-contract/manage-contract.component';
import { DatePipe } from '@angular/common';
import { ManageProjectComponent } from './manage-project/manage-project.component';
import { ManageUserComponent } from './manage-user/manage-user.component';
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DangKyComponent,
    DangNhapComponent,
    DoiPassComponent,
    EstateDetailComponent,
    ManageComponent,
    ContractComponent,
    ManageContractComponent,
    ManageProjectComponent,
    ManageUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
