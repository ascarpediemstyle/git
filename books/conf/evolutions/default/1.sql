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

create sequence book_seq;




# --- !Downs

drop table if exists book cascade;

drop sequence if exists book_seq;

