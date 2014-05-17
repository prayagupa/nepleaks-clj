lein clean
lein deps

runApp(){	
  #echo("[info] : make sure you've started neo4j.")
  #lein run -m nepleaks-engine.core

  echo "[info] : storm separately needs not to start."
  lein run -m nepleaks-engine.core


  #lein run -m nepleaks-engine.services.leaksSplitterTridentClient
}

runApp
