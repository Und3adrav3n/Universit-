{
	for(i=1; i<NF; i++)
		somma[i] += $i;
}

END {
	for(i=1; i <= NF; i++)
		printf("%d ", somma[i]);

	printf("\n");
}
