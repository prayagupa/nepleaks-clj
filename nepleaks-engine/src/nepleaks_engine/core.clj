(ns nepleaks-engine.core
 (:use nepleaks-engine.services.stormService
       nepleaks-engine.services.neo4jService
       nepleaks-engine.util.utility)
 (:require [clojure.data.json :as json]))


(defn getJson []
 (println str json/write-str {:name 1 :message 2}))

(defn -main []
  ;;(displaySourceStream "medical-engine")
  ;;(getJson)
  ;;(hackMonad)
  (bootstrapNeoleaks)
)

;;(defn -main
;;  ([]     (runLocal!))                ;;when nothing is supplied
;;  ([name] (submitWordTopology! name)) ;;when name is supplied
;;)
