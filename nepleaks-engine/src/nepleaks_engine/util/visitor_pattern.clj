
;;
;; author prayagupd
;; references
;; http://clojure.org/runtime_polymorphism
;; https://clojuredocs.org/clojure.core/defmulti
;; https://weblogs.java.net/blog/manningpubs/archive/2013/02/20/multimethods-clojure
;;

(ns nepleaks-engine.util.visitor-pattern)

;;(defmulti name dispatch-fn & options)
;;(defmethod multifn dispatch-value & fn-tail)

;; EXPECTED RESULT
;; For :mint.com   (user1)  30.0
;; For :google.com (user2)  9.0
;; For :yahoo.com  (user3)  14.0


(defn compute-amount [percentage user]
  (float (* 0.01 percentage (:salary user))))


;;
;; abstraction on referrer
;; public interface Visitable {
;;   public <T> void accept(Visitor<T> v);
;; }

(defmulti accept :referrer)

(defmethod accept :mint.com [user]
  (compute-amount 0.03 user))

(defmethod accept :google.com [user]
  (compute-amount 0.01 user))

(defmethod accept :default [user]
  (compute-amount 0.02 user))


;;
;; uses
;;

(def user-1 {:login "prayag upd"    :referrer :mint.com   :salary 100000})
(def user-2 {:login "rajesh hamal"  :referrer :google.com :salary 90000})
(def user-3 {:login "steven wilson" :referrer :yahoo.com  :salary 70000})

(defn visitor []
 (println "For :mint.com   (user1) " (accept user-1))
 (println "For :google.com (user2) " (accept user-2))
 (println "For :yahoo.com  (user3) " (accept user-3)))
