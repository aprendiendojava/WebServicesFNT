INSERT INTO cliente(id,nombre,apellidos) VALUES( 1, 'Cliente 1', 'Apellido 1' );
INSERT INTO direccion(id,direccion,ciudad,pais,cp) VALUES( 1, 'Dirección proveedor 1', 'Ciudad 1', 'Pais 1', '1000' );
INSERT INTO direccion(id,direccion,ciudad,pais,cp) VALUES( 2, 'Dirección proveedor 2', 'Ciudad 2', 'Pais 2', '2000' );
INSERT INTO direccion(id,direccion,ciudad,pais,cp) VALUES( 3, 'Dirección proveedor 3', 'Ciudad 3', 'Pais 3', '3000' );
INSERT INTO proveedor(id,nombre) VALUES( 1, 'Proveedor 1' );
INSERT INTO proveedor(id,nombre) VALUES( 2, 'Proveedor 2' );
INSERT INTO proveedor(id,nombre) VALUES( 3, 'Proveedor 3' );
INSERT INTO producto(id,nombre,precio,moneda,id_proveedor) VALUES( 1, 'Producto 1', 1, 'EUR', 1 );
INSERT INTO producto(id,nombre,precio,moneda,id_proveedor) VALUES( 2, 'Producto 2', 2, 'EUR', 2 );
INSERT INTO producto(id,nombre,precio,moneda,id_proveedor) VALUES( 3, 'Producto 3', 3, 'EUR', 3 );
INSERT INTO pedido(id,id_cliente,fecha) VALUES( 1, 1, '2016-03-04 00:00:00' );
INSERT INTO pedido(id,id_cliente,fecha) VALUES( 2, 1, '2015-12-24 00:00:00' );
INSERT INTO producto_pedido(id_producto,id_pedido) VALUES(1,1);
INSERT INTO producto_pedido(id_producto,id_pedido) VALUES(2,1);
INSERT INTO producto_pedido(id_producto,id_pedido) VALUES(3,2);