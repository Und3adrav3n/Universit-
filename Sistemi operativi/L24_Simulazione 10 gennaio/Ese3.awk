#! /usr/bin/awk -f

BEGIN {
	for(i=1; i<=90; i++)
		nvolte[i]=0

}

{
	b=0

	for(i=2; i<8; i++)
		if($i < 1 || $i > 90)
			b=1
	
	for(i=2; b!=1 && i<8; i++)
		nvolte[$i]++
}

END{
	for(i=1; i<=90; i++)
		if(nvolte[i]>0)
			print i, nvolte[i]
}
