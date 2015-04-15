
(ns nepleaks-engine.util.visitor-pattern)

;;(defmulti name dispatch-fn & options)
;;(defmethod multifn dispatch-value & fn-tail)

;; EXPECTED RESULT
;; For user1  30.0
;; For user2  9.0
;; For user3  14.0


;;
;; public interface Visitable {
;;   public <T> void accept(Visitor<T> v);
;; }

(defmulti accept :referrer)

(defn compute-amount [percentage user]
  (float (* 0.01 percentage (:salary user))))

(defmethod accept :mint.com [user]
  (compute-amount 0.03 user))

(defmethod accept :google.com [user]
  (compute-amount 0.01 user))

(defmethod accept :default [user]
  (compute-amount 0.02 user))

(def user-1 {:login "prayag upd"    :referrer :mint.com   :salary 100000})
(def user-2 {:login "rajesh hamal"  :referrer :google.com :salary 90000})
(def user-3 {:login "steven wilson" :referrer :yahoo.com  :salary 70000})

(defn visitor []
 (println "For user1 " (accept user-1))
 (println "For user2 " (accept user-2))
 (println "For user3 " (accept user-3)))
