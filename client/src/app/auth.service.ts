import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
import * as moment  from 'moment';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseURL='http://localhost:8080/batdongsan/UserController';
  constructor(private _http:HttpClient) { }
  login(user: User): Observable<User>{
    console.log(user)
    return this._http.post<User>(`${this.baseURL}/login`, user);
  }
  register(user: User): Observable<User>{
    console.log(user)
    return this._http.post<User>(`${this.baseURL}/register`, user);
  }
  thoat(){
    localStorage.removeItem("id_token");
    localStorage.removeItem("expires_at");
    localStorage.removeItem('userName');
    localStorage.removeItem('userPassword');
    localStorage.removeItem('rolId');
  }

  public daDangNhap() {
    const str = localStorage.getItem("expires_at") || "";
    const rol = localStorage.getItem("rolId")||"";

    if (str=="") return -1; //chưa dn
    if(rol=="") return -1; //
    const expiresAt = JSON.parse(str);
    //return moment().isBefore(moment(expiresAt));
    if(moment().isBefore(moment(expiresAt))==false){//truoc thoi diem qua han la true
      localStorage.clear();
      return -1;
    }
    if(rol=="2")
      return 0;
    if(rol=="1")
      return 2;
    return 1;
  }
}
