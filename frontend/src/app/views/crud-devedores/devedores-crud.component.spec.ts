import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DevedoresCrudComponent } from './devedores-crud.component';

describe('DevedoresCrudComponent', () => {
  let component: DevedoresCrudComponent;
  let fixture: ComponentFixture<DevedoresCrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DevedoresCrudComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DevedoresCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
