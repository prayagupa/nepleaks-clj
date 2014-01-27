(comment "Datasource definitions for nepleaks using kORMa.
          To get the list of users from the database run the following code in REPL:
          (use 'korma.db 'korma.core 'nepleaks.conf.datasource)
          (select users)
          ")

(ns nepleaks.conf.datasource)
   (use [korma.db])
   (use [korma.core])
)

;; exclude some clojure built-in symbols so we can use the lobos' symbols
  (:refer-clojure :exclude [alter drop
                            bigint boolean char double float time])
  ;; use only defmigration macro from lobos
  (:use (lobos [migration :only [defmigration]]
          core
          schema)))

;;; Defines the database for lobos migrations
(def nepleaksdb
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :user "root"
   :password "mysql55"})

(defmigration add-users-table
  ;; code be executed when migrating the schema "up" using "migrate"
  (up [] (create nepleaksdb
           (table :user (integer :id :primary-key )
             (varchar :username 100 :unique )
             (varchar :password 100 :not-null )
             (varchar :email 255))))
  ;; Code to be executed when migrating schema "down" using "rollback"
  (down [] (drop (table :user ))))

(defmigration add-posts-table
  (up [] (create nepleaksdb
           (table :posts (integer :id :primary-key )
             (varchar :title 250)
             (text :content )
             (boolean :status (default false))
             (timestamp :created (default (now)))
             (timestamp :published )
             (integer :user [:refer :user :id] :not-null))))
  (down [] (drop (table :posts ))))


(defentity user)
(defentity post)

