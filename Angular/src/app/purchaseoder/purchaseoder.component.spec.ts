import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PurchaseoderComponent } from './purchaseoder.component';

describe('PurchaseoderComponent', () => {
  let component: PurchaseoderComponent;
  let fixture: ComponentFixture<PurchaseoderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PurchaseoderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PurchaseoderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
