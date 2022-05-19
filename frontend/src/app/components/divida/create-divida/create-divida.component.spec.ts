import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateDividaComponent } from './create-divida.component';

describe('CreateDividaComponent', () => {
  let component: CreateDividaComponent;
  let fixture: ComponentFixture<CreateDividaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateDividaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateDividaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
