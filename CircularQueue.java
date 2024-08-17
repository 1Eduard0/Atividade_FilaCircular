public class CircularQueue<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;

    @SuppressWarnings("unchecked")
    public CircularQueue(int size) {
        data = (T[]) new Object[size];
    }

    public void add(T value) {
        if (isFull()) {
            throw new IllegalArgumentException("A Fila está cheia e o valor: " + value + " não foi adicionado");
        } else {
            top = move(top);
            data[top] = value;
            System.out.println("Adicionado: " + value);
            printQueue();
        }
    }

    public T remove() {
        if (isEmpty()) {
            System.out.println("A Fila está vazia");
            return null;
        } else {
            T value = data[base];
            data[base] = null;
            base = move(base);
            System.out.println("Removido: " + value);
            printQueue();
            return value;
        }
    }

    public void clear() {
        top = -1;
        base = 0;
    }

    public boolean isFull() {
        return move(top) == base && data[base] != null;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private int move(int position) {
        return (position + 1) % data.length;
    }

    public void printQueue() {
        System.out.print("Fila atual: ");
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            int i = base;
            while (true) {
                System.out.print(data[i]);
                if (i == top) {
                    break;
                }
                i = move(i);
                System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}