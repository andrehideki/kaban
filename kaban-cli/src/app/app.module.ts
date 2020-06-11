import { KanbanModule } from './kanban/kanban.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CoreModule } from './core/core.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,

    CoreModule,
    KanbanModule
  ],
  providers: [

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
