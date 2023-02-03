import {Component, OnInit} from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
  Validators
} from '@angular/forms';
import {Router} from '@angular/router';
import {Account} from '../../entity/account/account';
import {Customer} from '../../entity/customer/customer';
import {CustomerService} from '../../service/customer.service';

export const checkBirthDay: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  // @ts-ignore
  const birthday = new Date(control.get('birthDay').value).getTime();
  console.log(birthday);
  const dateNow = new Date().getTime();
  console.log(dateNow);
  if (dateNow - birthday < 18 * 365 * 24 * 60 * 60 * 1000) {
    return {checkBirthDay: true};
  } else {
    return null;
  }
};


@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {


  errorList: any;

  private registerAccount: FormGroup | undefined;
  userList: Account[] | undefined;

  // constructor(private formBuilder: FormBuilder,
  //             private accountService: CustomerService,
  //             private router: Router) {
  //   this.registerAccount = this.formBuilder.group({
  // tslint:disable-next-line:max-line-length
  //       name: ['', [Validators.required, Validators.pattern('^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{2,30}$'), Validators.minLength(2), Validators.maxLength(50)]],
  //     passwordGroup: new FormGroup({
  //       password: new FormControl('', [Validators.required, Validators.minLength(4), Validators.maxLength(20)]),
  //
  //       passwordConfirm: new FormControl()
  //     }, [this.checkPassword]),
  // tslint:disable-next-line:max-line-length
  //       nameCustomer: ['', [Validators.required, Validators.pattern('^[a-zA-Z_ÀÁÂÃÈÉÊẾÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêếìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{2,30}$'), Validators.minLength(2), Validators.maxLength(50)]],
  //       phoneCustomer1: ['', [Validators.required, Validators.pattern('[0][9][0]\\d{7}')]],
  //       phoneCustomer2: ['', [Validators.required, Validators.pattern('[0][9][0]\\d{7}')]],
  // tslint:disable-next-line:max-line-length
  //       emailCustomer: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9.!#$%&\'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$')]],
  //       dateOfBirth: ['', [Validators.required]],
  //       idCardCustomer: ['', [Validators.required, Validators.pattern('\\d{9}')]],
  //       pointDedication: [10.0],
  //       birthDay: ['', [Validators.required]],
  //       flagDelete: [false],
  //       addressCustomer: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
  //     }, {validators: [ checkBirthDay]},
  //   );
  // }


  account = new Account();
  customer: Customer | undefined;




  constructor(private formBuilder: FormBuilder,
              private customerService: CustomerService,
              private router: Router) {
    this.registerAccount = this.formBuilder.group({
      idCustomer: [''],
      nameCustomer: [''],
      emailCustomer: [''],
      addressCustomer: [''],
      idCardCustomer: [''],
      codeCustomer: [''],
      genderCustomer: [''],
      dateOfBirth: [''],
      flagDelete: [''],
      approvalCustomer: [''],
      phoneCustomer1: [''],
      phoneCustomer2: [''],
      usernameAccount: [''],
      encryptPassword: [''],
      passwordConfirm: ['']
      },
    );
  }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  saveCustomer() {
    console.log('save');
    // @ts-ignore
    this.customer = this.registerAccount?.value;
    this.customerService.saveCustomer(this.customer).subscribe(data => {
      this.router.navigateByUrl('/customer/create');
      // @ts-ignore
      this.registerAccount.reset();
    }, error => {
    }, () => {
    });
  }
}
