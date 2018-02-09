BEGIN {
	FS = ";";
}

{
	for(i=1; i<=NF;i++)
	{
		if($i=="Luigi")
		{
			count++;
		}
	}
}

END {
	printf("Il nome Luigi ricorre %d volte", count);
}
