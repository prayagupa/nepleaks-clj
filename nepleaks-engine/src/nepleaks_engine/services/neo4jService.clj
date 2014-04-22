;;
;; @see : http://clojureneo4j.info/articles/getting_started.html
;; @see : https://www.youtube.com/watch?v=H94-MEXcGAs
;;

(ns nepleaks-engine.services.neo4jService
  (:require [clojurewerkz.neocons.rest :as nr]))

;; connects to the default Neo4J Server host/port/path
(defn connectToNeoleaks []
  (nr/connect! "http://localhost:7474/db/data/"))
