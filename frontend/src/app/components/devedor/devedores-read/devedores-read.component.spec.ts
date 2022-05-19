import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DevedoresReadComponent } from './devedores-read.component';

describe('DevedoresReadComponent', () => {
  let component: DevedoresReadComponent;
  let fixture: ComponentFixture<DevedoresReadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DevedoresReadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DevedoresReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
