import { Component, OnInit } from '@angular/core';

import { faSearch } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  faSearch = faSearch;
  filtro = '';

  constructor() { }

  ngOnInit(): void {
  }

  pesquisar() {
    // TODO implementar pesquisar
    console.log(this.filtro);
  }
}
