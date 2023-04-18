import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Expense } from '../expense';
import { ServiceDemoService } from '../service-demo.service';

@Component({
  selector: 'app-create-expense',
  templateUrl: './create-expense.component.html',
  styleUrls: ['./create-expense.component.css']
})
export class CreateExpenseComponent implements OnInit{

  expense:Expense={
    particular: '',
    date: undefined,
    item: undefined,
    rate: undefined
    // total: undefined
  }

  ex:Expense=new Expense();
  constructor(private serv:ServiceDemoService,private router:Router){}
  ngOnInit(): void {
    
  }

  postData()
 {
  // this.student.student_name=this.addStudentForm.controls.student_name.value;
     
   this.serv.post(this.expense).subscribe(() => {
           this.router.navigate(['/list-expense'])
           }
          
   );
     
 }
}
