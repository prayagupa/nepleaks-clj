(ns nepleaks-engine.core
 (:use nepleaks-engine.services.stormService)
 (:require [clojure.data.json :as json]))

(defn helloStorm
  "I don't do a whole lot."
  [sourceName]
  (println "Hello," sourceName))

(defn getJson []
 (println str json/write-str {:name 1 :message 2}))

;;(defn -main []
  ;;(helloStorm "Storm")
  ;;(getJson)
;;)

(defn -main
  ([]     (runLocal!))                ;;when nothing is supplied
  ([name] (submitWordTopology! name)) ;;when name is supplied
)
