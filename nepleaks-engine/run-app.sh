lein clean
lein deps

runApp(){
  lein run -m nepleaks-engine.core
  #lein run -m nepleaks-engine.services.leaksSplitterTridentClient
}

runApp
