import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarStudentComponent } from './navbar.component';

describe('NavbarComponent', () => {
  let component: NavbarStudentComponent;
  let fixture: ComponentFixture<NavbarStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NavbarStudentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
