import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppService} from "./app.service";

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})
export class AppComponent {
	title = 'spring-security-angular-frontend';
	greeting: Object = {};

	constructor(private http: HttpClient,
				private appService: AppService) {
	}

	logout() {
		this.appService.logout();
	}
}
