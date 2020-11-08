import { Component, OnInit } from '@angular/core';
import { Observable, of } from 'rxjs';
import { map, filter, scan, retry, catchError } from 'rxjs/operators';
import { MapDemoService } from './map-demo.service';

@Component({
   selector: 'app-map-demo',
   templateUrl: './map-demo.component.html'
})
export class MapDemoComponent implements OnInit { 
   stdNames$: Observable<string[]>; 
   countryName$: Observable<string>;
   countryStates: string[];

   constructor(private mapDemoService: MapDemoService) { }
   
   ngOnInit() {
      this.getStdNames();
      this.calcData();      
      this.getCountryName();
      this.getCountryStates();

      let cities = ["Varanasi", "Mathura", "Ayodhya"];

      //Using JavaScript Array map
      cities.map(c => "Holy "+ c)
      .forEach(el => console.log(el));
  
      //Using RxJS map
      of(cities).pipe(
        map(dataArray => dataArray.join(", "))
      ).subscribe(res => console.log(res)); 

      
   }

   //Using map 
   getStdNames() {
    this.stdNames$ = this.mapDemoService.getStdNames().pipe(
      map(res => res.split(","))
    );
    
    this.mapDemoService.getStdNames().pipe(
      map(res => res.split(","))
    )
    .subscribe(names=> names.forEach(name => console.log(name)));
   }	

   //Using filter, map and scan
   calcData() {
    this.mapDemoService.getNumbers().pipe(
      filter(n => n % 2 === 1),
      map(n => n + 10),
      scan((sum, n) => sum + n)
    )
    .subscribe(result => console.log(result));
   }
   //Using map and catchError
   getCountryName() {
    this.countryName$ = this.mapDemoService.getCountry().pipe(
      map(country => country.getCountryName()),
      catchError(err => {
        console.error(err);
        return of("");
      })
    );
   }

   //Using retry, map and catchError
   getCountryStates() {
    this.mapDemoService.getCountry().pipe(
      retry(2),
      map(country => country.getCountryStates()),
      catchError(err => {
        console.error(err);
        return of([]);
      })
    )
    .subscribe(res => this.countryStates = res); 
   }
}