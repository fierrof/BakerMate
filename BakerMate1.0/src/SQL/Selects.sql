
SELECT producto.id_producto, compra.cantidad, producto.nombre, producto.id_proveedor, producto.precio_compra, producto.PRECIO_VENTA
FROM producto
INNER JOIN compra ON producto.id_producto = compra.id_producto;

SELECT compra.fecha, proveedor.nombre, compra.cantidad, producto.nombre, producto.precio_compra, producto.precio_compra * compra.cantidad , usuario.nombre, estado_compra.nombre
FROM producto
INNER JOIN compra ON producto.id_producto = compra.id_producto
INNER JOIN usuario ON compra.id_usuario = usuario.id_usuario
INNER JOIN proveedor ON producto.id_proveedor = proveedor.id_proveedor
INNER JOIN estado_compra ON compra.id_estado_compra = estado_compra.id_estado_compra
WHERE compra.fecha = CURRENT_DATE
ORDER BY compra.fecha

SELECT venta.fecha, venta.cantidad, producto.nombre, venta.precio_vendido, venta.precio_vendido*venta.cantidad as Total, usuario.nombre FROM venta
INNER JOIN producto ON venta.id_producto = producto.id_producto
INNER JOIN usuario ON venta.id_usuario = usuario.id_usuario 


SELECT movimiento.fecha,  movimiento.detalle, movimiento.monto, tipo_movimiento.nombre, usuario.nombre FROM movimiento
INNER JOIN usuario ON movimiento.id_usuario = usuario.id_usuario
INNER JOIN tipo_movimiento ON movimiento.id_tipo_movimiento = tipo_movimiento.id_tipo_movimiento
ORDER BY movimiento.fecha

SELECT producto.id_producto, producto.nombre, producto.precio_compra, producto.precio_venta, proveedor.nombre FROM producto
INNER JOIN proveedor on producto.id_proveedor = proveedor.id_proveedor
ORDER BY proveedor.nombre, producto.id_producto

SELECT proveedor.NOMBRE, proveedor.EMAIL, proveedor.TELEFONO, proveedor.DIRECCION, SUM(producto.PRECIO_COMPRA*compra.CANTIDAD*compra.id_estado_compra)
FROM compra
INNER JOIN producto ON compra.ID_PRODUCTO = producto.ID_PRODUCTO
INNER JOIN proveedor ON producto.ID_PROVEEDOR = proveedor.ID_PROVEEDOR
GROUP BY proveedor.NOMBRE, proveedor.EMAIL, proveedor.TELEFONO, proveedor.DIRECCION


SELECT id_compra from compra


SELECT SUM(compra.cantidad*producto.PRECIO_COMPRA) FROM compra
select*from producto
INNER JOIN producto on compra.id_producto = producto.ID_PRODUCTO


SELECT*FROM producto

SELECT gasto.mes,gasto.detalle,gasto.monto,gasto.observacion,tipo_gasto.nombre,estado_gasto.nombre FROM gasto
INNER JOIN tipo_gasto ON gasto.ID_TIPO_GASTO = tipo_gasto.ID_TIPO_GASTO
INNER JOIN estado_gasto ON gasto.ID_ESTADO_GASTO = estado_gasto.ID_ESTADO_GASTO
ORDER BY gasto.mes


INSERT INTO producto (nombre, precio_compra, precio_venta, id_proveedor) VALUES ('nombre', 20, 60, 1);

select nombre from usuario where nombre = 'Facundo' and pass = '123'

SELECT * FROM tipo_venta

select SUM(producto.precio_compra), compra.cantidad From producto
INNER JOIN compra ON producto.ID_PRODUCTO = compra.id_producto
GROUP BY compra.cantidad

select compra.id_estado_compra, estado_compra.nombre from estado_compra
inner join compra On estado_compra.ID_ESTADO_COMPRA = compra.id_estado_compra