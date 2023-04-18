import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Expense } from '../expense';
import { ServiceDemoService } from '../service-demo.service';

@Component({
  selector: 'app-update-expense',
  templateUrl: './update-expense.component.html',
  styleUrls: ['./update-expense.component.css']
})
export class UpdateExpenseComponent implements OnInit{

  expense:Expense={
    particular: '',
    date: undefined,
    item: undefined,
    rate: undefined
    // total: undefined
  }


  id:number=0;
  
  constructor(
    private expenseService: ServiceDemoService,
    private router: Router,
    private route: ActivatedRoute
    // private serv:ServicedemoService
    ) {}

    ngOnInit(): void {
      this.route.paramMap.subscribe((param) => {
         this.id = Number(param.get('id'));
        this.getById(this.id);
        
      });
    }

    getById(id: number) {
      this.expenseService.get(id).subscribe((data) => {
        this.expense = data;
      });
    }

  update() {
    this.expenseService.update(this.expense,this.id).subscribe(() => {
      this.router.navigate(['/']);
      
    });
}
postData()
 {
  // this.student.student_name=this.addStudentForm.controls.student_name.value;
     
   this.expenseService.post(this.expense).subscribe(() => {
           this.router.navigate(['/list-expense'])
           }
          
   );
     
 }
 

}
