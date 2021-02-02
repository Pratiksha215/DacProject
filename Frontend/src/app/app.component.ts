import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  //title = 'bts';

  constructor(private router:Router){}

  onLogout(){
    sessionStorage.removeItem('personName')
    this.router.navigate(['/login'])
  }


// onLogin(){
//   this.router.navigate(['/login'])
// }

// onSignUp(){
//   this.router.navigate(['/signup'])
// }

}
