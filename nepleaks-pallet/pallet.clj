;;; Pallet project configuration file

(require
 '[nepleaks-pallet.groups.nepleaksNodes :refer [nepleaks-pallet]])

(defproject nepleaks-pallet
  :provider {:jclouds
             {:node-spec
              {:image {:os-family :ubuntu :os-version-matches "12.04"
                       :os-64-bit true}}}}

  :groups [nepleaks-pallet])
