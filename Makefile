ALL =Archivos.class ListaLigadaProducto.class Producto.class
cc =javac -Xlint

All: $(ALL)

Archivos.class: Archivos.java
	$(cc) Archivos.java

ListaLigadaProducto.class: ListaLigadaProducto.java
	$(cc) ListaLigadaProducto.java

Producto.class: Producto.java
	$(cc) Producto.java

.PHONY: clean
clean:
	-rm $(ALL)
