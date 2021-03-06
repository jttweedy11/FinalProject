import { JobApplicationComment } from './job-application-comment';
import { JobDetail } from './job-detail';
import { JobPost } from './job-post';
import { User } from './user';

export class JobApplication {
  id: number;
  approved: boolean;
  status: string;
  date: string;
  jobPost: JobPost;
  user: User;
  decisionDate: string;
  detail: JobDetail | null = null;

  comments: JobApplicationComment[] = [];
  constructor(
    id: number = 0,
    approved: boolean = false,
    status: string = '',
    date: string = '',
    jobPost: JobPost = new JobPost(),
    user: User = new User(),
    decisionDate: string = '',
    detail: JobDetail = new JobDetail(),
    comments: JobApplicationComment[] = []
  ) {
    this.id = id;
    this.approved = approved;
    this.status = status;
    this.date = date;
    this.jobPost = jobPost;
    this.user = user;
    this.decisionDate = decisionDate;
    this.detail = detail;
    this.comments = comments;
  }
}
