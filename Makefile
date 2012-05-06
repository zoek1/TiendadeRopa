ALL =Archivos.class ListaLigadaProducto.class Producto.class Reloj.class Hashingmd5.class
cc =javac -Xlint

All: $(ALL)

Archivos.class: Archivos.java
	$(cc) Archivos.java

ListaLigadaProducto.class: ListaLigadaProducto.java
	$(cc) ListaLigadaProducto.java

Producto.class: Producto.java
	$(cc) Producto.java

Reloj.class: Reloj.java
	$(cc) Reloj.java

Hashingmd5.class: Hashingmd5.java
	$(cc) Hashingmd5.java

.PHONY: clean
clean:
	-rm $(ALL)
