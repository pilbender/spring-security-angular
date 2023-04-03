import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'spring-security-angular-frontend';
  greeting: Object = {'id': 'XXX', 'content': 'Hello World'};
  /*
  constructor(private http: HttpClient) {
    http.get('resource').subscribe(data => this.greeting = data);
  }
   */
}
