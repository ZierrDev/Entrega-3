import java.util.Scanner;
public class MainArbolTaller {
    
    public static void main(String[] args) throws Exception {
        ArbolBinario arbol = new ArbolBinario();
        arbol.inicializarArbol();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Menu de opciones");
        System.out.println("1. Recorrido InOrder");
        System.out.println("2. Recorrido PreOrder");
        System.out.println("3. Recorrido PostOrder");
        System.out.println("4. Agregar nodo");
        System.out.println("5. eliminar nodo");
        System.out.println("6. Buscar nodo");
        System.out.println("7. Mostrar altura del arbol");
        System.out.println("8. Contar nodos hojas");
        System.out.println("9. Vaciar el arbol");
        opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Recorrido InOrder del arbol");
                    arbol.Inorder(arbol.getRaiz());
                    
                    break;
                case 2:
                    System.out.println("Recorrido PreOrder del arbol");
                    arbol.Preorder(arbol.getRaiz());
                    
                    break;
                case 3:
                    System.out.println("Recorrido PostOrder del arbol");
                    arbol.Postorder(arbol.getRaiz());
                    
                    break;
                case 4:
                    System.out.println("Agregar nodo");
                    System.out.println("Ingrese el valor del nodo");
                    int valor = scanner.nextInt();
                    arbol.agregarNodo(valor);
                    arbol.Inorder(arbol.getRaiz());
                    break;
                case 5:
                    System.out.println("Eliminar nodo");
                    System.out.println("Ingrese el valor del nodo a eliminar");
                    int valorEliminar = scanner.nextInt();
                    arbol.eliminarNodo(valorEliminar);
                    arbol.Inorder(arbol.getRaiz());
                    break;

                case 6:
                    System.out.println("Buscar nodo");
                    System.out.println("Ingrese el valor del nodo a buscar");
                    int valorBuscar = scanner.nextInt();
                    Nodo nodoEncontrado = arbol.buscarNodo(valorBuscar);
                    if (nodoEncontrado != null) {
                        System.out.println("Nodo encontrado: " + nodoEncontrado.valor);
                    } else {
                        System.out.println("Nodo no encontrado");
                    }
                    break;
                case 7:
                    System.out.println("Altura del arbol: " + arbol.alturaArbol(arbol.getRaiz()));
                    break;
                case 8:
                    System.out.println("Contar nodos hojas");
                    System.out.println("Cantidad de nodos hojas: " + arbol.contarNodosHojas(arbol.getRaiz()));
                    break;
                case 9:
                    System.out.println("Vaciando el arbol");
                    arbol.vaciarArbol();
                    System.out.println("Arbol vacio");
                    break;

            
                default:
                    break;
            }


    
    }
}
