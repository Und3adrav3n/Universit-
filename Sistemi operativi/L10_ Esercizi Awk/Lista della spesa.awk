BEGIN {
	FORMAT="\t%-14s%-18s%s\n"
	printf(FORMAT, "TOTALE", "PRODOTTI", "COSTI%")
}

{
	spesa[$4]=$1
	somma+=$1
}

END {
	print "\n\t", somma, "euro"

	for (i in spesa)
	{
		printf(FORMAT, sum, i, (100*spesa[i])/somma)
	}
}
