
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; dashboard view
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns nepleaks.views.dashboard
	(:use [hiccup core page]
	      [clj-http.client :as client]
              [nepleaks-engine.services.esService     :as esService]
              [nepleaks.services.nlpService    :as nlpService]
              ))

(comment
	define views)

;;TODO render json here

(defn getJsonResponse []
  (println "getJsonResponse") ;;FIXME replace it with logger
  ;; TODO call from nepleaks-engine
  (println apply str (esService/requestJsonServer))
  ;; (nlpService/speak "I'm Prayag")
  ;; (nlpService/tag-page "http://writequit.org")
  ;; (str "<a>prayagupd</a>") ;;return
)

(defn dashboard []
  (html5
    [:head
      [:title "nepleaks.org"]
    ]
    [:body
     [:h1 "A leaks pool dashboard"]
     [:p (getJsonResponse)]
     [:a {:href "/leak/list"} "Leaks"]
     [:p ""]
     [:a {:href "/leaker/list"} "Leakers"]
     ]))
