;;
(ns nepleaks.conf.server
  (:require [clojurewerkz.elastisch.rest :as esr]
            [clojurewerkz.elastisch.rest.document :as esd]
  ))

(defn getJson []
  (esr/connect! "http://127.0.0.1:9200")

  ;; fetch a single document by a known id
  (esd/get "1000" "MemberSearch" "g:0xad8c81f57a9c06b293a87d54cb458126")
)

