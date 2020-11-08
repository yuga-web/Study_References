import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { MyCountry } from './my-country';

@Injectable({
    providedIn: 'root'
})
export class MapDemoService {
    getNumbers(): Observable<number> {
      return of(1, 2, 3, 4, 5, 6, 7);
    }
    getStdNames(): Observable<string> {
      return of("Mahesh, Krishna, Ram");
    }	
    getCountry(): Observable<MyCountry> {
      return of(new MyCountry());
    }
}