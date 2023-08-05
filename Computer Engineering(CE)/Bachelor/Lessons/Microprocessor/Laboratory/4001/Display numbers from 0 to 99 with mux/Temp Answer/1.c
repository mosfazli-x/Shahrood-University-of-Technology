#include <mega32.h>
#include <stdio.h>
#include <delay.h>


void main(void)
{
int SEG[10] = {0x3F,0x06,0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F};
int i = 0 , j = 0;

while (1)
      {
        DDRA = 0xFF;
        DDRB = 0xFF;
        
        for ( i = 0; i < 10; ++i) {
            if (i == 0) {
                for ( j = 0; j < 10; ++j) {
                    //printf("%d ", j);
                    PORTB = SEG[j];
                    delay_ms(20);
                }
            }else {
                for ( j = 0; j < 10; ++j) {
                    PORTA = SEG[i];
                    PORTB = SEG[j];
                    delay_ms(20);
                }
            }
        }

      }
}
