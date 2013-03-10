(ns hotel.conf.datasource)
   (use [korma.db])
   (use [korma.core])
)

(defdb db (mysql {:db "nepleaks"
                     :user "root"
                     :password "mysql55"}))

(defentity users)

