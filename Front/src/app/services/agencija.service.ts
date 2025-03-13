import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AGENCIJA_URL } from '../app.constants';
import { Agencija } from '../models/agencija';

@Injectable({
  providedIn: 'root'
})
export class AgencijaService {

  constructor(private httpClient: HttpClient) { }

  public getAllAgencije(): Observable<any> {
    return this.httpClient.get(`${AGENCIJA_URL}`);
  }

  public addAgencija(agencija: Agencija): Observable<any> {
    return this.httpClient.post(`${AGENCIJA_URL}`, agencija);
  }

  public updateAgencija(agencija: Agencija): Observable<any>{
    return this.httpClient.put(`${AGENCIJA_URL}/${agencija.id}`, agencija);
  }

  public deleteAgencija(agencijaId: number): Observable<any> {
    return this.httpClient.delete(`${AGENCIJA_URL}/${agencijaId}`);
  }
}
