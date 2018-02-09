BEGIN {
	FORMAT="\t%-18s%s\n"
	printf FORMAT, "SQUADRE", "PUNTI"
}

{
	if($3 > $4)
	{
		punti[$1] += 3
	}
	
	if($3 < $4)
	{
		punti[$2] += 3
	}
	
	if($3 == $4)
	{
		punti[$1]++
		punti[$2]++
	}
}

END {
	ordina = "sort -k 2nr"

	for i in c
	{
		printf(FORMAT, i, c[i]) | ordina
	}
	close(ordina)
}
