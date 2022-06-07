## Primeros pasos

Este es un trabajo para mi universidad echo con la libreria de javaFX. Si quieres que funcione como deberia debes cumplir con los siguientes reguisitos: 
- <p> Tener java version 11 en adelante.</p>
- <p> Tener postgresql como gestor de base de datos.</p>
- <p> Tener instalado <h1>scene builder</h1> para la modificacion de la interfaz.</p>

## instrucciones para modificar el proyecto
Este proyecto necesita de los siguientes cambios para que funcione correctamente:
- <p> Para la base de datos se necesita revisar las clases de <h1>Conexion.UsuarioDAO</h1> y <h1> Conexion.CitaDAO</h1> en dichas clases se encuentra la informacion para los atributos de las tablas</p>
- <p> Las tablas se relacionan como Usuario tiene atributo denominado getCita() que es la llave primaria de la tabla de cita </p>
- <p> Para que el proyecto funcione debes eliminar el archivo launch.json y crear el uno propio; una ves creado el archivo añade la siguiente line a las instrucciones <h1> "vmArgs": "--module-path \"lib/javafx-sdk-17.0.1/lib\" --add-modules javafx.controls,javafx.fxml" </h1> </p>

# Este es mi primer intento de realizar un README; espero puedan poner a funcionar el proyecto; dejo algunas capturas del proyecto
<p align="center">
  <img src="doc\login.jpg" width="350" title="Login">
  <img src="doc\panelCita.jpg" width="350" title="Consultas, Registro y Eliminar">
  <img src="doc\panelRegistro.jpg" width="350" title="Registrar datos">
</p>