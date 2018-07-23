create schema bd111app;
use bd111app;

create table if not exists modulo(
	pk_id_modulo bigint auto_increment,
	nombre varchar (45) not null,
    descripcion varchar (500),
	primary key (pk_id_modulo)
);

create table if not exists usuario(
	pk_id_usuario bigint auto_increment,
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
	pk_id_tema bigint auto_increment,
	nombre varchar (45) not null,
    descripcion varchar (500),
    teoria varchar (3000),
    fk_id_modulo bigint not null,
	primary key (pk_id_tema),
	constraint fk_tema_modulo foreign key(fk_id_modulo) references modulo(pk_id_modulo)
    on update cascade on delete cascade
);

create table if not exists ejercicio(
	pk_id_ejercicio bigint auto_increment,
    enunciado varchar (500) not null,
    imagen varchar(500),
    solucion int not null,
    puntaje int not null,
    opcion1 varchar (500),
    opcion2 varchar (500),
    opcion3 varchar (500),
    fk_id_tema bigint not null,
	primary key (pk_id_ejercicio),
    constraint fk_ejercicio_tema foreign key(fk_id_tema) references tema(pk_id_tema)
    on update cascade on delete cascade
);

create table if not exists ej_realizado(
	fk_id_usuario bigint,
    fk_id_ejercicio bigint,
    primary key(fk_id_usuario, fk_id_ejercicio),
	constraint fk_realizado_usuario foreign key(fk_id_usuario) references usuario(pk_id_usuario)
    on update cascade on delete cascade,
    constraint fk_realizado_ejercicio foreign key(fk_id_ejercicio) references ejercicio(pk_id_ejercicio)
    on update cascade on delete cascade
);
