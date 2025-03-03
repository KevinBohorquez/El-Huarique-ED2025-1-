package testeos.Controllers.AdminStorage;

import testeos.Controllers.Structures.ColaAlmacen;
import testeos.Controllers.Structures.NodoAlmacen;

public class AlmacenData {
    private static AlmacenData instance;

    private NodoAlmacen huariqueRoot = new NodoAlmacen("HUARIQUE");
    private NodoAlmacen carne = new NodoAlmacen("carne");
    private NodoAlmacen pescado = new NodoAlmacen("pescado");
    //private NodoAlmacen verduras = new NodoAlmacen("verduras");
    //private NodoAlmacen utensilio = new NodoAlmacen("utensilio");

    //colas para carne
    private ColaAlmacen pollo = new ColaAlmacen();
    private ColaAlmacen res = new ColaAlmacen();
    private ColaAlmacen cerdo = new ColaAlmacen();

    //colas para pescado
    private ColaAlmacen sal = new ColaAlmacen();
    private ColaAlmacen dulce = new ColaAlmacen();
    private ColaAlmacen marisco = new ColaAlmacen();

    private AlmacenData() {}  // Constructor privado para evitar instancias múltiples

    public static AlmacenData getInstance() {
        if (instance == null) {
            instance = new AlmacenData();
        }
        return instance;
    }

    public ColaAlmacen getPollo() {
        return pollo;
    }
    public ColaAlmacen getRes() {
        return res;
    }
    public ColaAlmacen getCerdo() {
        return cerdo;
    }

    public ColaAlmacen getSal() {
        return sal;
    }
    public void setSal(ColaAlmacen sal) {
        this.sal = sal;
    }

    public ColaAlmacen getDulce() {
        return dulce;
    }
    public ColaAlmacen getMarisco() {
        return marisco;
    }


    public NodoAlmacen obtenerArbol(){
        // simulamos Nodo Raíz
        NodoAlmacen huariqueRoot = new NodoAlmacen("HUARIQUE");

        // nodos hijos (categorías del almacen)
        NodoAlmacen carne = new NodoAlmacen("carne");
        NodoAlmacen pescado = new NodoAlmacen("pescado");

        // sub-categorías para cada categoría
        carne.agregarLote(pollo);
        carne.agregarLote(res);
        carne.agregarLote(cerdo);

        pescado.agregarLote(dulce);
        pescado.agregarLote(marisco);
        pescado.agregarLote(sal);

        // agregar los hijos al nodo raíz
        huariqueRoot.agregarHijo(carne);
        huariqueRoot.agregarHijo(pescado);

        return huariqueRoot;
    }
}
