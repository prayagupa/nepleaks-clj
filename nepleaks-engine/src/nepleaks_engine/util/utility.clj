;;`
;; http://onclojure.com/2009/03/05/a-monad-tutorial-for-clojure-programmers-part-1/
;;
(ns nepleaks-engine.util.utility
  (:import [java.util Locale Date]
           [org.joda.time DateTimeZone]
           [org.joda.time.format DateTimeFormat DateTimeFormatter]
           [org.joda.time.tz FixedDateTimeZone])
   (:use
           [nepleaks-engine.util.visitor-pattern :as xyz]
           [clojure.tools.logging :as log]))

(defn displaySourceStream
  "I don't do a whole lot."
  [sourceName]
  (println "Hello," sourceName))

;; 
;; default value for function argument in clj
;; http://stackoverflow.com/a/8660833/432903
;;
(defn string-to-integer [string & {:keys [base] 
                                 :or {base 10}}]
      (Integer/parseInt string base))

(defn disable-services {:os :debian-base} [os os-version services]
  (println "services = " services))

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


;; TODO move it to utils
;; division function with Exception handling ;;
(defn divide [x y]
  (try
    (log/info "dividing" x "by" y)
    (/ x y)
    (catch Exception ex
      (log/error ex "There was an error in calculation."))))

(defn string-hacks []
  (println (str "while read line; do echo $line1 >> ~/bin/cassandra/conf/log4j-server.properties ; done <<< \"$LOG4J\""))
  (println (str  "sed -i '/setCollectorUrl/c\\soothsayer.push(['setCollectorUrl', " "'"  "trackerUrl" "']);' " "asyncSourcefile"))
  (println (str "sed -i '/JMX_PORT/c\\JMX_PORT=\"7200\"' ~/bin/cassandra/conf/cassandra-env.sh")))

(defn sum [] 
  (println "Enter two numbers in separate lines : ")
  (let [a (read-line)
        b (read-line)]
    (+ (Integer/parseInt a) (Integer/parseInt b))))

;;
;; https://github.com/rodnaph/99-clojure-problems/blob/master/src/lisp_problems/lists.clj#L121
;;
(defn repeat-n-times [ times list-to-process ]
      ;;(mapcat #(list % %) list-to-process)
      (println "vector = " list-to-process)
      (mapcat #(repeat times %) list-to-process))

(defn test-repeat-list []
  (println "Input times and vector")
  (let [times  (read-line)
        list-to-process (list* (repeatedly 4 read-line))]
     (println (repeat-n-times (Integer/parseInt times) list-to-process))))

(defn repeat-2-times [repeat vector]
  (reduce 
    #(concat %1 (repeat 2 %2))
      '() vector))

(defn util-entry []
  ;; (displaySourceStream "leaks-engine")
  ;; (hackMonad)
    (println "sum = " (sum))
    ;;(println (repeat-n-times 3 '(1,2,3,4)))
    (string-hacks)
    (test-repeat-list)
    (disable-services "android" "7" ["zookeeper"])
    (println "10 in base 10 = " (string-to-integer "10"))
    (println "10 in base  8 = " (string-to-integer "10" :base 8))
    (visitor)
)
