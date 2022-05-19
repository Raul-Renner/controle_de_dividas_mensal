import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DevedorDetalhesComponent } from './devedor-detalhes.component';

describe('DevedorDetalhesComponent', () => {
  let component: DevedorDetalhesComponent;
  let fixture: ComponentFixture<DevedorDetalhesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DevedorDetalhesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DevedorDetalhesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
