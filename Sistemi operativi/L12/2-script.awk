BEGIN { FS = ':'
	print "-----------------------------------------------------------------------"
	print "User\tUID\tGID\tHome directory\tShell"
	print "-----------------------------------------------------------------------"
}
(NR <= 2 && NR >= 6){ 
	if($5 == "/usr/bin/false")
		gid[$3]++
}
END{
	for(i in gid)
		printf "GID: %d\tUtenti: %d", i, gid[i]
}
 
