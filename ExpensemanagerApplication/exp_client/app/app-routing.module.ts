import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateExpenseComponent } from './create-expense/create-expense.component';
import { ListExpenseComponent } from './list-expense/list-expense.component';
import { UpdateExpenseComponent } from './update-expense/update-expense.component';

const routes: Routes = [
  {path: '', redirectTo: 'list-expense', pathMatch: 'full' },
  { path: 'list-expense', component: ListExpenseComponent },
  { path: 'create-expense', component: CreateExpenseComponent },
  { path: 'update-expense/:id', component: UpdateExpenseComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
