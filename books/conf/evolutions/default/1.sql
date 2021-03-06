# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table book (
  book_id                   integer not null,
  title                     varchar(255),
  amazon_link               varchar(255),
  memo                      varchar(255),
  comment                   varchar(255),
  rating                    integer,
  create_date               timestamp,
  update_date               timestamp,
  constraint pk_book primary key (book_id))
;

create table member (
  member_id                 varchar(255),
  member_name               varchar(255),
  password                  varchar(255),
  create_date               timestamp,
  update_date               timestamp,
  constraint uq_member_1 unique (member_id))
;

create sequence book_seq;




# --- !Downs

drop table if exists book cascade;

drop table if exists member cascade;

drop sequence if exists book_seq;

