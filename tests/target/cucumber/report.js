$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/colabupmtest/features/comments.feature");
formatter.feature({
  "name": "Publicacion comentarios miembros",
  "description": "  Como usuario quiero poder crear comentarios en los concurso y las propuestas para colaborar en la plataforma",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@comments"
    }
  ]
});
formatter.scenario({
  "name": "Comentar concurso sin iniciar sesion - mensaje alerta",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@comments"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to the contest details of \"Concurso 1\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.go_to_the_contest_details_of(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Discuss Button",
  "keyword": "When "
});
formatter.match({
  "location": "CommentsSteps.click_on_Discuss_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the comment section opens",
  "keyword": "Then "
});
formatter.match({
  "location": "CommentsSteps.the_comment_section_opens()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the advise message appear with the text \"Debes ingresar a tu cuenta para publicar un comentario.\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.the_advise_message_appear_with_the_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Comentar propuesta sin iniciar sesion - solicitar inicio de sesion",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@comments"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to any proposal details",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.go_to_any_proposal_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on comments tab",
  "keyword": "When "
});
formatter.match({
  "location": "CommentsSteps.click_on_comments_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Write a comment as \"Esto es un comentario\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_comment_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on add comment button",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_add_comment_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a signin form opens",
  "keyword": "Then "
});
formatter.match({
  "location": "CommentsSteps.a_signin_form_opens()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Comentar concurso Nombre autor comentario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@comments"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@DeleteCommentAfterExecution"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to the contest details of \"Concurso 1\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.go_to_the_contest_details_of(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Discuss Button",
  "keyword": "When "
});
formatter.match({
  "location": "CommentsSteps.click_on_Discuss_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Write a comment as \"Esto es un comentario\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_comment_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on add comment button",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_add_comment_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the autor name is \"20190108215141311\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CommentsSteps.the_autor_name_is(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Contador comentarios concurso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@comments"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@DeleteCommentAfterExecution"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to the contest details of \"Concurso 1\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.go_to_the_contest_details_of(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Discuss Button",
  "keyword": "When "
});
formatter.match({
  "location": "CommentsSteps.click_on_Discuss_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Write a comment as \"Esto es un comentario\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_comment_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on add comment button",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_add_comment_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "comment counter increases in 1",
  "keyword": "Then "
});
formatter.match({
  "location": "CommentsSteps.the_comment_counter_increase_in_one(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Comentario propuesta publico",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@comments"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@DeleteCommentAfterExecution"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to any proposal details",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.go_to_any_proposal_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on comments tab",
  "keyword": "When "
});
formatter.match({
  "location": "CommentsSteps.click_on_comments_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Write a comment as \"Esto es un comentario\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_comment_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on add comment button",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_add_comment_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the comment is public",
  "keyword": "Then "
});
formatter.match({
  "location": "CommentsSteps.the_comment_is_public()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Editar comentario",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@comments"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@DeleteCommentAfterExecution"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to the contest details of \"Concurso 1\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.go_to_the_contest_details_of(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Discuss Button",
  "keyword": "When "
});
formatter.match({
  "location": "CommentsSteps.click_on_Discuss_Button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Write a comment as \"Esto es un comentario que se va a editar\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_comment_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on add comment button",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_add_comment_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on edit link",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_edit_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Write a comment as \"Esto es un comentario editado\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_comment_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_save()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the comment has changed",
  "keyword": "Then "
});
formatter.match({
  "location": "CommentsSteps.the_comment_has_changed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Borrar comentario propuesta",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@comments"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to any proposal details",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.go_to_any_proposal_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on comments tab",
  "keyword": "When "
});
formatter.match({
  "location": "CommentsSteps.click_on_comments_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Write a comment as \"Esto es un comentario para borrar\"",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_comment_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on add comment button",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_add_comment_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on delete comment link",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_delete_comment_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the new comment is deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "CommentsSteps.the_comment_is_deleted()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the comment counter decrease in 1",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.the_comment_counter_decrease_in_one(int)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Crear nuevo debate General",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@comments"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Community Section",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.go_to_Community_Section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on discussion tab",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_discussion_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "create new discussion",
  "keyword": "When "
});
formatter.match({
  "location": "CommentsSteps.create_new_discussion()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select \"General Discussion\" as category",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.select_as_category(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "write a tittle",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_tittle()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "write a comment",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_comment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on add",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_add()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a discussion is created",
  "keyword": "Then "
});
formatter.match({
  "location": "CommentsSteps.a_discussion_is_created()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "is shown in \"General Discussion\" Section",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.is_shown_in_Section(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Crear nuevo debate Bugs y mejoras",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@comments"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Community Section",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.go_to_Community_Section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on discussion tab",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_discussion_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "create new discussion",
  "keyword": "When "
});
formatter.match({
  "location": "CommentsSteps.create_new_discussion()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select \"Report bugs and request features\" as category",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.select_as_category(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "write a tittle",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_tittle()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "write a comment",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.write_a_comment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on add",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.click_on_add()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a discussion is created",
  "keyword": "Then "
});
formatter.match({
  "location": "CommentsSteps.a_discussion_is_created()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "is shown in \"Report bugs and request features\" Section",
  "keyword": "And "
});
formatter.match({
  "location": "CommentsSteps.is_shown_in_Section(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/colabupmtest/features/contest.feature");
formatter.feature({
  "name": "Concursos web colaborativa",
  "description": "  Como administrador quiero poder gestionar los concursos de la web colaborativa",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@contests"
    }
  ]
});
formatter.scenario({
  "name": "Creacion concurso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Create New Contest",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.createNewContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a new contest is created",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkNewContestIsCreated()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Mostrar pagina concurso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on view contest button",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.clickOnViewContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the contest is shown",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkContestPageIsShown()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Creacion resource page en concurso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Resources Page",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToResourcesPageMenu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on create Resources Page",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.clickOnCreateResourcePageButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "fill the fields",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.fillResourcesPageFields()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save resources",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.clickOnSaveResourcesButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the contest has a link to resources page",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkResourcesPageLinkInContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the resources is shown",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.getResourcesViewParagraphs()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Seleccionar ontology",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Ontologies",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToOntologyMenu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "change ontologies",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.changeOntologies()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save ontologies",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.clickOnSaveOntologyButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the contest show selected ontologies",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkOntologiesInContest()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Publicar concurso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select a contest",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.selectContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select Public not private option",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.selectPublicContestOption()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on submit",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.clickOnSubmit()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the contest is shown in contest section whith grid view",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkIfContestIsPublic()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "in list view",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.checkIfContestIsVisibleInListMode()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Seleccionar concursos que se muestran en la pagina principal",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on edit contest preferences",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.clickOnEditContestPreferences()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select the contest which will be shown",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.selectContestToShowInMainPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save button",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.clickOnSave()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to main page",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.returnToMainPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the selected contests is being shown in the main page",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkIfContestsAreVisibleInMainPage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Seleccionar los miembros del equipo que componen un concurso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to team",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToTeamSelection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "add members team",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.addMemberTeam()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save team",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.clickOnSaveTeam()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the team members are shown in the contest page",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkIfTeamIsShownInContestPage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Eliminar los miembros del equipo que componen un concurso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to team",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToTeamSelection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "delete members team",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.deleteMemberTeam()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save team",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.clickOnSaveTeam()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the team members are not shown in the contest page",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkTeamNotShownInContestPage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Edicion titulo concurso con tildes",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "set the new title with quotes",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.writeNewTitleContestWithAccentMark()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save description",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.saveDescription()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the title is changed",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkIfTitleContestIsChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Superar Limite characters length titulo",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "set a title with 76 characters length",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.introduce_un_titulo_con_caracteres(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save description",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.saveDescription()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appear the next error \"The contest title must be at least 3 characters and not more than 75 characters.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.aparece_un_error_con_el_siguiente_texto(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "No superar limite characters length titulo",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "set a title with 75 characters length",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.introduce_un_titulo_con_caracteres(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save description",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.saveDescription()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the title is changed",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkIfTitleContestIsChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Superar limite characters length pregunta",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "set a question with 1025 characters length",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.introduce_una_pregunta_con_caracteres(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save description",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.saveDescription()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appear the next error \"The contest question must be at least 3 characters and not more than 1024 characters.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.aparece_un_error_con_el_siguiente_texto(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Limite characters length pregunta concurso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "set a question with 1024 characters length",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.introduce_una_pregunta_con_caracteres(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save description",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.saveDescription()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the contest question is changed",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkIfQuestionContestIsChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Superar limite characters length descripcion concurso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "set a description with 10001 characters length",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.introduce_una_descripci_n_con_caracteres(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save description",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.saveDescription()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "appear the next error \"The contest description must have not more than 10000 characters (including html tags).\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.aparece_un_error_con_el_siguiente_texto(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "No Superar limite characters length descripcion concurso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@contests"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the title of the contest which will be change",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.goToEditContest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "set a description with 9900 characters length",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.introduce_una_descripci_n_con_caracteres(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "save description",
  "keyword": "And "
});
formatter.match({
  "location": "ContestSteps.saveDescription()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the contest description is changed",
  "keyword": "Then "
});
formatter.match({
  "location": "ContestSteps.checkIfDescriptionContestIsChanged()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/colabupmtest/features/createuser.feature");
formatter.feature({
  "name": "Registro de usuario",
  "description": "  Como usuario quiero poder crear perfiles de miembro para acceder a la plataforma",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@register"
    }
  ]
});
formatter.scenario({
  "name": "Crear usuario con campo screename vacio",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Screen Name is not filled",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Screen_Name_is_not_filled()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field email is filled with an valid email",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_email_is_filled_with_an_valid_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field First Name is filled with a valid First Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_First_Name_is_filled_with_a_valid_First_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Last Name is filled with a valid Last Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Last_Name_is_filled_with_a_valid_Last_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Password is filled with a valid Password such as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Password_is_filled_with_a_valid_Password_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Retype Password is filled with the same value that the field Password: \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Retype_Password_is_filled_with_the_same_value_that_the_field_Password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Country is filled with a valid country selection",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Country_is_filled_with_a_valid_country_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Short bio is filled with a short text such as \"Example of short Bio\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Short_bio_is_filled_with_a_short_text_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the button Create account",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.click_on_the_button_Create_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a message appears under screen name field with the next text: \"El nombre de usuario debe tener entre 3 y 26 caracteres.Por favor, elija un nombre de usuario.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.a_message_appears_under_screen_name_field_with_the_next_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Crear usuario con campo screenname con caracteres especiales",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Screen Name is filled with a name such as \"name.with.special.characters\"",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Screen_Name_is_filled_with_a_name_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field email is filled with an valid email",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_email_is_filled_with_an_valid_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field First Name is filled with a valid First Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_First_Name_is_filled_with_a_valid_First_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Last Name is filled with a valid Last Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Last_Name_is_filled_with_a_valid_Last_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Password is filled with a valid Password such as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Password_is_filled_with_a_valid_Password_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Retype Password is filled with the same value that the field Password: \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Retype_Password_is_filled_with_the_same_value_that_the_field_Password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Country is filled with a valid country selection",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Country_is_filled_with_a_valid_country_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Short bio is filled with a short text such as \"Example of short Bio\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Short_bio_is_filled_with_a_short_text_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the button Create account",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.click_on_the_button_Create_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a message appears under screen name with error format message",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.a_message_appears_under_screen_name_with_error_format_message()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Crear usuario con campo email vacio",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Screen Name is filled with a valid screen name",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Screen_Name_is_filled_with_a_valid_screen_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field First Name is filled with a valid First Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_First_Name_is_filled_with_a_valid_First_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Last Name is filled with a valid Last Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Last_Name_is_filled_with_a_valid_Last_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Password is filled with an invalid Password such as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Password_is_filled_with_an_invalid_Password_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Retype Password is filled with the same value that the field Password: \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Retype_Password_is_filled_with_the_same_value_that_the_field_Password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Country is filled with a valid country selection",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Country_is_filled_with_a_valid_country_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Short bio is filled with a short text such as \"Example of short Bio\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Short_bio_is_filled_with_a_short_text_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the button Create account",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.click_on_the_button_Create_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a message appears under email field with: Por favor, introduzca su direccion de correo electronico.",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.a_message_appears_under_email_field_with_the_next_text()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Crear usuario con contraseña inferior a 8 caracteres",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Screen Name is filled with a valid screen name",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Screen_Name_is_filled_with_a_valid_screen_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field email is filled with an valid email",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_email_is_filled_with_an_valid_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field First Name is filled with a valid First Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_First_Name_is_filled_with_a_valid_First_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Last Name is filled with a valid Last Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Last_Name_is_filled_with_a_valid_Last_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Password is filled with an invalid Password such as \"Pass\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Password_is_filled_with_an_invalid_Password_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Retype Password is filled with the same value that the field Password: \"Pass\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Retype_Password_is_filled_with_the_same_value_that_the_field_Password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Country is filled with a valid country selection",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Country_is_filled_with_a_valid_country_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Short bio is filled with a short text such as \"Example of short Bio\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Short_bio_is_filled_with_a_short_text_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the button Create account",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.click_on_the_button_Create_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a message appears under password field with: La contrasenia debe tener al menos 8 caracteres",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.a_message_appears_under_password_field_with_the_next_text()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Crear usuario con contraseñas no coincidentes",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Screen Name is filled with a valid screen name",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Screen_Name_is_filled_with_a_valid_screen_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field email is filled with an valid email",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_email_is_filled_with_an_valid_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field First Name is filled with a valid First Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_First_Name_is_filled_with_a_valid_First_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Last Name is filled with a valid Last Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Last_Name_is_filled_with_a_valid_Last_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Password is filled with a valid Password such as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Password_is_filled_with_a_valid_Password_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Retype Password is filled with the same value that the field Password: \"Password124\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Retype_Password_is_filled_with_the_same_value_that_the_field_Password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Country is filled with a valid country selection",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Country_is_filled_with_a_valid_country_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Short bio is filled with a short text such as \"Example of short Bio\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Short_bio_is_filled_with_a_short_text_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the button Create account",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.click_on_the_button_Create_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a message appears with the next text: Las contrasenias introducidas no coinciden.",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.a_message_appears_with_the_next_text()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Crear usuario con campo country sin seleccionar",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Screen Name is filled with a valid screen name",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Screen_Name_is_filled_with_a_valid_screen_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field email is filled with an valid email",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_email_is_filled_with_an_valid_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field First Name is filled with a valid First Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_First_Name_is_filled_with_a_valid_First_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Last Name is filled with a valid Last Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Last_Name_is_filled_with_a_valid_Last_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Password is filled with a valid Password such as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Password_is_filled_with_a_valid_Password_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Retype Password is filled with the same value that the field Password: \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Retype_Password_is_filled_with_the_same_value_that_the_field_Password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Country is not filled with a valid country selection",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Country_is_not_filled_with_a_valid_country_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Short bio is filled with a short text such as \"Example of short Bio\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Short_bio_is_filled_with_a_short_text_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the button Create account",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.click_on_the_button_Create_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a message appears under country field with the next text: \"Seleccione un pais de la lista anterior.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.a_message_appears_under_country_field_with_the_next_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Crear usuario nombre usuario ya existente",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Screen Name is filled with a already used name such as \"solmedo\"",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Screen_Name_is_filled_with_a_already_used_name_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field email is filled with an valid email",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_email_is_filled_with_an_valid_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field First Name is filled with a valid First Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_First_Name_is_filled_with_a_valid_First_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Last Name is filled with a valid Last Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Last_Name_is_filled_with_a_valid_Last_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Password is filled with a valid Password such as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Password_is_filled_with_a_valid_Password_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Retype Password is filled with the same value that the field Password: \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Retype_Password_is_filled_with_the_same_value_that_the_field_Password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Country is filled with a valid country selection",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Country_is_filled_with_a_valid_country_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the button Create account",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.click_on_the_button_Create_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a message appears under screen name field with the next text: \"Ya existe un miembro con el mismo nombre de usuario.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.a_message_appears_under_screen_name_field_with_the_next_text(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Crear usuario mail ya usado",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Screen Name is filled with a valid screen name",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Screen_Name_is_filled_with_a_valid_screen_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field email is filled with an already used email such as \"s.olmedo13@gmail.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_email_is_filled_with_an_already_used_email_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field First Name is filled with a valid First Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_First_Name_is_filled_with_a_valid_First_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Last Name is filled with a valid Last Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Last_Name_is_filled_with_a_valid_Last_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Password is filled with a valid Password such as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Password_is_filled_with_a_valid_Password_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Retype Password is filled with the same value that the field Password: \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Retype_Password_is_filled_with_the_same_value_that_the_field_Password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Country is filled with a valid country selection",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Country_is_filled_with_a_valid_country_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the button Create account",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.click_on_the_button_Create_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a message appears under email field with: \"Ya existe un miembro con la misma direccion de correo electronico.\".",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.a_message_appears_under_email_field_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Crear usuario sin biografia",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Screen Name is filled with a valid screen name",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Screen_Name_is_filled_with_a_valid_screen_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field email is filled with an valid email",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_email_is_filled_with_an_valid_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field First Name is filled with a valid First Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_First_Name_is_filled_with_a_valid_First_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Last Name is filled with a valid Last Name",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Last_Name_is_filled_with_a_valid_Last_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Password is filled with a valid Password such as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Password_is_filled_with_a_valid_Password_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Retype Password is filled with the same value that the field Password: \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Retype_Password_is_filled_with_the_same_value_that_the_field_Password(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the field Country is filled with a valid country selection",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.the_field_Country_is_filled_with_a_valid_country_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the button Create account",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUserSteps.click_on_the_button_Create_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user is created",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.a_user_is_created()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Enlace a terminos de uso",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Terminos de uso",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.click_on_Terminos_de_uso()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is redirect to \"/page/Terms-of-use\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.the_user_is_redirect_to(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Enlace a filosofia y politica de la comunidad",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@register"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "the user registration page in spanish language",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUserSteps.the_user_registration_page_in_spanish_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Filosofia y politica comunitaria",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUserSteps.click_on_Filosof_a_y_pol_tica_comunitaria()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user is redirect to \"/page/Community-philosophy-and-policies\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUserSteps.the_user_is_redirect_to(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/colabupmtest/features/edituser.feature");
formatter.feature({
  "name": "Edición de usuario",
  "description": "  Como usuario quiero poder editar mis datos de usuario en la plataforma para mantener mi perfil actualizado",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@edituser"
    }
  ]
});
formatter.scenario({
  "name": "Cambiar nombre",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edituser"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108210241542\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he has accessed to edition profile page",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_has_accessed_to_edition_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he change the name",
  "keyword": "When "
});
formatter.match({
  "location": "EditUserSteps.he_change_the_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the name is changed in the profile page",
  "keyword": "Then "
});
formatter.match({
  "location": "EditUserSteps.the_name_is_changed_in_the_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar apellido",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edituser"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108210241542\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he has accessed to edition profile page",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_has_accessed_to_edition_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he change the last name",
  "keyword": "When "
});
formatter.match({
  "location": "EditUserSteps.he_change_the_last_name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the last name is changed in the profile page",
  "keyword": "Then "
});
formatter.match({
  "location": "EditUserSteps.the_last_name_is_changed_in_the_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar pais",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edituser"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108210241542\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he has accessed to edition profile page",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_has_accessed_to_edition_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he change the country",
  "keyword": "When "
});
formatter.match({
  "location": "EditUserSteps.he_change_the_country()"
});
formatter.result({
  "error_message": "org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element \u003ca onclick\u003d\"updateTextarea();jQuery(\u0027#updateUserProfileForm\u0027).submit();\" href\u003d\"javascript:;\" class\u003d\"btn btn-primary\"\u003e...\u003c/a\u003e is not clickable at point (440, 906). Other element would receive the click: \u003cmain id\u003d\"content\" class\u003d\"container clearfix\"\u003e...\u003c/main\u003e\n  (Session info: chrome\u003d74.0.3729.169)\n  (Driver info: chromedriver\u003d74.0.3729.6 (255758eccf3d244491b8a1317aa76e1ce10d57e9-refs/branch-heads/3729@{#29}),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.13.0\u0027, revision: \u00272f0d292\u0027, time: \u00272018-06-25T15:24:21.231Z\u0027\nSystem info: host: \u0027SERGIO\u0027, ip: \u0027192.168.1.41\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_171\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 74.0.3729.6 (255758eccf3d24..., userDataDir: C:\\Users\\Solmedo\\AppData\\Lo...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:58557}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), rotatable: false, setWindowRect: true, strictFileInteractability: false, takesHeapSnapshot: true, takesScreenshot: true, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unexpectedAlertBehaviour: ignore, unhandledPromptBehavior: ignore, version: 74.0.3729.169, webStorageEnabled: true}\nSession ID: a6a710e1138e7729b7241cc90f964148\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:548)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:276)\r\n\tat org.openqa.selenium.remote.RemoteWebElement.click(RemoteWebElement.java:83)\r\n\tat sun.reflect.GeneratedMethodAccessor11.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:51)\r\n\tat com.sun.proxy.$Proxy16.click(Unknown Source)\r\n\tat colabupmtest.pageobjects.ProfileEditionPage.clickOnSave(ProfileEditionPage.java:57)\r\n\tat colabupmtest.pageobjects.ProfileEditionPage.changeCountry(ProfileEditionPage.java:70)\r\n\tat colabupmtest.steps.EditUserSteps.he_change_the_country(EditUserSteps.java:71)\r\n\tat ✽.he change the country(file:src/test/resources/colabupmtest/features/edituser.feature:46)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "the country is changed in the profile page",
  "keyword": "Then "
});
formatter.match({
  "location": "EditUserSteps.the_country_is_changed_in_the_profile_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar contrasenia",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edituser"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108210241542\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he has accessed to edition profile page",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_has_accessed_to_edition_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Contrasenia actual with the actual password as \"Password123\"",
  "keyword": "When "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Contrasenia_actual_with_the_actual_password_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Nueva contrasenia with \"newpassword\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Nueva_contrasenia_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Reescriba la nueva contrasela with \"newpassword\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Reescriba_la_nueva_contrasela_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Guardar",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.click_on_Guardar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "try to change the password to \"Password123\" again with the old password \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.try_to_change_the_password_again_with_the_old_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "next message is shown: \"Password change failed: Current password is incorrect.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EditUserSteps.next_message_is_shown(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the password can be changed to \"Password123\" if use \"newpassword\"",
  "keyword": "But "
});
formatter.match({
  "location": "EditUserSteps.the_password_can_be_changed_if_use(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar correo electronico",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edituser"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108210241542\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he has accessed to edition profile page",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_has_accessed_to_edition_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Nuevo correo electronico with a new email",
  "keyword": "When "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Nuevo_correo_electronico_with_a_new_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Guardar",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.click_on_Guardar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the email is changed in the profile page",
  "keyword": "Then "
});
formatter.match({
  "location": "EditUserSteps.the_email_is_changed_in_the_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar correo electronico con correo ya usado",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edituser"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108210241542\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he has accessed to edition profile page",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_has_accessed_to_edition_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Nuevo correo electronico with an already exist mail such as \"s.olmedo13@gmail.com\"",
  "keyword": "When "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Nuevo_correo_electronico_with_an_already_exist_mail_such_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Guardar",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.click_on_Guardar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "next message is shown: \"Ya existe un miembro con la misma direccion de correo electronico.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EditUserSteps.next_message_is_shown(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar contrasenia con contrasenia actual invalida",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edituser"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108210241542\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he has accessed to edition profile page",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_has_accessed_to_edition_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Contrasenia actual with an incorrect actual password as \"Password124\"",
  "keyword": "When "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Contrasenia_actual_with_an_incorrect_actual_password_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Nueva contrasenia with \"newpassword\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Nueva_contrasenia_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Reescriba la nueva contrasenia with \"newpassword\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Reescriba_la_nueva_contrasenia_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Guardar",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.click_on_Guardar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "next message is shown: \"Password change failed: Current password is incorrect.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EditUserSteps.next_message_is_shown(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar contrasenias no coincidentes",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edituser"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108210241542\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he has accessed to edition profile page",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_has_accessed_to_edition_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Contrasenia actual with actual password as \"Password123\"",
  "keyword": "When "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Contrasenia_actual_with_actual_password_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Nueva contrasenia with \"newpassword\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Nueva_contrasenia_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Reescriba la nueva contrasenia with \"newpasswords\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Reescriba_la_nueva_contrasenia_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Guardar",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.click_on_Guardar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "next message is shown: \"Las contrasenias introducidas no coinciden.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EditUserSteps.next_message_is_shown(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar contrasenias longitud no valida",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@edituser"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108210241542\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he has accessed to edition profile page",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_has_accessed_to_edition_profile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Contrasenia actual with actual password as \"Password123\"",
  "keyword": "When "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Contrasenia_actual_with_actual_password_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Nueva contrasenia with \"new\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Nueva_contrasenia_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he fill the field Reescriba la nueva contrasenia with \"new\"",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.he_fill_the_field_Reescriba_la_nueva_contrasenia_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Guardar",
  "keyword": "And "
});
formatter.match({
  "location": "EditUserSteps.click_on_Guardar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "next message is shown: \"La contrasenia debe tener al menos 8 caracteres\"",
  "keyword": "Then "
});
formatter.match({
  "location": "EditUserSteps.next_message_is_shown(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/colabupmtest/features/login.feature");
formatter.feature({
  "name": "Login",
  "description": "  Como usuario quiero poder acceder a la plataforma de colaboración con mi usuario y contraseña.",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@login"
    }
  ]
});
formatter.scenario({
  "name": "Usuario y password correctos",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on enter button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.clickEnter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insert a valid credentials",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.insertValidUserAndPassword()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user sign in",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.checkUserLoged()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Datos de acceso incorrectos mensaje de error",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on enter button",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.clickEnter()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "insert a invalid credentials",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.insertInvalidUserAndPassword()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the message \"Error de autenticación, comprueba tu nombre de usuario y contraseña.\" is shown",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.checkErrorLoginMessageText(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cerrar sesion",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@login"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on close session",
  "keyword": "When "
});
formatter.match({
  "location": "LoginSteps.closeSession()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the session closed rightly",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.checkLogOut()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/colabupmtest/features/proposals.feature");
formatter.feature({
  "name": "Gestion propuestas concurso",
  "description": "  Como usuario quiero poder crear y gestionar mis propuestas para participar en los concursos",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Proposals"
    }
  ]
});
formatter.scenario({
  "name": "Concurso donde no se ha abierto el periodo de propuestas y usuario verificado en la plataforma",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Proposals"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter in a contest where the proposal creation is not still open as \"Concurso 2\"",
  "keyword": "When "
});
formatter.match({
  "location": "ProposalsSteps.enter_in_a_contest_where_the_proposal_creation_is_not_still_open(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the button to create proposal is not shown",
  "keyword": "Then "
});
formatter.match({
  "location": "ProposalsSteps.the_button_to_create_proposal_is_not_shown()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Creación de concurso con nombre de equipo",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Proposals"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter in a contest where the proposal creation is open as \"Concurso 1\"",
  "keyword": "When "
});
formatter.match({
  "location": "ProposalsSteps.enter_in_acontest_where_the_proposal_creation_is_open(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the button to create a new proposal",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.click_on_the_button_to_create_a_new_proposal()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "fill mandatory fields",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.fill_mandatory_fields()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "fill the field Team Name",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.fill_the_field_Team_Name()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "fill optional sections",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.fill_optional_sections()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on save and PUBLISH changes button",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.click_on_save_and_PUBLISH_changes_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "accept the Contest Rules",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.acceptTheContestRules()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the proposal is created with the provided information",
  "keyword": "Then "
});
formatter.match({
  "location": "ProposalsSteps.the_proposal_is_created_with_the_provided_information()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the name that appears in the proposal is that of the team",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.the_name_that_appears_in_the_proposal_is_that_of_the_team()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Apoyar propuesta",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Proposals"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190109175748648\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter in a contest where the proposal creation is open as \"Concurso 1\"",
  "keyword": "When "
});
formatter.match({
  "location": "ProposalsSteps.enter_in_acontest_where_the_proposal_creation_is_open(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter in a proposal details of a proposal created by member \"20190108215141311\"",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.enter_in_a_proposal_details_of_a_proposal_created_by_member(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contributors section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.go_to_contributors_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Support proposal button",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.click_on_Support_proposal_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user \"20190109175748648\" is added to support proposal",
  "keyword": "Then "
});
formatter.match({
  "location": "ProposalsSteps.the_user_is_added_to_support_proposal(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat colabupmtest.steps.ProposalsSteps.the_user_is_added_to_support_proposal(ProposalsSteps.java:186)\r\n\tat ✽.the user \"20190109175748648\" is added to support proposal(file:src/test/resources/colabupmtest/features/proposals.feature:100)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Retirar apoyo propuesta",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Proposals"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190109175748648\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter in a contest where the proposal creation is open as \"Concurso 1\"",
  "keyword": "When "
});
formatter.match({
  "location": "ProposalsSteps.enter_in_acontest_where_the_proposal_creation_is_open(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter in a proposal details of a proposal created by member \"20190108215141311\"",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.enter_in_a_proposal_details_of_a_proposal_created_by_member(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contributors section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.go_to_contributors_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Retract support",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.click_on_Retract_support()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user \"20190109175748648\" is removed to support proposal",
  "keyword": "Then "
});
formatter.match({
  "location": "ProposalsSteps.the_user_is_removed_to_support_proposal(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat colabupmtest.steps.ProposalsSteps.the_user_is_removed_to_support_proposal(ProposalsSteps.java:198)\r\n\tat ✽.the user \"20190109175748648\" is removed to support proposal(file:src/test/resources/colabupmtest/features/proposals.feature:110)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Eliminar propuesta",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Proposals"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"member\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"20190108215141311\" and password as \"Password123\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter in a contest where the proposal creation is open as \"Concurso 1\"",
  "keyword": "When "
});
formatter.match({
  "location": "ProposalsSteps.enter_in_acontest_where_the_proposal_creation_is_open(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter in a proposal details of a proposal created by member \"20190108215141311\"",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.enter_in_a_proposal_details_of_a_proposal_created_by_member(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to admin section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.go_to_admin_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on delete proposal",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.click_on_delete_proposal()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the proposal is deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "ProposalsSteps.the_proposal_is_deleted()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/colabupmtest/features/proposalstemplate.feature");
formatter.feature({
  "name": "Plantillas propuestas",
  "description": "  Como usuario quiero poder editar las plantillas de las propuestas de los concursos para poder adaptarlas a las necesidades del concurso",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ProposalTemplate"
    }
  ]
});
formatter.scenario({
  "name": "creacion plantilla propuesta",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ProposalTemplate"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on proposal template tab",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.clickOnProposalTemplateTab()"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for text (\u0027Plantilla Ã�reas de Trabajo\u0027) to be the value of element [[ChromeDriver: chrome on XP (3349d6ea2ea181f66dccfd1c03c1c011)] -\u003e id: templateName] (tried for 5 second(s) with 500 milliseconds interval)\nBuild info: version: \u00273.13.0\u0027, revision: \u00272f0d292\u0027, time: \u00272018-06-25T15:24:21.231Z\u0027\nSystem info: host: \u0027SERGIO\u0027, ip: \u0027192.168.1.41\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_171\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 74.0.3729.6 (255758eccf3d24..., userDataDir: C:\\Users\\Solmedo\\AppData\\Lo...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:59256}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), rotatable: false, setWindowRect: true, strictFileInteractability: false, takesHeapSnapshot: true, takesScreenshot: true, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unexpectedAlertBehaviour: ignore, unhandledPromptBehavior: ignore, version: 74.0.3729.169, webStorageEnabled: true}\nSession ID: 3349d6ea2ea181f66dccfd1c03c1c011\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:81)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:271)\r\n\tat colabupmtest.pageobjects.ContestManagerPage.goToProposalTemplates(ContestManagerPage.java:178)\r\n\tat colabupmtest.steps.ProposalTemplateSteps.clickOnProposalTemplateTab(ProposalTemplateSteps.java:29)\r\n\tat ✽.click on proposal template tab(file:src/test/resources/colabupmtest/features/proposalstemplate.feature:29)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "click on CREATE new template",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.click_on_CREATE_new_template()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "a new template is created",
  "keyword": "Then "
});
formatter.match({
  "location": "ProposalTemplateSteps.a_new_template_is_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambio nombre plantilla propuesta",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ProposalTemplate"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on proposal template tab",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.clickOnProposalTemplateTab()"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for text (\u0027Plantilla Ã�reas de Trabajo\u0027) to be the value of element [[ChromeDriver: chrome on XP (ebe3f1fcb1392788b43618bfcfa8c1cb)] -\u003e id: templateName] (tried for 5 second(s) with 500 milliseconds interval)\nBuild info: version: \u00273.13.0\u0027, revision: \u00272f0d292\u0027, time: \u00272018-06-25T15:24:21.231Z\u0027\nSystem info: host: \u0027SERGIO\u0027, ip: \u0027192.168.1.41\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_171\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 74.0.3729.6 (255758eccf3d24..., userDataDir: C:\\Users\\Solmedo\\AppData\\Lo...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:59300}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), rotatable: false, setWindowRect: true, strictFileInteractability: false, takesHeapSnapshot: true, takesScreenshot: true, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unexpectedAlertBehaviour: ignore, unhandledPromptBehavior: ignore, version: 74.0.3729.169, webStorageEnabled: true}\nSession ID: ebe3f1fcb1392788b43618bfcfa8c1cb\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:81)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:271)\r\n\tat colabupmtest.pageobjects.ContestManagerPage.goToProposalTemplates(ContestManagerPage.java:178)\r\n\tat colabupmtest.steps.ProposalTemplateSteps.clickOnProposalTemplateTab(ProposalTemplateSteps.java:29)\r\n\tat ✽.click on proposal template tab(file:src/test/resources/colabupmtest/features/proposalstemplate.feature:38)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "select a existing template as \"New template\"",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.select_a_existing_template_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "change the name of the template to \"Example name Proposal Template\"",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.change_the_name_of_the_template_to(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click on save template",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.click_on_save_template()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the new name is \"Example name Proposal Template\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ProposalTemplateSteps.the_new_name_is(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Añadir secciones propuesta",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ProposalTemplate"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to Contest Manager section",
  "keyword": "When "
});
formatter.match({
  "location": "ContestSteps.goToContestManager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on proposal template tab",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.clickOnProposalTemplateTab()"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for text (\u0027Plantilla Ã�reas de Trabajo\u0027) to be the value of element [[ChromeDriver: chrome on XP (a129d65765506088615437e4562c742e)] -\u003e id: templateName] (tried for 5 second(s) with 500 milliseconds interval)\nBuild info: version: \u00273.13.0\u0027, revision: \u00272f0d292\u0027, time: \u00272018-06-25T15:24:21.231Z\u0027\nSystem info: host: \u0027SERGIO\u0027, ip: \u0027192.168.1.41\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_171\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 74.0.3729.6 (255758eccf3d24..., userDataDir: C:\\Users\\Solmedo\\AppData\\Lo...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:59342}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, proxy: Proxy(), rotatable: false, setWindowRect: true, strictFileInteractability: false, takesHeapSnapshot: true, takesScreenshot: true, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unexpectedAlertBehaviour: ignore, unhandledPromptBehavior: ignore, version: 74.0.3729.169, webStorageEnabled: true}\nSession ID: a129d65765506088615437e4562c742e\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:81)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:271)\r\n\tat colabupmtest.pageobjects.ContestManagerPage.goToProposalTemplates(ContestManagerPage.java:178)\r\n\tat colabupmtest.steps.ProposalTemplateSteps.clickOnProposalTemplateTab(ProposalTemplateSteps.java:29)\r\n\tat ✽.click on proposal template tab(file:src/test/resources/colabupmtest/features/proposalstemplate.feature:49)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "select a existing template as \"Example name Proposal Template\"",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.select_a_existing_template_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click on add section button",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.click_on_add_section_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "select Text section in section type of new section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.select_Text_section_in_section_type_of_new_section()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "fill the field Title of new section with \"New title section\"",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.fill_the_field_Title_of_new_section_with(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "fill the field character limit with 300",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.fill_the_field_character_limit_with(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "fill the field help text with \"New Help Text section\"",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.fill_the_field_help_text_with(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "fill the field Default text with \"New Default Text\"",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.fill_the_field_Default_text_with(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click on save template",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.click_on_save_template()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "link the proposal Example name Proposal Template to a contest",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalTemplateSteps.link_the_proposal_Example_name_Proposal_Template_to_a_contest()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the proposal template for the contest include the new sections",
  "keyword": "Then "
});
formatter.match({
  "location": "ProposalTemplateSteps.the_proposal_template_for_the_contest_include_the_new_sections()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/colabupmtest/features/results.feature");
formatter.feature({
  "name": "Asignación ganadores",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@results"
    }
  ]
});
formatter.scenario({
  "name": "Asignacion automatica premio finalista",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@results"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a proposal which a judge decide that can be advance",
  "keyword": "Given "
});
formatter.match({
  "location": "SemiFinalistSelection.a_proposal_which_a_judge_decide_that_can_be_advance()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the fellow go to advance proposals selection section",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.the_fellow_go_to_advance_proposals_selection_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "advance the proposal",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.advance_the_proposal()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the proposal is visible in the Proposal Revision Phase",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.the_proposal_is_visible_in_the_Proposal_Revision_Phase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "wait until phase change to finalist selection phase",
  "keyword": "And "
});
formatter.match({
  "location": "FinalistSelection.waitUntilPhaseChange()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a proposal in a contest in phase Finalist selection",
  "keyword": "And "
});
formatter.match({
  "location": "FinalistSelection.a_proposal_in_a_contest_in_phase_Finalist_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a fellow decide advance the proposal",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.a_fellow_decide_advance_the_proposal()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select the judge",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.select_the_judge()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the judge decide that can be advance",
  "keyword": "And "
});
formatter.match({
  "location": "FinalistSelection.a_finalist_proposal_which_a_judge_decide_that_can_be_advance()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the fellow go to advance proposals selection section",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.the_fellow_go_to_advance_proposals_selection_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "advance the proposal",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.advance_the_proposal()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the proposal is visible in the voting Phase",
  "keyword": "And "
});
formatter.match({
  "location": "FinalistSelection.the_proposal_is_visible_in_the_voting_Phase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the contest change to \"Ganadores Proximamente\"",
  "keyword": "When "
});
formatter.match({
  "location": "ResultsSteps.waitUntilContestChange(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "show ribbons",
  "keyword": "And "
});
formatter.match({
  "location": "ResultsSteps.showRibbons()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the proposal has the finalist ribbon",
  "keyword": "Then "
});
formatter.match({
  "location": "ResultsSteps.checkFinalistRibbon()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Asignacion automatica premio semi-finalista",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@results"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a proposal which a judge decide that can be advance",
  "keyword": "Given "
});
formatter.match({
  "location": "SemiFinalistSelection.a_proposal_which_a_judge_decide_that_can_be_advance()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the fellow go to advance proposals selection section",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.the_fellow_go_to_advance_proposals_selection_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "advance the proposal",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.advance_the_proposal()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the proposal is visible in the Proposal Revision Phase",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.the_proposal_is_visible_in_the_Proposal_Revision_Phase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "wait until phase change to finalist selection phase",
  "keyword": "And "
});
formatter.match({
  "location": "FinalistSelection.waitUntilPhaseChange()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a proposal in a contest in phase Finalist selection",
  "keyword": "And "
});
formatter.match({
  "location": "FinalistSelection.a_proposal_in_a_contest_in_phase_Finalist_selection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a fellow decide not advance the proposal",
  "keyword": "And "
});
formatter.match({
  "location": "SemiFinalistSelection.a_fellow_decide_not_advance_the_proposal()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "wait until phase change to voting phase",
  "keyword": "And "
});
formatter.match({
  "location": "ResultsSteps.waitUntilContestChangeToVotingPhase()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the contest change to \"Ganadores Proximamente\"",
  "keyword": "When "
});
formatter.match({
  "location": "ResultsSteps.waitUntilContestChange(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "show ribbons",
  "keyword": "And "
});
formatter.match({
  "location": "ResultsSteps.showRibbons()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the proposal has the semi-finalist ribbon",
  "keyword": "Then "
});
formatter.match({
  "location": "ResultsSteps.checkSemiFinalistRibbon()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar premio a Popular choice",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@results"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to any proposal of contest in \"Ganadores Anunciados\" phase",
  "keyword": "And "
});
formatter.match({
  "location": "ResultsSteps.goToContestInPhase(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to admin section",
  "keyword": "When "
});
formatter.match({
  "location": "ProposalsSteps.go_to_admin_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select \"Popular choice\" ribbon",
  "keyword": "And "
});
formatter.match({
  "location": "ResultsSteps.setRibbonByType(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Popular choice\" ribbon is shown in proposal details",
  "keyword": "Then "
});
formatter.match({
  "location": "ResultsSteps.checkRibbonIsShown(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar premio a Judges choicce",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@results"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to any proposal of contest in \"Ganadores Anunciados\" phase",
  "keyword": "And "
});
formatter.match({
  "location": "ResultsSteps.goToContestInPhase(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to admin section",
  "keyword": "When "
});
formatter.match({
  "location": "ProposalsSteps.go_to_admin_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select \"Judges choice\" ribbon",
  "keyword": "And "
});
formatter.match({
  "location": "ResultsSteps.setRibbonByType(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Judges choicce\" ribbon is shown in proposal details",
  "keyword": "Then "
});
formatter.match({
  "location": "ResultsSteps.checkRibbonIsShown(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Cambiar premio a Popular \u0026 Judges choicce",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@results"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"admin\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "logged in the platform with his username as \"solmedo\" and password as \"odemlo13\"",
  "keyword": "And "
});
formatter.match({
  "location": "LoginSteps.logged_in_the_platform_with_his_username_as_and_password_as(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to contests section",
  "keyword": "And "
});
formatter.match({
  "location": "ProposalsSteps.goToContestSection()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to any proposal of contest in \"Ganadores Anunciados\" phase",
  "keyword": "And "
});
formatter.match({
  "location": "ResultsSteps.goToContestInPhase(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "go to admin section",
  "keyword": "When "
});
formatter.match({
  "location": "ProposalsSteps.go_to_admin_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "select \"Popular \u0026 Judges choice\" ribbon",
  "keyword": "And "
});
formatter.match({
  "location": "ResultsSteps.setRibbonByType(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Popular \u0026 Judges choice\" ribbon is shown in proposal details",
  "keyword": "Then "
});
formatter.match({
  "location": "ResultsSteps.checkRibbonIsShown(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/colabupmtest/features/theme.feature");
formatter.feature({
  "name": "Tema personalizado corporacion",
  "description": "  Como usuario quiero poder ver la aplicación con el tema y los estilos que se ajustan a la organización.",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Theme"
    }
  ]
});
formatter.scenario({
  "name": "Logo organización",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Theme"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check the path of the logo image",
  "keyword": "When "
});
formatter.match({
  "location": "ThemeSteps.getPathLogo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "is the path of the theme \"MADRID_COLAB\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ThemeSteps.checkPathLogo(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Color primario corporativo del que nacen el resto de colores",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Theme"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check the primary color",
  "keyword": "When "
});
formatter.match({
  "location": "ThemeSteps.getPrimaryColor()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "is \"#0072ce\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ThemeSteps.checkPrimaryColor(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Hoja de estilo personalizada",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Theme"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check the stylesheets",
  "keyword": "When "
});
formatter.match({
  "location": "ThemeSteps.getCss()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "are the stylesheets related to the theme \"MADRID_COLAB\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ThemeSteps.checkCss(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Lenguaje castellano por defecto",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Theme"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check the language by default",
  "keyword": "When "
});
formatter.match({
  "location": "ThemeSteps.check_the_language_by_default()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "is spanish",
  "keyword": "Then "
});
formatter.match({
  "location": "ThemeSteps.is_spanish()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "change language to english",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Theme"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "change the language to english",
  "keyword": "When "
});
formatter.match({
  "location": "ThemeSteps.change_the_language_to_english()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check the language",
  "keyword": "And "
});
formatter.match({
  "location": "ThemeSteps.check_the_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the language change to english rightly",
  "keyword": "Then "
});
formatter.match({
  "location": "ThemeSteps.the_language_change_to_english_rightly()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "change language to spanish",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Theme"
    },
    {
      "name": "@regression"
    }
  ]
});
formatter.step({
  "name": "a \"user\" in the platform main page",
  "keyword": "Given "
});
formatter.match({
  "location": "ThemeSteps.goToColabPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "change the language to spanish",
  "keyword": "When "
});
formatter.match({
  "location": "ThemeSteps.change_the_language_to_spanish()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check the language",
  "keyword": "And "
});
formatter.match({
  "location": "ThemeSteps.check_the_language()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the language change to spanish rightly",
  "keyword": "Then "
});
formatter.match({
  "location": "ThemeSteps.the_language_change_to_spanish_rightly()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});