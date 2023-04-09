import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {HttpOptionsService} from "./http-options.service";

@Injectable({
	providedIn: 'root'
})
export class AppService {

	authenticated = false;

	constructor(private http: HttpClient,
				private httpOptionsService: HttpOptionsService) {
	}

	authenticate(credentials, callback) {
		console.log("AppService.authenticated: " + this.authenticated);

		const headers = new HttpHeaders(credentials ? {
			authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
		} : {});

		this.http.get('user', {headers: headers}).subscribe(response => {
			console.log("response: " + response);
			if (response['name']) {
				this.authenticated = true;
			} else {
				this.authenticated = false;
			}
			return callback && callback();
		});

	}

	logout() {
		console.log("logout");
		this.authenticated = false;
		/*this.http.get('logout', this.httpOptionsService.httpOptions).subscribe(() => {
			console.log("are we logging out?");
			this.authenticated = false;
		});*/
	}
}
