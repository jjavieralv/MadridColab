ALTER TABLE contest__contest ADD COLUMN read_only_comments TINYINT(4) NOT NULL DEFAULT 0;

DROP TABLE IF EXISTS `user__user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__user` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `screen_name` varchar(42) DEFAULT NULL,
                              `email_address` varchar(75) DEFAULT NULL,
                              `is_email_confirmed` tinyint NOT NULL DEFAULT '0',
                              `is_email_bounced` tinyint DEFAULT '0',
                              `first_name` varchar(75) DEFAULT NULL,
                              `last_name` varchar(75) DEFAULT NULL,
                              `hashed_password` varchar(75) DEFAULT NULL,
                              `created_at` datetime DEFAULT NULL,
                              `updated_at` datetime DEFAULT NULL,
                              `password_updated_at` datetime DEFAULT NULL,
                              `country` varchar(75) DEFAULT NULL,
                              `state` varchar(50) DEFAULT NULL,
                              `short_bio` text,
                              `facebook_id` bigint DEFAULT NULL,
                              `google_id` varchar(50) DEFAULT NULL,
                              `colab_sso_id` varchar(50) DEFAULT NULL,
                              `climate_x_id` varchar(75) DEFAULT NULL,
                              `open_id` varchar(255) DEFAULT NULL,
                              `login_ip` varchar(75) DEFAULT NULL,
                              `login_date` datetime DEFAULT NULL,
                              `status` int DEFAULT '0',
                              `forgot_password_token` varchar(255) DEFAULT NULL,
                              `forgot_password_token_expire_time` datetime DEFAULT NULL,
                              `portrait_file_entry_id` bigint DEFAULT NULL,
                              `report_karma` int DEFAULT '100',
                              `default_locale` varchar(45) DEFAULT 'en',
                              `auto_registered_member_status` int DEFAULT '0',
                              `uuid` varchar(40) DEFAULT NULL,
                              `login_token_id` varchar(75) DEFAULT NULL,
                              `login_token_key` varchar(75) DEFAULT NULL,
                              `login_token_expiration_date` datetime DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `IX_XCOLAB_MEMBERS_SCREEN_NAME` (`screen_name`),
                              UNIQUE KEY `IX_XCOLAB_MEMBERS_EMAIL_ADDRESS` (`email_address`),
                              KEY `IX_XCOLAB_MEMBERS_CREATE_DATE` (`created_at`,`updated_at`),
                              KEY `IX_XCOLAB_MEMBERS_MODIFIED_DATE` (`updated_at`),
                              KEY `IX_XCOLAB_MEMBERS_FACEBOOK_ID` (`facebook_id`),
                              KEY `IX_XCOLAB_MEMBERS_GOOGLE_ID` (`google_id`),
                              KEY `IX_XCOLAB_MEMBERS_COLAB_SSO_ID` (`colab_sso_id`),
                              KEY `IX_XCOLAB_MEMBERS_CLIMTE_X_ID` (`climate_x_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE user__sector(
                             id bigint(20) PRIMARY KEY,
                             sector VARCHAR(200));

CREATE TABLE user__sector_company(
                                     id bigint(20) PRIMARY KEY,
                                     sector_company VARCHAR(200));

CREATE TABLE user__community(
                                id bigint(20) PRIMARY KEY,
                                community VARCHAR(200));

CREATE TABLE user__ods(
                          id bigint(20) PRIMARY KEY,
                          ods VARCHAR(200));

CREATE TABLE user__community_registry(
                                         id_user bigint(20),
                                         id_community bigint(20),
                                         PRIMARY KEY (id_user, id_community),
                                         FOREIGN KEY (id_user)
                                             REFERENCES user__user (id),
                                         FOREIGN KEY (id_community)
                                             REFERENCES user__community (id));

CREATE TABLE user__ods_registry(
                                   id_user bigint(20),
                                   id_ods bigint(20),
                                   PRIMARY KEY (id_user, id_ods),
                                   FOREIGN KEY (id_user)
                                       REFERENCES user__user (id),
                                   FOREIGN KEY (id_ods)
                                       REFERENCES user__ods (id));

CREATE TABLE user__data_people(
                                  id_user bigint(20),
                                  twitter varchar(40),
                                  linkedin varchar(40),
                                  is_community BOOLEAN,
                                  id_sector bigint(20),
                                  other varchar(50),
                                  cod_postal varchar(5),
                                  PRIMARY KEY (id_user),
                                  FOREIGN KEY (id_user)
                                      REFERENCES user__user (id),
                                  FOREIGN KEY (id_sector)
                                      REFERENCES user__sector (id)
);

CREATE TABLE user__data_company(
                                   id_user bigint(20),
                                   twitter varchar(40),
                                   web varchar(40),
                                   is_community BOOLEAN,
                                   id_sector_company bigint(20),
                                   other varchar(50),
                                   cod_postal varchar(5),
                                   PRIMARY KEY (id_user),
                                   FOREIGN KEY (id_user)
                                       REFERENCES user__user (id),
                                   FOREIGN KEY (id_sector_company)
                                       REFERENCES user__sector_company (id)
);

CREATE TABLE user__data_city(
                                id_user bigint(20),
                                twitter varchar(40),
                                web varchar(100),
                                aut_community varchar(20),
                                municipality varchar(20),
                                PRIMARY KEY (id_user),
                                FOREIGN KEY (id_user)
                                    REFERENCES user__user (id)
);

INSERT INTO user__sector VALUES(0,	"Académico"),
                               (1,	"Administración pública"),
                               (2,	"Autónomo"),
                               (3,	"Empresa"),
                               (4,	"Start-up (o PYME)"),
                               (5,	"Tercer sector (o ONG/Fundación)"),
                               (6,	"Otro"),
                               (7,	"Desconocido");

INSERT INTO user__sector_company VALUES(0,	"Actividades profesionales"),
                                       (1,	"Actividades administrativas y servicios auxiliares"),
                                       (2,	"Agricultura y pesca"),
                                       (3,	"Comercio"),
                                       (4,	"Construcción"),
                                       (5,	"Consultoría"),
                                       (6,	"Educación"),
                                       (7,	"Financiero y seguros"),
                                       (8,	"Hostelería"),
                                       (9,	"Industria y energía"),
                                       (10,	"Información y comunicaciones"),
                                       (11,	"Inmobiliario"),
                                       (12,	"Resto servicios"),
                                       (13,	"Salud"),
                                       (14,	"Tecnología"),
                                       (15,	"Transporte y almacenamiento"),
                                       (16,	"Turismo"),
                                       (17,	"Otro");

INSERT INTO user__community VALUES(0,	"Transformación de ciudades"),
                                  (1,	"Desigualdad y nuevo modelo económico"),
                                  (2,	"Gobernanza global y cooperacion"),
                                  (3,	"Medio ambiente y salud");

INSERT INTO user__ods VALUES(0,	"1. Fin de la pobreza"),
                            (1,	"2. Hambre cero"),
                            (2,	"3. Salud y bienestar"),
                            (3,	"4. Educación de calidad"),
                            (4,	"5. Igualdad de género"),
                            (5,	"6. Agua limpia y saneamiento"),
                            (6,	"7. Energía asequible y no contaminante"),
                            (7,	"8. Trabajo decente y crecimiento económico"),
                            (8,	"9. Industria, innovación e infraestructura"),
                            (9,	"10. Reducción de las desigualdades"),
                            (10,	"11. Ciudades y comunidades sostenibles"),
                            (11,	"12. Producción y consumo responsables"),
                            (12,	"13. Acción por el clima"),
                            (13,	"14. Vida submarina"),
                            (14,	"15. Vida de ecosistemas terrestres"),
                            (15,	"16. Paz, justicia e instituciones sólidas"),
                            (16,	"17. Alianzas para lograr los objetivos");

CREATE TABLE contest__contest_fusion (
                                         id_fusion bigint(20) PRIMARY KEY,
                                         contest_id_1 bigint(20),
                                         contest_id_2 bigint(20),

                                         FOREIGN KEY (id_fusion)
                                             REFERENCES contest__contest (id),
                                         FOREIGN KEY (contest_id_1)
                                             REFERENCES contest__contest (id),
                                         FOREIGN KEY (contest_id_2)
                                             REFERENCES contest__contest (id)
);

CREATE TABLE contest__proposal_fusion_request(
                                                 id bigint(20) PRIMARY KEY AUTO_INCREMENT,
                                                 from_user_id bigint(20),
                                                 to_user_id bigint(20),
                                                 from_proposal_id bigint(20),
                                                 to_proposal_id bigint(20),
                                                 created_at DATETIME,
                                                 updated_at DATETIME,
                                                 status VARCHAR(75),
                                                 contest_id bigint(20),
                                                 proposal_id bigint(20),
                                                 request_text varchar(200),
                                                 common_text varchar(1000),

                                                 FOREIGN KEY (from_user_id)
                                                     REFERENCES user__user (id),
                                                 FOREIGN KEY (to_user_id)
                                                     REFERENCES user__user (id),
                                                 FOREIGN KEY (from_proposal_id)
                                                     REFERENCES contest__proposal (id),
                                                 FOREIGN KEY (to_proposal_id)
                                                     REFERENCES contest__proposal (id),
                                                 FOREIGN KEY (proposal_id)
                                                     REFERENCES contest__proposal (id),
                                                 FOREIGN KEY (contest_id)
                                                     REFERENCES contest__contest (id));

