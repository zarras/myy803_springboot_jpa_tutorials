create table drivers (id integer not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table routes (driver_id integer, id integer not null auto_increment, service_id integer, name varchar(255), primary key (id)) engine=InnoDB;
create table services (id integer not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table stops (id integer not null auto_increment, latitude float(53), longtitude float(53), route_id integer, name varchar(255), primary key (id)) engine=InnoDB;
create table stops_agents (agent_id integer not null, stop_id integer not null) engine=InnoDB;
create table ticket_control_agents (id integer not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
alter table routes add constraint UK_o3nstw01u961qxd8p88s5lm71 unique (driver_id);
alter table routes add constraint FKop0qr5t6dwfrb9sg8x25o5ivd foreign key (driver_id) references drivers (id);
alter table routes add constraint FKrpd7n1kigocwmbylbu1u56ucc foreign key (service_id) references services (id);
alter table stops add constraint FKj89bt622wq57q3hmubkjgu6il foreign key (route_id) references routes (id);
alter table stops_agents add constraint FKqv3ww9gtjyyvwu74v4q9ekpf8 foreign key (agent_id) references ticket_control_agents (id);
alter table stops_agents add constraint FKpigucwdeu774ebyjvkyd0xyqa foreign key (stop_id) references stops (id);
