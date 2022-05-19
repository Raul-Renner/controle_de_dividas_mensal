import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardListDividaComponent } from './card-list-divida.component';

describe('CardListDividaComponent', () => {
  let component: CardListDividaComponent;
  let fixture: ComponentFixture<CardListDividaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardListDividaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CardListDividaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
