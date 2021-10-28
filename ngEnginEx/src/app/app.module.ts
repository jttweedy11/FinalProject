import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DeveloperComponent } from './components/developer/developer.component';
import { SkillComponent } from './components/skill/skill.component';
import { ExperienceComponent } from './components/experience/experience.component';
import { EducationComponent } from './components/education/education.component';
import { ClientComponent } from './components/client/client.component';
import { CompanyComponent } from './components/company/company.component';
import { PostComponent } from './components/post/post.component';
import { JobPostComponent } from './components/job-post/job-post.component';
import { JobStatusComponent } from './components/job-status/job-status.component';
import { JobDetailComponent } from './components/job-detail/job-detail.component';
import { JobApplicationComponent } from './components/job-application/job-application.component';
import { JobApplicationCommentComponent } from './components/job-application-comment/job-application-comment.component';
import { UserComponent } from './components/user/user.component';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { ClientService } from './services/client.service';
import { DeveloperService } from './services/developer.service';
import { JobApplicationService } from './services/job-application.service';
import { JobPostService } from './services/job-post.service';
@NgModule({
  declarations: [
    AppComponent,
    DeveloperComponent,
    SkillComponent,
    ExperienceComponent,
    EducationComponent,
    ClientComponent,
    CompanyComponent,
    PostComponent,
    JobPostComponent,
    JobStatusComponent,
    JobDetailComponent,
    JobApplicationComponent,
    JobApplicationCommentComponent,
    UserComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
  ],
  providers: [
    ClientService,
    DeveloperService,
    JobApplicationService,
    JobPostService,
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
