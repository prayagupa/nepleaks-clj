
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; dashboard view
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns nepleaks.views.dashboard
	(:use [hiccup core page]
	      [clj-http.client :as client]
              [nepleaks.services.esService     :as esService]
              [nepleaks.services.nlpService    :as nlpService]
              ))

(comment
	define views)

;;TODO render json here

(defn getJsonResponse []
  (println "getJsonResponse") ;;FIXME replace it with logger
  ;;(println apply str (esService/getEsMapping))
  ;;(nlpService/speak "I'm Prayag")
  ;;(nlpService/tag-page "http://writequit.org")
  "prayagupd" ;;return
)

(defn dashboard []
  (html5
    [:head
      [:title "nepleaks.org"]
    ]
    [:body
     [:h1 "A leaks pool dashboard"]
     [:p (getJsonResponse)]
     ]))
