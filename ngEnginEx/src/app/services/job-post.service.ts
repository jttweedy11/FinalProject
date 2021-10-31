import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { JobPost } from '../models/job-post';
import { JobStatus } from '../models/job-status';
import { JobType } from '../models/job-type';

@Injectable({
  providedIn: 'root',
})
export class JobPostService {
  private baseUrl = 'http://localhost:8091/';
  private jobsUrl = this.baseUrl + 'api/jobs';
  private typeUrl = this.baseUrl + 'api/jobstatus';

  constructor(private http: HttpClient) {}

  index(): Observable<JobPost[]> {
    console.log('In call to DB.');
    return this.http.get<JobPost[]>(this.jobsUrl).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Bad Post Request');
      })
    );
  }
  create(jobPost: JobPost) {
    return this.http.post(this.jobsUrl, jobPost).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('creating a Job Post was not successful.');
      })
    );
  }
  indexStatus(): Observable<JobStatus[]> {
    console.log('in call to type DB');
    return this.http.get<JobStatus[]>(this.typeUrl).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('Bad Type Request');
      })
    );
  }
}
