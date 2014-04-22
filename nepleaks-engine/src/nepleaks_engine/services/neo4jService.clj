;;
;; @see : http://clojureneo4j.info/articles/getting_started.html
;; @see : https://www.youtube.com/watch?v=H94-MEXcGAs
;;

(ns nepleaks-engine.services.neo4jService
  (:require [clojurewerkz.neocons.rest               :as nr]
            [clojurewerkz.neocons.rest.nodes         :as nn])
            ;;[clojurewerkz.neocons.rest.relationships :as nrl]
)

;; connects to the default Neo4J Server host/port/path
(defn connectToNeoleaks []
  (println "connecting to neo4j leakers")
  (nr/connect! "http://localhost:7474/db/data/"))

(comment
(defn insertNodes []
    (let [govt    (nn/create {:title "Govt files"                :leaker "prayagupd"})
          embassy (nn/create {:title "Embassy Diplomatic Cables" :leaker "j"})
          war     (nn/create {:title "War Diary: Nepal War Logs" :leaker "prab"})]
                   ;; printing here will force the lazy response sequence to be evaluated
                   (println nodes))))

(defn insertNodesInBatch []
    (let [nodes (nn/create-batch [{:title "Govt files"                :leaker "prayagupd"}
                                  {:title "Embassy Diplomatic Cables" :leaker "j"}
                                  {:title "War Diary: Nepal War Logs" :leaker "prab"}])]
                   ;; printing here will force the lazy response sequence to be evaluated
                   (println nodes)))

(comment
(defn insertNodesWithRelation []
 (let [govt    (nn/create {:title "Govt files"                 :leaker "prayagupd"})
       embassy (nn/create {:title "Embassy Diplomatics cables" :leaker "j"})
       rel     (nrl/create govt embassy :corruption {:on "2011"})]
    (println (nn/get (:id govt)))
    (println (nn/get (:id embassy))))))

;;
;;@see : http://clojureneo4j.info/articles/populating.html
;;
(defn bootstrapNeoleaks []
  (connectToNeoleaks)
  (insertNodesInBatch))
