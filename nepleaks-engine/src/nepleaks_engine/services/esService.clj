;;
;; leaksEsService
;;
(ns nepleaks-engine.services.esService
  (:require [clojurewerkz.elastisch.rest          :as esr]
            [clojurewerkz.elastisch.rest.document :as esd]
            [clojurewerkz.elastisch.query         :as q]
            [clojurewerkz.elastisch.rest.response :as esrsp]
            [clj-http.client                      :as client]
            [clojure.pprint                       :as pp]
            [nepleaks-engine.conf.config          :as conf]
            [clojure.tools.logging                :as log]))

;;(defmacro ES_TYPE_MEMBER [] "Member")
(def ES_TYPE_MEMBER "MemberSearch")
(def ES_MAPPING_URL (str (get (conf/es-server) :hostname) (get (conf/es-server) :index) "/" ES_TYPE_MEMBER "/_mapping?pretty=true"))


(def urlsMap
  {:selected "http://localhost:8443/DasTest/selectedProcedure?clientId=2000&reportingBasis=ServiceDate&reportingTo=2014-01-31&reportingFrom=2013-02-01&comparisonFrom=2012-02-01&comparisonTo=2013-01-31&report=selectedProcedure:default&eligibilityType=[medical]&reportingPaidThrough=2014-01-31&comparisonPaidThrough=2013-01-31&phiCSDate=09-01-2010&phiCEDate=01-31-2014"

  :requestUrl "http://localhost:8443/DasTest/provider?clientId=2000&reportingFrom=04-01-2013&reportingTo=03-31-2014&phiCSDate=11-01-2010&phiCEDate=03-31-2014&report=grs:group"})


(defn requestJsonServer []
   (let [response (client/post (:requestUrl urlsMap) {:accept :json})]
	(println response)))

(defn getEsMapping []
   (client/get ES_MAPPING_URL {:accept :json}))

(defn getEsJson []
  (esr/connect! (get (conf/es-server) :hostname))

  ;; fetch a single document by a known id
  ;; (esd/get ES_INDEX ES_TYPE_MEMBER "g:0xad8c81f57a9c06b293a87d54cb458126")

  ;; (esd/search ES_INDEX ES_TYPE_MEMBER :query {:term {:memberFirstName "Charlie"}})

  (log/info "Preparing to query the Es Server.")
  
  (let [res (esd/search (get es-server :index)  ES_TYPE_MEMBER :query {:term {:currentStatus "Termed"}})
        numberOfHits (esrsp/total-hits res)
        hits         (esrsp/hits-from res)]
    (println (format "Total document hits: %d" numberOfHits))
    
    ;; display the hit documents
    ;; (pp/pprint hits)
  ))
