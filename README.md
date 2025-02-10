# Poke App

Esta aplicación es un ejemplo de una app Android desarrollada utilizando **Clean Architecture** y **Jetpack Compose**. La app permite listar, buscar y ver detalles de pokémon obtenidos desde la [PokeAPI](https://pokeapi.co).

## Características

- **Clean Architecture:**  
  La app está estructurada en tres capas:
  - **Dominio:** Define las entidades, casos de uso y contratos de repositorios.
  - **Datos:** Implementa la obtención de datos (usando Retrofit para llamar a la PokeAPI) y el mapeo de DTOs a entidades de dominio.
  - **Presentación:** Utiliza MVVM con Jetpack Compose para la UI.

- **Jetpack Compose:**  
  Toda la interfaz de usuario se implementa utilizando Compose, lo que facilita la creación de UI modernas y reactivas.

- **Listado y Búsqueda de Pokémon:**  
  La pantalla de Home muestra una lista de pokémon y permite filtrar por nombre.

- **Detalle de Pokémon:**  
  Al seleccionar un pokémon, se navega a una pantalla de detalle que muestra su imagen, tipos y otra información relevante.

## Stack Tecnológico

- **Kotlin**
- **Jetpack Compose**
- **Clean Architecture**
- **Retrofit** (para las llamadas a la PokeAPI)
- **Hilt** (para inyección de dependencias)
- **Coroutines** (para manejo de operaciones asíncronas)

## Arquitectura

La aplicación sigue los principios de Clean Architecture:

- **Dominio:**  
  Contiene las entidades del negocio (por ejemplo, `Pokemon`), interfaces de repositorios y casos de uso como `GetPokemonListUseCase`.

- **Datos:**  
  Se encarga de implementar la lógica para obtener los datos desde la PokeAPI. Aquí se definen los DTOs y se realiza el mapeo a entidades de dominio.

- **Presentación:**  
  Implementa la lógica de UI usando ViewModels y Jetpack Compose. Los ViewModels consumen los casos de uso para exponer el estado de la aplicación a las pantallas.

## Pantallas de la App


<img width=300 src="https://github.com/user-attachments/assets/04553c03-dd4d-431b-b8e4-772cd61e3235"/>
<img width=300 src="https://github.com/user-attachments/assets/c29c7ba2-d024-491d-8a11-a57e3b0e1157"/>

### Home

- **Listado de Pokémons:**  
  Muestra una lista de pokémon obtenida de la PokeAPI.
  
- **Búsqueda:**  
  Permite filtrar la lista por nombre para encontrar rápidamente el pokémon deseado.

### Detalle

- **Información del Pokémón:**  
  Al seleccionar un pokémon, se muestra una pantalla con detalles como:
  - Nombre
  - Imagen
  - Tipos
  - Estadísticas adicionales

## Instalación y Ejecución

1. **Clonar el Repositorio:**

   ```bash
   git clone https://github.com/itzae/pokemon-clean-architecture-compose.git

2. **Abrir el Proyecto en Android Studio:**

    Asegúrate de tener instalada la última versión de Android Studio (preferiblemente Arctic Fox o Bumblebee).

3. **Sincronizar Dependencias:**

   El proyecto utiliza Gradle para la gestión de dependencias. Al abrir el proyecto, Android Studio descargará automáticamente las librerías necesarias.

4. **Ejecutar la Aplicación:**

  Conecta un dispositivo Android o inicia un emulador.
  Haz clic en "Run" para compilar y ejecutar la aplicación.
   
