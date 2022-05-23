import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardHolderSearchComponent } from './card-holder-search.component';

describe('CardHolderSearchComponent', () => {
  let component: CardHolderSearchComponent;
  let fixture: ComponentFixture<CardHolderSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardHolderSearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CardHolderSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
