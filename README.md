Para abrir el juego es recomendable compilar el juego usando Intellij IDEA.

Para compilar el programa dentro de un IDE, asegurate de que el IDE tenga configurado la carpeta
media como carpeta de recursos. De lo contrario, el programa lanzará la excepción "NullPointerException" porque
no encuentra las rutas de las imagenes y los sonidos que utiliza el proyecto.

Si utilizas Intellij IDEA como IDE, puedes configurar la carpeta llendo a project structures -> modules, le das click
a la carpeta media y luego al apartado en dónde dice "resources". Finalmente le das en apply y ya el proyecto debería
compilar normalmente.
