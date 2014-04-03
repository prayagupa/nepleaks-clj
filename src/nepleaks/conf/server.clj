;;
(ns nepleaks.conf.server
  (:require [clojurewerkz.elastisch.rest          :as esr]
            [clojurewerkz.elastisch.rest.document :as esd]
            [clojurewerkz.elastisch.query         :as q]
            [clojurewerkz.elastisch.rest.response :as esrsp]
            [clj-http.client                      :as client]
            [clojure.pprint                       :as pp]
            [clojure.tools.logging                :as log]
  ))


(def ES_SERVER "http://10.0.4.70:9200/")
(def ES_INDEX "1000")
;;(defmacro ES_TYPE_MEMBER [] "Member")
(def ES_TYPE_MEMBER "MemberSearch")
(def ES_MAPPING_URL (str ES_SERVER ES_INDEX "/" ES_TYPE_MEMBER "/_mapping?pretty=true"))


(def selected "http://localhost:8443/DasTest/selectedProcedure?clientId=2000&reportingBasis=ServiceDate&reportingTo=2014-01-31&reportingFrom=2013-02-01&comparisonFrom=2012-02-01&comparisonTo=2013-01-31&report=selectedProcedure:default&eligibilityType=[medical]&reportingPaidThrough=2014-01-31&comparisonPaidThrough=2013-01-31&phiCSDate=09-01-2010&phiCEDate=01-31-2014")

(def requestUrl "http://localhost:8080/DasTest/dashboard?clientId=QA_1000&reportingBasis=ServiceDate&reportingTo=2013-05-31&reportingFrom=2012-06-01&comparisonFrom=2011-06-01&comparisonTo=2012-05-31&report=populationRisk&reportingPaidThrough=2013-05-31&comparisonPaidThrough=2012-05-31&recordTypes=[Medical,Pharmacy,Lab,Eligibility,Biometrics,HRA,Workers_Comp]&phiCSDate=06-01-2008&phiCEDate=05-31-2013")

(def selectedUrl "http://localhost:8443/DasTest/selectedProcedure?clientId=1000&reportingFrom=2012-12-01&reportingTo=2013-11-30&reportingPaidThrough=2013-11-30&comparisonFrom=2011-12-01&comparisonTo=2012-11-30&comparisonPaidThrough=2012-11-30&report=selectedProcedure:default&reportingBasis=ServiceDate&isParticipation=y&program_type={'Wellness':['Activity Tracker']}")


(defn requestJsonServer []
   (let [response (client/post selected {:accept :json})   
        ]
	(println response)
	)
)

(defn getEsMapping []
   (client/get ES_MAPPING_URL {:accept :json})
)

(defn getEsJson []
  (esr/connect! ES_SERVER)

  ;; fetch a single document by a known id
  ;; (esd/get ES_INDEX ES_TYPE_MEMBER "g:0xad8c81f57a9c06b293a87d54cb458126")

  ;; (esd/search ES_INDEX ES_TYPE_MEMBER :query {:term {:memberFirstName "Charlie"}})

  (log/info "Preparing to query the Es Server.")
  
  (let [res (esd/search ES_INDEX  ES_TYPE_MEMBER :query {:term {:currentStatus "Termed"}})
        numberOfHits (esrsp/total-hits res)
        hits         (esrsp/hits-from res)
        ]
    (println (format "Total document hits: %d" numberOfHits))
    
    ;; display the hit documents
    ;; (pp/pprint hits)
  ))

;; division function with Exception handling ;;
(defn divide [x y]
  (try
    (log/info "dividing" x "by" y)
    (/ x y)
    (catch Exception ex
      (log/error ex "There was an error in calculation."))))

