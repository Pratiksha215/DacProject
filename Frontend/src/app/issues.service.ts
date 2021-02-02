import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class IssuesService {
  

  url='http://localhost:8080/issues'
   
 
  constructor(private httpClient:HttpClient) { }

  getBugs(){
    return this.httpClient.get(this.url)

  } 
 
  getBugDetail(issueId: number){
    return this.httpClient.get(this.url+"/"+issueId)

  }
  getProjectId(){

  const url1='http://localhost:8080/projects/id'
    
    return this.httpClient.get(url1)

  }

  getPersonid(){
    const url2='http://localhost:8080/people/id'
    
    return this.httpClient.get(url2)
  }


 
  updateIssue(issueId:number,issueName:string,issueDescription:string,createdBy:string,createdOn:string,
    priority:string,severity:string,status:string,projectId:number,personId:number) {
const body={
  issueName:issueName,
  issueDescription:issueDescription,
  createdBy:createdBy,
  createdOn:createdOn,
  priority:priority,
  severity:severity,
  status:status,
  people:{ 
    personId:personId }, 
  
  projects:{
    projectId:projectId }

}
console.log(body)
return this.httpClient.put(this.url+"/"+issueId,body)
}

insertIssue(issueName:string,issueDescription:string,createdBy:string,createdOn:string,
  priority:string,severity:string,status:string,projectId:number,personId:number){

const body={
issueName:issueName,
issueDescription:issueDescription,
status:status,
priority:priority,
severity:severity,
createdBy:createdBy,
people:{ 
  personId:personId },
projects:{
  projectId:projectId }

}

return this.httpClient.post(this.url+"/",body)

}



}
