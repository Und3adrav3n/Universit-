BEGIN {
	printf("[Nazione] [Continente]\n")
}

{
	print $1, $2
}
