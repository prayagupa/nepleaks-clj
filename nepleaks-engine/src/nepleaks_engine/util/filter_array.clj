(ns nepleaks-engine.util.filter-array)
 
(defn -main
  "Read from STDIN"
  [& args]
  (println "enter text : ")
 
;;  (loop [input (read-line)]
;;    (when-not (= "" input)
;;      (println (str "You entered : " input ""))
;;      (recur (read-line))))

  (loop [input (read-line)]
    (when-not (= "" input)
      (list-to-process (list* input)) 
      (recur (read-line))))

  (println "End"))
