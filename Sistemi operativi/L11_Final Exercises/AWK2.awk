BEGIN {
	print "[Nazioni asiatiche]\n"
	print "[nazione] [superficie] [popolazione]\n"
}

($4 == "Asia") {
	printf("%s %s %d", $1, $2, $3)
}


