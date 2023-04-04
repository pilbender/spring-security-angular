import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'spring-security-angular-frontend';
	greeting: Object = {};

	constructor(private http: HttpClient) {
		http.get('resource').subscribe(data => {
			console.log(data);
			this.greeting = data;
		});
	}

	logout() {
		/*
		this.http.post('logout', {}).finally(() => {
			this.app.authenticated = false;
			this.router.navigateByUrl('/login');
		}).subscribe();
		 */
	}
}
