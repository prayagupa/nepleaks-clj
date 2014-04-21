;;
;; http://onclojure.com/2009/03/05/a-monad-tutorial-for-clojure-programmers-part-1/
;;

(ns nepleaks-engine.util.utility)

(defn displaySourceStream
  "I don't do a whole lot."
  [sourceName]
  (println "Hello," sourceName))

(defn hackMonad []
(let [a  1
      b  (inc a)]
  (* a b)))
