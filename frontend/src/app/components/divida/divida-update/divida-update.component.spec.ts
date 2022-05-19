import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DividaUpdateComponent } from './divida-update.component';

describe('DividaUpdateComponent', () => {
  let component: DividaUpdateComponent;
  let fixture: ComponentFixture<DividaUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DividaUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DividaUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
