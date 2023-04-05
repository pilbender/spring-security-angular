import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
	providedIn: 'root'
})
export class AppService {

	authenticated = false;

	constructor(private http: HttpClient) {
	}

	authenticate(credentials, callback) {

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
		this.http.post('logout', {}).subscribe(() => {
			this.authenticated = false;
		});
	}
}
