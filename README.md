<h3  align="center">PRUEBA TECNICA NEQUI</h3>

  

</div>

  

## Acerca del Proyecto

  

Se requiere construir un API para manejar una lista de franquicias. Una franquicia se
compone por un nombre y un listado de sucursales y, a su vez, una sucursal está
compuesta por un nombre y un listado de productos ofertados en la sucursal. Un producto
se componente de un nombre y una cantidad de stock..

### Se empaqueto toda la aplicacion en docker 
para correr la applicacion desde docker compose solo basta con lo siguiente

**Instalar Docker y Docker Compose**
Es necesario tener Docker instalado en tu sistema. Descárgalo e instálalo desde Docker Desktop si usas Windows o macOS. En Linux, puedes instalarlo con:
 >> sudo apt update
 >> sudo apt install docker.io

**Verifica que Docker y Docker Compose están instalados correctamente**:
>> docker --version
>> docker compose version

**Para finalizar ejecuta el comnado:**
 >> docker compose -f k8s/docker-compose.yml up

para mejorar la experiencia de usuario se instalo la dependencia de **springdoc-openapi** que nos permite visualizar los endpoint desde un swagger para acceder a este la ruta al correr el docker compose es 
http://localhost:8001/swagger-ui/index.html#/

**NOTA IMPORTANTE**: si se va a correr la aplicacion desde el contenedor de docker compose es necesario no utlizar el archvio de SwaggerConfig.java  basta con comentarlo y tambien comentar las lineas 
# springdoc.api-docs.path=/v3/api-docs
# springdoc.swagger-ui.path=/swagger-ui.html
# server.forward-headers-strategy=native
# springdoc.swagger-ui.validator-url=
# springdoc.swagger-ui.oauth2-redirect-url=https://nequi-test-production.up.railway.app/swagger-ui/oauth2-redirect.html
en el archivo application.properties de la carpeta resource 


### Se desplego a la nube la aplicacion
se utilizo un servicio gratuito en la nube para desplegar la aplicacion obteniendo la url 
 http://nequi-test-production.up.railway.app
desde la cual tambien se puede acceder al swagger

http://nequi-test-production.up.railway.app/swagger-ui/index.html#/

### Criterios de Aceptación

  #### - Exponer endpoint para agregar una nueva franquicia.
  
*la ruta es [/franquicia](https://nequi-test-production.up.railway.app/swagger-ui/index.html#/franquicia-controller/createFranquicia) 
se creo un endpoint para crear un objeto franquicia el cual solicita como request body el campo de nombre 
quedando por defecto el campo de sucursales vacio

  #### - Exponer endpoint para agregar una nueva sucursal a una franquicia.
  
*la ruta es [/franquicia/{id}/sucursal/{id_sucursal}](https://nequi-test-production.up.railway.app/swagger-ui/index.html#/franquicia-controller/AddSucursaltoFranquicia) 

se creo un endpoint para agregar un objeto sucursal a un objeto franquicia el cual tiene en su ruta dos path param uno identificando el id del objeto franquicia y otro para identificar el id de la sucursal

  #### - Exponer endpoint para agregar un nuevo producto a una sucursal.
  
*la ruta es [/sucursal/{id}/product/{id_product}](https://nequi-test-production.up.railway.app/swagger-ui/index.html#/sucursal-controller/AddProductotoSucursal)
se creo un endpoint para agregar un objeto producto a un objeto sucursal el cual tiene en su ruta dos path param uno identificando el id del objeto producto y otro para identificar el id de la sucursal

  #### - Exponer endpoint para eliminar un nuevo producto a una sucursal.
  
*la ruta es [/sucursal/{id}/product/{id_product}](https://nequi-test-production.up.railway.app/swagger-ui/index.html#/sucursal-controller/RemoveProductoFromSucursal)
se creo un endpoint para eliminar un objeto producto a un objeto sucursal el cual tiene en su ruta dos path param uno identificando el id del objeto producto y otro para identificar el id de la sucursal

  #### - Exponer endpoint para modificar el stock de un producto.
  
*la ruta es [/producto/{id}](https://nequi-test-production.up.railway.app/swagger-ui/index.html#/producto-controller/updateProducto)
se creo un endpoint para actualizar un objeto producto pidiendo como path param el identificador del producto y como query param la cantidad nueva del campo stock

 #### - Exponer endpoint que permita mostrar cual es el producto que más stock tiene por sucursal para una franquicia puntual. Debe retornar un listado de productos que indique a que sucursal pertenece.
  
*la ruta es [/franquicia/{id}/stock](https://nequi-test-production.up.railway.app/swagger-ui/index.html#/franquicia-controller/getStockBySucursalByFranquicia)
se creo un endpoint que muestre cual es el producto que más stock tiene por sucursal para una franquicia puntual. solo tiene como path param el id de la franquicia

  #### - Plus si se expone endpoint que permita actualizar el nombre de una franquicia.
  
*la ruta es [/franquicia/{id}/name](https://nequi-test-production.up.railway.app/swagger-ui/index.html#/franquicia-controller/putFranquiciaNombre)
se creo un endpoint para actualizar un objeto franquicia pidiendo como path param el identificador del producto y como query param el nuevo valor del campo name

 #### - Plus si se expone endpoint que permita actualizar el nombre de una sucursal.
  
*la ruta es [/sucursal/{id}/name](https://nequi-test-production.up.railway.app/swagger-ui/index.html#/sucursal-controller/putSucursalNombre)
se creo un endpoint para actualizar un objeto sucursal pidiendo como path param el identificador del producto y como query param el nuevo valor del campo name

 #### - Plus si se expone endpoint que permita actualizar el nombre de un producto.
  
*la ruta es [/producto/{id}/name](https://nequi-test-production.up.railway.app/swagger-ui/index.html#/producto-controller/putProductoNombre)
se creo un endpoint para actualizar un objeto producto pidiendo como path param el identificador del producto y como query param el nuevo valor del campo name

 #### - Se utlizo para la persistencia de datos una base un proveedor de la nube utilizando MySql.
**url**: mysql://root:GlYrpgITUWtnPhDuubOOSgUDvLSieubd@yamanote.proxy.rlwy.net:15587/railway
**password**: GlYrpgITUWtnPhDuubOOSgUDvLSieubd
**username**: root
