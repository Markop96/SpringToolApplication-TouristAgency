import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Aranzman } from '../models/aranzman';
import { Observable } from 'rxjs';
import { ARANZMAN_PO_AGENCIJAMA_URL, ARANZMAN_URL } from '../app.constants';

@Injectable({
  providedIn: 'root'
})
export class AranzmanService {

  constructor(private httpClient: HttpClient) { }

  public getAranzman(agencijaId: number): Observable<any> {
    return this.httpClient.get(`${ARANZMAN_PO_AGENCIJAMA_URL}/${agencijaId}`);
  }

  public addAranzman(aranzman: Aranzman): Observable<any> {
    aranzman.id=0;
    return this.httpClient.post(`${ARANZMAN_URL}`, aranzman);
  }

  public updateAranzman(aranzman: Aranzman): Observable<any>{
    return this.httpClient.put(`${ARANZMAN_URL}/${aranzman.id}`, aranzman); // --moguce da treba iza  return this.httpClient.put(`${ARANZMAN_URL}/${aranzman.id}`, aranzman); 
  }

  public deleteAranzman(Id: number): Observable<any> {
    return this.httpClient.delete(`${ARANZMAN_URL}/${Id}`);
  }

}
