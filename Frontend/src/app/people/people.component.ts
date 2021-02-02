import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PeopleService } from '../people.service';

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.css']
})
export class PeopleComponent implements OnInit {
  people=[]

  constructor(private router:Router, 
    private activatedRoute: ActivatedRoute,
    private peopleservice:PeopleService) { }

  ngOnInit(): void {
    this.loadPeople()
  }
 


  
  loadPeople()
  {
    this.peopleservice
    .getPeople()
    .subscribe((response: { [x: string]: any; })=>
    {
      if(response['status']=='success')
      {
        this.people=response['data']
      }
      else
      {
        console.log(response['error'])
      }
    })

  }

}
