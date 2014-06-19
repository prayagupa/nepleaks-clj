clean(){
 lein clean
 lein deps
}

runApp(){	
  #echo("[info] : make sure you've started neo4j.")
  #lein run -m nepleaks-engine.core

  echo "[info] : storm separately needs not to start."
  #TODO ask options to start neo (y,n)
  processId=$(pgrep neo4j);

  echo "#################################"
  echo $processId;
  echo "#################################"

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

test(){
  lein test
}

case "$2" in 	
	development)
             case "$1" in
                clean) 
                     clean
                     ;;
                runApp)
                    runApp
                    ;;
                test)
                    test
                    ;;
                *)
                    echo "Usage: $0 {clean|runApp|test}"
                    exit 1
                    ;;
            esac
	    ;;
       *)
          echo "Usage $0 {clean|runApp|test} {dev}"
          exit 2
          ;;
esac 
