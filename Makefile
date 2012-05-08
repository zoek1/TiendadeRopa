ALL =Archivos.class ListaLigadaProducto.class Producto.class Reloj.class Hashingmd5.class TiendaRopa.class Contrasenia.class 
cc =javac -Xlint
ccj =jar cmf

All: $(ALL)
	$(ccj) Manifiesto.mf TiendadeRopa.jar $(ALL) Emblemas
	echo "Para ejecutar programa escriba java -jar TiendadeRopa.jar";

TiendaRopa.class: TiendaRopa.java
	$(cc) TiendaRopa.java

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

Contrasenia.class: Contrasenia.java
	$(cc) Contrasenia.java

.PHONY: clean
clean:
	-rm $(ALL)

.PHONY: dist-clean

distclean:
	-rm $(ALL) TiendadeRopa.jar

.PHONY: check-syntax

check-syntax: 
	$(cc) $(CHK_SOURCES)