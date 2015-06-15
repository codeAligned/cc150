unsigned int i;
for(i=100; i>=0; --i)
	printf("%d\n", i);

There are 2 mistakes

1 unsigned int is always greater than or equal to zero. The for loop will always be true and will loop infinitely.

2 use %u in place of %d

unsigned int i;
for(i=100; i>0; --i)
	printf("%u\n", i);