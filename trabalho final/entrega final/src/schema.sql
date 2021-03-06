CREATE TABLE jogador
(
    "id_Jogador" serial NOT NULL,
    nome character varying(100) NOT NULL,
    nivel integer NOT NULL,
    moedas bigint NOT NULL,
    experiencia bigint NOT NULL,
    CONSTRAINT "Jogador_pkey" PRIMARY KEY ("id_Jogador")
)

create table missao(

"id_Missao" serial not null,
descricao varchar(300) not null,
dataInicio date not null,
dataFim date ,
status boolean not null,
tipo varchar(300) not null,
quantidade int not null,
Primary key("id_Missao")

);

create table "jogadorMissao"(
id_missao int not null,
id_jogador int not null,
primary key(id_missao, id_jogador),
foreign key (id_jogador) references jogador("id_Jogador")
ON DELETE CASCADE,
foreign key (id_missao) references missao("id_Missao")
ON DELETE CASCADE
);