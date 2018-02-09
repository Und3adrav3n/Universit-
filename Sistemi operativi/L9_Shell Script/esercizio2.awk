/^A:/ {
	for(i=1; i <= NF; i++)
	{
		if($i ~ /^[0-9]+$/)
			printf("%s ", $i*2) >> "doppio.txt";
		else
			printf("%s ", $i) >> "doppio.txt";
	}
	printf("\n") >> "doppio.txt";
}

/^[B-Z]:/ { print >> "doppio.txt"; }
