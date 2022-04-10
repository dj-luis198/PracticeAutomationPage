@register
Feature: Registro de usuarios
  Como usuario quiero registrarme para poder realizar compras
Scenario: Registrarse en la pagina ingresando desde el home
Given El usuario se encuentra en la pagina home de automationpractice
When Hace clic en SignIn
And Ingresa su Email
And Presiona el boton Create an account
And Selecciona Title
And Ingresa First name
And Ingresa Last name
And Confirma Email
And Ingresa Password
And Ingresa Date of Birth
And Selecciona opciones de suscripcion
And Ingresa Company
And Selecciona Country
And Selecciona State
And Ingresa City
And Ingresa Postal Code
And Ingresa Address1
And Ingresa Address2
And Ingresa Additional information
And Ingresa Home phone
And Ingresa Mobile phone
And Ingresa address alias
And Presiona el boton register
Then Deberia llevarme a la pagina My Account

