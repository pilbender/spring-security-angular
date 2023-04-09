import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppService} from "./app.service";
import {Router} from "@angular/router";

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'spring-security-angular-frontend';
	greeting: Object = {};

	constructor(private http: HttpClient,
				private appService: AppService,
				private router: Router) {
	}

	logout() {
		console.log("logout");
		this.appService.logout();
		this.router.navigateByUrl("/login");
	}
}
