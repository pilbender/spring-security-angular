import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AppService} from "../app.service";
import {HttpClient} from "@angular/common/http";

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
	credentials = {username: '', password: ''};

	constructor(private app: AppService, private http: HttpClient, private router: Router) {
	}

	ngOnInit() {
	}

	login() {
		this.app.authenticate(this.credentials, () => {
			this.router.navigateByUrl('/');
		});
		return false;
	}
}
