import { Component } from '@angular/core';
import { Expense } from '../expense';
import { ServiceDemoService } from '../service-demo.service';

@Component({
  selector: 'app-list-expense',
  templateUrl: './list-expense.component.html',
  styleUrls: ['./list-expense.component.css']
})
export class ListExpenseComponent {
  expense:Expense[]=[];
  
  displayedColumns: string[] = ['id', 'particular','date','item','rate','total','actions'];

  constructor(private serv:ServiceDemoService)
  {}
  
 
  ngOnInit(): void {
    this.getAllExpenses();
  }
 

  getAllExpenses()
  {

    this.serv.getAll().subscribe(data=>
      {
          this.expense=data;

      });
  }
  openDeleteModal(id:number)
  {
    
    if(window.confirm("Do you want to delete this record?"))
    {
            this.serv.delete(id).subscribe(() => {
              this.getAllExpenses();
              //this.router.navigate(['/']);
         
            });
          }


}
}
