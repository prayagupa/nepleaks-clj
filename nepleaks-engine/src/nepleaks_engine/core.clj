(ns nepleaks-engine.core
 (:use nepleaks-engine.services.stormService))

(defn helloStorm
  "I don't do a whole lot."
  []
  (println "Hello, Storm!"))

(defn -main []
  (helloStorm))
