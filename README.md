<h1 align="center"> Challenge Foro Hub </h1>

## ¿Como usar el forohub? :scream_cat:: 
- Para usar el forohub debes conectar MySql al proyecto, solo debes ir a la carpeta resources y en aplication.properties colocar la informacion de tu MySql para conectarlo.
- Para hacer las pruebas puedes usar postman o insomnia para hacer las requests html al servidor local.
- A continuacion te dejare unas imagenes como forma de guia para que sepas el formato de las requests(En mis ejemplos usare postman).
- Recuerda que debes hacer el login primero, para generar el token de acceso, ademas en las tablas de MySql debes poner la informacion en usuario(id, usuario, correo(Opcional por el momento) y la clave),
  ya que esta informacion no viene por defecto ni se puede crear desde postman. toca crearla directamente desde la base de datos.
- Pd: La clave debe estar encriptada, si quieres puedes usar este link para crearla, (https://www.browserling.com/tools/bcrypt)
  
-`Formato para añadir la informacion en MySql`:

  ![tableUsuariosMySql](https://github.com/user-attachments/assets/574c2683-08ba-4f02-8735-c19e5267c40f)
  
- `Formato login`:
  
  ![LoginPostaman](https://github.com/user-attachments/assets/e87f839f-897d-42c2-b975-25d595d96af5)

- `Formato GET`:
  Recuerda colocar la direccion de tu servidor local mas /topicos en la url.
  
  ![getPostman](https://github.com/user-attachments/assets/aefe14ea-f65e-44d4-a432-b765ffc45a2f)

-`Formato GET id especifica` En GET tambien puedes obtener topicos independientes por id(/topicos/tu id):

  ![GetIdPostman](https://github.com/user-attachments/assets/41698bd7-2ecd-4afb-9e1b-504ebc3b49dc)

  
- `Formato POST`:
  
  ![postPostmanReal](https://github.com/user-attachments/assets/5e2fd526-ec3a-4d8e-afcf-18907c65d343)

- `Formato PUT`:
  
  ![putPostman](https://github.com/user-attachments/assets/da378440-e06f-4520-b76c-6946ade12ddc)

- `Formato DEL`:
  Debes colocar el id del topico que deseas eliminar(/topicos/la id que deseas eliminar)
  
  ![DelPostman](https://github.com/user-attachments/assets/b6701207-079c-4b1e-a40d-8e6b00d362a4)



