(ns nepleaks-engine.core
 (:use nepleaks-engine.services.stormService
       nepleaks-engine.services.neo4jService
       nepleaks-engine.util.utility
       nepleaks-engine.util.collection-util)
 (:require [clojure.data.json :as json]))

(defn getJson []
 (println str json/write-str {:name 1 
                              :message 2
                              }))

;;(defn -main
;;  ([]     (runLocal!))                ;;when nothing is supplied
;;  ([name] (submitWordTopology! name)) ;;when name is supplied
;;)

(defn -main []
  (println "================================")
  ;;(displaySourceStream "medical-engine")
  ;;(getJson)
  ;;(hackMonad)
  ;;(bootstrapNeoleaks)
  (println (get-nth-elem-map :production))
  (println (get-nth-elem 2))
  (println "================================")
) 

