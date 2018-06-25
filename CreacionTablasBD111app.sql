create schema bd111app;
use bd111app;

create table if not exists modulo(
	pk_id_modulo int auto_increment,
	nombre varchar (45) not null,
    descripcion varchar (500),
    orden int not null,
	primary key (pk_id_modulo)
);

create table if not exists usuario(
	pk_id_usuario int auto_increment,
    nombre varchar (45),
    apellido varchar (45),
    email varchar (45) not null,
    contraseña varchar(45) not null,
    telefono varchar (45),
    progreso int,
    alumno_111mil boolean,
	primary key (pk_id_usuario)
);

create table if not exists tema(
	pk_id_tema int auto_increment,
	nombre varchar (45) not null,
    descripcion varchar (500),
    orden int not null,
    teoria varchar (3000),
    fk_id_modulo int not null,
	primary key (pk_id_tema),
	constraint fk_tema_modulo foreign key(fk_id_modulo) references modulo(pk_id_modulo)
    on update no action on delete no action
);

create table if not exists ejercicio(
	pk_id_ejercicio int auto_increment,
    enunciado varchar (500) not null,
    imagen blob,
    solucion int not null,
    puntaje int not null,
    opcion1 varchar (100),
    opcion2 varchar (100),
    opcion3 varchar (100),
    fk_id_tema int not null,
	primary key (pk_id_ejercicio),
    constraint fk_ejercicio_tema foreign key(fk_id_tema) references tema(pk_id_tema)
    on update no action on delete no action
);

create table if not exists ejercicio_realizado(
	fk_id_usuario int,
    fk_id_ejercicio int,
    primary key(fk_id_usuario, fk_id_ejercicio),
	constraint fk_realizado_usuario foreign key(fk_id_usuario) references usuario(pk_id_usuario)
    on update no action on delete no action,
    constraint fk_realizado_ejercicio foreign key(fk_id_ejercicio) references ejercicio(pk_id_ejercicio)
    on update no action on delete no action
);
