(ns nepleaks-engine.engine-test
  (:require [clojure.test         :refer :all]
            [nepleaks-engine.services.esService :as esService]))

(deftest esServiceTest
  (testing "es service."
    (esService/getEsMapping)
    (is (= 1 1))))
