import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Project } from './project';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private baseURL='http://localhost:8080/batdongsan/ProjectController';
  constructor(private httpClient:HttpClient) { }
  public getProjectList(): Observable<Project[]>{
    return this.httpClient.get<Project[]>(`${this.baseURL}`);
  }
  public postProject(project:Project): Observable<Object>{
    //console.log(project)
    return this.httpClient.post(`${this.baseURL}`, project);
  }
  public getProjectById(id: number): Observable<Project>{
    return this.httpClient.get<Project>(`${this.baseURL}/${id}`);
  }
  public updateProject(id: number, project: Project):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,project);
  }
  public deleteProject(id: number): Observable<Project>{
    return this.httpClient.delete<Project>(`${this.baseURL}/${id}`);
  }
}
