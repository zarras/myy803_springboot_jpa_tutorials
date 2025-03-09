create table active_employees (aid integer not null, salary float(53), primary key (aid)) engine=InnoDB;
create table employees (eid integer not null, name varchar(255), primary key (eid)) engine=InnoDB;
create table retired_employees (pension float(53), rid integer not null, primary key (rid)) engine=InnoDB;
alter table active_employees add constraint FKrhq6xfqtb8fsqekvbtn3ax7sk foreign key (aid) references employees (eid);
alter table retired_employees add constraint FK4xei9yw6otxxp7i1m7769ba5x foreign key (rid) references employees (eid);
