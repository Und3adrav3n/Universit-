{
	num = int($5/1024);
	distrib[num]++;

	if(num > max)
		max = num;
}

END {
	print "Istogramma:\n"

	for(i=0; i<=max; i++)
	{
		printf("[%6d - %6d] K = %6d |", i, i+1, distrib[i]);
		
		for(j=0; j < distrib[i]; j++) printf("*")
			printf("\n");
	}
}
