;;`
;; http://onclojure.com/2009/03/05/a-monad-tutorial-for-clojure-programmers-part-1/
;;
(ns nepleaks-engine.util.utility
  (:import [java.util Locale Date]
           [org.joda.time DateTimeZone]
           [org.joda.time.format DateTimeFormat DateTimeFormatter]
           [org.joda.time.tz FixedDateTimeZone])
   (:use
           [clojure.tools.logging :as log]))

(defn displaySourceStream
  "I don't do a whole lot."
  [sourceName]
  (println "Hello," sourceName))

(defn hackMonad []
(let [a  1
      b  (inc a)]
  (* a b)))

(defn equality []
 (if (= "staging" (str "stag" "ing_"))
       (let [bucketname "staging-cdn"]
       (println bucketname))
  ) (cond (= "production" "production")
          (let [bucketname "cdn"]
            (println bucketname))))

;(defn equality-iflet []
;   (if-let [(= "staging" (str "stag" "ing"))]
;       ("staging-cdn")
;       ("cdn")))

;;(defn equality-letif []
;;   (let [bucketname
;     (if (= "staging" "staging")
;       ("staging-cdn"))
;     (cond (= "production" "production_")
;       ("cdn"))]))

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


;; TODO move it to utils
;; division function with Exception handling ;;
(defn divide [x y]
  (try
    (log/info "dividing" x "by" y)
    (/ x y)
    (catch Exception ex
      (log/error ex "There was an error in calculation."))))

(defn string-hacks []
  (println (str  "sed -i '/setCollectorUrl/c\\soothsayer.push(['setCollectorUrl', " "'"  "trackerUrl" "']);' " "asyncSourcefile")))

(defn util []
  ;; (displaySourceStream "leaks-engine")
  ;; (hackMonad)
  
  ;; get-date
  (let [date (awsdate)]
    ;;(println (operation-test "staging"))
    ;;(println (operation-test "local"))
    ((string-hacks))))
