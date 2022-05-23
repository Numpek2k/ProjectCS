import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardHolderHomeComponent } from './card-holder-home.component';

describe('CardHolderHomeComponent', () => {
  let component: CardHolderHomeComponent;
  let fixture: ComponentFixture<CardHolderHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardHolderHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CardHolderHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
