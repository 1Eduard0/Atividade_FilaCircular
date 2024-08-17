public class Main {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);

        try {
            queue.add(1);
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.add(5);

            queue.remove();
            queue.remove();

            queue.add(6);
            queue.add(7);
            queue.add(8);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fila está cheia? " + queue.isFull());
        System.out.println("Fila está vazia? " + queue.isEmpty());

        System.out.println("------------------------------------------------------------------------");

        System.out.println("Limpando a fila");
        queue.clear();

        System.out.println("A fila está limpa? " + queue.isEmpty());
    }
}