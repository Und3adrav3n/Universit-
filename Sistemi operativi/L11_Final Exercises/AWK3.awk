BEGIN {
	printf("[Continente] [Numero medio di abitanti]\n")
}

{
	abitanti[$4] += $3
	nazioni[$4] += 1
}

END {
	for (i in abitanti)
	{
		printf("%s %lf\n", i, abitanti[i]/nazioni[i])
	}
}
