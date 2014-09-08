
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;; leakerService
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns nepleaks-engine.services.leakerEsService
  (:require [clojurewerkz.elastisch.rest          :as esr]
            [clojurewerkz.elastisch.rest.document :as esd]
            [clojurewerkz.elastisch.query         :as q]
            [clojurewerkz.elastisch.rest.response :as esrsp]
            [clj-http.client                      :as client]
            [clojure.pprint                       :as pp]
            [clojure.tools.logging                :as log]))


(def ES_SERVER "http://localhost:9200/") ;;CHANGEME
(def ES_INDEX "3056")                 ;;CHANGEME
(def ES_TYPE_MEMBER "Billing")            ;;CHANGEME
(def ES_MAPPING_URL (str ES_SERVER ES_INDEX "/" ES_TYPE_MEMBER "/_mapping?pretty=true"))

(defn leakers []
  (log/info "Preparing to query the Es Server.")
  "prayagupd")
