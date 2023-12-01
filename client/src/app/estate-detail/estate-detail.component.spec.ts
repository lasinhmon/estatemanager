import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstateDetailComponent } from './estate-detail.component';

describe('EstateDetailComponent', () => {
  let component: EstateDetailComponent;
  let fixture: ComponentFixture<EstateDetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EstateDetailComponent]
    });
    fixture = TestBed.createComponent(EstateDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
