import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDevedoresComponent } from './list-devedores.component';

describe('ListDevedoresComponent', () => {
  let component: ListDevedoresComponent;
  let fixture: ComponentFixture<ListDevedoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListDevedoresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDevedoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
