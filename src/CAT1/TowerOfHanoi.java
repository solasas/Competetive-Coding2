package CAT1;

class TowerOfHanoi {
    public int towerOfHanoi(int n, int from, int to, int aux) {

        // Base case
        if (n == 1) {
            System.out.println("move disk 1 from rod " + from + " to rod " + to);
            return 1;
        }

        // Step 1: move n-1 disks from 'from' to 'aux'
        int moves1 = towerOfHanoi(n - 1, from, aux, to);

        // Step 2: move nth disk
        System.out.println("move disk " + n + " from rod " + from + " to rod " + to);

        // Step 3: move n-1 disks from 'aux' to 'to'
        int moves2 = towerOfHanoi(n - 1, aux, to, from);

        return moves1 + 1 + moves2;
    }
}