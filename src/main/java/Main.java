class Main {
  public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        q.insert(5);
        q.insert(7);
        q.insert(8);
        q.insert(9);
        q.insert(10);
        Queue<Integer> q1 = createqueue();
        System.out.println(q1);
        System.out.println(q);
        System.out.println(ex_1(q));
        System.out.println(q);
        System.out.println(ex_2(q));
        System.out.println(ex_3(q, 35));
        System.out.println(ex_4(q1, q));
        System.out.printf("%s | %s\n", q1, q);
        System.out.println(ex_5(q1, 4));

    }

    public static Queue<Integer> createqueue() {
        Queue<Integer> q = new Queue<>();
        try (Scanner rd = new Scanner(System.in)) {
            int x = rd.nextInt();
            while (x != -1) {
                q.insert(x);
                x = rd.nextInt();
            }
        }
        return q;
    }

    public static <T> Queue<T> ex_1(Queue<T> q) {
        Queue<T> co = new Queue<>();
        Queue<T> te = new Queue<>();
        while (!q.isEmpty()) {
            T vl = q.remove();
            co.insert(vl);
            te.insert(vl);
        }
        while (!te.isEmpty())
            q.insert(te.remove());
        return co;
    }

    public static double ex_2(Queue<Integer> q1) {
        Queue<Integer> q2 = ex_1(q1);
        double sum = 0;
        int i = 0;
        while (!q2.isEmpty()) {
            sum += q2.remove();
            i++;
        }
        return sum / i;
    }

    public static int ex_3(Queue<Integer> q1, int num) {
        int x = 0;
        Queue<Integer> q2 = ex_1(q1);
        while (!q2.isEmpty()) {
            if (num % q2.remove() == 0)
                x++;
        }
        return x;
    }

    public static boolean ex_4(Queue<Integer> q1, Queue<Integer> q2) {
        Queue<Integer> q3 = ex_1(q1);
        while (!q3.isEmpty()) {
            if (ex_3(q2, q3.remove()) == 0)
                return false;
        }
        return true;
    }

    public static <T> boolean ex_5(Queue<T> q1, T x) {
        Queue<T> q2 = ex_1(q1);
        if (q2.isEmpty())
            return false;
        T prev = q2.remove();
        while (!q2.isEmpty()) {
            T now = q2.remove();
            if (prev == now && prev == x)
                return true;
            prev = now;
        }
        return false;
    }
}
