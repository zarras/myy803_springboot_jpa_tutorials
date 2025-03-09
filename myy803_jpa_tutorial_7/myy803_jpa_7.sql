create table active_employees (eid integer not null, salary float(53), name varchar(255), primary key (eid)) engine=InnoDB;
create table employee (eid integer not null, name varchar(255), primary key (eid)) engine=InnoDB;
create table retired_employees (eid integer not null, pension float(53), name varchar(255), primary key (eid)) engine=InnoDB;
