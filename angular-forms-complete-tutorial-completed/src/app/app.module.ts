import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FormsComponent } from './forms/forms.component';

import { HighlightModule } from 'ngx-highlightjs';
import { TemplateSampleComponent } from './forms/template-sample/template-sample.component';
import { ReactiveSampleComponent } from './forms/reactive-sample/reactive-sample.component';
import { NestedFormComponent } from './forms/nested-form/nested-form.component';

import { Routes, RouterModule } from '@angular/router';
import { FooterComponent } from './footer/footer.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ZipValidatorDirective } from './zip-validator.directive';


const routes: Routes = [
  {path: '', redirectTo: 'template', pathMatch: 'full'},
  {path: 'template', component: TemplateSampleComponent},
  {path: 'reactive', component: ReactiveSampleComponent},
  {path: 'nested', component: NestedFormComponent},
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FormsComponent,
    TemplateSampleComponent,
    ReactiveSampleComponent,
    NestedFormComponent,
    FooterComponent,
    ZipValidatorDirective
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HighlightModule.forRoot({ theme: 'arduino-light'}),
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
