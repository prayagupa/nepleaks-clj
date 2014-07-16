(ns storm-hello-world.documentation.show-topology
  "Generate a D3.js JSON for graphing the Storm Topology

  Authors: Matthew Wampler-Doty negacthulhu@gmail.com"
  (:require
   [cheshire.core :refer [generate-string]]
   [storm-hello-world.topology :refer [example-topology]]
   [hiccup.core :refer [html]]))

; TODO: Collect more meta-data
;  For nodes:
;    - # of processes
;    - output field names
;    - option map
;  For links:
;    - stream grouping
(defn topology-to-graph
  "Takes a topology specification and converts it to a graph"
  [topology]
  (let [nodes (concat
               (for [[spout-name _] (.get_spouts topology)] {:name spout-name :group "spouts"})
               (for [[bolt-name _] (.get_bolts topology)] {:name bolt-name :group "bolts"}))
        node-idx (into {} (map-indexed #(vector (:name %2) %1) nodes))
        links (flatten
               (for [[bolt-name bolt] (.get_bolts topology)]
                 (for [input (->> bolt .get_common .get_inputs .keySet)]
                   {:source (node-idx (.get_componentId input)), :target (node-idx bolt-name)})))]
    {:nodes nodes, :links links}))

(defn gen-d3!
  "Generate an HTML5 D3.js graph of the Storm Topology"
  []
  (spit "./doc/graph/index.html"
        (html
         [:html
          [:meta {:charset "utf-8"}]
          [:head [:title "Graph of Storm Topology"]
           [:style (slurp "./doc/graph/style.css")]]
          [:body
           [:script {:src "http://d3js.org/d3.v3.min.js"}]
           [:script (str "var graph = "
                         (-> example-topology topology-to-graph (generate-string {:pretty true}))
                         ";\n" (slurp "./doc/graph/graph.js"))]]])))
