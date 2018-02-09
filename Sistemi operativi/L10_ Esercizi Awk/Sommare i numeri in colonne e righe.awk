BEGIN {
	print "\n\t\t___SOMMA___\n"
	FS="+"
	OFS="\t"
}

{
	somma=0;
	print "\t"

	for(i=1; i <= NF; i++)
	{
		print $i
		colonne[i]+=$i
		somma+=$i
	}

	print "| ", somma 
}

END {
	print "\t________________________________\n"
	print "\t" somma[1], somma[2], somma[3], "--> "(somma[1]+somma[2]+somma[3])" (Totale)","\n";
}


