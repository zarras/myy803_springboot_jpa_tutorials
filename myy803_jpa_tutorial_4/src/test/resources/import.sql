delete from stops_agents
delete from stops
delete from routes

delete from ticket_control_agents
delete from services
delete from drivers


insert into drivers(id, name) values (1, 'John Doe')
insert into drivers(id, name) values (2, 'Jane Smith')
insert into drivers(id, name) values (3, 'Bob Martin')

insert into services(id, name) values (1, 'Service 1')
insert into services(id, name) values (2, 'Service 2')

insert into ticket_control_agents(id, name) values (1, 'Elegktis 1')
insert into ticket_control_agents(id, name) values (2, 'Elegktis 2')

insert into routes(id, name, driver_id, service_id) values (1, 'Pedion Areos - Acropolis', 1, 1)
insert into routes(id, name, driver_id, service_id) values (2, 'OAKA - SEF', 2, 2)

insert into stops(id, name, latitude, longtitude, route_id) values(1, 'Pedion Areos', 37.99294900722829, 23.736567391372496, 1)
insert into stops(id, name, latitude, longtitude, route_id) values(2, 'Syntagma', 37.97569448870225, 23.73471989313159, 1)
insert into stops(id, name, latitude, longtitude, route_id) values(3, 'Acropolis', 37.97200493179254, 23.725749051518168, 1)

insert into stops(id, name, latitude, longtitude, route_id) values(4, 'OAKA', 38.03605314932543, 23.786941787128843, 2)
insert into stops(id, name, latitude, longtitude, route_id) values(5, 'Syntagma', 37.97569448870225, 23.73471989313159, 2)
insert into stops(id, name, latitude, longtitude, route_id) values(6, 'Peiraios', 37.96298, 23.69157, 2)
insert into stops(id, name, latitude, longtitude, route_id) values(7, 'Stadio Eirinis kai Filias', 37.94263107650468, 23.66723596482305, 2)


insert into stops_agents(stop_id, agent_id) values(1, 1)
insert into stops_agents(stop_id, agent_id) values(2, 1)
insert into stops_agents(stop_id, agent_id) values(3, 1)
insert into stops_agents(stop_id, agent_id) values(4, 2)
insert into stops_agents(stop_id, agent_id) values(5, 2)
insert into stops_agents(stop_id, agent_id) values(6, 2)
insert into stops_agents(stop_id, agent_id) values(7, 2)


