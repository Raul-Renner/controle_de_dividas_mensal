import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormDevedorComponent } from './form-devedor.component';

describe('FormDevedorComponent', () => {
  let component: FormDevedorComponent;
  let fixture: ComponentFixture<FormDevedorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormDevedorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormDevedorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
