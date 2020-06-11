import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { KabanComponent } from './kaban/kaban.component';
import { EtapaCadastrarComponent } from './etapa-cadastrar/etapa-cadastrar.component';



@NgModule({
  declarations: [KabanComponent, EtapaCadastrarComponent],
  imports: [
    CommonModule,
    FormsModule,

    FontAwesomeModule
  ],
  exports: [KabanComponent]
})
export class KanbanModule { }
