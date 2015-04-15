
(ns nepleaks-engine.util.collection-util
  (:import [java.util Locale Date]
           [org.joda.time DateTimeZone]
           [org.joda.time.format DateTimeFormat DateTimeFormatter]
           [org.joda.time.tz FixedDateTimeZone])
  (:use     [clj-yaml.core :as yaml] ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;http://stackoverflow.com/q/10801744/432903
;; list/vector and set
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def array [4 5 6])
(def clothes-votes-vector [1 2 3 4 5 6])

;;http://clojure-doc.org/articles/language/collections_and_sequences.html
(def clothes-vector ["Jacket" "Pants" "Gauge" "Hat" "Shirts" "Shoes"])
(def clothes-set #{"Jacket" "Pants" "Gauge" "Hat" "Shirts" "Shoes"})

(defn get-nth-elem [elem]
  (println (str "Getting element of a vector, same for 'list/#set"))
  (some #{elem} [1 2 3 4]))

(defn process-clothes-vector [clothes-vector]
  (let [buy-clothes (map #(str "Buy " % " ASAP. " ) ["Jacket" "Pants" "Hat"])
        buy-clothes-str (apply str buy-clothes)]
       (println (str "Processed clothes for buying : " buy-clothes-str))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;; map ;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn nohup-config [service-name] 
  {:service-name service-name
   :run-file {
    :content (str "#!/bin/sh\nexec " service-name)}})

;; http://stackoverflow.com/questions/6685916/how-to-iterate-over-map-keys-and-values
(def dbMap {:classname "com.mysql.jdbc.Driver" 
            :subprotocol "mysql" 
            :subname "//10.0.7.40:3306/neleaks" 
            :username "root" 
            :password "mysql55"})

(defn printDbMap []
  (doseq [keyVal dbMap] (prn keyVal)))

(defn dbMapX []
  (let []))

;; http://blog.jayfields.com/2010/07/clojure-destructuring.html
(def book {:name "SICP" 
           :details {:pages 657 
                     :isbn-10 "0262011530"
                    }})

(defn printBook []
(let [{name :name 
       {:keys [pages isbn-10]} :details} book]
     (println "name:" name)
     (println "pages:" pages)
     (println "isbn-10:" isbn-10)))

;;
(def buckets-map {:production "cdn" 
              :staging "staging-cdn"})

(defn get-nth-elem-map [elem]
  (println (str "Getting element of a map " buckets-map))
  (some #{elem} buckets-map))

(defn get-bucket [env]
  (let [ bucketname (buckets-map (keyword env))]
        (println bucketname)))

(defn operation-test [cluster]
  (if (or (= "staging-cdn" (str (buckets-map (keyword cluster)))) (= "cdn" (str (buckets-map (keyword cluster)))))
       ;;(println (str "#####" cluster "#####"))
       (str cluster " passed")))

(defn generate-yaml []
   (let [config-yaml (yaml/generate-string buckets-map)]
     (println config-yaml)))

;;main-entry
(defn collection-entry []
  ;; (printBook)
  ;; (get-bucket "staging")
  (let [first-elem (get-nth-elem 1)]
      (println first-elem))
  (process-clothes-vector clothes-vector)
  ;;(println (operation-test "staging"))
  ;;(println (operation-test "local"))
  ;;(doseq [keyval (nohup-config "nimbus")] (prn keyval))
  (generate-yaml)
  )
