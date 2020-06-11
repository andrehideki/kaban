import { Etapa } from './../core/model';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EtapaService {

  etapas: Etapa[];

  constructor() { }

  listar(): Promise<Etapa[]> {
   
  }

  cadastrar(etapa: Etapa) {
    this.etapas.push(etapa);
  }
}
