;;
;; @see : http://stackoverflow.com/a/12125548/432903
;;

(ns nepleaks.conf.nlp
       (:use [speech-synthesis.say :as    say]
             [clojure.java.shell   :only [sh]]
       )
)

(defn speak [textToSpeak]
   (say/say textToSpeak)
)
