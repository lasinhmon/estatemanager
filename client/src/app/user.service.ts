import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL='http://localhost:8080/batdongsan/UserController';
  constructor(private httpClient:HttpClient) { }
  public getUserList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}`);
  }
  public postUser(user:User): Observable<Object>{
    //console.log(User)
    return this.httpClient.post(`${this.baseURL}/add`, user);
  }
  public getUserByUserName(userName: string): Observable<User>{
    return this.httpClient.get<User>(`${this.baseURL}/${userName}`);
  }
  public updateUser(userName: string, user: User):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${userName}`,user);
  }
  public deleteUser(userName: string): Observable<User>{
    return this.httpClient.delete<User>(`${this.baseURL}/${userName}`);
  }
}
