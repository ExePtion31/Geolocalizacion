import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCareersComponent } from './create.component';

describe('CreateComponent', () => {
  let component: CreateCareersComponent;
  let fixture: ComponentFixture<CreateCareersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateCareersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCareersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
