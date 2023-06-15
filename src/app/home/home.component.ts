import {Component, OnInit} from '@angular/core';
import {AppService} from "../app.service";
import {HttpClient} from "@angular/common/http";

@Component({
	selector: 'app-home',
	templateUrl: './home.component.html',
	styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

	title = 'Demo';
	greeting: Greeting;

	constructor(private app: AppService, private http: HttpClient) {
		http.get('basic/resource').subscribe(data => {
			this.greeting = data;
			if (data) {
				this.app.authenticated = true;
			} else {
				this.app.authenticated = false;
			}
		});
	}

	ngOnInit() {
	}

	authenticated() {
		console.log("authenticated: " + this.app.authenticated);
		return this.app.authenticated;
	}
}
