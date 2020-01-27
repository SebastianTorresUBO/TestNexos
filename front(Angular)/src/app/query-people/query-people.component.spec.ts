import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QueryPeopleComponent } from './query-people.component';

describe('QueryPeopleComponent', () => {
  let component: QueryPeopleComponent;
  let fixture: ComponentFixture<QueryPeopleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QueryPeopleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QueryPeopleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
