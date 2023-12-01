import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Estate } from './estate';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EstateService {
  private baseURL='http://localhost:8080/batdongsan/EstateController';
  constructor(private httpClient:HttpClient) { }
  public getEstatesList(): Observable<Estate[]>{
    return this.httpClient.get<Estate[]>(`${this.baseURL}`);
  }
  public getEstatesListPag(page:number,size:number):Observable<Estate[]>{
    return this.httpClient.get<Estate[]>(`${this.baseURL}/${page}/${size}`);
  }
  public postEstate(estate:Estate): Observable<Object>{
    //console.log(estate)
    return this.httpClient.post(`${this.baseURL}`, estate);
  }
  public getEstateById(id: number): Observable<Estate>{
    return this.httpClient.get<Estate>(`${this.baseURL}/${id}`);
  }
  public updateEstate(id: number, estate: Estate):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,estate);
  }
  public deleteEstate(id: number): Observable<Estate>{
    return this.httpClient.delete<Estate>(`${this.baseURL}/${id}`);
  }
  public findEstate(pid:string,cid:string,pr:number): Observable<Estate[]>{
    console.log(pid+"hehe"+cid);
    return this.httpClient.get<Estate[]>(`${this.baseURL}/${pid}/${cid}/${pr}`);
  }
}
