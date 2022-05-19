import { TestBed } from '@angular/core/testing';

import { DevedorDetalhesService } from './devedor-detalhes/devedor-detalhes.service';

describe('DevedorDetalhesService', () => {
  let service: DevedorDetalhesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DevedorDetalhesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
