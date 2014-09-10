(ns nepleaks-webservice.es-service-test
  (:require [clojure.test         :refer :all]
            [nepleaks-webservice.services.esService :as esService]))

(deftest mappingTest
  (testing "es service."
    (println (esService/getEsMapping))
    (is (= 1 1))))

(deftest getJsonTest
  (testing "get json service."
    (println (esService/getEsMapping))
    (is (= 1 1))))
