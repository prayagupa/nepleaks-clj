(ns storm-hello-world.TopologySubmitter
  "This file is necessary for submitting a topology to Nimbus/Zookeeper ; remember to anotate :aot in project.clj with the class that is generated here with gen-class"
  (:require [storm-hello-world.topology :refer [example-topology]]
            [backtype.storm [config :refer :all]]
            [clojure.tools.logging :as log])
  (:import [backtype.storm StormSubmitter])
  (:gen-class))

(defn -main
  [& {max-spout-pending :max-spout-pending
      debug :debug
      workers :workers
      :or {
           ; TODO: Make max-spout-pending bigger some day
           max-spout-pending "200"
           debug "false"
           workers "4"
           }}]
  (log/info "============= Submitting topology...======================")
  (StormSubmitter/submitTopology
   "Example_Topology"
   {TOPOLOGY-DEBUG (Boolean/parseBoolean debug) ; Java interop which parses a String to a Boolean type
    TOPOLOGY-WORKERS (Integer/parseInt workers) ; Java interop which parses a String to an Integer
    TOPOLOGY-MAX-SPOUT-PENDING (Integer/parseInt max-spout-pending)}
   example-topology))
