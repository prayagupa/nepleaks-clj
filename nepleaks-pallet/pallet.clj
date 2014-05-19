;;; Pallet project configuration file

(require
 '[pallet-java-example.groups.pallet-java-example :refer [pallet-java-example]])

(defproject pallet-java-example
  :provider {:jclouds
             {:node-spec
              {:image {:os-family :ubuntu :os-version-matches "12.04"
                       :os-64-bit true}}}}

  :groups [pallet-java-example])
