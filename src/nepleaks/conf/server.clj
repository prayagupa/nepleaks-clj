;;
(ns nepleaks.conf.server
  (:require [clojurewerkz.elastisch.rest          :as esr]
            [clojurewerkz.elastisch.rest.document :as esd]
            [clojurewerkz.elastisch.query         :as q]
            [clojurewerkz.elastisch.rest.response :as esrsp]
            [clj-http.client                      :as client]
            [clojure.pprint                       :as pp]
  ))


(def ES_SERVER "http://localhost:9200/")
(def ES_INDEX "gccount")
;;(defmacro ES_TYPE_MEMBER [] "Member")
(def ES_TYPE_MEMBER "Member")
(def ES_MAPPING_URL (str ES_SERVER ES_INDEX "/" ES_TYPE_MEMBER "/_mapping?pretty=true"))

(def requestUrl "http://localhost:8080/gccount/dashboard")

(defn requestJsonServer []
   (client/post requestUrl {:accept :json})
)

(defn getEsMapping []
   (client/get ES_MAPPING_URL {:accept :json})
)

(defn getEsJson []
  (esr/connect! ES_SERVER)

  ;; fetch a single document by a known id
  ;; (esd/get ES_INDEX ES_TYPE_MEMBER "g:0xad8c81f57a9c06b293a87d54cb458126")

  ;; (esd/search ES_INDEX ES_TYPE_MEMBER :query {:term {:memberFirstName "Charlie"}})

  (let [res (esd/search ES_INDEX  ES_TYPE_MEMBER :query {:term {:currentStatus "Termed"}})
        numberOfHits (esrsp/total-hits res)
        hits         (esrsp/hits-from res)
        ]
    (println (format "Total document hits: %d" numberOfHits))
    
    ;; display the hit documents
    ;; (pp/pprint hits)
  ))

