import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Expense } from './expense';

@Injectable({
  providedIn: 'root'
})
export class ServiceDemoService {

  constructor(private http:HttpClient) { }

  post(expense:Expense):Observable<Expense>
  {
      return this.http.post<Expense>("http://localhost:8080/expense",expense);
  }

  get(id:Number):Observable<Expense>
  {
    console.log("Get request sent...."); 
    return this.http.get<Expense>("http://localhost:8080/expense/"+id);

  }

  getAll():Observable<Expense[]>
  {
    console.log("Get all request sent...."); 
    return this.http.get<Expense[]>("http://localhost:8080/expenses");

  }

  update(expense:Expense,id:number):Observable<Expense>
  {
   return this.http.put<Expense>("http://localhost:8080/expense/"+id,expense);

  }

  delete(id:number):Observable<any>
  {
    return this.http.delete("http://localhost:8080/expense/"+id,{responseType:'text'});

  }


}
