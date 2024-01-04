# PROGRAMACIÓN EN RED CON JAVA


## Sección 1: Conceptos básicos de redes
---

#### Conceptos Básicos

**Protocolos de comunicaciones**, conjunto de reglas que permiten la comunicación entre dispoositivos.

| **IP** | **TCP**     | **UDP**      | **PORT**  |
| :----- | :---------- | :----------- | :-------- |
| IPv4   | Orientado a | No orientado | 0 - 65535 |
| IPv6   | la conexión | a conexiones | 0 - 1023  |

* Puertos:
    * 0 - 1023 para programas y protocolos.
    * 1024 - 49151 asignados por ICANN para uso específico.
    * 49152 - 65535 para asignación dinámica o privada.

- UDP:
  - Los mensajes se denominan *datagramas*.
  - Admite 64 kb como máximo.
  - No garantiza que los mensajes lleguen a destino.
  - No se asegura que los mensajes lleguen en el orden correcto.
  - No dispone de detección de errores.

#### Protocolos de Comunicaciones

Las siete capas del modelos **OSI** es útil para dividir un problema en diferentes partes. Donde cada capa de un nivel, se comunica con un nivel adyacente superior o inferior.

> **Física**: define la manera en que los datos se convierten en señales digitales.  
> 
> **Enlace de datos**: define la interfaz con la tarjeta de red.  
> 
> **Red**: permite administrar las direcciones y el enrutamiento.  
> 
> **Transporte**: se encarga en subdividir en *paquetes* y control de errores.  
> 
> **Sesión**: define inicio y fin de las sesiones entre equipos.  
> 
> **Presentación**: define el formato/cifrado de los datos, independiente del sistema.  
> 
> **Aplicación**: son aplicaciones de la interfaz.

El modelo **TCP/IP** o de **Internet** es un derivado del modelo **OSI** pero con cuatro capas.

> **Acceso a Red**: especifica la forma de enrutar los datos. Protocolos de acceso a subredes y hardware asociado. Aquí los datos se llman *trama*.  
> 
> **Internet**: responsable del paquete de datos o *datagrama*. Protocolo *IP*.  
> 
> **Transporte**: datos de enrutamiento y estado de la transmisión. Protocolos *TCP* y el *UDP*. Aquí los datos se llaman *segmento*.  
> 
> **Aplicación**: proporciona aplicaciones de red estándar; Telnet, FTP, HTTP, SMTP, DNS, POP, RLOGIN, SNMTP, etc. Aquí los datos se llaman *mensaje*.  
> 


## Sección 2: Elementos de programación de comunicaciones en red
---

## Sección 3: Comunicación cliente/servidor usando datagramas
---

## Sección 4: Transmisón de información compleja. Serialización
---

## Sección 5: Comunicaciones en red con hilos. Entornos gráficos con la librería Swing
---
