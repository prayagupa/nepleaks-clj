(ns storm-hello-world.core
  (:import [backtype.storm LocalCluster]) ; Import is for Java classes
  (:require
   [storm-hello-world.topology :refer [example-topology]]
   [backtype.storm
    [clojure :refer [topology spout-spec bolt-spec]]
    [config :refer :all]]))

(defn run! [& {debug :debug
               workers :workers
               max-spout-pending :max-spout-pending
               :or {debug "true"
                    workers "2"
                    max-spout-pending "200"}}]
  (doto
    (LocalCluster.)
    (.submitTopology "example_topology_simulated_local_cluster"
                     {TOPOLOGY-DEBUG (Boolean/parseBoolean debug)
                      TOPOLOGY-WORKERS (Integer/parseInt workers)
                      TOPOLOGY-MAX-SPOUT-PENDING (Integer/parseInt max-spout-pending)}
                     example-topology)))
