#include <stdio.h>
#include <stdlib.h>

int main() {
    // Fail to compile due to type mismatch.
    int a = 1;
    char *b = "hello";

    a / b;
}
