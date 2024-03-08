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
## Con estas modificacion se hace funcion de la busqueda de contactos por nombre.

### Capturas de la ejecucion del proyecto.





