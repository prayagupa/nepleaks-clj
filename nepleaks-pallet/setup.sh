echo "[info] : Turn off auth (only needs to be done once)"
echo ""

VBoxManage setproperty websrvauthlibrary null

echo "[info] : Start VirtualBox listening"
echo ""
vboxwebsrv -t0
