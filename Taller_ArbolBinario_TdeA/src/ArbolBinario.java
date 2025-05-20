public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario(){
        raiz = null;
    }

    //metodo para inicializar el arbol
    public void inicializarArbol(){
        raiz = new Nodo(10);
        raiz.izquierdo = new Nodo(5);
        raiz.derecho = new Nodo(15);

        raiz.izquierdo.izquierdo= new Nodo(3);
        raiz.izquierdo.derecho= new Nodo(7);
        raiz.derecho.izquierdo= new Nodo(12);
        raiz.derecho.derecho= new Nodo(18);
    }
    //metodo para recorrer
    public void Inorder(Nodo nodo){
        if(nodo!=null){
            Inorder(nodo.izquierdo);
            System.out.println(nodo.valor + " ");
            Inorder(nodo.derecho);
        }
    }
    public Nodo getRaiz(){
        return raiz;
    }
    public void Preorder(Nodo nodo){
        if(nodo!=null){
            System.out.println(nodo.valor + " ");
            Preorder(nodo.izquierdo);
            Preorder(nodo.derecho);
        }
    }
    public void Postorder(Nodo nodo){
        if(nodo!=null){
            Postorder(nodo.izquierdo);
            Postorder(nodo.derecho);
            System.out.println(nodo.valor + " ");
        }
    }
//agregar nodo
    public void agregarNodo(int valor){
        Nodo nuevoNodo = new Nodo(valor);
        if(raiz == null){
            raiz = nuevoNodo;
        }
        else{
            Nodo actual = raiz;
            Nodo padre = null;
            while(actual != null){
                padre = actual;
                if(valor < actual.valor){
                    actual = actual.izquierdo;
                }
                else{
                    actual = actual.derecho;
                }
            }
            if(valor < padre.valor){
                padre.izquierdo = nuevoNodo;
            }
            else{
                padre.derecho = nuevoNodo;
            }
        }
    }
    //eliminar nodo
    public void eliminarNodo(int valor){
        Nodo actual = raiz;
        Nodo padre = null;
        while(actual != null && actual.valor != valor){
            padre = actual;
            if(valor < actual.valor){
                actual = actual.izquierdo;
            }
            else{
                actual = actual.derecho;
            }
        }
        if(actual == null){
            System.out.println("El nodo no existe");
            return;
        }
        if(actual.izquierdo == null && actual.derecho == null){
            if(padre == null){
                raiz = null;
            }
            else if(padre.izquierdo == actual){
                padre.izquierdo = null;
            }
            else{
                padre.derecho = null;
            }
        }
        else if(actual.izquierdo == null || actual.derecho == null){
            Nodo hijo = (actual.izquierdo != null) ? actual.izquierdo : actual.derecho;
            if(padre == null){
                raiz = hijo;
            }
            else if(padre.izquierdo == actual){
                padre.izquierdo = hijo;
            }
            else{
                padre.derecho = hijo;
            }
        }
    }
    //Metodo para buscar un nodo
    public Nodo buscarNodo(int valor){
        Nodo actual = raiz;
        while(actual != null && actual.valor != valor){
            if(valor < actual.valor){
                actual = actual.izquierdo;
            }
            else{
                actual = actual.derecho;
            }
        }
        return actual;
    }
    //Metodo para vaciar el arbol
    public void vaciarArbol(){
        raiz = null;
    }
    //Metodo para mostrar la altura del arbol
    public int alturaArbol(Nodo nodo){
        if(nodo == null){
            return -1;
        }
        else{
            int alturaIzquierda = alturaArbol(nodo.izquierdo);
            int alturaDerecha = alturaArbol(nodo.derecho);
            return Math.max(alturaIzquierda, alturaDerecha) + 1;
        }
    }
    //Contar nodos hojas
    public int contarNodosHojas(Nodo nodo){
        if(nodo == null){
            return 0;
        }
        if(nodo.izquierdo == null && nodo.derecho == null){
            return 1;
        }
        else{
            return contarNodosHojas(nodo.izquierdo) + contarNodosHojas(nodo.derecho);
        }
    }


}
