
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; @desc: realtime processing what Hadoop did for batch processing
;; @see : https://www.youtube.com/watch?v=bdps8tE0gYo&list=PL65681C476097F57D
;; @see : https://github.com/apache/incubator-storm/blob/master/examples/storm-starter/src/clj/storm/starter/clj/word_count.clj
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns nepleaks-engine.services.stormService
  (:import [backtype.storm StormSubmitter LocalCluster])
  (:use    [backtype.storm clojure config]
           [nepleaks-engine.services.leakSpouts]
           [nepleaks-engine.services.leakBolts])
  (:gen-class))



;; 
(defn mk-topology []

  (topology
   {"1" (spout-spec sentence-spout)
    "2" (spout-spec (sentence-spout-parameterized
                     ["the cat jumped over the door"
                      "greetings from a faraway land"])
                     :p 2)}
   {"3" (bolt-spec {"1" :shuffle "2" :shuffle}
                   split-sentence
                   :p 5)
    "4" (bolt-spec {"3" ["word"]}
                   word-count
                   :p 6)}))

(defn runLocal! []
  (let [cluster (LocalCluster.)]                                               ;;instantiate cluster
    (.submitTopology cluster "word-count" {TOPOLOGY-DEBUG true} (mk-topology)) ;;call cluster.submitTopology
    (Thread/sleep 10000)   ;; 10 secs
    (.shutdown cluster)
    ))


(defn submitWordTopology! [name]
  (StormSubmitter/submitTopology
   name
   {TOPOLOGY-DEBUG true
    TOPOLOGY-WORKERS 3} ;; 3 physical JVM processes
   (mk-topology)))

