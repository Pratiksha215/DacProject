import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {

url='http://localhost:8080/people'
  

  constructor(private httpClient:HttpClient) { }
  
  
  getPeople(){
    return this.httpClient.get(this.url)
  }

  getProjectById(id: number){
    const url1='http://localhost:8080/projects'
    return this.httpClient.get(url1+"/"+id)

  }
}
 