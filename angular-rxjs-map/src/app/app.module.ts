import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent }  from './app.component';
import { MapDemoComponent }  from './map-demo.component';
import { MapDemoService } from './map-demo.service';

@NgModule({
  imports: [     
      BrowserModule,
	  HttpClientModule,
	  FormsModule,
  ],
  declarations: [
      AppComponent,
	  MapDemoComponent
  ],
  providers: [
  ],
  bootstrap: [
      AppComponent
  ]
})
export class AppModule { }
