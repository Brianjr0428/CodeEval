#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
  int i,j;
  for (i=1;i<13;i++){
      for (j=1;j<13;j++){
         if (i*j<10)
            printf("   %d",i*j);
         else if (i*j>9&&i*j<100)
            printf("  %d",i*j);
         else if (i*j>99)
            printf(" %d",i*j);
      }
      printf("\n");
  }
}
