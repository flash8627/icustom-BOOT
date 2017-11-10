
-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_ROLES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_ROLES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_ROLES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_AUTHORITIES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_AUTHORITIES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_AUTHORITIES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_RESOURCES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_RESOURCES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_RESOURCES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;



-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_AUTHORITIES_RESOURCES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_AUTHORITIES_RESOURCES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_AUTHORITIES_RESOURCES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_USERS_ROLES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_USERS_ROLES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_USERS_ROLES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_ROLES_AUTHORITIES_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_ROLES_AUTHORITIES_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_ROLES_AUTHORITIES_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_USERS_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_USERS_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_USERS_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_NAVIGATION_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_NAVIGATION_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_NAVIGATION_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_LOOKUP_CLASSIFY_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_LOOKUP_CLASSIFY_S';
end if;
end;
/
-- 20160814
-- Create sequence 
create sequence SYS_LOOKUP_CLASSIFY_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_LOOKUP_ITEM_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_LOOKUP_ITEM_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_LOOKUP_ITEM_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_REGISTER_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_REGISTER_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_REGISTER_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;


-- Drop SEQUENCE
declare
v_num number;
begin
select count(*) into v_num from user_sequences where sequence_name='SYS_LANGUAGE_S';
if v_num > 0 then
execute immediate 'drop SEQUENCE SYS_LANGUAGE_S';
end if;
end;
/
-- Create sequence 
create sequence SYS_LANGUAGE_S
minvalue 1
maxvalue 9999999999999999999999999999
start with 101
increment by 1
cache 20;
