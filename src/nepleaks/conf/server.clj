;;
(ns nepleaks.conf.server
  (:require [clojurewerkz.elastisch.rest          :as esr]
            [clojurewerkz.elastisch.rest.document :as esd]
            [clj-http.client                      :as client]
  ))

(defn getJson []
  (esr/connect! "http://127.0.0.1:9200")

  ;; fetch a single document by a known id
  (esd/get "1000" "MemberSearch" "g:0xad8c81f57a9c06b293a87d54cb458126")
)



(defn requestJsonServer [ ]
       (client/post "http://localhost:8080/DasTest/trendingReport?report=chronicConditionUtilization:default&clientId=2000&reportingBasis=ServiceDate&reportingFrom=2013-01-01&reportingTo=2013-11-01&reportingPaidThrough=2013-11-01" {:accept :json})
)       

(println apply str (requestJsonServer))

