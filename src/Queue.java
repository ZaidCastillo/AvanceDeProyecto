
public class Queue {
    Node front;
    Node rear;

    // Constructor para almacenar una lista enlazada que simule una cola.
    public Queue(){
        this.front = null;
        this.rear = null;
    }

    // Función para introducir un elemento de tipo String al final de la lista enlazada en una estructura de cola.
    public void enqueue(String data){
        Node newNode = new Node(data);
        if(rear ==null){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear =newNode;
    }
    // Función para remover el elemento que más tiempo tiene dentro.
    public String dequeue(){
        if (front == null){
            return "(no hay procesos)";
        }
        String data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    // Función que devuelve el primer elemento que se introdujo.
    public String peek(){
        if (front == null){
            return "(no hay tareas asignadas)";
        }
        return front.data;
    }

    // Función para mostrar la lista creada hasta el momento.
    public void display(){
        if (front == null){
            System.out.println("No hay procesos");
            return;
        }
        Node temp = front;
        System.out.println("Procesos: ");
        while (temp!=null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
