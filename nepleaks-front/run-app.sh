app=nepleaks
logDir=logs
date=`date +%Y-%m-%d`
logDateDir=$logDir/$date
##########################
###### start es ##########

##################################################################
############################ start server ########################
##################################################################
if [ ! -d "$logDir" ]; then
   mkdir $logDir
fi

if [ ! -d "$logDateDir" ]; then 
   mkdir $logDateDir
fi

appender=$logDateDir/$app-$date.log
lein deps
lein ring server 8443 > $appender #&
#tail -f $appender