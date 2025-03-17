# Proyecto de Automatización con Selenium, Java y TestNG

## Descripción
Este primer proyecto implementa pruebas automatizadas varias para aplicaciones web utilizando **Selenium WebDriver**, **Java** y **TestNG**, siguiendo el patrón de diseño **Page Object Model (POM)**. Este enfoque mejora la mantenibilidad y escalabilidad de las pruebas automatizadas.

## Estructura del Proyecto
La estructura del proyecto es la siguiente:

```
Proyectos2025/
├── src/
│   ├── main/
│   └── test/
│       └── java/
│           ├── EducacionIT_75402/           
│           │   └──EduIT             # Clases que contienen los primeros casos de prueba
│           ├──paginas               # Clase con atributos para las pruebas de loggin (Clase PracticaM4)
│           ├──pruebas               # Clases que contienen los casos de prueba restantes
│           └──utils                 # Clase para conectar con la base de datos
│
├── CrossBrowserTest.xml              # Configuración para pruebas en múltiples navegadores
├── pom.xml                           # Archivo de configuración de Maven
└── testng.xml                        # Archivo de configuración de TestNG
```

## Tecnologías y Herramientas
- **Lenguaje**: Java 11+
- **Framework de pruebas**: TestNG
- **Automatización**: Selenium WebDriver
- **Gestor de dependencias**: Maven
- **Patrón de diseño**: Page Object Model (POM)

## Configuración y Ejecución

### Prerrequisitos
1. **Java JDK 11 o superior**: Asegúrate de tener instalado el JDK adecuado y configurada la variable de entorno `JAVA_HOME`.
2. **Maven**: Instala Maven y verifica su correcta instalación ejecutando `mvn -version` en la línea de comandos.
3. **Controladores de Navegador**: Descarga y coloca los controladores de los navegadores que utilizarás (ChromeDriver, GeckoDriver, etc.) en una ubicación incluida en la variable de entorno `PATH`.

### Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/Daf2025/Proyectos2025.git
   cd Proyectos2025
   ```
2. Instala las dependencias del proyecto utilizando Maven:
   ```bash
   mvn clean install
   ```

### Ejecución de Pruebas
Para ejecutar las pruebas en diferentes navegadores, puedes utilizar el archivo `CrossBrowserTest.xml` que está configurado para ello:
```bash
mvn test -DsuiteXmlFile=CrossBrowserTest.xml
```

## Implementación del Patrón Page Object Model (POM)
El patrón POM se implementa creando una clase para cada página de la aplicación web. Cada clase contiene los elementos de la página y las acciones que se pueden realizar sobre ellos.

### Ejemplo de Clase POM:
```java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By searchBox = By.id("search_query_top");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String query) {
        driver.findElement(searchBox).sendKeys(query);
        driver.findElement(searchBox).submit();
    }
}
```

### Ejemplo de Caso de Prueba:
```java
package EducacionIT_75402.EduIT;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticaM1 {
  String url = "http://www.automationpractice.pl/"; 

  @Test @Disabled	
  public void lab1_test ( ) {
      System.out.println ("Hola Mundo de Automatización!!");				
    }
	
  @Test @Disabled	
  public void buscarProductoEdge() {
      WebDriver navegador= new EdgeDriver();
      navegador.manage().deleteAllCookies();
      navegador.manage().window().maximize();
      navegador.get(url);
      WebElement txtBusqueda=navegador.findElement(By.id("search_query_top"));
      txtBusqueda.sendKeys("dress");
      txtBusqueda.sendKeys(Keys.ENTER);
      navegador.close();
    }

  @Test
  public void buscarProductoFirefox() {
      WebDriver navegador= new FirefoxDriver();
      navegador.manage().deleteAllCookies();
      navegador.manage().window().maximize();
      navegador.get(url);
      WebElement txtBusqueda=navegador.findElement(By.id("search_query_top"));
      txtBusqueda.sendKeys("dress");
      txtBusqueda.sendKeys(Keys.ENTER);
      navegador.close();
    }
}
```

## Contribuciones
Si deseas contribuir a este proyecto:
1. Realiza un fork del repositorio.
2. Crea una nueva rama para tu funcionalidad (`git checkout -b nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Agrega nueva funcionalidad'`).
4. Sube tus cambios a tu repositorio (`git push origin nueva-funcionalidad`).
5. Abre un Pull Request en este repositorio.

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más información.


