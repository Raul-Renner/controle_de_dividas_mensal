import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DevedorUpdateComponent } from './devedor-update.component';

describe('DevedorUpdateComponent', () => {
  let component: DevedorUpdateComponent;
  let fixture: ComponentFixture<DevedorUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DevedorUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DevedorUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
