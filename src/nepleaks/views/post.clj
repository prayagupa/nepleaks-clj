(ns nepleaks.views.post
	(:use [hiccup core page]
	      [clj-http.client :as client])
)

(comment
	define views
)

(defn getJson [ ]
       (client/get "https://github.com/timeline.json" {:accept :json})
)       

(println apply str (getJson))

(defn index []
  (html5
    [:head
      [:title "nepleaks.org"]
    ]
    [:body
      [:h1 "welcome to nepleaks.org"]]))

