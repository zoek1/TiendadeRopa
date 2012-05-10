ALL =Archivos.class CambiarContraseniaGui.class ListaLigadaProducto.class Producto.class Reloj.class Hashingmd5.class TiendaRopa.class Contrasenia.class VerifContraseniaGui.class ContraseniaGui.class Main.class ContraseniaGui.class login.class NuevaContraseniaGui.class ProductoGui.class
cc =javac -Xlint
ccj =jar cmf

All: $(ALL)
	$(ccj) Manifiesto.mf TiendadeRopa.jar $(ALL) $(Productos) Emblemas
	chmod +x ./clasesanidadas.sh
	./clasesanidadas.sh "TiendadeRopa.jar"
	echo "Para ejecutar programa escriba java -jar TiendadeRopa.jar";

Main.class: Main.java
	$(cc) Main.java

ContraseniaGui.class: ContraseniaGui.java
	$(cc) ContraseniaGui.java

TiendaRopa.class: TiendaRopa.java
	$(cc) TiendaRopa.java

Archivos.class: Archivos.java
	$(cc) Archivos.java

ContraseniaGui.class: ContraseniaGui.java
	$(cc) ContraseniaGui.java

CambiarContraseniaGui.class: CambiarContraseniaGui.java
	$(cc) CambiarContraseniaGui.java

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

login.class: login.java
	$(cc) login.java

VerifContraseniaGui.class: VerifContraseniaGui.java
	$(cc) VerifContraseniaGui.java

NuevaContraseniaGui.class: NuevaContraseniaGui.java
	$(cc) NuevaContraseniaGui.java

ProductoGui.class: ProductoGui.java
	$(cc) ProductoGui.java

.PHONY: clean
clean:
	-rm $(ALL)

.PHONY: dist-clean

distclean:
	-rm $(ALL) TiendadeRopa.jar

.PHONY: check-syntax

check-syntax: 
	$(cc) $(CHK_SOURCES)
