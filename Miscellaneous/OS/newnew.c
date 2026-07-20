#include <stdio.h>

void tower(int n, char src, char aux, char dest) {
    if (n == 0)
        return;

    tower(n - 1, src, dest, aux);

    printf("Move disk %d from %c to %c\n", n, src, dest);

    tower(n - 1, aux, src, dest);
}

int main() {
    int n = 10;

    tower(n, 'A', 'B', 'C');
    

    return 0;
}
