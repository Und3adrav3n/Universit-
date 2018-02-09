BEGIN { FS = ':'
	print "-----------------------------------------------------------------------"
	print "User\tUID\tGID\tHome directory\tShell"
	print "-----------------------------------------------------------------------"
}

(NR<=12){
		printf "%s\t%s\t%s\t%s\t%s\n"
		gid[$3]++;
}
END{
	for(i in gid)
		if(gid[i] > 2)
			printf "GID: %d\tUtenti: %d", i, gid[i]
}
 
