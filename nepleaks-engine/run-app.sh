lein clean
lein deps

runApp(){	
  #echo("[info] : make sure you've started neo4j.")
  #lein run -m nepleaks-engine.core

  echo "[info] : storm separately needs not to start."
  #TODO ask options to start neo (y,n)
  processId=$(ps -ef | grep neo4j);
  if [ "$processId" ];
  then
        echo "#############################################"
        echo "####### neo4j is already running ############";
        echo "#############################################"
  else
        echo "############## start neo4j ##################";
        echo "#############################################"
        ./neo4jBootstrap.sh
        echo "#############################################"
  fi

  lein run -m nepleaks-engine.core

  #lein run -m nepleaks-engine.services.leaksSplitterTridentClient
}

runApp
