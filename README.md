# Microservicio: Puerta de Enlace (gateway-service)

## 🎯 Propósito
Este servicio es la **única puerta de entrada (API Gateway)** para todo el sistema. Utiliza **Spring Cloud Gateway**.

Ningún cliente externo (como Postman o una app móvil) habla directamente con `ms-pedidos` o `ms-productos`. Todas las peticiones **deben** pasar primero por el Gateway.

## 🛠️ Configuración Clave

* **Puerto de Servicio:** `8080` (Este es el puerto "público" principal del sistema).
* **Descubrimiento de Servicios:** Está conectado a `registry-service` (Eureka).
* **Reglas de Enrutamiento (Routing):** Su configuración (obtenida del `ms-config-server`) le indica cómo redirigir el tráfico:
    * Las peticiones a `http://localhost:8080/api/productos/**` son redirigidas a `ms-productos`.
    * Las peticiones a `http://localhost:8080/api/pedidos/**` son redirigidas a `ms-pedidos`.

## 🐳 Docker
* **Dependencias de Arranque:** Espera a que **todos** los demás servicios (`config-server`, `registry-service`, `ms-pedidos`, `ms-productos`) estén listos antes de arrancar.
* Es el **último** servicio en iniciarse, asegurando que el "directorio telefónico" (Eureka) esté lleno y las "oficinas" (otros servicios) estén abiertas antes de recibir tráfico.