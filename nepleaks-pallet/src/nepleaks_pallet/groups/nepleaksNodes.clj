(ns nepleaks-pallet.groups.nepleaksNodes
    "Node defintions for nepleaks-pallet"
    (:require
            [pallet.compute :refer [instantiate-provider]]
            [pallet.api :refer [group-spec server-spec node-spec plan-fn converge lift]]
            [pallet.compute :refer [images nodes]]
            [pallet.configure :refer [compute-service]]
            [pallet.crate.java :as java]
            [pallet.crate.automated-admin-user :refer [automated-admin-user]]
            [pallet.actions :as pact]
            [pallet.compute.vmfest :as vmf]))

;; A refer to hold the provider
;; There are several ways to configure providers, such as a local .pallet/config.clj file
;; Here is an example where we can be very explicit about what we want, and even develop
;; a solution that changes the cloud provider to suit our needs - e.g. some code goes to EC2,
;; sometimes we use VMFest (Oracle VirtualBox) for development, etc
(def provider (ref {}))

;; the pallet compute provider, such as EC2, VMFest, Docker, etc can be manipulated
;; programmatically, as done here, or configured centrally such as via a local ~/.pallet/config.clj file
;; there is also a lein plugin for working with them as lein tasks
(defn init-vmfest []
  "Initializes the vmfest cloud provider"
  (dosync
   (ref-set provider
            (hash-map :vmfest
                      (instantiate-provider "vmfest" :vbox-comm :ws)))))

;; Note image specification, such as RAM amount can be specified here
(def default-node-spec
  (node-spec
   :image {:image-id :ubuntu-13.04-64bit}
   :hardware {:min-cores 1}))

;; here is where the automated-admin-user, a representation of your current
;; user ID executing the program, and SSH key used to bootstrap the target VM
;; this enables seamless ssh to the VM
(def
  ^{:doc "Defines the type of node will run on"}
  base-server
  (server-spec
   :phases
   {:bootstrap (plan-fn (automated-admin-user))}))

;; typically a server spec is where all of the application specific configuration
;; will take place, such as moving files, unzipping them, etc
(def
  ^{:doc "Define a server spec"}
  example-server
  (server-spec
   :phases
   {:configure (plan-fn
                 (pact/file "/tmp/phase-configure-basenode" :owner "vmfest", :group "vmfest", :mode "0644")
                ;; add more functions here, usually using things out of the pallet.actions namespace
                 )}))

;; The group is what is used by converge or lift to spin up VMs and move configuration on to them
;; Each of servers will be executed in the order of phases (bootstrap, configure, install)
;; So per the above, base-server has a bootstrap with automated-admin-user which will be done first
;; next, the java server-spec will execute during the install phase
;; lastly, the example-server configure phase will create the remote file, finishing up the converge
(def
  ^{:doc "Defines a example group spec that can be passed to converge or lift."}
  example-group
  (group-spec
   "example-group"
   :extends [base-server example-server (java/server-spec {:vendor :oracle :version "7"})]
   :node-spec default-node-spec))
