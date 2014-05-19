(ns nepleaks-pallet.main
  (:use [clojure.tools.cli :only (cli)]
        [clojure.pprint])
  (:gen-class :main true)
  (:require
            [pallet.api            :refer [group-spec server-spec node-spec plan-fn converge lift]]
            [pallet.compute        :refer [nodes images]]
            [clojure.pprint        :refer [pprint]]
            [pallet.compute.vmfest :refer [add-image]]
            [pallet.node           :refer [group-name primary-ip]]
            [pallet.phase          :as pphase]
            [pallet.actions        :as pact]
            [clojure.java.io       :as io]
            [nepleaks-pallet.groups.nepleaksNodes :as pvm]
            [clojure.java.shell                   :as csh]))


;; Simple example showing creatin of a compute service provider, via vmfest
;; and the converge of it
;; Note you'll have to shut down the VM manually in this example
(defn -main [& args]
  (do
    (pvm/init-vmfest)
    (when-not (contains? (images (:vmfest @pvm/provider)) :ubuntu-13.04-64bit)
      (println "Adding default ubuntu VM")
      (add-image (:vmfest @pvm/provider) "https://s3.amazonaws.com/vmfest-images/ubuntu-13.04-64bit.vdi.gz"))
    (println "Spinning up example-group virtual machine")
    (converge {pvm/example-group 1} :compute (:vmfest @pvm/provider))
    (println "Completed VM creation")
    (println (nodes (:vmfest @pvm/provider)))
    (System/exit 0)))

