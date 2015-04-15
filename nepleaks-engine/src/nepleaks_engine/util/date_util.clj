;;`
;; http://onclojure.com/2009/03/05/a-monad-tutorial-for-clojure-programmers-part-1/
;;
(ns nepleaks-engine.util.date-util
  (:import [java.util Locale Date]
           [org.joda.time DateTimeZone]
           [org.joda.time.format DateTimeFormat DateTimeFormatter]
           [org.joda.time.tz FixedDateTimeZone])
   (:use
           [clojure.tools.logging :as log]))


(defn aws-time []
  (let [aws-date-value (java.util.Date.)]
  (println aws-date-value)))

(defn awsdate []
    (let [GMT              (new FixedDateTimeZone "GMT" "GMT" 0 0)
          rfc822           (. DateTimeFormat forPattern "EEE, dd MMM yyyy HH:mm:ss z")
          locale           (. Locale US)
          rfcL             (. rfc822 withLocale locale)
          rfcT             (. rfcL withZone GMT)
          date             (Date.)
          datetime         (. date getTime)
          finalDate        (. rfcT print datetime)]
    (str finalDate)))



(defn date-util-entry []
  ;; get-date
  (let [date (awsdate)]
    (println "date = " date)))
