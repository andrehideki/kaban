import { Component, OnInit } from '@angular/core';

import { faPlus } from '@fortawesome/free-solid-svg-icons';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-etapa-cadastrar',
  templateUrl: './etapa-cadastrar.component.html',
  styleUrls: ['./etapa-cadastrar.component.css']
})
export class EtapaCadastrarComponent implements OnInit {

  icon = faPlus;
  nova = false;
  nome: string;

  constructor() { }

  ngOnInit(): void {
  }

  cadastrar(form: NgForm) {
    this.nova = false;
    form.reset();
  }
}
