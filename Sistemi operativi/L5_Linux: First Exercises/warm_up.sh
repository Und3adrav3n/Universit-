mkdir uno due
cp /etc/profile ./uno/.
cp /etc/profile ./due/copia-profile
mv ./uno/profile ./due/
mv ./due/copia-profile ./uno/
rm ./uno/copia-profile ./due/profile
rmdir uno due
touch newfile
