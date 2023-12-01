import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageContractComponent } from './manage-contract.component';

describe('ManageContractComponent', () => {
  let component: ManageContractComponent;
  let fixture: ComponentFixture<ManageContractComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManageContractComponent]
    });
    fixture = TestBed.createComponent(ManageContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
