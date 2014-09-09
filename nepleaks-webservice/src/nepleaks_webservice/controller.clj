(ns nepleaks-webservice.controller
 (:use 
       nepleaks-webservice.services.neo4jService
       nepleaks-webservice.services.esService
       nepleaks-webservice.util.utility)
 (:require [clojure.data.json :as json]))


(defn getJson []
 (println str json/write-str {:name 1 :message 2}))

(defn -main []
  ;;(displaySourceStream "medical-engine")
  ;;(getJson)
  ;;(hackMonad)
  (requestJsonServer)
  ;;(bootstrapNeoleaks)
)

;;(defn -main
;;  ([]     (runLocal!))                ;;when nothing is supplied
;;  ([name] (submitWordTopology! name)) ;;when name is supplied
;;)
