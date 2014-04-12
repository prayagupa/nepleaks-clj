(ns nepleaks.templates
  (:require [net.cgrand.enlive-html 
   :refer [deftemplate content]]))

(deftemplate tpl-leaker-list "public/leaker/list.html"
  [value]
  [:#firstName] (content value))