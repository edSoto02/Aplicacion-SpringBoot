## Proyecto: Agenda Contactos.

![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E)



### Este proyecto fue realizado a partir de un curso practico en Spring para la implementacion de un CRUD.
### En este proycto se implementaron las tecnologias:
 - SprinBoot: El proyecto se creo en Spring Tool Suite 4, pero fue completado en Visual Studio Code
 - MySQL: Como gestor de base de datos.
 - Visual Studio Code: Para la edicion del codigo.
 - HTML con Thymeleaf: Para la renderizacion dinamica de los datos en lado del servidor.
 - Bootstrap: Para el diseño y el estilo de la pagina.



### Estructura del proyecto:

#### Pakage: agendacontacto.
- class AgendaContactoApplication: Esta clase sirve como punto de entrada para la aplicación SpringBoot, configurando y arrancando la aplicación mediante el uso de la anotación @SpringBootApplication y el método main.  

#### Pakage: controlador.
- class ContactoControlador: Esta clase es un controlador se SpringMVC que maneja las solicitudes relacionadas con los contactos.
- Utiliza anotaciones como @Controller, @Autowired, @GetMapping, @PostMapping, @PathVariable, etc., para configurar y definir las rutas de acceso y los métodos que manejan las solicitudes HTTP.
- Utiliza un repositorio de contactos (ContactoRepositorio) para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la base de datos.
- Además, realiza validación de datos utilizando el framework de validación de Spring (@Validated y BindingResult) para garantizar la integridad de los datos ingresados por el usuario.
- Utiliza RedirectAttributes para enviar mensajes de éxito o error a través de redirecciones.

#### Pakage: modelo.
- class Contacto: representa una entidad de contacto en la aplicación, que se mapea a una tabla en la base de datos a través de la anotación @Entity.
- Utiliza anotaciones de validación como @NotBlank, @NotEmpty, @Email, @Past, @NotNull para validar los datos del contacto.
- La anotación @PrePersist se utiliza para marcar un método que se debe ejecutar antes de que la entidad sea persistida en la base de datos. En este caso, se utiliza para asignar la fecha de registro del contacto antes de que sea guardado por primera vez.

#### Pakage: repositorio.
- interface ContactoRepositorio extends JpaRepository: es una interfaz proporcionada por Spring Data JPA para simplificar el acceso a datos en aplicaciones Spring basadas en JPA.
- Al extender JpaRepository, ContactoRepositorio hereda métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la entidad Contacto.
- Esta interfaz actúa como un repositorio de datos para la entidad Contacto, proporcionando métodos para interactuar con la base de datos de manera eficiente y consistente.

### Este proyecto esta configurado para que la base de datos se cree a partir de la ejecucion del proyecto, despues de esto para cargar los datos ya ingresados y no se vuelva a crear la base de datos, es necesario cambiar en application.properties esta instruccion spring.jpa.hibernate.ddl-auto =update: el update por el create. 
### De igual manera y como fue en este caso, se tuvo que cambiar de puerto, de igual manera en application.properties se tiene que agregae esta instruccion server.port=8081.


## En este proyecto al extender a JpaRepository se hacen las operaciones CRUD (Crear, Leer, Actualizar, Eliminar), a parte de esto se implemento de forma pesonal la busqueda por nombre de cada contacto, para esto se hicieron las sig modificaciones:
- En la clase ContactoControlador se implemento el siguiente metodo:
```java
@GetMapping("/buscar")
	public String buscarContacto(@RequestParam("q") String query, Model modelo) {
		List<Contacto> resultadoBusqueda = (List<Contacto>) contactoRepositorio.findByNombreContainingIgnoreCase(query);
		modelo.addAttribute("contactos", resultadoBusqueda);
		return "index";
	}
```
- En la interface ContactoRepositorio se implemento en siguiente metodo:
```java
List<Contacto> findByNombreContainingIgnoreCase(String nombre);
```
- Y en HTML se introdujo en siguiente bloque de codigo:
```html
<form action="/buscar" method="get" class="mb-3">
  <div class="input-group">
    <input type="text" class="form-control" name="q" placeholder="Buscar contacto por nombre">
    <button type="submit" class="btn btn-outline-secondary">Buscar</button>
  </div>
</form>
```
## Con estas modificación se hace función de la busqueda de contactos por nombre.

### Capturas de la ejecución del proyecto.

1. Esta es la vista principal al iniciar el proyecto.

![vistaprincipal](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/cb6c5dfc-7bad-4a82-b0ea-fcaf3ff368da)

2. Vista para guardar un contacto.

![guardarcontacto](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/aa8e8c46-2d6b-4144-a6cf-61550f4ecf7f)

3. Guardamos un par de contactos en la Agenda.

![prueba4](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/f97c4ca4-ce4a-4c6b-9616-25ead7166e42)

4. Probamos el editar un contacto de la Agenda.

![Edicion](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/f34d6d62-49db-4cce-9658-a37a6602e56a)

Resultado y respuesta en consola.
![edicion2](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/f095bfdd-ac73-46b2-9f72-0ebc4bb378fe)

![edicion3](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/76ac851b-2e68-4d25-b3a8-ab8d83e953a7)

5. Realizamos una busqueda por nombre en la Agenda.

![busqueda1](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/4f07254d-cef7-482a-9e8c-6e526a569867)

Resultado y respuesta en consola.

![busqueda2](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/81208167-38a2-46d9-a39a-ae5022a8c156)

![busqueda3](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/e766b62c-efc9-4d82-be4a-ff45ad6e853e)

6. Realizamos la eliminación de un contacto en la Agenda.

![eliminar1](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/9a07d502-c6fb-41e6-9c1f-951da939a00f)

Resultado y respuesta en consola.

![eliminar2](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/68c58d9c-c74d-4b2f-8f8e-8dc19714ccab)

7. Base de datos.

![registrofina](https://github.com/edSoto02/Aplicacion-SpringBoot/assets/106222946/313154ac-0fe0-4b7b-b839-581b79a63f42)

### Uso del proyecto.

1. Clonar el repositorio.
   - git clone https://github.com/edSoto02/Aplicacinn-SpringBoot.git
2. Configuracion de la base de datos.
   - Asegúrate de tener MySQL instalado y configurado en tu máquina.
   - Crea una base de datos llamada agendacontactos.   
   - Actualiza las credenciales de la base de datos en el archivo application.properties.
3. Ejecutar la aplicacion.
   - Para este caso la aplicación se ejecuto desde Visual Studio Code.
   - Puedes hacer uso del mismo o el entorno de tu agrado, como Eclipse o el mismo SpringBoot.
4. Acceder a la aplicación.
   - Abre tu navegador web de preferencia y vistia http://localhost:8080 (Para mi caso fue 8081)

### Contribuciones
- Las contribuciones son bienvenidas! Si deseas mejorar esta aplicación.

 
