import { Directive } from '@angular/core';
import {NG_VALIDATORS, Validator, AbstractControl} from '@angular/forms';

@Directive({
  selector: '[appZipValidator]',
  providers: [{provide: NG_VALIDATORS, useExisting: ZipValidatorDirective, multi: true}]
})
export class ZipValidatorDirective implements Validator {

  constructor() { }

  validate(control: AbstractControl) {
    const elementValue = control.value;

    if (elementValue === null || elementValue === undefined || elementValue === '') {
      return {'cus_required' : 'Field is required'};
    }

    const reg = new RegExp('^[0-9]{5}$');
    if (!reg.test(elementValue)) {
      return {'cus_pattern' : 'Value should be 5 digit number.'};
    }

    return null;
  }

}
