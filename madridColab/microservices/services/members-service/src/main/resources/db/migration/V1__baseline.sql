/*CREATE TABLE IF NOT EXISTS `members_Member` (
  `id_` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `screenName` varchar(42) DEFAULT NULL,
  `emailAddress` varchar(75) DEFAULT NULL,
  `isEmailConfirmed` tinyint(4) NOT NULL DEFAULT '0',
  `isEmailBounced` TINYINT(4) DEFAULT 0,
  `firstName` varchar(75) DEFAULT NULL,
  `lastName` varchar(75) DEFAULT NULL,
  `hashedPassword` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  `passwordModifiedDate` datetime DEFAULT NULL,
  `country` varchar(75) DEFAULT NULL,
  `state` varchar(50) null,
  `shortBio` text,
  `facebookId` bigint(20) DEFAULT NULL,
  `googleId` varchar(50) DEFAULT NULL,
  `colabSsoId` varchar(50) DEFAULT NULL,
  `climateXId` varchar(75) DEFAULT NULL,
  `openId` varchar(255) DEFAULT NULL,
  `loginIP` varchar(75) DEFAULT NULL,
  `loginDate` datetime DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  `forgotPasswordToken` varchar(255) DEFAULT NULL,
  `forgotPasswordTokenExpireTime` datetime DEFAULT NULL,
  `portraitFileEntryId` bigint(20) DEFAULT NULL,
  `reportKarma` int(11) DEFAULT '100',
  `defaultLocale` VARCHAR(45) NULL DEFAULT 'en',
  `autoRegisteredMemberStatus` int(4) DEFAULT '0',
  `uuid` varchar(40) DEFAULT NULL,
  loginTokenId VARCHAR(75) NULL,
  loginTokenKey VARCHAR(75) NULL,
  loginTokenExpirationDate DATETIME NULL,
  UNIQUE `IX_XCOLAB_MEMBERS_SCREEN_NAME` (`screenName`),
  UNIQUE `IX_XCOLAB_MEMBERS_EMAIL_ADDRESS` (`emailAddress`),
  INDEX `IX_XCOLAB_MEMBERS_CREATE_DATE` (`createDate`,`modifiedDate`),
  INDEX `IX_XCOLAB_MEMBERS_MODIFIED_DATE` (`modifiedDate`),
  INDEX `IX_XCOLAB_MEMBERS_FACEBOOK_ID` (`facebookId`),
  INDEX `IX_XCOLAB_MEMBERS_GOOGLE_ID` (`googleId`),
  INDEX `IX_XCOLAB_MEMBERS_COLAB_SSO_ID` (`colabSsoId`),
  INDEX `IX_XCOLAB_MEMBERS_CLIMTE_X_ID` (`climateXId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Role_` (
  `roleId` bigint(20) NOT NULL PRIMARY KEY,
  `companyId` bigint(20) DEFAULT NULL,
  `classNameId` bigint(20) DEFAULT NULL,
  `classPK` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  `title` longtext,
  `description` longtext,
  `type_` int(11) DEFAULT NULL,
  `subtype` varchar(75) DEFAULT NULL,
  `uuid_` varchar(75) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `userName` varchar(75) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `modifiedDate` datetime DEFAULT NULL,
  UNIQUE `IX_A88E424E` (`companyId`,`classNameId`,`classPK`),
  UNIQUE `IX_EBC931B8` (`companyId`,`name`),
  INDEX `IX_449A10B9` (`companyId`),
  INDEX `IX_CBE204` (`type_`,`subtype`),
  INDEX `IX_F436EC8E` (`name`),
  INDEX `IX_5EB4E2FB` (`subtype`),
  INDEX `IX_F3E1C6FC` (`companyId`,`type_`),
  INDEX `IX_F92B66E6` (`type_`),
  INDEX `IX_26DB26C5` (`uuid_`),
  INDEX `IX_B9FF6043` (`uuid_`,`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Users_Roles` (
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  INDEX `IX_C19E5F31` (`roleId`),
  INDEX `IX_C1A01806` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `xcolab_MemberCategory` (
  `roleId` bigint(20) NOT NULL PRIMARY KEY,
  `displayName` varchar(75) DEFAULT NULL,
  `categoryName` varchar(75) DEFAULT NULL,
  `sortOrder` bigint(20) DEFAULT NULL,
  `showInList` tinyint(4) DEFAULT NULL,
  `imageName` varchar(75) DEFAULT NULL,
  `description` varchar(2048) DEFAULT NULL,
  INDEX `IX_B3858EE9` (`displayName`),
  INDEX `IX_8336AE28` (`showInList`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `members_RoleGroupRoles` (
  `roleGroupId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`roleGroupId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `members_RoleGroup` (
  `roleGroupId` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Users_Groups` (
  `userId` bigint(20) NOT NULL,
  `groupId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`groupId`),
  INDEX `IX_C4F9E699` (`groupId`),
  INDEX `IX_F10B6C6B` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `xcolab_StaffMember` (
  `id_` bigint(20) NOT NULL PRIMARY KEY,
  `userId` bigint(20) DEFAULT NULL,
  `categoryId` bigint(20) DEFAULT NULL,
  `firstNames` varchar(75) DEFAULT NULL,
  `lastName` varchar(75) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `photoUrl` varchar(255) DEFAULT NULL,
  `role` varchar(75) DEFAULT NULL,
  `organization` varchar(75) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  INDEX `IX_9C5CE364` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `xcolab_Message` (
  `messageId` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `fromId` bigint(20) DEFAULT NULL,
  `repliesTo` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `subject` varchar(2048) DEFAULT NULL,
  `content` longtext,
  INDEX `IX_9DF5C6F0` (`fromId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `xcolab_MessagingUserPreferences` (
  `messagingPreferencesId` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `userId` bigint(20) DEFAULT NULL,
  `emailOnSend` tinyint(4) DEFAULT NULL,
  `emailOnReceipt` tinyint(4) DEFAULT NULL,
  `emailOnActivity` tinyint(4) DEFAULT NULL,
  `emailActivityDailyDigest` tinyint(4) DEFAULT NULL,
  `dailyMessageLimit` int(11) DEFAULT NULL,
  INDEX `IX_F504493F` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `xcolab_MessageRecipientStatus` (
  `messageRecipientId` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `messageId` bigint(20) DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `threadId` VARCHAR(75) DEFAULT NULL,
  `opened` tinyint(4) DEFAULT NULL,
  `archived` tinyint(4) DEFAULT NULL,
  INDEX `IX_E4B60412` (`messageId`),
  INDEX `IX_76FF2A4C` (`messageId`,`userId`),
  INDEX `IX_74DCC2DA` (`userId`),
  INDEX `IX_88CD5CB0` (`userId`,`archived`),
  INDEX `xcolab_MessageRecipientStatus_threadId_index` (threadId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `xcolab_PlatformTeam` (
    `id_` BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `xcolab_PlatformTeamMember` (
    `userId` BIGINT(20) NOT NULL,
    `teamId` BIGINT(20) NOT NULL,
    PRIMARY KEY (userId, teamId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




-- Candidates to move to tracking-service

CREATE TABLE IF NOT EXISTS `xcolab_LoginLog` (
  `pk` bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `userId` bigint(20) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `ipAddress` varchar(75) DEFAULT NULL,
  `city` varchar(75) DEFAULT NULL,
  `country` varchar(75) DEFAULT NULL,
  `entryUrl` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `xcolab_AnalyticsUserEvent` (
  `userId` bigint(20) NOT NULL,
  `idString` varchar(75) NOT NULL,
  `category` varchar(75) DEFAULT NULL,
  `action` varchar(75) DEFAULT NULL,
  `label` varchar(75) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`userId`,`idString`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;*/


--
-- Table structure for table `user__platform_team`
--

DROP TABLE IF EXISTS `user__platform_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__platform_team` (
                                       `id` bigint NOT NULL AUTO_INCREMENT,
                                       `name` varchar(256) DEFAULT NULL,
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user__platform_team_member`
--

DROP TABLE IF EXISTS `user__platform_team_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__platform_team_member` (
                                              `user_id` bigint NOT NULL,
                                              `team_id` bigint NOT NULL,
                                              PRIMARY KEY (`user_id`,`team_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user__role`
--

DROP TABLE IF EXISTS `user__role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__role` (
                              `id` bigint NOT NULL,
                              `name` varchar(75) DEFAULT NULL,
                              `title` longtext,
                              `description` longtext,
                              `created_at` datetime DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user__role_group`
--

DROP TABLE IF EXISTS `user__role_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__role_group` (
                                    `id` bigint NOT NULL AUTO_INCREMENT,
                                    `name` varchar(255) DEFAULT NULL,
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user__role_group_role`
--

DROP TABLE IF EXISTS `user__role_group_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__role_group_role` (
                                         `role_group_id` bigint NOT NULL,
                                         `role_id` bigint NOT NULL,
                                         PRIMARY KEY (`role_group_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user__sso_client_details`
--

DROP TABLE IF EXISTS `user__sso_client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__sso_client_details` (
                                            `id` varchar(50) NOT NULL,
                                            `secret` varchar(50) DEFAULT NULL,
                                            `scope` varchar(50) DEFAULT NULL,
                                            `registeredRedirectUri` varchar(191) DEFAULT NULL,
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user__staff_member`
--

DROP TABLE IF EXISTS `user__staff_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__staff_member` (
                                      `id` bigint NOT NULL AUTO_INCREMENT,
                                      `user_id` bigint DEFAULT NULL,
                                      `category_id` bigint DEFAULT NULL,
                                      `first_names` varchar(75) DEFAULT NULL,
                                      `last_name` varchar(75) DEFAULT NULL,
                                      `url` varchar(255) DEFAULT NULL,
                                      `photo_url` varchar(255) DEFAULT NULL,
                                      `role` varchar(75) DEFAULT NULL,
                                      `organization` varchar(75) DEFAULT NULL,
                                      `sort_order` int DEFAULT NULL,
                                      PRIMARY KEY (`id`),
                                      KEY `IX_9C5CE364` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;



-- Table structure for table `user__user_role`
--

DROP TABLE IF EXISTS `user__user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__user_role` (
                                   `user_id` bigint NOT NULL,
                                   `role_id` bigint NOT NULL,
                                   PRIMARY KEY (`user_id`,`role_id`),
                                   KEY `IX_C19E5F31` (`role_id`),
                                   KEY `IX_C1A01806` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users_groups`
--

DROP TABLE IF EXISTS `users_groups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_groups` (
                                `userId` bigint NOT NULL,
                                `groupId` bigint NOT NULL,
                                PRIMARY KEY (`userId`,`groupId`),
                                KEY `IX_C4F9E699` (`groupId`),
                                KEY `IX_F10B6C6B` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Table structure for table `user__analytics_user_event`
--

                                DROP TABLE IF EXISTS `user__analytics_user_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__analytics_user_event` (
                                              `user_id` bigint NOT NULL,
                                              `id_string` varchar(75) NOT NULL,
                                              `category` varchar(75) DEFAULT NULL,
                                              `action` varchar(75) DEFAULT NULL,
                                              `label` varchar(75) DEFAULT NULL,
                                              `value` int DEFAULT NULL,
                                              `created_at` datetime DEFAULT NULL,
                                              PRIMARY KEY (`user_id`,`id_string`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `user__login_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__login_log` (
                                   `id` bigint NOT NULL AUTO_INCREMENT,
                                   `user_id` bigint DEFAULT NULL,
                                   `created_at` datetime DEFAULT NULL,
                                   `ip_address` varchar(75) DEFAULT NULL,
                                   `city` varchar(75) DEFAULT NULL,
                                   `country` varchar(75) DEFAULT NULL,
                                   `entry_url` varchar(255) DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `user__member_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__member_category` (
                                         `role_id` bigint NOT NULL,
                                         `display_name` varchar(75) DEFAULT NULL,
                                         `category_name` varchar(75) DEFAULT NULL,
                                         `sort_order` bigint DEFAULT NULL,
                                         `show_in_list` tinyint DEFAULT NULL,
                                         `image_name` varchar(75) DEFAULT NULL,
                                         `description` varchar(2048) DEFAULT NULL,
                                         PRIMARY KEY (`role_id`),
                                         KEY `IX_B3858EE9` (`display_name`),
                                         KEY `IX_8336AE28` (`show_in_list`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `user__message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__message` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `from_id` bigint DEFAULT NULL,
                                 `replies_to` bigint DEFAULT NULL,
                                 `created_at` datetime DEFAULT NULL,
                                 `subject` varchar(2048) DEFAULT NULL,
                                 `content` longtext,
                                 PRIMARY KEY (`id`),
                                 KEY `IX_9DF5C6F0` (`from_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `user__message_recipient_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__message_recipient_status` (
                                                  `id` bigint NOT NULL AUTO_INCREMENT,
                                                  `message_id` bigint DEFAULT NULL,
                                                  `user_id` bigint DEFAULT NULL,
                                                  `thread_id` varchar(75) DEFAULT NULL,
                                                  `opened` tinyint DEFAULT NULL,
                                                  `archived` tinyint DEFAULT NULL,
                                                  PRIMARY KEY (`id`),
                                                  KEY `IX_E4B60412` (`message_id`),
                                                  KEY `IX_76FF2A4C` (`message_id`,`user_id`),
                                                  KEY `IX_74DCC2DA` (`user_id`),
                                                  KEY `IX_88CD5CB0` (`user_id`,`archived`),
                                                  KEY `xcolab_MessageRecipientStatus_threadId_index` (`thread_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `user__messaging_user_preference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user__messaging_user_preference` (
                                                   `id` bigint NOT NULL AUTO_INCREMENT,
                                                   `user_id` bigint DEFAULT NULL,
                                                   `email_on_send` tinyint DEFAULT NULL,
                                                   `email_on_receipt` tinyint DEFAULT NULL,
                                                   `email_on_activity` tinyint DEFAULT NULL,
                                                   `email_activity_daily_digest` tinyint DEFAULT NULL,
                                                   `daily_message_limit` int DEFAULT NULL,
                                                   `email_activity_weekly_digest` tinyint DEFAULT NULL,
                                                   PRIMARY KEY (`id`),
                                                   KEY `IX_F504493F` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

